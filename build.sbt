name := "DS_SpellChecker"

version := "0.1"

scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-collection-compat" % "2.4.3",
  "org.jsoup" % "jsoup" % "1.8.3",
  "org.apache.spark" %% "spark-core" % "2.4.5",
  "org.apache.spark" %% "spark-sql" % "2.4.5",
  "org.apache.pdfbox" % "pdfbox" % "1.8.2",
  "com.uttesh" % "exude" % "0.0.4",
  "org.openjfx" % "javafx" % "11",
  "org.openjfx" % "javafx-base" % "11.0.2"
)