
val base = Seq(scalaVersion := "2.12.4")

lazy val server = project
  .settings(base)
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.0.10",
      "org.webjars" % "codemirror" % "5.33.0",
      "org.webjars" % "webjars-locator" % "0.32"
    ),
    scalaJSProjects := Seq(client),
    pipelineStages in Assets := Seq(scalaJSPipeline),
    WebKeys.packagePrefix in Assets := "public/"
  )
  .enablePlugins(WebScalaJSBundlerPlugin, JavaServerAppPackaging)

lazy val client = project
  .settings(base)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly(),
    webpackBundlingMode in fullOptJS := BundlingMode.Application,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.3",
    npmDependencies in Compile += "codemirror" -> "5.23.0"
  )
  .enablePlugins(ScalaJSBundlerPlugin, ScalaJSWeb)
