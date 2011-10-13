import util.Random

class Rolls extends Roll {
  def size = values.size

  var values = List(roll,roll,roll,roll,roll)

  def reroll(dice1: Boolean, dice2: Boolean, dice3: Boolean, dice4: Boolean, dice5: Boolean) = {

    values = List(dice1, dice2, dice3, dice4, dice5) zip values map {
      case (true, _) => roll
      case (false, v) => v
    }
  }
}

trait Roll {
  def roll = {
    Random.nextInt(6) + 1
  }

}