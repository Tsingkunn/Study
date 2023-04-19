## JAVA

---

在蜗牛培训学习时期的全部代码.

#### 4.19:

今日了解到了两个重要的方法:

- 重点在于 System.arraycopy() 和 Arrays.copyOf()的应用

1. System.arraycopy() 方法需要传入两个数组,没有返回值.

```java
    delFlower = flowerName[index]; //记录被删除的信息
    System.arraycopy(flowerName, index + 1, flowerName, index, flowerName.length- 1 - index); // 数组之间的切片复制
    flowerName = Arrays.copyOf(flowerName, flowerName.length - 1); // 数组缩容
```

2. Arrays.copyOf() 方法需要传入一个数组,重要的是可以自动缩容与扩容并且返回这个缩容或者扩容之后的数组.

```Java
    flowerName = Arrays.copyOf(flowerName, flowerName  length + 1); // 数组扩容
    flowerName[flowerName.length - 1] = name; // 添加数据
```

- 对于字符串的操作:
  1. string.startsWith(String str) 以什么字符开始
  2. string.endWith(String str) 以什么字符结束
  3. string.contains(String str) 包含什么字符
