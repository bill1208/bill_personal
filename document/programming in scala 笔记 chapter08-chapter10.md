# chapter 8 Functions and closoures
## 8.1 methods 
定义一个函数作为obeject的成员，此函数就是方法。

## 8.2 local fucntion
一个大的程序需要切割成一个个小的函数，有些函数只是为了其他函数的辅助作用，像这样的函数一般定义为private。但是如果这样的函数变多了会占用函数的命名空间，所以一般用本地函数来替代，也就是内部函数。

```
object LongLines {

  def processFile(fileName: String, width: Int) = {
    val lines = Source.fromFile(fileName)
    for(line <- lines.getLines()) {
      processLine(fileName,width,line)
    }
  }

  private def processLine(fileName: String, width: Int, line: String) {
    if(line.length > width) {
      println(fileName + ": " + line.trim)
    }
  }


  def processFile_optimized(fileName: String, width: Int) = {
    val lines = Source.fromFile(fileName)
    for(line <- lines.getLines()) {
      processLine(line)
    }

    def processLine(line: String): Unit = {
      if(line.length > width) {
        println(fileName + ": " + line.trim)
      }
    }
  }
  def main(args: Array[String]): Unit = {

  }

}
```

## 8.3 first-class function
scala中不仅可以定义函数并引用它，也可以定义未命名的字面值函数，把他当做值一样传递给其他函数或者赋值给其它变量。

unamed function 会编译到class中，unamed fucntin 可以被赋值到变量，通过变量调用，如果函数有多行值可以用大括号括起来，最后一行就是函数的返回值。

```
  (x:Int) => x + 1
  (x:Int) => {
    println(1212)
    println(x)
    x + 1
  }

  val addOne = (x:Int) => x + 1
  addOne(10)
```

## 8.4 short forms of function
函数的调用可以简化，例如去掉数据类型（如果编译器可以自动检测），去掉括号（如果数据类型被去掉）。

```
val list = List(12,3,4,5)
list.foreach((x) => x + 1)
list.foreach(x => x + 1)
```
## 8.5 占位符
占位符可以让字面值函数更加简洁，可以理解一个占位符就是一个空置，作用于占位符的函数要把自身的每一个值填到空置位置上。

```
println(List(12,23,3,4,-2034,1).filter(_ > 0))
```
有时需要给占位符指定类型，上例scala可以自己检测。

```
val f = (_:Int) + (_:Int)
println(f(2,3))
```

## 8.6 部分函数-partially function，注意不是偏函数。部分函数就是只函数的参数少了一部分。


```
def main(args: Array[String]): Unit = {

    val a = sum _  //把sum赋值给一个变量a,scala编译器会检测sum _少了三个参数会生成一带有3个参数的函数。注意sum和_之间有空格
    print(a)
    println(a(1,3,4)) //当调用a(1,2,3)时，其实调用a.apply(1,2,3)
    val b = sum(_:Int, 2,3) //也可以指定其中的部分函数。
    println(b)
    println(b(1))

  }

  def sum(a:Int, b:Int, c:Int):Int = a + b + c //sum有三个参数
```

