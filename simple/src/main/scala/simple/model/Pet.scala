package simple.model

import scala.beans.BeanProperty

case class Pet(
    @BeanProperty var id: Int,
    @BeanProperty var name: String,
    @BeanProperty var age: Option[Int],
    @BeanProperty var owner: Int
)
