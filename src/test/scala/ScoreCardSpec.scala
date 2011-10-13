import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * Created by IntelliJ IDEA.
 * User: david
 * Date: 13/10-11
 * Time: 19:44 
 */
class ScoreCardSpec extends FlatSpec with ShouldMatchers {

  "ScoreCard" should "calculate score for category Ones" in {
    new ScoreCard().calculate(Ones, List(1, 2, 1, 1, 1)) should be (4)
  }

  "ScoreCard" should "calculate score for category Twos" in {
    new ScoreCard().calculate(Twos, List(1, 2, 1, 1, 1)) should be (2)
  }

  "ScoreCard" should "calculate score for category Numbers" in {
    new ScoreCard().calculate(Numbers(1), List(1, 2, 3, 4, 5)) should be (1)
    new ScoreCard().calculate(Numbers(2), List(1, 2, 3, 4, 5)) should be (2)
    new ScoreCard().calculate(Numbers(3), List(1, 2, 3, 4, 5)) should be (3)
    new ScoreCard().calculate(Numbers(4), List(1, 2, 3, 4, 5)) should be (4)
    new ScoreCard().calculate(Numbers(5), List(1, 2, 3, 4, 5)) should be (5)
    new ScoreCard().calculate(Numbers(6), List(1, 2, 3, 4, 5)) should be (0)
  }

}