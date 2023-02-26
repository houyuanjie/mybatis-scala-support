package mybatis.scala.support.typing

trait Unboxed[T]:
  type Input
  def unbox(value: Input): T

object Unboxed extends UnboxedInstances

trait UnboxedInstances:

  given Unboxed[Boolean] with
    override type Input = java.lang.Boolean
    override def unbox(value: Input): Boolean = Boolean.unbox(value)

  given Unboxed[Byte] with
    override type Input = java.lang.Byte
    override def unbox(value: Input): Byte = Byte.unbox(value)

  given Unboxed[Char] with
    override type Input = java.lang.Character
    override def unbox(value: Input): Char = Char.unbox(value)

  given Unboxed[Short] with
    override type Input = java.lang.Short
    override def unbox(value: Input): Short = Short.unbox(value)

  given Unboxed[Int] with
    override type Input = java.lang.Integer
    override def unbox(value: Input): Int = Int.unbox(value)

  given Unboxed[Long] with
    override type Input = java.lang.Long
    override def unbox(value: Input): Long = Long.unbox(value)

  given Unboxed[Float] with
    override type Input = java.lang.Float
    override def unbox(value: Input): Float = Float.unbox(value)

  given Unboxed[Double] with
    override type Input = java.lang.Double
    override def unbox(value: Input): Double = Double.unbox(value)

object UnboxedInstances extends UnboxedInstances
