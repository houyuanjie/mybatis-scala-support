package simple.model

import scala.beans.BeanProperty

case class Pet(
    id: Int,
    name: String,
    age: Option[Int],
    owner: Int
)
