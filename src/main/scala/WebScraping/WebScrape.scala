package WebScraping

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import java.io.File
import java.net.URL
import scala.jdk.CollectionConverters._
import scala.language.postfixOps
import sys.process._

object WebScrape {
  def getLinks(url: String, selector: String) = {
    val document: Document = Jsoup.connect(url).userAgent("Mozilla").get()
    val aTags: Elements = document.select(selector)
    val links = for (aTag <- aTags.asScala) yield aTag.attr("href")
    links.toIndexedSeq
  }

  def appendRootUrl(rootUrl: String, links: IndexedSeq[String]) = {
    val loadableLinks = for (link <- links) yield rootUrl + link
    loadableLinks.foreach((element: String) => println(element))
    loadableLinks.toList
  }

  def downloadFiles(downloadableFileLinks: List[String], path: String): Unit = {
    downloadableFileLinks.map(downloadableLink => {
      // TODO: Only write if fileNotExists?
      val urlObject = new URL(downloadableLink)
      val filePath = path + "/" + urlObject.getPath().replaceAll("/", "")
      urlObject #> new File(filePath) !!
    })
  }


  def main(args: Array[String]) {
    val rootUrl = "https://www.biorxiv.org"

    //    val scrapedUrl = "https://www.who.int/emergencies/diseases/novel-coronavirus-2019/situation-reports?fbclid=IwAR0bANT83XoqEwhEWnGvjmBSsGjy0S9smn1wP5wTtIyy_Oe78_NtMUATEqA"
    for (pageNo <- 1 to 1) {
      val pages = "https://www.biorxiv.org/content/early/recent?page=" + pageNo
      val aLinksContentSelectpr = ".highwire-list a[class=highwire-cite-linked-title]"
      val linksOnPage = getLinks(pages, aLinksContentSelectpr)
      val validLinksOnPage = appendRootUrl(rootUrl, linksOnPage)
      var downloadableLinks = appendRootUrl(rootUrl, linksOnPage)
      for (link <- validLinksOnPage) {
        val contentSelectpr = ".pane-content a[class=article-dl-pdf-link link-icon]"
        val downloadLinksOnPage = getLinks(link, contentSelectpr)
        downloadableLinks = appendRootUrl(rootUrl, downloadLinksOnPage)
        downloadFiles(downloadableLinks, "./files")
      }
    }
  }
}
