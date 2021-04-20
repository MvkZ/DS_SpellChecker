package ExtractData

import com.uttesh.exude.ExudeData
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.util.PDFTextStripper

import java.io.{BufferedWriter, File, FileWriter}
import java.util
import java.util.StringTokenizer
import scala.collection.mutable.ListBuffer
import scala.collection.JavaConversions._


object ExtractPdfData {

  System.setProperty("java.awt.headless", "true")

  def main(args: Array[String]) {
    println(getTextFromPdf("test.pdf"))
  }

  def getTextFromPdf(filename: String): Unit = {
    try {
      val pdf = PDDocument.load(new File(filename))
      val stripper = new PDFTextStripper
      val atext = stripper.getText(pdf)
      val t = new StringTokenizer(atext)
      var word = ""
      var collectedWords = new ListBuffer[String]()
      while ( {
        t.hasMoreTokens
      }) {
        word = t.nextToken
        if (word.length() > 2) {
          collectedWords += word
        }
      }
      val finalWords = collectedWords.toList
      var output = ExudeData.getInstance.filterStoppingsKeepDuplicates(finalWords.mkString(" "));
      output = output.replaceAll("\\d", "")
      val finalTokens = new StringTokenizer(output)
      word = ""
      var collectedFilteredWords = new ListBuffer[String]()
      while ( {
        finalTokens.hasMoreTokens
      }) {
        word = finalTokens.nextToken
        if (word.length() > 2) {
          collectedFilteredWords += word
        }
      }
      println(collectedFilteredWords.size)
      println(collectedFilteredWords)
      val file = new File("dict.txt")
      val bw = new BufferedWriter(new FileWriter(file))
      val frequencyMap = new util.HashMap[String, Integer]
      for (s <- collectedFilteredWords) {
        var count = frequencyMap.get(s)
        if (count == null) count = 0
        frequencyMap.put(s, count + 1)
      }
      for (entry <- frequencyMap.entrySet) {
        bw.write(entry.getKey + " " + entry.getValue + "\n")
      }
      bw.close()
    } catch {
      case t: Throwable =>
        t.printStackTrace
        None
    }
  }

}
