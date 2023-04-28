# day11



## 一、内部类



### 1.1、成员内部类

```java
package com.wn;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示内部类 (了解)
 * 	内部类: 定义一个类中的类
 * 
 * 1、成员内部类
 * 2、静态内部类
 * 3、匿名内部类
 * 4、局部内部类
 */
public class OuterClass {
	
	//定义一个成员变量
	String str = "OuterClass类的成员变量";
	
	//定义成员内部类
	class InnerClass{
		
		//定义一个内部类的成员变量
		String str = "InnerClass类中的成员变量";

		//定义构造方法
		public InnerClass() {
			System.out.println("InnerClass 无参构造....");
		}
		
		//定义成员方法
		public void showInfo() {
			//定义内部类中的局部变量
			String str = "innerClass类中的局部变量";
			//打印所有变量的值
			System.out.println(str);
			System.out.println(this.str);
			System.out.println(OuterClass.this.str);
		}
	}
	/**
	 * 创建内部类对象并返回
	 */
	public InnerClass getInstance() {
		return new InnerClass();
	}
}

```

测试类:

```java
		//创建外部类的对象
//		OuterClass outer = new OuterClass();
//		//创建内部类的对象
//		OuterClass.InnerClass inner = outer.new InnerClass();
//		//调用方法
//		inner.showInfo();
		
//		OuterClass.InnerClass inner = new OuterClass().new InnerClass();
//		inner.showInfo();
		
//		OuterClass.InnerClass inner = new OuterClass().getInstance();
//		inner.showInfo();
```



## 1.2、静态内部类

```java
package com.wn;
/**
 * 演示静态内部类
 */
public class OuterClass2 {
	static String message = "OuterClass2中的成员变量";
	//定义静态内部类
	static class InnerClass2{
		
		//定义属性
		static String message = "静态内部类成员变量";
		
		//构造方法
		public InnerClass2() {
			System.out.println("无参构造");
		}
		
		//定义方法
		public void show() {
			String message = "静态内部类中的局部变量";
			System.out.println(message);
			System.out.println(InnerClass2.message);
			System.out.println(OuterClass2.message);
			
		}
		
	}
	
}

```

测试类:

```java
//创建静态内部类中对象
//		OuterClass2.InnerClass2 inner = new  OuterClass2.InnerClass2();
//		inner.show();
```



### 1.3、匿名内部类

```java
public class Test {
	public static void main(String[] args) {		
		//创建一个线程
		//定义一个类继承线程类,重写run方法
		//创建一个匿名内部类
		Thread t1 = new Thread() {
			//重写run方法
			@Override
			public void run() {
				//执行任务
				for(int i = 0;i < 10;i++) {
					System.out.println("i = " + i);
				}
			}
		};
//		System.out.println(Thread.currentThread().getName()); //获取当前正在执行的线程
//		t1.run();
		
		//创建Runnable接口对象，是以匿名内部类方式实现
		
		Runnable r = new Runnable() { //匿名内部类
			@Override
			public void run() {
				for(int i = 0;i < 10;i++) {
					System.out.println("i = " + i);
				}
			}
		};
		
		r.run();
		
	}
}
```





### 1.4、局部内部类

略....





## 二、Java8新特性

1、lambda表达式

2、方法的引用

3、新增接口方法

4、函数式接口

5、Stream流

6、Optional类

7、新增日期类型





## 三、接口新增方法



之前的接口中我们只能声明抽象方法，现在接口其实可以声明static和default修饰的方法



### 3.1、default修饰的方法

default 返回值类型(void) 方法名(参数列表){

​	//方法体

}



default修饰方法特点：

1.在接口中被default修饰的方法必须要有方法体 

2.接口中的default方法不能直接被自己调用，而是由实现类调用  

语法:实现类对象名.方法名(); 

3.接口中的default方法可以被子接口继承 

4.接口中的default方法可以被实现类重写和调用 



### 3.2、static关键修饰接口中的方法



