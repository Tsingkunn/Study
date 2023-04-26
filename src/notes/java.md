# Java

---

## 4.19

在数组中关于 **System.arraycopy()** 和 **Arrays.copyOf()** 的应用

1. 删除数组中的一个元素

   ```java
   /**
   * 删除数组元素
   *
   * @param arr   需要删除元素的数组
   * @param index 需要删除元素的下标
   * @return 返回删除元素之后的数组
   */
   private static String[] delElement(String[] arr, int index) {
       // 剪切
       System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
       // 缩容
       arr = Arrays.copyOf(arr, arr.length - 1);
       return arr;
   }
   ```

2. 添加一个元素到数组中

   ```Java
   private static String[] addElement(String[] arr, String element) {
       // 扩容
       arr = Arrays.copyOf(arr, arr.length + 1);
       // 末位追加数据
       arr[arr.length - 1] = element;
       return arr;
    }
   ```

3. 关于字符串的方法:

   ```java
   // 以字符串 str 符开始,返回布尔值
   string.startsWith(String str);
   // 以字符串 str 结束,返回布尔值
   string.endWith(String str)
   // 包含字符串 str,返回布尔值
   string.contains(String str)
   // 分割字符,返回一个字符数组
   string.split()
   ```

## 4.20

1. 补全字符串长度:

   ```java
   // 表示左对齐 并设定了字符串最少占据的字节长度
   // 当str不足指定数字的字节长度时用空格补足
   String.format("%-数字s",str)
   ```

2. 将数组以["数据 1","数据 2","数据 3"]的格式输出

   ```java
   int[]numbers={1,2,3,4};
   Arrays.toString(numbers);
   >>[1,2,3,4]
   ```

## 4.21

1. 拼接字符串:

   ```java
   "abc".contact("def");
   >>"abcdef"
   // "+" 的链接操作会不断调用new StringBuilder.
   // new StringBuilder()--> append() --> toString --> ... -->
   // --> new StringBuilder() --> append() --> toString()
   // 会浪费大量内存空间
   "abc"+"def";
   >>"abcdef"
   ```

2. compareTo() 与 equals() 与 ==

   ```java
   String str1 = "123";
   String str2 = new String("123");
   String str3 = "1234";
   String str4 = "123";

   System.out.println(str1.compareTo(str2));
   >>0
   System.out.println(str1.compareTo(str3));
   >>-1
   System.out.println(str1.equals(str2));
   >>true
   System.out.println(str1 == str2);
   >>false
   System.out.println(str1 == str4);
   >>true
   ```

3. 获取子字符串

   ```java
   // 获取子字符串,从beginIndex(包括)到endIndex(不包括)结束
   // string.subString(beginIndex, endIndex)
   "123456".subString(1,3);
   >>"23"
   ```

## 4.22

1. Integer.parseInt(str)与 Integer.valueOf(str)

   ```java
   Integer.parseInt(str) // 将字符串转换成基本类型int
   Integer.parseInt(str) // 自动拆箱,所以可以用 ==,来判断

   Integer.valueOf(str) // 将字符串转换成Integer类型
   Integer.valueOf(str) // 可以直接对转换的对象调用Integer里面的方法,若数字在 -128~127之间,会直接取缓存,超过则创建新的对象

   integer1.equals(integer2) // 用此方法来判断是否相等
   ```

## 4.23

1. 知道数组长度,但每次都在数组后面添加元素,可以不用定义初始长度再找下标的方法,可以利用每次数组扩容的方式在数组最后面添加元素

   ```java
   public static void queryCountInfoByGender() {
      String[] genders = {};
      int[] counts = {};
      int count = 0;
      boolean exist = false;
      for (String person : people) {
         String perGender = person.split("-")[2];
         for (String gender : genders) {
            if (perGender.equals(gender)) {
               exist = true;
               break;
            }
         }
         if (!exist) {
            genders = addElement(genders, perGender);
         }
         exist = false;
      }
        // 用要统计的信息在数据中遍历
      for (String gender : genders) {
         for (String person : people) {
                if (person.split("-")[2].equals(gender)) {
                    count++;
                }
            }
         counts = Arrays.copyOf(counts, counts.length + 1);
         counts[counts.length - 1] = count;
         count = 0;
      }

      System.out.println(Arrays.toString(genders));
      System.out.println(Arrays.toString(counts));
   }
   ```

2. 将字符串转化为字符的方法

   ```java
   "string".charAt(0);
   >>'s'
   ```

