import scala.util.Random

val monkeyState: (Int) => Vector[Int] = (ts) =>
  Vector.tabulate(ts)(t => (t - 1) + Random.nextInt(3))

monkeyState(3)
