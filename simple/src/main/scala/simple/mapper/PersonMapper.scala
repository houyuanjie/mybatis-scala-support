package simple.mapper

import org.apache.ibatis.annotations.{Param, Select}
import simple.model.Person

import scala.collection.mutable

trait PersonMapper:

  @Select(
    Array(
      "SELECT *",
      "FROM person"
    )
  )
  def selectAll(): mutable.Buffer[Person]

  @Select(
    Array(
      "SELECT *",
      "FROM person",
      "WHERE id=#{id}"
    )
  )
  def selectOne(@Param("id") id: Int): Option[Person]
