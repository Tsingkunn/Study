package practice.array;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

// Iterable<E> 可以实现迭代
// Cloneable 可以使用.clone()方法;标记型接口,内部没有需要实现的抽象方法
// Serializable可序列化;标记型接口,内部没有需要实现的抽象方法
public class MyArrayList<E> implements Iterable<E>, Cloneable, Serializable {
    // Object空数组
    private static final Object[] EMPTY_LIST = {};

    // 数组初始化默认大小 10
    private static final int DEFAULT_SIZE = 5;

    // 记录数组大小
    private int size;

    // values 是一个动态数组,有些数据可能是空值,为null
    // 没有序列化的必要
    private transient Object[] values;

    // 空参构造函数,默认初始数组大小为10
    public MyArrayList() {
        values = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    // 一参构造函数,初始化时给定默认数组的大小值
    public MyArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Index Out Bounds: " + size);
        } else {
            values = new Object[size];
            this.size = 0;
        }
    }

    // 链式添加方法.
    public MyArrayList<E> add(E e) {
        // 静态方法Objects.requireNonNull是不能添加null元素进来
        Objects.requireNonNull(e);
        addValue(e);
        return this;
    }

    // 普通的添加方法,添加到结合的最后一位,注意不是内部实现数组的最后一位
    public void endAdd(E e) {
        // 静态方法Objects.requireNonNull是不能添加null元素进来
        Objects.requireNonNull(e);
        addValue(e);
    }

    // 删除,无参删除,默认删除最后一位,并返回删除的元素
    @SuppressWarnings("unchecked")
    public E remove() {
        Object obj;
        if (size > 0) {
            obj = values[size - 1];
            delValue(size - 1);
        } else {
            throw new IllegalArgumentException("Index error.");
        }
        return (E) obj;
    }

    // 根据下标删除元素,并返回删除的元素
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        // 静态方法Objects.checkIndex是检测下标是否越界的.
        Objects.checkIndex(index, this.size);
        Object obj = this.values[index];

        delValue(index);
        return (E) obj;
    }

    // 根据对象来删除元素,删除第一次遇到该值的元素
    public boolean removeBy(E e) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(values[index], e)) {
                delValue(index);
                return true;
            }
        }
        return false;
    }

    // 断言式删除,根据给定条件来删除指定的全部元素
    public void removeIf(Predicate<? extends E> predicate) {
        for (int index = 0; index < size; index++) {
            // 根据输入的断言执行判断
            if (predicate.test(valueAt(values, index))) {
                // 删除元素
                delValue(index);
                // 每次删除一个元素后都要调整下标
                index--;
            }
        }
    }

    // 更改指定下标元素的值,
    public void set(int index, E e) {
        // 禁止插入null元素
        Objects.requireNonNull(e);
        // 扩容
        values = Arrays.copyOf(values, size + 1);
        // 移动元素,然后size自增
        System.arraycopy(values, index, values, index + 1, size++ - index);
        // 插值
        values[index] = e;
    }

    // 获取指定下标的值
    public E get(int index) {
        // 判断下标是否越界
        Objects.checkIndex(index, size);
        // 返回值
        return valueAt(values, index);
    }

    // 清空数组,集合的长度变为0,是一个size为0的Object数组
    public void clear() {
        // values = {}
        values = EMPTY_LIST;
        // size 也要初始为 0
        size = 0;
    }

    // 获取集合的元素个数
    public int size() {
        return size;
    }

    // 如果size是0,则是一个空集合.
    public boolean isEmpty() {
        // size 是 0 就是空集合
        return size == 0;
    }

    // 返回遇到给定的第一个元素的下标
    public int indexOf(E e) {
        int index = 0;
        // 如果e是null 但是我们已经禁止插入或修改为null了,所以没啥用.
        if (e == null) {
            for (; index < size; index++) {
                if (values[index] == null) {
                    return index;
                }
            }
        } else {
            // 这个就是遍历,找到值
            for (Object value : values) {
                if (value.equals(e)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    // 普通地删除某位的元素
    private void delValue(int index) {
        System.arraycopy(this.values, index + 1, this.values, index, size - index - 1);
        this.values[size = size - 1] = null;
    }

    // 末尾追加
    private void addValue(E e) {
        if (this.values.length == this.size) {
            // 扩容
            this.values = grow(size);
        }
        // 添加元素
        this.values[size++] = e;
    }

    // 某一个元素地址的值
    @SuppressWarnings("unchecked")
    private <R extends E> R valueAt(Object[] objects, int index) {
        return (R) objects[index];
    }

    // 数组的扩容
    private Object[] grow(int size) {
        if (size == 0) {
            return new Object[DEFAULT_SIZE];
        } else {
            return Arrays.copyOf(values, values.length << 1);
        }
    }

    // 重写toString
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                str.append(values[i].toString()).append(", ");
            } else {
                str.append(values[i].toString());
            }
        }
        str.append("]");
        return str.toString();
    }

    // 迭代器,重写了hasNext, next, remove
    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int cursor = -1;

            @Override
            public boolean hasNext() {
                return cursor + 1 < size;
            }

            @Override
            public E next() {
                // next 就是游标下移动.默认是-1,所以开始刚进来就++,编程0,从第一位开始
                cursor++;
                // 返回当前值
                return (E) values[cursor];
            }

            @Override
            public void remove() {
                // 简单的删除当前元素,就是数组中元素的移动
                delValue(cursor);
                // 不要忘了让游标归位
                cursor--;
            }
        };
    }

    // 重写foreach,实现每隔一个消费一个
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        // 这里让 i 每次自增2
        for (int i = 0; i < size; i = i + 2) {
            // 将元素消费掉,accept()内的元素就会被消费掉
            // 这里的 valueAt(values, i) 就是 (E) values[i] ,获取数组中的元素,转换成传进来的泛型类型
            action.accept(valueAt(values, i));
        }
    }

    // 重写hashCode()方法
    @Override
    public int hashCode() {
        Object[] es = values;

        if (size > es.length) {
            throw new ConcurrentModificationException();
        }
        int hashCode = 1;
        for (int i = 0; i < size; i++) {
            Object obj = es[i];
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    // 重写equals()方法
    @Override
    public boolean equals(Object obj) {
        // 地址相同,直接返回true
        if (this == obj) {
            return true;
        }
        // 类型不同,直接返回false
        if (!(obj instanceof MyArrayList<?>)) {
            return false;
        }
        // 长度不同,直接返回false
        if (((MyArrayList<?>) obj).size != size) {
            return false;
        }
        // 数组长度
        boolean equal = true;
        // 当前数组
        final Object[] es = this.values;
        // 参数数组,要比较的数组
        final Object[] esOther = ((MyArrayList<?>) obj).values;

        // 如果有一个元素不同,将equal标记为false,break.
        for (int i = 0; i < size; i++) {
            if (!es[i].equals(esOther[i])) {
                equal = false;
                break;
            }
        }
        // 返回是否相等的结果
        return equal;
    }

    // 浅克隆
    // 所谓浅克隆,就是新建了一个引用,指向了
    @Override
    @SuppressWarnings("unchecked")
    public MyArrayList<E> clone() throws CloneNotSupportedException {
        return (MyArrayList<E>) super.clone();
    }
}
