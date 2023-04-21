## Java

---

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

1. 补全字符串长度:
>String.format("%-数字s",str)

表示左对齐 并设定了字符串最少占据的字节长度 当str不足指定数字的字节长度时用空格补足
1. 将数组以["数据1","数据2","数据3"]的格式输出

```java
        int[] numbers = {1, 2, 3, 4};
        Arrays.toString(numbers);
        >> [1,2,3,4]
```

#### 4.21
问题:git上已经上传的的文件夹,再在.gitignore中添加该文件夹,结果不生效的问题:

1. 原理解释:.gitignore 中只能添加之前没有被track(add)过的文件,如果文件已经进入了版本管理,那么在.gitignore中添加是无效的.
2. 解决方案:先把本地缓存删除掉(改成未track状态),然后再提交.
    >git rm -r --cached /out
    