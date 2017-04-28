/**
  * Created by z00176928 on 2017/4/21.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n,1)

//  println(s"created $n/$d")

  override def toString: String = {
    if(denom != 1) {
      numer + "/" + denom
    } else {
      numer.toString
    }
  }

  def add(that: Rational): Rational = {
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  }

  def +(that: Rational): Rational = {
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  }

  def +(n: Int): Rational = {
    new Rational(numer + n * denom, denom)
  }

  def -(that: Rational): Rational = {
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  }

  def -(n: Int): Rational = {
    new Rational(numer - n * denom, denom)
  }

  def *(that: Rational): Rational = {
    new Rational(numer * that.numer, denom * that.denom)
  }

  def *(n: Int): Rational = {
    new Rational(numer * n, denom)
  }

  def /(that: Rational): Rational = {
    new Rational(numer * that.denom, denom * that.numer)
  }

  def /(n: Int): Rational = {
    new Rational(numer, denom * n)
  }

  def lessThan(that: Rational): Boolean = {
    numer * that.denom < that.numer * denom
  }

  def max(that: Rational): Rational = {
    if(lessThan(that)) that else this
  }

  def gcd(a: Int, b: Int): Int = {
    if(b == 0) a else gcd(b, a % b)
  }
}
