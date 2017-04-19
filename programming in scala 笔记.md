## use tuple
定义tuple的方法，访问tuple元素的方法

```
val test_tuple = (1,"name")
println(test_tuple._1)
println(test_tuple._2)
```
tuple是不可变的，tuple不同于list，tuple可以包含不同类型的元素，当一个函数需要返回多个不同类型的值时可以考虑使用tuple。

tuple为什么不用和list同样的方式(0)来访问元素，以为apply方法通常会返回相同的数据类型，但是tuple里面包含不同的数据类型。还有tuple的下标是从1开始的不是从0开始。
## use the set and map
set和map scala都提供了两种：可变的和不可变的。默认是不可变的，要使用可变的需要导入可变的包路径。set和map的继承关系如下图. hashMap和此图类似
![image](http://images2015.cnblogs.com/blog/981815/201704/981815-20170418103807712-2120396671.png)
set和map的定义方法如下和list，array类似：

```
val set = Set("bill","nick")
set += "tack"   //对于不可变set += 相当于 set = set + "tack", 对于可变的相当于调用set.+= 方法
println(set.contains("nice") 

val treasureMap = Map(1 -> "bill", 2 -> "nick")
treasureMap += (3 -> "test")
println(treasuerMap(3)) 

```

## step 12 read lines from a file
一个例子从文件读取每一行，并打印出每一样的长度，且对格式的要求。

里面学习到了一个知识：函数作为参数的意义。如下：

```
//line为从文件中读取的内容的list。
val longestLine = line.reduceLeft((a,b) => if(a.length > b) a else b )
//reduceleft 可以接受一个函数作为参数，(a,b) => if(a.length > b) a else b 为一个函数，reduceleft会按照这个函数的规则去处理自己集合中前两个元素，作用后的结果再和下一个元素按照规则处理。
```

# class and Object
## class, fields and methods
class是object的blueprint，定义好class后可以通过new关键字创建一个object。

fields和method是class的member。

fields是asinstance的，即从一个class创建了两个类，改变一个类中field的值不会影响另外一个类的值。

把field定义为private的属性可以保持类的鲁棒性。field默认为public的，不需要定义field之前添加public 关键字。

虽然scala能识别方法的返回值类型，但是为了方便阅读以及调用者调用类，最好每个方法都明确标明返回值类型。

方法的参数都是val的，不能在方法内部改变参数的值

如果一个方法只有副作用(side effort)，这个方法就叫做procedure