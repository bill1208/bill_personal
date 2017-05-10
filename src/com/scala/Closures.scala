package com.scala

/**
  * Created by root on 17-5-10.
  */
object Closures {

  def main(args: Array[String]): Unit = {

    val test = (x:Int) => x + 1;
//    val test02 = (x:Int) => x + more  //this will give compile error: cannot resolve symbol more

    var more = 10;
    val addMore = (x:Int) => x + more
    println(addMore(10))   //20
    more = 20
    println(addMore(10))   //30

    val inc1 = makeIncreaser(1)
    println(inc1(99))

    val inc99 = makeIncreaser(99)
    println(inc99(1))
  }

  def makeIncreaser(increaser:Int) = (x:Int) => x + increaser



}
