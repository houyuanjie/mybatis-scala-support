package mybatis.scala.support.config.builder

import mybatis.scala.support.config.model.{TypeHandlerModel, TypeHandlers}

import scala.annotation.implicitNotFound

@implicitNotFound("Please put me inside 'dsl.typeHandlers' or give me a 'builder.TypeHandlersBuilder'")
class TypeHandlersBuilder extends Builder[TypeHandlers]:

  // field

  private var typeHandlerModelVector: Vector[TypeHandlerModel] = Vector.empty

  // update

  def appendTypeHandlerModel(typeHandlerModel: TypeHandlerModel): Unit =
    this.typeHandlerModelVector = this.typeHandlerModelVector.appended(typeHandlerModel)

  // override

  override def build(): TypeHandlers =
    new TypeHandlers(this.typeHandlerModelVector)
