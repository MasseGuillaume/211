package client

import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom

@JSExportTopLevel("client.Client")
object Client {
  @JSExport
  def main(): Unit = {
    val node = dom.document.createElement("div")
    node.innerHTML = "Hello, Scala.js"
    dom.document.body.appendChild(node)
  }
}