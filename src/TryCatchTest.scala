/**
  * Created by z00176928 on 2017/4/27.
  */
object TryCatchTest {
  var name = 0

  def main(args: Array[String]): Unit = {
    println(123)
    println(f())
    println(g())
    h()
    println(name)
  }

  def f(): Int = try return 1 finally return 2
  def g(): Int = try 1 finally 2
  def h() = try name = 1 finally name = 2
}
