name := "nasarenos-app"

version := "0.1"

scalaVersion := "2.13.1"

val sparkVersion = "2.3.0"

evictionWarningOptions in update := EvictionWarningOptions.default.withWarnTransitiveEvictions(false)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

lazy val raiz = (project in file("."))
  .settings(mainClass in Compile := Some("nasarenos.Initializer"))

dependencyOverrides ++= Seq("com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "com.datastax.spark" %% "spark-cassandra-connector" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)