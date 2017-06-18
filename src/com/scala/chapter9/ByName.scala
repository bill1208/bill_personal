package com.scala.chapter9

/**
  * Created by 周生 on 2017/6/3.
  */
object ByName {
  var assertionsEnabled = true

  def main(args: Array[String]) {

    assertionsEnabled = false
    byNameAssert(5 / 0 == 1)
    byValueAssert(5 / 0 == 1)  // this will throw java.lang.ArithmeticException: / by zero

  }

  //by-name parameter
  def byNameAssert(op: => Boolean) = {
    if(assertionsEnabled && !op) {
      throw new AssertionError()
    }
  }
  //by-value parameter
  def byValueAssert(op: Boolean) = {
    if(assertionsEnabled && !op) {
      throw new AssertionError()
    }
  }

  def byNameAssert02(op:  => Boolean) = {
    if(assertionsEnabled && !op) {
      throw new AssertionError()
    }
  }
}
