package com.scala.chapter19

/**
  * Created by 周生 on 2017/6/25.
  */
class Queue[T](private val leading: List[T], private val trailing: List[T]) {

  private def mirror = {
    if(leading.isEmpty) {
      new Queue(trailing.reverse, Nil)
    } else
      this
  }

  def head = {
    mirror.leading.head
  }

  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) = {
    new Queue(leading,x :: trailing)
  }
}
