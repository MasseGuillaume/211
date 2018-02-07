package server


import akka.http.scaladsl._
import akka.http.scaladsl.server.Directives._

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.duration._
import scala.concurrent.Await


object ServerMain {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("Web")
    import system.dispatcher
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    val env = args.headOption.getOrElse("dev")

    val routes = 
      get(
        concat(
          pathSingleSlash(
            getFromResource(s"$env-index.html")
          ),
          path("public" / Remaining)(
            path ⇒ getFromResource("public/" + path)
          )
        )
      )

    Await.result(Http().bindAndHandle(routes, "0.0.0.0", 8080), 1.seconds)
  }
}