## Java

---

#### 4.19:

在数组中关于***System.arraycopy()*** 和 ***Arrays.copyOf()*** 的应用

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

#### 4.20

1. 补全字符串长度:
    ```java
    // 表示左对齐 并设定了字符串最少占据的字节长度 
    // 当str不足指定数字的字节长度时用空格补足
    String.format("%-数字s",str)
    ```

2. 将数组以["数据1","数据2","数据3"]的格式输出
    ```java
    int[]numbers={1,2,3,4};
    Arrays.toString(numbers);
    >>[1,2,3,4]
    ```

#### 4.21

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

2. Stream 流遍历数组:
    - 打印:
    ```java
    Stream.of(数组).foreach(System.out::println);
    Arrays.stream(数组).foreach(System.out::println)
    ```
    - 获取数值:
    ```java
    String.of(数组).foreach( e -> System.out.println("元素" + e);
    ```

3. compareTo() 与 equals() 与 ==

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
4. 获取子字符串
    ```java
    // 获取子字符串,从benginIndex(包括)到endIndex(不包括)结束
    // string.subString(benginIndex, endIndex)
    "123456".subString(1,3); 
    >>"23"
   ```

#### 4.22

1. Integer.parseInt(str)与Integer.valueOf(str)

    ```java
    Integer.parseInt(str) 将字符串转换成基本类型int
    Integer.parseInt(str) 自动拆箱,所以可以用 ==,来判断
   
    Integer.valueOf(str) 将字符串转换成Integer类型
    Integer.valueOf(str) 可以直接对转换的对象调用Integer里面的方法,若数字在 -128~127之间,会直接取缓存,超过则创建新的对象
    
   用integer1.equals(integer2) 来判断是否相等
    ```

#### 4.23

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
3. 位运算:^异或:相同为0,不同为1

