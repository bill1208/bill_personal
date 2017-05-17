package com.scala.chapter8

/**
  * Created by 周生 on 2017/5/17.
  */
object TailRecurision {
  def main(args: Array[String]) {

  }
  // one tail recursion
  def boom01(x: Int): Int = if(x == 0) throw new Exception("Boom") else boom01(x - 1)
  // one recursion is not recursion because in the last call is not the function himself, it has + 1
  def boom02(x: Int): Int = if(x == 0) throw new Exception("Boom") else boom01(x - 1) + 1
  // one recursion is not recursion because because the last call is not indirect
  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)
  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)
  // one recursion is not recursion because because the last call is function value call
  val funValue = nestedFun _
  def nestedFun(x: Int) : Unit = {
    if (x != 0) { println(x); funValue(x - 1) }
  }

}
