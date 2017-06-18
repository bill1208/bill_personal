package com.scala.chapter15

/**
  * Created by 周生 on 2017/6/17.
  */
sealed abstract class Expr2
case class Var2(name: String) extends Expr2
case class Number2(num: Double) extends Expr2
case class UnOp2(operator: String, arg: Expr2) extends Expr2
case class BinOp2(operator: String,left: Expr2, right: Expr2) extends Expr2

  object Test2 {

    def main(args: Array[String]): Unit = {
      val capitals = Map("China" -> "beijing", "Indian" -> "mengmai")
      println(capitals.get("China"))
      println(capitals.get("Japan"))

      println(show(capitals.get("China")))
      println(show(capitals.get("ddd")))


      val withDefault: Option[Int] => Int = {
        case Some(x) => x
        case None => 0
      }

      println(withDefault(Some(10)))
      println(withDefault(Option(4)))
      println(withDefault(None))
    }

    def show(x: Option[String]) = x match {
      case Some(x) => x
      case None => "?"
    }



//it wil give a compiler warning, because not case all
    def describe(e: Expr2): String = e match {
      case Number2(_) => "a number"
      case Var2(_) => "a variable"
//      case UnOp(_,_) => "a unop"
//      case BinOp(_,_,_) => "a binop"
    }
  }

