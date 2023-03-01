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
      "SELECT name",
      "FROM person"
    )
  )
  def selectAllName(): mutable.Buffer[String]

  @Select(
    Array(
      "SELECT *",
      "FROM person",
      "WHERE id=#{id}"
    )
  )
  def selectOne(@Param("id") id: Int): Person
