package com.scala

import scala.io.Source

/**
  * Created by z00176928 on 2017/4/28.
  */
object LongLines {

  def processFile(fileName: String, width: Int) = {
    val lines = Source.fromFile(fileName)
    for(line <- lines.getLines()) {
      processLine(fileName,width,line)
    }
  }

  private def processLine(fileName: String, width: Int, line: String) {
    if(line.length > width) {
      println(fileName + ": " + line.trim)
    }
  }


  def processFile_optimized(fileName: String, width: Int) = {
    val lines = Source.fromFile(fileName)
    for(line <- lines.getLines()) {
      processLine(line)
    }

    def processLine(line: String): Unit = {
      if(line.length > width) {
        println(fileName + ": " + line.trim)
      }
    }
  }
  def main(args: Array[String]): Unit = {

  }

}
