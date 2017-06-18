package com.scala.chapter13.bobsrockets.navigation.bobsdelights

/**
  * Created by 周生 on 2017/6/11.
  */
abstract class Fruit(val name: String, val color: String)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple,Orange,Pear)
}

object Test {
  def showFruit(fruit: Fruit): Unit = {
//      val name = "test"
    import fruit._
    val color = "test color"
    println(name + "s are " + color)
  }

  def main(args: Array[String]) {
    showFruit(Fruits.Apple)
  }
}

class Outer {
  class Inner {
    private def f() = println("f")
    class InnerMost {
      f()
    }
  }
  val inner = new Inner
//  inner.f()  // cannot access f, because this is not in the Inner class body. but in java can access
}

package p {
  class Super {
    protected def f() = println("f")
  }
  class Sub extends Super {
    f()
  }

  class Others {
//    (new Super).f //// cannot access f, because this is not sub class of Super. but in java can access
  }
}
