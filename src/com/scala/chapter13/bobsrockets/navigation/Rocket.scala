package com.scala.chapter13.bobsrockets.navigation

/**
  * Created by 周生 on 2017/6/11.
  */
class Rocket {
  import Rocket.fuel
  private def canGohomeAgain = fuel > 20

}

object Rocket {
  private def fuel = 10
  def chooseStrategy(rocket: Rocket) = {
    if(rocket.canGohomeAgain)
      goHome()
    else
    pickAStar()
  }
  def goHome() = {}
  def pickAStar() = {}
}

package object bobsdelights {
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }
}


