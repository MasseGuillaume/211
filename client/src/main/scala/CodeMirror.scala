package codemirror

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation._
import org.scalajs.dom.raw.HTMLTextAreaElement

@js.native
@JSImport("codemirror", JSImport.Namespace)
object CodeMirror extends js.Object {
  def fromTextArea(
    textarea: HTMLTextAreaElement,
    options: UndefOr[Options] = js.native): TextAreaEditor = js.native
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

@js.native
trait Options extends js.Object {
  val theme: UndefOr[String]
}

@JSImport("codemirror/mode/clike/clike", JSImport.Namespace)
@js.native
object CLike extends js.Object