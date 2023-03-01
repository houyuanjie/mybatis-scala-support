package simple.model

import scala.beans.BeanProperty

class Person(
    @BeanProperty var id: Integer,
    @BeanProperty var name: String,
    @BeanProperty var age: Option[java.lang.Integer]
) {

  def this() = this(null, null, null)
  override def toString = s"Person(id=$id, name=$name, age=$age)"

}
