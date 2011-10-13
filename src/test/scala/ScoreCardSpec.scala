import collection.mutable.Map
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ScoreCardSpec extends FlatSpec with ShouldMatchers {

  "ScoreCard" should "calculate score for Numbers" in {
    val scoreCard = new ScoreCard(Map(
      1 -> List(1, 2, 3, 4, 5),
      2 -> List(1, 2, 3, 4, 5),
      3 -> List(1, 2, 3, 4, 5),
      4 -> List(1, 2, 3, 4, 5),
      5 -> List(1, 2, 3, 4, 5),
      6 -> List(1, 2, 3, 4, 5)
    ))

    scoreCard.calculate(Ones) should be(1)
    scoreCard.calculate(Twos) should be(2)
    scoreCard.calculate(Threes) should be(3)
    scoreCard.calculate(Fours) should be(4)
    scoreCard.calculate(Fives) should be(5)
    scoreCard.calculate(Sixes) should be(0)
  }

  it should "calculate score for Pair" in {
    val scoreCard = new ScoreCard(Map(
      7 -> List(1, 2, 3, 3, 5)
    ))

    scoreCard.calculate(Pair) should be(6)
  }

  "Adding rolls to ScoreCard" should "be possible" in {
    val scoreCard = new ScoreCard
    scoreCard += 1 -> List(1, 1, 1, 2, 3)

    scoreCard.calculate(Ones) should be(3)
  }

  "Calculating empty slot" should "return zero" in {
    val scoreCard = new ScoreCard

    scoreCard.calculate(Ones) should be(0)
  }

  "Trying to replace filled slot" should "throw exception" in {
    val scoreCard = new ScoreCard
    scoreCard += 1 -> List(1, 1, 1, 2, 3)

    evaluating {scoreCard += 1 -> List(1, 1, 2, 2, 3)} should produce[IllegalArgumentException]

    scoreCard.calculate(Ones) should be(3)
  }
}