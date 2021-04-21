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
  "org.openjfx" % "javafx-base" % "11.0.2",
  "org.openjfx" % "javafx-graphics" % "11.0.2",
  "org.openjfx" % "javafx-fxml" % "11.0.2",
  "org.openjfx" % "javafx-media" % "11.0.2",
  "org.openjfx" % "javafx-swing" % "11.0.2",
  "org.openjfx" % "javafx-web" % "11.0.2",
  "org.openjfx" % "javafx-controls" % "11.0.2",
  "org.scalatest" %% "scalatest-funsuite" % "3.2.6" % Test,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)