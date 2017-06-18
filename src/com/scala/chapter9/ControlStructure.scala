package com.scala.chapter9

import java.io.{File, PrintWriter}

/**
  * Created by 周生 on 2017/5/21.
  */
object ControlStructure {
  def main(args: Array[String]) {




    def twice(op: Double => Double, x: Double) = op(op(x))
    println(twice(_ + 1, 5))
    println(twice((x => x + 1), 5))  // x = x + 1

    val file = new File("D:\\test\\writer.txt")
    withPrintWriter(file, writer => writer.print(new java.util.Date()))
    withPrintWriter(file, _.print(new java.util.Date()))

    // if the function only have one parameter, it can use curly to replace the parentheses
    //for the make your client code look like a bit more like a built-in control
    println("121212")
    println{"121212"}

    // so for the writhPrintWriter use currying to def it, then can use curly
    withPrintWriter02(file){_.print(new java.util.Date())}
    withPrintWriter02{file}{_.print(new java.util.Date())}
  }

  //write new control structure
  def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

   //write new control structure with currying function
  def withPrintWriter02(file: File)(op: PrintWriter => Unit) = {
     val writer = new PrintWriter(file)
     try {
       op(writer)
     } finally {
       writer.close()
     }
   }

}
