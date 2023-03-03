package mybatis.scala.support.config.builder

trait Builder[T]:
  def build(): T
