package simple.mapper

import simple.model.Person

import scala.collection.mutable

trait PersonMapper:

  def selectAll(): mutable.Seq[Person]

  def selectAllName(): mutable.Seq[String]

  def selectOne(id: Int): Person
