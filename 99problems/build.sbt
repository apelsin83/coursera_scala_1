
name := "99problems"

version := "1.0"

scalaVersion := "2.12.4"

scalacOptions ++= Seq("-deprecation")

libraryDependencies += "junit" % "junit" % "4.10" % Test
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

// resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

// libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

// for debugging sbt problems
// logLevel := Level.Debug