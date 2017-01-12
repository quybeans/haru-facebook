name := """akka-scala-seed"""

version := "1.0"

scalaVersion := "2.11.6"

val circeVersion = "0.6.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq(
  // Change this to another test framework if you prefer
  "org.scalatest" %% "scalatest" % "2.1.6" % "test",
  // Akka
  "com.typesafe.akka" %% "akka-actor" % "2.3.5",
  "com.typesafe.akka" %% "akka-http" % "10.0.1"
  //"com.typesafe.akka" %% "akka-remote" % "2.3.5",
  //"com.typesafe.akka" %% "akka-testkit" % "2.3.5"
)