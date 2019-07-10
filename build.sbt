name := "Kafka"

version := "1.0"

scalaVersion := "2.11.8"
name := "Streaming_Using_Kafka"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies+="org.apache.spark" % "spark-core_2.11" % "2.3.1"
libraryDependencies+="org.apache.spark" %% "spark-streaming" % "2.3.1"
libraryDependencies+="org.apache.spark" % "spark-sql_2.11"  % "2.3.1"
libraryDependencies+="org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.3.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
//libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.2"

//libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "1.5.2"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka
//libraryDependencies += "org.apache.kafka" %% "kafka" % "2.3.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka
//libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.3"





//dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.2"
//dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.2"
//dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.2"
//
//resolvers ++= Seq(
//  "Maven 1" at "http://repo1.maven.org/maven2/",
//  "Spark Packages Repo2" at "http://dl.bintray.com/spark-packages/maven",
//  "Scala_logging repo" at "https://mvnrepository.com/artifact/",
//  "HDP Repo" at "http://repo.hortonworks.com/content/repositories",
//  "maven repo" at "https://mvnrepository.com/maven2"
//)
//
//publishMavenStyle := true
//
//credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

//libraryDependencies ++= Seq(
//  "org.apache.spark" % "spark-core_2.11" % "2.3.2",
//  "org.apache.spark" % "spark-sql_2.11" % "2.3.2",
//  "org.apache.spark" %% "spark-streaming" % "2.3.2",
//  "org.apache.spark" %% "spark-streaming-kafka-0-10" % "2.3.2",
//  "org.apache.logging.log4j" % "log4j-api-scala_2.11" % "11.0"
//)
retrieveManaged := true
//coverageHighlighting := false
//coverageEnabled := false
fork in run := true


