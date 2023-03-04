package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.TypeHandlerModel

import scala.annotation.implicitNotFound

@implicitNotFound("Please put me inside 'dsl.typeHandlers' or give me a 'builder.TypeHandlersBuilder'")
class TypeHandlersBuilder extends Builder[Vector[TypeHandlerModel]]:

  // field

  private var typeHandlers: Vector[TypeHandlerModel] = Vector.empty

  // update

  def appendTypeHandler(typeHandlerModel: TypeHandlerModel): Unit =
    this.typeHandlers = this.typeHandlers.appended(typeHandlerModel)

  // override

  override def build(): Vector[TypeHandlerModel] =
    this.typeHandlers
