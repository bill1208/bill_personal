package com.scala.chapter16

/**
  * Created by 周生 on 2017/6/17.
  */
object Test {

  def main(args: Array[String]): Unit = {
    val fruit = "apple" :: ("oranges" :: ("pears" :: Nil))
    val fruit3 = "apple" :: "oranges" :: "pears" :: Nil
    println(fruit)
    val fruit2 = List("apple", "oranges", "pears")

    val List(a,b,c) = fruit


    //list.length will traverse whole list, so it not suggestion to use fruit.length == 0
    //suggestion use fruit.isEmpty
    println(fruit.length == 0)
    println(fruit.isEmpty)

    //Unlike head and tail, which both run in constant time, init and last need to traverse the whole list to
    //compute their result. As a result, they take time proportional to the length of the list
    println(fruit.head)
    println(fruit.last)
    println(fruit.tail)
    println(fruit.init)

    println(fruit.reverse)

    println(fruit.take(1))
    println(fruit.drop(2))
    println(fruit.splitAt(2))

    //xs apply n equals (xs drop n).head
//    One reason why random element selection is less popular for lists than for arrays is that xs(n)takes time
//    proportional to the index n.
      println(fruit.apply(1))
    println(fruit(1))

    println(List(List(1,2), List(3), List(4,4)).flatten)
    println(fruit.map(_.toCharArray).flatten)

    println(fruit.zip(fruit))
    println(fruit.zipWithIndex)
    println(fruit.zip(fruit).unzip)

    println(fruit.mkString("[",",","]"))

    println(fruit.toArray)
    println(fruit.toArray.toList)

    val arr2 = new Array[Int](10)
    println(List(2,3,4).copyToArray(arr2,4))

    println(fruit.toIterator.next())

    println(List.apply(1,2,3))
    println(List.range(1,5))
    println(List.range(1,9,2))

//    println(List.fill(5))
    println(List.fill(5)('a'))
//    println(List.fill(2,3))
    println(List.fill(2,3)('b'))

    println(List.tabulate(5)(n => n * n))
    println(List.tabulate(5,5)(_ * _))

    println((List(3,5),List(10,20,30)).zipped.map(_ * _))
    println((List("abc","ab"), List(3,2)).zipped.forall(_.length == _))
    println((List("abc","ab"), List(3,2)).zipped.exists(_.length != _))


  }

  def append[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xsl => x :: append(xsl,ys)
  }
}
