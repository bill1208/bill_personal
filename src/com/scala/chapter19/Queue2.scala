package com.scala.chapter19

/**
  * Created by 周生 on 2017/6/25.
  */
trait Queue2[T] {
  def head: T
  def tail: Queue2[T]
  def enqueue(x: T): Queue2[T]
}

object Queue2 {
  def apply[T](xs: T*): Queue2[T] = {
    new QueueImpl(xs.toList,Nil)
  }

  private class QueueImpl[T](
   private val heading: List[T],
   private val trailing: List[T]
   ) extends Queue2[T] {
    def mirror = {
      if(heading.isEmpty) {
        new QueueImpl[T](trailing.reverse,Nil)
      } else
        this
    }
    def head = mirror.heading.head
    def tail = {
      val q = mirror
      new QueueImpl[T](mirror.heading.tail,mirror.trailing)
    }
    def enqueue(x: T) = {
      new QueueImpl[T](heading,x :: trailing)
    }
  }
  def main(args: Array[String]): Unit = {
    val q1 = Queue2(3,4,5,5)
    println(q1.head)
  }

}
