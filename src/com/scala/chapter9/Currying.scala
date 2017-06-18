package com.scala.chapter9

/**
  * Created by 周生 on 2017/5/21.
  */
object Currying {

  def main(args: Array[String]) {
    def functionSum(x: Int, y: Int) = x + y  // this is not curring function
    def curryingSum(x: Int)(y: Int) = x + y  // this is the curring function
    // this currying function like two function as following
    def sum(x: Int) = (y: Int) => x + y
    def sumOne = sum(1)
    println(sumOne(2))  // it should be 3

    // currying function also can do like this
    def curryingSumOne = curryingSum(1)(_)
    println(curryingSumOne(2)) // it should be 3
  }


}
