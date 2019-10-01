val sparkVersion = "2.4.4"
val LogbackVersion        = "1.2.3"
val Log4catsVersion       = "0.4.0-M2"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.fortysevendeg",
      scalaVersion := "2.12.8"
    )),
    name := "spark-sftp",
    version := "1.1.6-SNAPSHOT",

  // Dependent libraries
  libraryDependencies ++= Seq(
    "org.apache.spark"  %% "spark-core"      % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-avro" % sparkVersion,
    "com.springml" % "sftp.client" % "1.0.3",
    "org.mockito" % "mockito-core" % "3.0.0",
    "com.databricks" % "spark-xml_2.12" % "0.6.0",
    "ch.qos.logback"  %  "logback-classic"     % LogbackVersion,
    "io.chrisdavenport" %% "log4cats-core"     % Log4catsVersion,
    "io.chrisdavenport" %% "log4cats-slf4j"     % Log4catsVersion
  ),
   resolvers += "Spark Package Main Repo" at "https://dl.bintray.com/spark-packages/maven",

    // Test dependencies
   libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test",
   libraryDependencies += "org.apache.avro" % "avro-mapred" % "1.9.1" % "test" exclude("org.mortbay.jetty", "servlet-api"),
   libraryDependencies +=  "org.apache.spark" %% "spark-hive" % sparkVersion % "test",

   credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),

   publishTo := {
     val nexus = "https://oss.sonatype.org/"
     if (version.value.endsWith("SNAPSHOT"))
       Some("snapshots" at nexus + "content/repositories/snapshots")
     else
       Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },

pomExtra := (
  <url>https://github.com/springml/spark-sftp</url>
    <licenses>
      <license>
        <name>Apache License, Verision 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <connection>scm:git:github.com/springml/spark-sftp</connection>
      <developerConnection>scm:git:git@github.com:springml/spark-sftp</developerConnection>
      <url>github.com/springml/spark-sftp</url>
    </scm>
    <developers>
      <developer>
        <id>springml</id>
        <name>Springml</name>
        <url>http://www.springml.com</url>
      </developer>
    </developers>)
  )