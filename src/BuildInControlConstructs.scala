import java.io.File

/**
  * Created by z00176928 on 2017/4/22.
  */
object BuildInControlConstructs {

  val filesHere = (new File(".")).listFiles()

  def sclaFiles = for {
    file <- filesHere
    if file.getName.endsWith("scala")
  } yield file.getName

  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

  def grep(pattern: String) = {
    for {file <- filesHere
         if file isFile
         if file.getName.endsWith("scala");
         line <- fileLines(file)
         trimmedLine = line.trim
         if trimmedLine.matches(pattern)
    } print(file + ":" + trimmedLine)
  }



}
