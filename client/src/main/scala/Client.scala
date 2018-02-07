package client

import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLTextAreaElement

@JSExportTopLevel("client.Client")
object Client {
  @JSExport
  def main(): Unit = {
    codemirror.CLike
    val node = dom.document.getElementById("mirror").asInstanceOf[HTMLTextAreaElement]
    val options = js.Dictionary[Any](
      "theme" -> "solarized dark",
      "mode" -> "text/x-scala"
    ).asInstanceOf[codemirror.Options]
    val editor = codemirror.CodeMirror.fromTextArea(node, options)
  }
}