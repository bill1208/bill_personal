package com.scala

/**
  * Created by z00176928 on 2017/4/28.
  */
object FindLongLines {
  def main(args: Array[String]) = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }
}
