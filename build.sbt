
val base = Seq(scalaVersion := "2.12.4")

lazy val server = project
  .settings(base)
  .settings(
    libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.0.10",
    (managedClasspath in Runtime) += (packageBin in Assets).value,
    scalaJSProjects := Seq(client),
    pipelineStages in Assets := Seq(scalaJSPipeline),
    WebKeys.packagePrefix in Assets := "public/"
  )
  .enablePlugins(SbtWeb)
  .enablePlugins(JavaServerAppPackaging)

lazy val client = project
  .settings(base)
  .settings(
    webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly(),
    webpackBundlingMode in fullOptJS := BundlingMode.Application,
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.3",
    npmDependencies in Compile += "codemirror" -> "5.28.0"
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin, ScalaJSWeb, WebScalaJSBundlerPlugin)
