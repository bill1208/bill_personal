 package com.scala

import scala.io.Source

/**
  * Created by z00176928 on 2017/4/20.
  */
object Test {

  def main(args: Array[String]): Unit = {

   val x = Console.readLine()
    println("请输入名字")
    if(x.equals("zhouxingpeng")) {
      println("hello zhouxingpeng")
    } else {
      println("你输错了")
    }
//    file.foreach(line => if(line.contains("ab")) println(line + " -2-"))
//    file.foreach{line =>
//    }

//    val tupleList = List[(String, String)]()
//    // doesn't compile, violates case clause requirement
////    val filtered = tupleList.takeWhile( case (s1, s2) => s1 == s2 )
//    // block of code as a partial function and parentheses omission,
//    // i.e. tupleList.takeWhile({ case (s1, s2) => s1 == s2 })
//    val filtered = tupleList.takeWhile{ case (s1, s2) => s1 == s2 }
//
//    // curly braces omission, i.e. List(1, 2, 3).reduceLeft({_+_})
//    List(1, 2, 3).reduceLeft(_+_)
//    // parentheses omission, i.e. List(1, 2, 3).reduceLeft({_+_})
//    List(1, 2, 3).reduceLeft{_+_}
//    // not both though it compiles, because meaning totally changes due to precedence
//    List(1, 2, 3).reduceLeft _+_ // res1: String => String = <function1>
//
//    // curly braces omission, i.e. List(1, 2, 3).foldLeft(0)({_ + _})
//    List(1, 2, 3).foldLeft(0)(_ + _)
//    // parentheses omission, i.e. List(1, 2, 3).foldLeft(0)({_ + _})
//    List(1, 2, 3).foldLeft(0){_ + _}
//    // block of code and parentheses omission
//    List(1, 2, 3).foldLeft {0} {_ + _}
//    // not both though it compiles, because meaning totally changes due to precedence
//    List(1, 2, 3).foldLeft(0) _ + _
//    // error: ';' expected but integer literal found.
////    List(1, 2, 3).foldLeft 0 (_ + _)

  }



}
