package com.scala.chapter9

/**
  * Created by 周生 on 2017/5/21.
  */
object Test {
  def main(args: Array[String]) {

    println(fileContains("txt").mkString(","))
    println(fileMatch("txt",(file,qury) => file.contains(qury)).mkString(","))
    println(fileMatch("txt",(file,qury) => file.endsWith(qury)).mkString(","))

  }

  private def fileHere = new java.io.File("d:\\test").listFiles()

  def fileEnding(query: String) = {
    for(file <- fileHere if file.getName.endsWith(query))  yield file
  }

  def fileContains(query: String) = {
    for(file <- fileHere if file.getName.contains(query)) yield  file
  }

  def fileMatch(query: String) = {
    for(file <- fileHere if file.getName.matches(query)) yield  file
  }

  def fileMatch(query:String, matchs: (String,String) => Boolean) = {
    for(file <- fileHere if matchs(file.getName, query)) yield file
  }

  def fileEnd(query: String) = {
//    fileMatch(query,(file,query) => file.endsWith(query) )
    fileMatch(query, _.endsWith(_))
  }

  def fileMatch(matchs: String => Boolean) = {
    for(file <- fileHere if matchs(file.getName)) yield file
  }

  def containOdd(num: List[Int]): Boolean = {
    var exist = false
    for(value <- num) {
      if(value % 2 == 0)
        exist = true
    }
    exist
  }

  def containOdd2(num: List[Int]): Boolean = num.exists(_ % 2 == 0)

}
