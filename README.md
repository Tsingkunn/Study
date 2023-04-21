## JAVA

---

在蜗牛培训学习时期的全部代码

#### 4.19:

今日了解到了两个重要的方法:

- 重点在于 System.arraycopy() 和 Arrays.copyOf()的应用

1. System.arraycopy() 方法需要传入两个数组,没有返回值.

```java
    delFlower = flowerName[index]; //记录被删除的信息
    System.arraycopy(flowerName, index + 1, flowerName, index, flowerName.length- 1 - index); // 数组之间的切片复制
    flowerName = Arrays.copyOf(flowerName, flowerName.length - 1); // 数组缩容
```

1. Arrays.copyOf() 方法需要传入一个数组,重要的是可以自动缩容与扩容并且返回这个缩容或者扩容之后的数组.

```Java
    flowerName = Arrays.copyOf(flowerName, flowerName  length + 1); // 数组扩容
    flowerName[flowerName.length - 1] = name; // 添加数据
```

1. 字符串的四个方法:
   - string.startsWith(String str) 以字符串 str 符开始,返回布尔值
   - string.endWith(String str) 以字符串 str 结束,返回布尔值
   - string.contains(String str) 包含字符串 str,返回布尔值
   - string.split() 分割字符,返回一个字符数组

#### 4.20

今日去找了一下如何补全字符串长度:
String.format("%-数字s",str)  表示左对齐 并设定了字符串最少占据的字节长度 当str不足指定数字的字节长度时用空格补足
