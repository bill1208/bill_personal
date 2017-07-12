package com.scala.chapter20

/**
  * Created by 周生 on 2017/7/8.
  */
trait RationTrait {
  val numerarg: Int
  val denomarg: Int

}

object Test {
  def main(args: Array[String]): Unit = {
    new RationTrait {
      val numerarg = 1
      val denomarg = 2
    }
  }
}
