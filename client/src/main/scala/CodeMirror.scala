package codemirror

import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom.raw.HTMLTextAreaElement

@js.native
@JSImport("codemirror", JSImport.Namespace)
object CodeMirror extends js.Object {
  def fromTextArea(textarea: HTMLTextAreaElement): TextAreaEditor = js.native
}

@js.native
trait TextAreaEditor extends Editor {
  def save(): Unit
  def toTextArea(): Unit
  def getTextArea: HTMLTextAreaElement
}

@js.native
trait Editor extends js.Object {
  def hasFocus(): Boolean
}
