name := """AD_Template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  guice
)


fork in run := true