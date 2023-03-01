package simple.model

import scala.beans.BeanProperty

case class Person(
    id: Int,
    name: String,
    age: Option[Int]
)
