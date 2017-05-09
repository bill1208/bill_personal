package com.scala

/**
  * Created by z00176928 on 2017/4/20.
  */
object Test {

  def main(args: Array[String]): Unit = {

//    print(if(!args.isEmpty) args(0) else "default.txt")

    println(List(12,23,3,4,-2034,1).filter(_ > 0))

    val f = (_:Int) + (_:Int)
    println(f(2,3))

//    val oneHalf = new Rational(1,2)
//    val oneThree = new Rational(1,3)
//    println(oneHalf * 2)
//
//    implicit def intToRational(x: Int) = new Rational(x)
//    println(2 * oneHalf)

//    println(""" welcome to linux
//print "help" for help.""")
//
//    println(
//      """ welcome to linux.
//        | print "help" for help.
//      """.stripMargin)
  }



}