3. 位运算:^异或:相同为 0,不同为 1

   ```java
   System.out.println(5 ^ 2);
   // 5: 101
   // 2: 010
   // x: 111
   >>7
   ```

4. 关于类中的变量

   ```java
   class Demo {
         public int id;
         public String name;
         @Override
         public String toString() {
            // 每次调用同String都会使id自增1;
            id ++;
            return id + " ";
         }
   }
   Demo demo = new Demo();
   // 这个操作也会让id自增.
   System.out.println(demo.id++);
   // 更有,在对成员变量进行字符串补空格的操作如果也是
   demo.name = String.format("%-12s", demo.name);
   // 上述操作也会改变引用中成员变量的数值,str会被补足.
   //然后将补足后的字符串赋值给原字符串demo.name.
   ```

## 面向对象

1. 什么是类?

   把某一类有相同特征(属性)和行为(方法)抽象出来的概念,叫做类.类是不占用内存的.

2. 什么是对象

   表示在现实生活中存在的事物.Java 中通过 new 关键字来创建一个对象.对象占用内存.

3. 成员变量与局部变量区别:

   1. **_定义位置_**:成员变量在类里面,方法体外面;局部变量定义在方法体,代码块里面
   2. **_默认值_**:成员变量如果没有赋值,则会默认值,和数组一样;局部变量必须有默认;
   3. **_生命周期_**:成员变量随着对象的创建而创建,随着对象被垃圾回收而消失;随着方法进栈而诞生,随着方法出栈而消失
   4. **_适用范围_**:成员变量整个类中都可使用;局部变量只有在方法体和代码块中执行
   5. **_存储位置_**:成员变量储存在堆内存中;局部变量储存在栈内存中;

4. 面向对象的三大特征:**封装,继承,多态**

- 封装:将类的信息隐藏到内部.

  - 访问修饰符:public , protected , default , private

    - private: 本类.
    - **default: 本类,同包**
    - protected: 本类,同包,子类
    - public: 本类,同包,子类,不同包

  - getter/setter
  - 构造方法
  - 方法重载

    - 同一类
    - 方法名一致
    - 方法的参数列表不一样(类型/个数/顺序)

  ```java
  public void show(int num) {}
  public void show(float f) {}
   ...
  public void show(int num, String str) {}
  public void show(String str, int num) {}
  ```

  - 构造方法重载

  - 同一类
  - 方法名一致
  - 方法的参数列表不一样(类型/个数/顺序)
  - **方法的返回值对方法的重载无影响**

  ```java
  public Job01() {
    System.out.println("无参构造方法");
  }

  public Job01(int num) {
  System.out.println("int : " + num);
  }

  ```

  - **static** 关键字

  - 类在被加载时同时被加载.
  - 只会加载一次,并且内存中只有一块内存空间保存
  - 可以修饰类/方法

  > 1. static 修饰的方法叫静态方法(类方法),该方法属于这个类,通过 **_类名.静态方法名(实参);_** 用 **_对象.方法名(实参)_** 也能调用
  > 2. 没有被 static 修饰的叫做成员方法,成员方法的调用方式为: **_对象.方法名(实参)_**

  ```java
  public class Job02 {
    static String name;
    int age;

    public Job02(String name, int age) {
       Job02.name = name;
       this.age = age;
    }

    public static void main(String[] args) {
       Job02 j1 = new Job02("晓峰", 20);
       Job02 j2 = new Job02("圆圆", 16);

       System.out.println(name);
       System.out.println(j1.age);
       System.out.println(name);
       System.out.println(j2.age);
       }
   }
   >>圆圆
   >>20
   >>圆圆
   >>16
  ```

  静态块:静态代码块主要用于类的初始化。它只执行一次，并且在同属于一个类的 main 函数之前执行。

  - 静态代码块会在类被加载时自动执行。
  - 静态代码块只能定义在类里面，不能定义在方法里面。

  ```java
  class Test01 {
      static {
          System.out.println("1234");
      }
      public static void main(String[] args){
      }
  }
  >>"1234"
  ```

  - 静态代码块里的变量都是局部变量，只在块内有效。
  - 一个类中可以定义多个静态代码块，按顺序执行。
  - 静态代码块只能访问类的静态成员，而不允许访问实例成员。

  ```java
  class Test02 {
     // 成员变量(类比C的"全局变量")
      static int a = 0;
      static {
          // 局部变量
          a = 0;
          // 定义int整型变量b,只能在静态块中使用,无法被静态块外部调用
          int b = 1;
      }
  }
  ```

  - 一个类可以使用不包含在任何方法体中的静态代码块，当类被载入时，静态代码块被执行，且只被执行一次，静态块常用来执行类属性的初始化.

  ```java
  class Test03 {
     static {
        System.out.println("run!");
     }
  }

  class Test04 {
     public static void main(String[] args) {
        new Test03();
     }
  }
  >>"run!"
  ```

  - 初始化顺序: 静态属性初始化 ->静态方法初始化 -> 普通属性初始化 -> 普通方法快初始化 -> 构造函数初始化

