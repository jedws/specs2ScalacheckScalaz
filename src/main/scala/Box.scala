import scalaz.{ Equal, Monad }

case class Box[A](a: A)

object Box {
  implicit object BoxMonad extends Monad[Box] {
    def point[A](a: => A) = Box(a)
    def bind[A, B](b: Box[A])(f: A => Box[B]) = f(b.a)
    override def map[A, B](b: Box[A])(f: A => B) = Box(f(b.a))
  }

  implicit def BoxEqual[A]: Equal[Box[A]] =
    new Equal[Box[A]] {
      def equal(b1: Box[A], b2: Box[A]) =
        b1.a == b2.a
    }
}