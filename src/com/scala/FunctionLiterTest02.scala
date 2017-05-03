package com.scala

/**
  * Created by z00176928 on 2017/5/2.
  */
object FunctionLiterTest02 {

  (x:Int) => x + 1
  (x:Int) => {
    println(1212)
    println(x)
    x + 1
  }

  val addOne = (x:Int) => x + 1
  addOne(10)

  def main(args: Array[String]): Unit = {
    val flt = new FunctionLiterTest

    var list = List(1,2,34,4)
    println(list.foreach((y:Int) => y + 1))
    val test = (z:Int) => z + 1
    println(list.foreach(test))
    list.foreach(test)
  }

}
