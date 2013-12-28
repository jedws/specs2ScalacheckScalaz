import org.scalacheck.{ Arbitrary, Gen }
import scalaz.scalacheck.ScalazProperties._

class BoxSpec extends ScalaCheckSpec {

  implicit def arbitraryBox[A: Arbitrary]: Arbitrary[Box[A]] =
    Arbitrary {
      implicitly[Arbitrary[A]].arbitrary.map { Box.apply }
    }

  def is =
    s2"""
  The monadic interpreter should 
    implement Monad                             ${checkAll(monad.laws[Box])}
  """
}