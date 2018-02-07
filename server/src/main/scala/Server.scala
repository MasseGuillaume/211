package server


import akka.http.scaladsl._
import akka.http.scaladsl.server.Directives._

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.duration._
import scala.concurrent.Await

import org.webjars.WebJarAssetLocator
import scala.util.{Failure, Success, Try}



object ServerMain {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("Web")
    import system.dispatcher
    implicit val materializer: ActorMaterializer = ActorMaterializer()


    val env = args.headOption.getOrElse("dev")

    // https://github.com/ThoughtWorksInc/akka-http-webjars
    val webJarAssetLocator = new WebJarAssetLocator
    def webJars = {
      extractUnmatchedPath { path =>
        Try(webJarAssetLocator.getFullPath(path.toString)) match {
          case Success(fullPath) =>
            getFromResource(fullPath)
          case Failure(_: IllegalArgumentException) =>
            reject
          case Failure(e) =>
            failWith(e)
        }
      }
    }

    val routes = 
      get(
        concat(
          pathSingleSlash(
            getFromResource(s"$env-index.html")
          ),
          pathPrefix("public")(
            concat(
              webJars,
              path(Remaining)(
                path ⇒ getFromResource("public/" + path)
              )
            )
          )
        )
      )

    Await.result(Http().bindAndHandle(routes, "0.0.0.0", 8080), 1.seconds)
  }
}