package com.scala

/**
  * Created by z00176928 on 2017/4/20.
  */

import com.scala.ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App{
  for(arg <- List("fall","Winter","Spring","Summer")) {
    println(arg + " : " + calculate(arg))
  }
}
