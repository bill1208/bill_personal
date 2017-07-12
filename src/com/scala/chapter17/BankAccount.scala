package com.scala.chapter17

/**
  * Created by 周生 on 2017/6/23.
  */
class BankAccount {

  private var bal:Int = 0

  def balance = bal

  def deposit(amount: Int) = {
    require(amount > 0)
    bal += amount
  }

  def withdraw(amount: Int): Boolean = {
    if(amount > bal) false
    else {
      bal -= amount
      true
    }
  }
}

//the following two time class is the same
class Time1 {
  var hour = 12
  var minute = 0
}

class Time2 {
  private[this] var h = 12
  private[this] var m = 0

  def hour:Int = h
  def hour__=(x: Int) = {
    h = x
  }

  def minute:Int = m
  def minute_=(x:Int) = {
    m = x
  }
}

//It's also possible, and sometimes useful, to define a getter and a setter without an associated field.
class Thermometer {
  var celsius: Float = _
  //Note that you cannot simply leave off the "= _" initializer in Scala. If you had written:
 // var celsius: Float   this would declare an abstract variable, not an uninitialized one.[1]

  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheti_=(x: Float) = {
    celsius = (x -32) / 9 * 5
  }

  override def toString = fahrenheit + "F/" + celsius + "C"

}

object Test2 {
  def main(args: Array[String]): Unit = {
    val thermometer = new Thermometer
//    println(thermometer.celsius)
//    println(thermometer.test3)
  }
}
