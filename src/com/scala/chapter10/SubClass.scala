package com.scala.chapter10

/**
  * Created by 周生 on 2017/6/4.
  */
class SubClass(x: Array[String]) extends SuperClass{

  override def withImplement(x:Int) = {println("create new method in subclass")}

  override def noImplement(x: Int): Unit = {println("Implement in sub class")}

  def hidden() = {println("hidden")}

  final def finalMethod() = {println("this is final method")}
}


object SubClass {
  def main(args: Array[String]) {
    val subClass = new SubClass(Array("dd"))
    subClass.withImplement(3)
    subClass.noImplement(4)
    subClass.hidden()
  }
}