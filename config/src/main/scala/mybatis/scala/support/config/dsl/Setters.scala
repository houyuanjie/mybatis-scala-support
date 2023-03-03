package mybatis.scala.support.config.dsl

import mybatis.scala.support.config.builder.ConfigurationBuilder
import org.apache.ibatis.reflection.factory.ObjectFactory
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory

// ConfigurationBuilder

val objectFactory = new Setter[ConfigurationBuilder, ObjectFactory](_.setObjectFactory)
val objectWrapperFactory = new Setter[ConfigurationBuilder, ObjectWrapperFactory](_.setObjectWrapperFactory)
