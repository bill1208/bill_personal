/**
  * Created by z00176928 on 2017/4/20.
  */

import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]): Unit = {
    for(arg <- args) {
      println(arg + " : " + calculate(arg))
    }
  }

}
