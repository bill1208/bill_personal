/**
  * Created by z00176928 on 2017/4/19.
  */
class ChecksumAccumulator {

  private var sum = 0

  def add(n: Int):Unit = sum += n
  def checksum(): Int = ~(sum & 0xFF) + 1


}

object ChecksumAccumulator {

  def main(args: Array[String]): Unit = {
    val test = new ChecksumAccumulator
    test.add(5)
    println(test.checksum())
    test.add(6)
    println(test.checksum())
  }
}
