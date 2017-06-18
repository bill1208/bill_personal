package com.scala.chapter12

/**
  * Created by 周生 on 2017/6/11.
  */
class Frog extends Animal with Philosophical with HasLeg{
override def toString = "green"
}
class Animal
trait HasLeg