static 返回值类型(void)  方法名(参数列表){

​	//方法体

}



static修饰方法特点:

1.使用static修饰接口中的方法并且必须有方法体(方法主体)。

2.接口中的static方法只能被接口本身调用。 

语法:接口名.方法名();

3.接口中的static方法不能被子接口类继承

4.接口中的static方法不能被实现类覆盖及直接调用 





## 四、函数式接口



**什么是函数式接口?**

​	接口中有且仅有一个抽象方法的接口，该接口就是一个函数式接口，但是函数式接口中可以有多个default或者static修饰的方法



如果接口上使用@FunctionalInterface注解，说明当前这个接口也是函数式接口，且该接口不能再定义第二个抽象方法

```java
/**
 * 自定义一个函数式接口
 */
@FunctionalInterface //声明当前接口是一个函数式接口
public interface FunctionInterface {
	
	void show();

}
```





## 五、Lambda表达式



lambda表示在Java中简化匿名内部类写法，使用代码更加清晰,简洁



lambda表达式 使用  ->  lambda操作符(箭头操作符)

lambda、表达式语法:

数据类型  对象名 = (参数列表)  ->  {方法体}



演示1：无参无返回值

```java
package com.lambda;

public class TestLambda01 {
	/**
	 * 演示无参无返回值方法
	 */
	public static void main(String[] args) {
		
		//1.创建Runnable接口对象，匿名内部类实现
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("run -----");
			}
		};
		//调用run方法
//		r1.run();
		
		//使用lambda对象匿名内部类进行简写
		Runnable r2 =  () -> {
			System.out.println("run -----");
		};
		//调用方法
//		r2.run();
		
		//lambda表达式简写2
		Runnable r3 =  () -> System.out.println("run -----"); 
		r3.run();
	}
}

```



演示2：有参无返回值

```java
package com.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * lambda简化有参数无返回值匿名方法
 */
public class TestLambda02 {
	public static void main(String[] args) {
		
		//实现一个参数的匿名内部类简写
		Consumer<String> con1 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		//调用方法
//		con1.accept("aaa");
		
		//lambda优化
		Consumer<String> con2 = (String str) -> {
			System.out.println(str);
		};
		
//		con2.accept("bbb");
		
		//lambda优化2
		Consumer<String> con3 = str -> System.out.println(str);
//		con3.accept("ccc");
		
		//演示参数有多个 匿名内部类实现
		BiConsumer<String, String> c1 = new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				System.out.println(t + u);
			}
		};
//		c1.accept("a", "b");
		
		//lambda表达式优化
		BiConsumer<String, String> c2 = (t1,t2) -> System.out.println(t1 + t2);
		c2.accept("b", "cc");
		
	}
}

```



演示3：有参有返回值

```java
package com.lambda;

import java.util.function.Function;

/**
 * 演示有参有返回值简写
 */
public class TestLambda03 {
	public static void main(String[] args) {
		
		//把一个字符串转换成int类型   匿名内部类实现
		Function<String, Integer> f1 = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		
		//调用方法
//		System.out.println(f1.apply("123"));
		
		//lambda表示简写
		Function<String, Integer> f2 = str -> Integer.parseInt(str);
		System.out.println(f2.apply("234"));
		
	}
}

```





## 六、方法的引用



***\*概念:\****方法的引用是对lambda表达式的优化，当lambda表达式重写的抽象方法，已经有现成

的方法可以使用时，此时，lambda表达式就显得冗余了，方法引用的优势是省去了参数的传递。



方法的引用操作符   "::"



//方法的引用有如下四种:

1、静态方法的引用:

​	类名 :: 方法名；

2、实例方法的引用：

​	类名 :: 方法名;

3、对象方法的引用：

​	对象名 :: 方法名;

4、构造方法的引用

​	类名 :: new;



## 七、Stream API



//获取Stream流对象

//1.通过Arrays获取

//2.通过集合获取

//3.Stream提供方法











