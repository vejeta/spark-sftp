// You may use this file to add plugin dependencies for sbt.
resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"

//addSbtPlugin("org.spark-packages" %% "sbt-spark-package" % "0.2.5")
//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.7")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "2.0.0")
