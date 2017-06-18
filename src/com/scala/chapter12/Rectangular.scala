package com.scala.chapter12

import java.awt.Point

/**
  * Created by 周生 on 2017/6/11.
  */
trait Rectangular {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x

  def width = right - left
}

abstract class Component extends Rectangular

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular
