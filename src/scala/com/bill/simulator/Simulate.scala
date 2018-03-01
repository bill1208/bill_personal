package scala.com.bill.simulator

import java.io.{File, PrintWriter}
import java.util.Date
import javax.print.attribute.standard.PrinterMoreInfoManufacturer

import scala.io.Source
import scala.util.Random

object Simulate {

  def main(args: Array[String]): Unit = {

    println(new Date().getTime)
    val random = new Random()
    println(random.nextInt(100))
    println(random.nextDouble() * 1000)
    val msisdnPath = "/opt/test/msisdn.txt"
    val smartPhonePath = "/opt/test/smartPhone.txt"
    val msisdnWithPhonePath = "/opt/test/msisdnWithPhone.txt"

//    println("10000000000".substring(0, "1"))
    val msisdnNum = 10
    val msisdnLength = 11
    val manufacturerNum = 50
    val modelNum = 30
//    generateMsisdn(msisdnNum, msisdnLength, msisdnPath)
//    generateSmartphone(manufacturerNum, modelNum, smartPhonePath)
//    generateMsisdnWithPhone(msisdnpath, smartPhone, msisdnWithPhonePath)
    schedulerGenerateDataForArab(1000, 10, "second", msisdnWithPhonePath, "/opt/test/arab")

  }



  def schedulerGenerateDataForArab(rows: Int, bacthRow: Int, timeLevel: String, msisdnWithPhonePath: String, resultFolder: String) = {
    //timeLeve, second, minute, hour, day
//    val writer = new PrintWriter(new File(resultPath), "TUF-8")
    val msisdnWithPhone = Source.fromFile(msisdnWithPhonePath).getLines().toList

    val msisdnWithPhoneSize = msisdnWithPhone.size
    val random = new Random()
    var startTime = new Date().getTime
    var fileNum = 0
    val sb = new StringBuilder()
    for(i <- 0 to rows) {
      sb.append(msisdnWithPhone(i % msisdnWithPhoneSize)).append(",")  //need imei, imesi, msisdn
      sb.append(getNextInt(random,100)).append(",")
      sb.append(getNextDouble(random, 10000)).append(",")
      sb.append(startTime).append("\n")

      if(i % bacthRow == 0) {
        val writer = new PrintWriter(new File(resultFolder + "/" + "rest" + fileNum + ".txt"))
        writer.write(sb.toString())
        println(fileNum + "============" + sb.toString())
        writer.close()
        sb.setLength(0)
        fileNum = fileNum + 1
        startTime = startTime + 300
      }

    }

  }

  private def generateMsisdn(rows: Int, length: Int, resultPath: String) = {
    val writer = new PrintWriter(new File(resultPath), "UTF-8")
    var initialMsisdn = "1"
    for(i <- 1 to length - 1) {
      initialMsisdn = initialMsisdn + "0"
    }
    println(initialMsisdn)

    for(i <- 1 to rows) {
      println(initialMsisdn.substring(0,length - i.toString.length) + i)
      writer.write(initialMsisdn.substring(0,length - i.toString.length) + i + "\n")
    }

    writer.close()
  }

  private def generateSmartphone(manufacturerNum: Int, modelNum: Int, resultPath: String) = {
    val writer = new PrintWriter(new File(resultPath), "UTF-8")
    for(i <- 0 to manufacturerNum) {
      for(j <- 0 to modelNum) {
        writer.write("Manufacturer" + i + ",model" + j + "\n")
      }
    }
    writer.close()
  }


  private def generateMsisdnWithPhone(msisdnPath: String, phonePath: String, resutPath: String) = {
    val msisdn = Source.fromFile(msisdnPath)
    val smartPhone = Source.fromFile(phonePath).getLines().toList

    val writer = new PrintWriter(new File(resutPath), "UTF-8")

    var i = 0
    val size = smartPhone.size
    for(line <- msisdn.getLines()) {
        println(line + "," + smartPhone(i % size) + "\n")
      i = i + 1
      //need imei, imesi, msisdn
      writer.write(line + "," + line + "," + line + "," + smartPhone(i % size) + "\n")
    }
    writer.close()
  }


  def getFixLengthNumber(length: Int): Int = {

    1

  }

  private def getNextInt(random: Random, maxNum: Int): Int = {
    random.nextInt(maxNum)
  }

  private def getNextDouble(random: Random, maxValue: Long): Double = {
    random.nextDouble() * maxValue
  }
}
