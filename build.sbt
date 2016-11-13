name := "NN_Framework"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVers = "2.0.0"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.5"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"

// https://mvnrepository.com/artifact/com.joptimizer/joptimizer
libraryDependencies += "com.joptimizer" % "joptimizer" % "3.5.1"

libraryDependencies += "org.deeplearning4j" % "deeplearning4j-core" % "0.4-rc3.9"

libraryDependencies += "com.sksamuel.scrimage" %% "scrimage-core" % "2.1.0"

libraryDependencies += "com.sksamuel.scrimage" %% "scrimage-io-extra" % "2.1.0"

libraryDependencies += "com.sksamuel.scrimage" %% "scrimage-filters" % "2.1.0"

libraryDependencies  ++= Seq(
  // Last stable release
  "org.scalanlp" %% "breeze" % "0.12",

  // Native libraries are not included by default. add this if you want them (as of 0.7)
  // Native libraries greatly improve performance, but increase jar sizes. 
  // It also packages various blas implementations, which have licenses that may or may not
  // be compatible with the Apache License. No GPL code, as best I know.
  "org.scalanlp" %% "breeze-natives" % "0.12",

  // The visualization library is distributed separately as well.
  // It depends on LGPL code
  "org.scalanlp" %% "breeze-viz" % "0.12"
)



