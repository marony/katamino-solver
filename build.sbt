import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.binbo-kodakusan",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT",
      javaOptions  := Seq("-Xms 2G -Xmx 8G -verbose:gc"),
    )),
    name := "katamino-solver",
    libraryDependencies += scalaTest % Test,
    scalacOptions ++= Seq(
      "-deprecation",         // @deprecatedなAPIが使われている箇所を警告します
      "-feature",             // language feature の import が必要な箇所を警告します
      "-unchecked",           // Enable additional warnings where generated code depends on assumptions.
      "-Xlint",               // scalac -Xlint:help
      "-Ywarn-dead-code",     // Warn when dead code is identified.
      "-Ywarn-numeric-widen", // Warn when numerics are widened.
//      "-Ywarn-unused",        // Warn when local and private vals, vars, defs, and types are are unused.
//      "-Ywarn-unused-import", // Warn when imports are unused.
      "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
      "-Xfatal-warnings"
    ),
  )
