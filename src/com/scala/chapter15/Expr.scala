package com.scala.chapter15

/**
  * Created by 周生 on 2017/6/17.
  */
abstract class Expr

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, expr: Expr) extends Expr
case class BinOp(operator: String, leftExpr: Expr, rightExpr: Expr) extends Expr

object Test {
  def main(args: Array[String]): Unit = {

    collectionTypeMatch(Array("dsd"))
    collectionTypeMatch(Map(1 -> 1))
    collectionTypeMatch(Map("a" -> "b"))

    val v = Var("x")  //can directly use class name to construct a object, because case class add a factory method for this.
    v.name // case class default define a val variable from the class parameter
    v.copy() // cass class default has a copy method, which can only specify the changed class parameter
    v.equals()
    v.toString // default implement the equals and toString

    val op = BinOp("+",v,v)
    val op2 = BinOp("-", Number(4.0),Var("d"))  //the benefit of use the class name to crate a variable

    //if match one value will not go to next, in the book told like： Second, Scala's alternative expressions never "fall through" into the next
//    case
    v match {
      case Var(e) => println("it is match to the Var(" + e + ")")
      case _ => println("just println")
    }

    //match is a expression will return a value.
    val matchResult = v match {
      case Var(e) => e
      case _ => "jst a value"
    }
    println(matchResult)

    println(describe((5)))


  }

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e  //this is the construct match
    case BinOp("+", Number(0),e) => e
    case BinOp("*", e, Number(1)) => e
    case BinOp("*", Number(1), e) => e
    case _ => expr
  }

  // how constant as match
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi"
    case Nil => "the empty list"
    case _ => "something else"
  }

  //A pattern match with a variable pattern
  def matchVariable(expr: Expr) = expr match {
    case Number(0) => "it is zero"
    case somethingElse => "not a zero, it is  " + somethingElse
  }

  //how to know the Pi is a variable or a constant, one rule, which start with lowercase is variable math, others is constant
  import math.{E,Pi}
  E match {
    case Pi => "it is Pi = " + Pi
    case _ => "Ok"
  }

  //the book told this is not allowed because the variable is cover all the match ,so no need case _ for default, but try it succesffuly
  E match {
    case pi => "it is just a pi not Pi" + pi
    case _ => "other"
  }

  // use the `` can specify it to a constant not a variable, or use Math.PI, or object.variable
  val pi = Math.PI
  val number2 = Number(2)
  E match  {
    case `pi` => "strange math? Pi = " + pi
    case Math.PI => "strange math? Pi = " + pi
    case number2.num => "strange value = " + number2.num
    case _ => "nothing"
  }

  //list match
  def matchList(expr: Any) = {
    expr match {
      case List(0,_,_) => println("it match a list(3) start with 0")   //list match
      case List(0, _*) => println("it match a list which start with 0")  //list match
      case (a,b,c) => println("it match a tuple(a,b,c)")
      case s: String => println("it match a string s and its lenght is " + s.length)
      case map: Map[_,_] => println("it matches map and it size is " + map.size)
    }
  }

  //to match the type in collection or Array
  def collectionTypeMatch(x: Any) = {
    x match {
      // this is not work, because during running time,
      // scala doesnot maintained the type information
      // so match(Map(1 -> 1) and Map("a" -> "b") will both retur true.
      // But only Array can work.
      case m: Map[Int,Int] => println("it matches a map[int,int]")
      case array: Array[String] => println("it matches a Array[String]")
    }
  }

  //variable binding during the match to assign a value to one variable if match successfully
  def binddingVariable(expr: Expr) = {
    expr match {
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case e @ UnOp("+", _) => e
    }
  }

  //pattern guards
  def simplifyAdd(expr: Expr) = expr match {
//    case BinOp("+", x, x) => BinOp("*", x, Number(2)) // this cannot compile because x appear 2 times, this can do as following:
    case BinOp("+", x, y) if(x == y) => BinOp("*", x, Number(2))
    case _ => expr
  }
}