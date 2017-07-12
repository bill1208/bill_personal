package com.scala.chapter17

import scala.collection.immutable
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * Created by 周生 on 2017/6/18.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val fiveInt = new Array[Int](5)
    val fiveToOne = Array(5,4,3,2,1)
    fiveInt(0) = fiveToOne(1)

    val buf = new ListBuffer[Int]
    buf += 2
    buf += 3
    4 +=: buf
    println(buf)
    println(buf.toList)

    val arrayBuf = new ArrayBuffer[Int]()
    arrayBuf += 3
    arrayBuf += 4
    5 +=: arrayBuf
    println(arrayBuf)
    println(arrayBuf.toArray.mkString(","))

    def hasUpperCase(s: String) = s.exists(_.isUpper)
    println(hasUpperCase("adasdF"))

    type Map[A, +B] = collection.immutable.Map[A, B]
    type Set[A] = collection.immutable.Set[A]
    val Map = collection.immutable.Map
    val Set = collection.immutable.Set
    val set = collection.immutable.Set

    val text = "See Spot run. Run, Spot. Run!"
    val wordsArray = text.split("[ !,.]+")
    val words = mutable.Set.empty[String]
    for(word <- wordsArray) {
      words += word.toLowerCase
    }
    println(words)

    val map = mutable.Map.empty[String, Int]
    map("one") = 1
    map("two") = 2
    println(map("one"))

    println(countWords("See Spot run! Run, Spot. Run!"))

    val treeSet = immutable.TreeSet(94,3,123,213,14,12,1,2,3,431,3,2)
    println(treeSet)
    println(immutable.TreeSet('f','s','b','.'))
    println(mutable.TreeSet(94,3,123,213,14,12,1,2,3,431,3,2))
    println(immutable.TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x'))
//    println(mutable.TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x'))

    val stuff = mutable.Set(3)
//    stuff += "dsdf" //this will throw error, when run it, because when create it passed is int, so
    //it consider as int, but you add it a string, so will give error. we can def it as any
    println(stuff)
    val stuff2 = mutable.Set[Any](3)
    println(stuff2 += "adad")

    val colors = List("blue", "yellow", "red", "green")
//    val treeSet2 = immutable.TreeSet(colors)  // error: No implicit Ordering defined for, need do as following:
    val treeSet2 = immutable.TreeSet[String]() ++ colors
    println(treeSet2)

    val treeSet3 = immutable.Set("blue", "yellow", "red", "green")
    val mutaSet = mutable.Set.empty ++= treeSet3
    val immutableSet = immutable.Set.empty ++ mutaSet

    val longest = longestWord(Array("asdf","dsdfsdf","dsdfewerd"))
    println(longest._1)

    val (word, index) = longest
    val word2, index2 = longest  //means define 2 value equals to longest
    println(word)   //this two are different
    println(word2)
  }

  def countWords(text: String) = {
    val counts = mutable.Map.empty[String,Int]
    for(rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase
      val oldcount = if(counts.contains(word)) counts(word) else 0
      counts += (word -> (oldcount + 1))
    }
    counts
  }

  def longestWord(words: Array[String]) = {
    var word = words(0)
    var index = 0
    for(i <- 1 until words.length) {
      if(words(i).length > word.length) {
        word = words(i)
        index = i
      }
    }
    (word,index)
  }

}
