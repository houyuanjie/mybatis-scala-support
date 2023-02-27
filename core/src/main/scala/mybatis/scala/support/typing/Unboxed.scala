package mybatis.scala.support.typing

trait Unboxed[T]:
  type Input
  def unbox(value: Input): T

object Unboxed extends UnboxedInstances

trait UnboxedInstances:

  given booleanUnboxed: Unboxed[Boolean] with
    override type Input = java.lang.Boolean
    override def unbox(value: Input): Boolean = Boolean.unbox(value)

  given byteUnboxed: Unboxed[Byte] with
    override type Input = java.lang.Byte
    override def unbox(value: Input): Byte = Byte.unbox(value)

  given charUnboxed: Unboxed[Char] with
    override type Input = java.lang.Character
    override def unbox(value: Input): Char = Char.unbox(value)

  given shortUnboxed: Unboxed[Short] with
    override type Input = java.lang.Short
    override def unbox(value: Input): Short = Short.unbox(value)

  given intUnboxed: Unboxed[Int] with
    override type Input = java.lang.Integer
    override def unbox(value: Input): Int = Int.unbox(value)

  given longUnboxed: Unboxed[Long] with
    override type Input = java.lang.Long
    override def unbox(value: Input): Long = Long.unbox(value)

  given floatUnboxed: Unboxed[Float] with
    override type Input = java.lang.Float
    override def unbox(value: Input): Float = Float.unbox(value)

  given doubleUnboxed: Unboxed[Double] with
    override type Input = java.lang.Double
    override def unbox(value: Input): Double = Double.unbox(value)

object UnboxedInstances extends UnboxedInstances
