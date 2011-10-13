import scala.collection.mutable.Map

case class ScoreCard(slots: Map[Int, List[Int]] = Map[Int, List[Int]]()) {

  def slot(i: Int): List[Int] = {
    slots.getOrElse(i, Nil)
  }

  def +=(roll: Tuple2[Int, List[Int]]) {
    slots.get(roll._1) match {
      case None => slots += roll._1 -> roll._2
      case _ => throw new IllegalArgumentException
    }
  }

  def calculate(category: Category): Int = category.calculate(this)

}

trait Category {
  def cardSlot: Int
  def calculate(scoreCard: ScoreCard): Int = 0
}

abstract trait Numbers extends Category {
  override def calculate(scoreCard: ScoreCard) = {
    scoreCard.slot(cardSlot).filter(cardSlot == _).sum
  }
}

object Ones extends Numbers {
  val cardSlot = 1
}

object Twos extends Numbers {
  val cardSlot = 2
}

object Threes extends Numbers {
  val cardSlot = 3
}

object Fours extends Numbers {
  val cardSlot = 4
}

object Fives extends Numbers {
  val cardSlot = 5
}

object Sixes extends Numbers {
  val cardSlot = 6
}

object Pair extends Category {
  val cardSlot = 7
  override def calculate(scoreCard: ScoreCard) = {
    scoreCard.slot(cardSlot).groupBy(i => i).filter(_._2.size >= 2).foldLeft(0)((sum, l) => l._2.sum)
  }
}