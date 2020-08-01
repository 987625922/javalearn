# kotlin
### 1.类与集成

- ##### 构造函数

  ```
  class Person(val name: String) {
  	init(){}
      var children: MutableList<Person> = mutableListOf<>()
      constructor(name: String, parent: Person) : this(name) {
          parent.children.add(this)
      }
  }
  ```

  init()方法会在次构造函数前执行

  私有构造函数

  ```
  class DontCreateMe private constructor () { /*……*/ }
  ```

- ##### 继承

  超类是Any，Any有三个方法`equals()`、 `hashCode()` 与 `toString()`。因此，为所有 Kotlin 类都定义了这些方法。Kotlin 类是最终（final）的：它们不能被继承。 要使一个类可继承，请用 `open` 关键字标记它。

  ```
  open class Base(p: Int)
  
  class Derived(p: Int) : Base(p)
  
  class MyView : View {
      constructor(ctx: Context) : super(ctx)
  
      constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
  }
  ```

  果派生类有一个主构造函数，其基类可以（并且必须） 用派生类主构造函数的参数就地初始化。如果派生类没有主构造函数，那么每个次构造函数必须使用 *super* 关键字初始化其基类型，或委托给另一个构造函数做到这一点。 

- ##### 覆盖方法

  ```
  open class Shape {
      open fun draw() { /*……*/ }
      fun fill() { /*……*/ }
  }
  
  class Circle() : Shape() {
      override fun draw() { /*……*/ }
  }
  ```

- ##### 覆盖属性

  ```
  open class Shape {
      open val vertexCount: Int = 0
  }
  
  class Rectangle : Shape() {
      override val vertexCount = 4
  }
  ```

- ##### 调用超类实现

  ```
  class FilledRectangle: Rectangle() {
      fun draw() { /* …… */ }
      val borderColor: String get() = "black"
      
      inner class Filler {
          fun fill() { /* …… */ }
          fun drawAndFill() {
              super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 实现
              fill()
              println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
          }
      }
  }
  ```
覆盖规则

  可以同时继承 `Rectangle` 与 `Polygon`， 但是二者都有各自的 `draw()` 实现，所以我们必须在 `Square` 中

  覆盖 `draw()`， 并提供其自身的实现以消除歧义。
  
  ```
  open class Rectangle {
      open fun draw() { /* …… */ }
  }
  
  interface Polygon {
      fun draw() { /* …… */ } // 接口成员默认就是“open”的
  }
  
  class Square() : Rectangle(), Polygon {
      // 编译器要求覆盖 draw()：
      override fun draw() {
          super<Rectangle>.draw() // 调用 Rectangle.draw()
          super<Polygon>.draw() // 调用 Polygon.draw()
      }
}
  ```
  
- ##### 抽象类

  ```
  open class Polygon {
      open fun draw() {}
  }
  
  abstract class Rectangle : Polygon() {
      abstract override fun draw()
  }
  ```

- ##### 对象表达式（内部类）

  创建一个匿名内部类

  ```
  window.addMouseListener(object : MouseAdapter() {
      override fun mouseClicked(e: MouseEvent) { /*……*/ }
  
      override fun mouseEntered(e: MouseEvent) { /*……*/ }
  })
  ```

  创建一个内部类

  ```
  open class A(x: Int) {
      public open val y: Int = x
  }
  
  interface B { /*……*/ }
  
  val ab: A = object : A(1), B {
      override val y = 15
  }
  //=========
  fun foo() {
      val adHoc = object {
          var x: Int = 0
          var y: Int = 0
      }
      print(adHoc.x + adHoc.y)
  }
  ```

  对象声明（单例模式）

  ```
  object DataProviderManager {
      fun registerDataProvider(provider: DataProvider) {
          // ……
      }
      val allDataProviders: Collection<DataProvider>
          get() = // ……
  }
  ```

- ##### 伴生对象

  ```
  class MyClass {
      companion object { }
  }
  ```

### 2.属性与字段

Kotlin 类中的属性既可以用关键字 *var* 声明为可变的，也可以用关键字 *val* 声明为只读的。

如果只读属性的值在编译期是已知的，那么可以使用 *const* 修饰符将其标记为*编译期常量*。

lateinit 延迟初始化属性与变量，.isInitialized 检测一个 `lateinit var` 是否已经初始化

### 3.泛型

- 使用关键字 `out` 来支持协变，等同于 Java 中的上界通配符 `? extends`。

- 使用关键字 `in` 来支持逆变，等同于 Java 中的下界通配符 `? super`。

  ```
  var textViews: List<out TextView>
  var textViews: List<in TextView>
  class Producer<out T>{}
  ```

- java的无界符?和kotlin的*相等

- java的泛型extends可以换成：

  ```
  //java
  class Monster<T extends Animal & Food>{ 
  }
  //kotlin
  class Monster<T> where T : Animal, T : Food
  ```

### 4.扩展函数和方法

```
//把MutableList扩展一个swap的方法
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}
//扩展属性
var String.s: Int
    get() = this.length
    set(value){
        //set方法并没有field可以用来存储value，
        //其实际作用是使用通过value来操作调用者，即this
        println(this.plus(value))
    }
```
### 5.嵌套类与内部类

```
//嵌套类
class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

val demo = Outer.Nested().foo() // == 2
```

```
//内部类
class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

val demo = Outer().Inner().foo() // == 1
```
### 6.委托

```
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    //使用委托
    Derived(b).print()
}
```

