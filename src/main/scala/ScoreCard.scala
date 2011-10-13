/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 13/10-11
 * Time: 19:49 
 */
class ScoreCard {

  def calculate(category: Category, rolls: List[Int]) = {
    rolls.filter(category.number == _).sum
  }

}

trait Category {
  def number: Int
}

case object Ones extends Numbers(1)

case object Twos extends Numbers(2)
case object Threes extends Numbers(3)
case object Fours extends Numbers(4)
case object Fives extends Numbers(5)
case object Sixes extends Numbers(6)

case class Numbers(number: Int) extends Category