lazy val commonSettings = Seq(
  name := "spark-scala-esqueleto",
  organization := "br.com.semantix",
  version := "1.0.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,

    libraryDependencies ++= Seq(

      "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
      "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided",
      "org.apache.spark" %% "spark-hive" % "2.1.0" % "provided",

      "org.scalactic" %% "scalactic" % "3.0.5" % "test",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test",
      "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",

      "com.typesafe" % "config" % "1.2.1"

    ),

    // append several options to the list of options passed to the Java compiler
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),

    // fork a new JVM for 'run' and 'test:run'
    fork := true,

    // fork a new JVM for 'test:run', but not 'run'
    fork in Test := true,

    // add a JVM option to use when forking a JVM for 'run'
    javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled"),

    // only use a single thread for building
    parallelExecution := false,

    // Execute tests in the current project serially
    //   Tests from other projects may still run concurrently.
    parallelExecution in Test := false,

    // uses compile classpath for the run task, including "provided" jar (cf http://stackoverflow.com/a/21803413/3827)
    run in Compile := Defaults.runTask(
      fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run)
    ).evaluated

  )

// change the .jar name
assemblyJarName in assembly := "spark-scala-esqueleto.jar"

// Don't trigger test before generate assembly
test in assembly := {}
