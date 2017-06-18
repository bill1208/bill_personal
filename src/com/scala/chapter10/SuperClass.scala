package com.scala.chapter10

/**
  * Created by 周生 on 2017/6/4.
  */
abstract class SuperClass {

  def noImplement(x:Int)
  def withImplement(x: Int) = {println(x)}

  def hidden()
  def demo() = {println("demo in the super class")}

}
