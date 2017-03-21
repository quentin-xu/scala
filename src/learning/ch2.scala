package learning

import scala.collection.immutable._
import scala.math.Numeric._

object ch2 {

    def exer1(num: Int) = if (num > 0) 1 else if (num < 0) -1 else 0

    var y = 20
    def exer3 = y = 1

    def exer4 = { for (i <- 10.to(1, -1)) println(i) }

    def exer5(begin: Int) = { for (i <- begin.to(0, -1)) println(i) }

    def empty() = { 10 }

    def exer6(in: String) = { in.map(_.toLong).product }

    //7 使用foreach
    //StringOps有一个Product方法，但是返回的是Char类型

    def exer10(x: Double, n: Int): Double = {
        if (n % 2 == 0 && n > 0) exer10(x * x, n / 2)
        else if (n % 2 == 1 && n > 0) x * exer10(x, n - 1)
        else if (n == 0) 1
        else 1 / exer10(x, -n)
    }

    //var x:(Unit)=>Unit = null

    def main(args: Array[String]): Unit = {

        println(exer10(5, 3))
    }
}