package simple.model

import scala.beans.BeanProperty

case class Person(
    @BeanProperty var id: Int,
    @BeanProperty var name: String,
    @BeanProperty var age: Option[Int]
)
