package com.scala.chapter19

/**
  * Created by 周生 on 2017/6/23.
  */
class SlowAppendQueue[T](element: List[T]) {
  def head = element.head
  def tail = new SlowAppendQueue(element.tail)
  def enqueue(x: T) = new SlowAppendQueue(element ::: List(x))
}
