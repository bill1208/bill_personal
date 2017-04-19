/**
  * Created by z00176928 on 2017/4/19.
  */
class ChecksumAccumulator {

  private var sum = 0

  def add(n: Int):Unit = sum += n
  def checksum(): Int = ~(sum & 0xFF) + 1


}

object ChecksumAccumulator {

import scala.collection.mutable

  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int = {
    if(cache.contains(s)) {
      cache(s)
    } else {
      val ac = new ChecksumAccumulator
      for(c <- s) {
        ac.add(c.toByte)
      }
      val cs = ac.checksum()
      cache += (s -> cs)
      cs
    }
  }

  def main(args: Array[String]): Unit = {
    val test = new ChecksumAccumulator
    test.add(5)
    println(test.checksum())
    test.add(6)
    println(test.checksum())
  }
}
