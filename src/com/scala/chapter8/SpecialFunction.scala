package com.scala.chapter8

import javafx.scene.effect.Light.Distant

/**
  * Created by 周生 on 2017/5/17.
  */
object SpecialFunction {
  def main(args: Array[String]) {
  //use repeat arguments function
    echo("bill")
    echo("bill","bill02")
    val arrayString = Array("bill","bill02")
//    echo(arrayString) //compile is failure, the parameter should be string
    echo(arrayString: _*)

    //named argument
    def speed(distant: Float, time: Float, others: Int): Float = distant / time * others
    println(speed(100, 10, 2))
    println(speed(distant = 100, time = 20, 3))
//    speed(time = 20, distant = 100, 3) // the positional arguments should come first, if the named argument order is different
    println(speed(200, others = 2, time = 10))

    //default value for parameter
    def speed02(distant: Float = 200, time: Float, others: Int = 2): Float = distant / time * others
    println(speed02(time = 2))
    println(speed02(300,20))
  }

  //repeat arguments
  def echo(args: String*) = {
    for(arg <- args) {
      println(arg)
    }
  }

}
