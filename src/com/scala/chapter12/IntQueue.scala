package com.scala.chapter12

import scala.collection.mutable.ArrayBuffer
/**
  * Created by 周生 on 2017/6/11.
  */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  override def get(): Int = buf.remove(0)
  override def put(x: Int): Unit = buf += (x - 1)
}

class MyQueue extends BasicIntQueue with Doubling with Incrementing{} // will first effect by right

object IntQueue {
  def main(args: Array[String]) {
    val myQueue = new MyQueue
    myQueue.put(3)
    println(myQueue.get())

    val myQueue2 = new BasicIntQueue with Doubling with Filtering
    myQueue2.put(-1)
    myQueue2.put(1)
    println(myQueue2.get)

    val basicIntQueue = new BasicIntQueue
    basicIntQueue.put(3)
    basicIntQueue.put(4)
    println(basicIntQueue.get())
    println(basicIntQueue.get())
//    println(basicIntQueue.get())  //this will throw a exception, because there is no value in the queue
  }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) = super.put(2 * x)
}
trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = super.put(x + 1)
}
trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if(x > 0) super.put(x)
  }
}