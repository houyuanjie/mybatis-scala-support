package mybatis.scala.support.typing

trait Boxed[T]:
  type Output
  def box(value: T): Output

object Boxed extends BoxedInstances

trait BoxedInstances:

  given booleanBoxed: Boxed[Boolean] with
    override type Output = java.lang.Boolean
    override def box(value: Boolean): Output = Boolean.box(value)

  given byteBoxed: Boxed[Byte] with
    override type Output = java.lang.Byte
    override def box(value: Byte): Output = Byte.box(value)

  given charBoxed: Boxed[Char] with
    override type Output = java.lang.Character
    override def box(value: Char): Output = Char.box(value)

  given shortBoxed: Boxed[Short] with
    override type Output = java.lang.Short
    override def box(value: Short): Output = Short.box(value)

  given intBoxed: Boxed[Int] with
    override type Output = java.lang.Integer
    override def box(value: Int): Output = Int.box(value)

  given longBoxed: Boxed[Long] with
    override type Output = java.lang.Long
    override def box(value: Long): Output = Long.box(value)

  given floatBoxed: Boxed[Float] with
    override type Output = java.lang.Float
    override def box(value: Float): Output = Float.box(value)

  given doubleBoxed: Boxed[Double] with
    override type Output = java.lang.Double
    override def box(value: Double): Output = Double.box(value)

object BoxedInstances extends BoxedInstances
