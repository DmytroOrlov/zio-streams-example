package example
/*
import $ivy.`dev.zio::zio-streams:1.0.0-RC11-1`
import $ivy.`org.typelevel::cats-core:2.0.0-RC2`
*/
import cats.implicits._
import zio._
import zio.console._
import zio.stream._

import scala.util.Random

object Hello extends App {
  def run(args: List[String]) = {
    val monkeyState: Int => Stream[Nothing, Int] =
      n => Stream.unfold(n)(i => if (i > 0) (Random.nextInt(3) -> (i - 1)).some else none)

    def monkeyEating(xs: Stream[Nothing, Int]): Stream[Nothing, Int] =
      xs.map(_ % 2)

    val numMonkeys = 100

    val timeSteps = 1000

    val res: Stream[Nothing, Int] = Stream.flattenPar(numMonkeys)(
      Stream.fromIterable(0 to timeSteps).map(_ => monkeyEating(monkeyState(timeSteps)))
    )

    res.foreach(i => putStrLn(s"$i")).fold(_ => 0, _ => 1)
  }
}
