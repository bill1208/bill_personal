package com.scala

/**
  * Created by root on 17-5-9.
  */
object PartiallyFunction {

  def main(args: Array[String]): Unit = {

    val a = sum _
    print(a)
    println(a(1,3,4))

    val b = sum(_:Int, 2,3)
    println(b)
    println(b(1))

  }

  def sum(a:Int, b:Int, c:Int):Int = a + b + c

}
