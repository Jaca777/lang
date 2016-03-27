package pl.jaca.lang.interpreter.visitor

/**
  * @author Jaca777
  *         Created 2016-03-23 at 14
  */
case class Value(val value: Any, val `type`: String) {

  def asInt: Int = {
    if (`type` != "int") throw new RuntimeException(s"Unable to cast ${`type`} to int.")
    value.asInstanceOf[Int]
  }


}
object Value {
  val Unit = Value(null, "unit")
}