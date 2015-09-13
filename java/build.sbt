name := "leetcode_java"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.12",
  "org.apache.commons" % "commons-lang3" % "3.4"
)

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