- 继承

  - public class 类名 extends 父类 { }
  - 子类只能继承父类中非私有化的属性和方法
  - **_构造方法不能被继承_**
  - 一个子类只能有一个父类,一个父类可以有多个子类
  - 继承关系满足: xxx(子类) is a xxx(父类)
  - 一个 B 类继承 A 类:

    1. B 类是 A 类的子类(派生类)
    2. 类是 B 类的超类(基类,父类)

  - 子类重写父类方法时:

    1. 问修饰符只能放大.
    2. 方法的返回值也与父类中相同.
    3. 方法的参数列表必须完全一致
    4. 方法名和父类中的方法名必须一致

       **方法的重载与重写**

       1.方法的重写:方法的重写是子类对父类中非私有,非 final,非 static 的方法的重新实现.
       返回值,方法名,参数列表必须完全一致, 且子类方法访问修饰符只能对比父类的只能扩大访问范围,不能缩小. 2.方法的重载:在同一类中,方法名相同,参数列表不同,返回值可以不同.同一类中,故访问范围可以扩大或缩小
       区别:① 位置不同 ② 参数列表不同 ③ 返回值不同 ④ 访问范围不同

  - this 与 super

    - this:表示当前类对象.

      `可以调用本类属性,方法,构造方法` **this 调用构造方法时,只能在本类构造方法内的第一行**

  ```java
  public class Student {

   String name;

   String gender;

   public Student() {
       // this 调用构造方法只能在构造方法第一行
       this("乔治", "男");
   }

   public Student(String name, String gender) {
       this.name = name;
       this.gender = gender;
   }

   public void speak() {
       System.out.println("speak!");
   }

   public void showInfo(String name) {
       System.out.println(this.name);
       this.speak();
   }

   public static void main(String[] args) {
       Student student = new Student();
       student.showInfo("");
   }
  }
  >>乔治
  >>speak!
  ```

  - super:出现在有继承关系的子类中

    - `可以调用父类的属性,方法,构造方法` **构造方法只能在子类的构造方法的第一行来 super 父类的构造方法,如果子类构造方法中没有
      super 父类的构造方法,那么编译时会默认 super()父类的方法**
      > 如果省略不写 super() ,那么默认第一行会调用父类的构造方法 super();
      > 也可以调用有参的构造函数
      > 当父类没有无参构造方法时,子类有无参构造,如果没有 super 父类的有参构造,
      > 将会默认 super()父类的无参构造,但由于父类没有无参构造,所以程序将会程序无法编译,
      > 所以这时必须要手动 super()父类的有参构造

  ```java
  public class Person {
    String name;
    String gender;

    public Person() {
        System.out.println("无参构造");
    }
    public Person(String name, String gender) {
      this.name = name;
      this.gender = gender;
    }

    public void eat() {
       System.out.println("吃---");
    }
  }
  ```

  ```java
   public class Teacher extends Person {
      public Teacher() {
         // 如果省略不写 super() ,那么默认第一行会调用父类的构造方法
         // super();
         // 也可以调用有参的构造函数
         // 当父类没有无参构造方法时,子类有无参构造,如果没有super父类的有参构造,
         // 将会默认super()父类的无参构造,但由于父类没有无参构造,将会程序无法编译,
         // 所以要手动super()父类的有参构造
         super("", "");
      }

      public Teacher(String name, String gender) {
         super(name, gender);
      }

      public void showInfo() {
         System.out.println(super.name);
         System.out.println(super.gender);
         super.eat();
      }

      public static void main(String[] args) {
         Teacher teacher = new Teacher();

         teacher.showInfo();
      }
   }
  ```

  - final: 可以修饰类,方法,变量

    - 被 final 修饰的类不能被继承
    - 被 final 修饰的方法不能被重写(无所谓重载)
    - 被 final 修饰的成员变量必须给初始值,成员变量一旦被定义就不能被修改.
    - 被 final 修饰的局部变量可以不赋初始值,但一旦赋值也不能被更改

  - 抽象类:

    - 抽象类不能被实例化
    - 抽象类主要是用来承载抽象方法的,如果一个抽象类里面没有抽象方法,那么抽象类也没有存在的必要了
    - 抽象类必须被继承,抽象类中的抽象方法必须被实现
    - 子类不能降低继承的抽象类中的方法的访问范围
    - 抽象类中可以定义构造方法,主要用来给子类用来初始化使用
    - 如果一个子类没有全部实现父类方法,那么这个子类是个抽象类.

  ```java
  // 抽象类可以定义普通类中的所有属性和方法
  // 抽象类中可以定义抽象方法,如果没有抽象方法,那么抽象类的存在没有意义
  public abstract class Animal {
      String name;
      String age;

      public Animal() {}

      public Animal(String name) {}

      // 抽象方法的定义:
      // 访问修饰符 abstract 返回值类型 方法名();
      public abstract void eat();

      public abstract void run();
  }

   // 抽象类可以被继承,继承的类亦可以是抽象类
   // 如果是普通类,则必须实现抽象类中的所有方法;
   // 如果是抽象类,可以不用实现抽象方法,
  public abstract class Dog extends Animal {

      @Override
      public void eat() {}

  }
  ```

