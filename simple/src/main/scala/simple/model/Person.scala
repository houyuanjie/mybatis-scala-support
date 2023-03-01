package simple.model

import scala.beans.BeanProperty

class Person(
    @BeanProperty var id: java.lang.Integer,
    @BeanProperty var name: String,
    @BeanProperty var age: java.lang.Integer
) {

  def this() = this(null, null, null)

  override def toString = s"Person($id, $name, $age)"

}
