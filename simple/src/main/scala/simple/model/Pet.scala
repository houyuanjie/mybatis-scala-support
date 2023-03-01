package simple.model

import scala.beans.BeanProperty

class Pet(
    @BeanProperty var id: Int,
    @BeanProperty var name: String,
    @BeanProperty var age: Int,
    @BeanProperty var owner: Int
) {

  def this() = this(0, null, 0, 0)

  override def toString = s"Pet(id=$id, name=$name, age=$age, owner=$owner)"

}