- 接口

  - 定义 : 访问修饰符 interface 接口名{}
  - 特点 :

    1. 不能被实例化
    2. 都是抽象方法,接口中方法默认都是抽象方法,默认添加 public abstract 修饰符, 所有方法都是 public
    3. 不能定义构造方法
    4. 接口中变量都是常量,定义成员变量必须有初始值.默认添加 public static final,如 public static final int AGE = 10 或 int AGE = 10;
    5. 接口与接口之间可以实现多继承(extends)
    6. 抽象类中不必实现接口中的抽象方法

  - 实现:

    - 访问修饰符 interface 接口名 {}
      **_只能先继承,后实现_**

- 多态

  - 提高代码的扩展性,复用性
  - 解耦

  - 实现多态的特点:

    1. 有继承和实现关系.
    2. 子类中必须要重写父类/父接口中的方法.
    3. 父类的引用指向了子类的引用. `Vehicle vehicle = new Car();`
    4. 多态中是向上转型的.父类中的引用只能调用父类对子类重写的方法.不能调用子类中新增的方法.如果想调用子类中的方法,必须向下转型.

## 集合

- 单列集合

  - Collection(接口) --> 子接口 List , Set

    - List(接口):集合元素有序可重复的集合

      1. ArrayList 使用:

      > 1. 构造方法: 无参构造方法默认大小是 10
      > 2. add(E) 末尾追加元素
      >    add(int index, E element) 向指定下标添加元素
      >    addAll(Collection<? extends E> c) 向集合末尾添加一个新的集合
      >    clear() 删除所有元素
      >    contains(Object o) 集合中包含某元素
      >    get(index) 获取集合中指定位置元素
      >    indexOf(Object o) 返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
      >    isEmpty() 如果此列表不包含元素，则返回 true
      >    set(index, E) 用指定的元素（可选操作）替换此列表中指定位置的元素。
      >    remove(index) 删除该列表中指定位置的元素
      >    remove(obj) 从列表中删除指定元素的第一个出现（如果存在）
      >    removeAll(Collection<?> c) 从此列表中删除包含在指定集合中的所有元素
      >    size() 返回当前集合元素个数
      >    sort()
      >    sort(Comparator<? super E> c) 指定规则排序
      >    subList(int fromIndex, int toIndex) 返回此列表中指定的 fromIndex （含）和 toIndex 之间的 List。
      > 3. 遍历集合的方式:for;for-each;iterator
      >
      > ```java
      > Iterator it = list.iterator();
      >
      > while (it.hasNext()) {
      >   if (it.next().equals("cc")) {
      >       // 迭代器的remove方法每次删除元素之后会更新迭代器.
      >       // List的remove方法每次删除元素之后不会更新迭代器信息
      >       it.remove();
      >   }
      > }
      > ```
      >
      > 对数组的增加,删除操作,不要再 foreach 中进行.foreach 中的删除添> 加操作不会修改迭代器信息.会抛出异常.

    - Set(接口):集合元素无序不重复的集合

- 双列集合
  - Map<K,V>
