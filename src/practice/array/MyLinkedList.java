package practice.array;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MyLinkedList<E> implements Iterable<E>, Cloneable, Serializable {

    private transient int size = 0;
    private transient Node<E> head;
    private transient Node<E> last;

    public MyLinkedList() {
    }

    public void addFirst(E e) {
        linkNode(head, e, 0);
    }

    public void addLast(E e) {
        linkNode(last, e, size);
    }

    public void add(E e) {
        linkNode(last, e, size);
    }

    public void add(int index, E e) {
        checkIndex(index, size);

        linkNode(getNode(index), e, index);
    }

    public boolean removeFirst() {
        unlinkNode(head);
        return true;
    }

    public boolean removeLast() {
        unlinkNode(last);
        return true;
    }

    public E remove(int index) {
        checkIndex(index, size);
        E e = null;
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                e = unlinkNode(node);
                return e;
            }
            node = node.next;
        }
        return e;
    }

    public boolean removeBy(E e) {
        Node<E> node = getNode(e);
        unlinkNode(node);
        return true;
    }

    public boolean removeIf(Predicate<E> predicate) {
        Node<E> node = head;
        while (node != null) {
            if (predicate.test(node.item)) {
                unlinkNode(node);
            }
            node = node.next;
        }
        return true;
    }

    public boolean set(int index, E e) {
        checkIndex(index, size);
        Node<E> node = getNode(index);
        node.item = e;
        return true;
    }

    public E get(int index) {
        checkIndex(index, size);
        return getNode(index).item;
    }

    public void clear() {
        for (int i = size; i > 0; i--) {
            unlinkNode(head);
        }
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peekFirst() {
        return head.item;
    }

    public E peekLast() {
        return last.item;
    }

    public E pollFirst() {
        return unlinkNode(head);
    }

    public E pollLast() {
        return unlinkNode(last);
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        checkIndex(0, size);
        return remove(0);
    }

    public E element() {
        if (head == null) return null;
        return getNode(0).item;
    }

    public int indexOf(E e) {
        return getIndex(e);
    }

    public int size() {
        return size;
    }


    // 根据节点删除元素,删除成功返回元素值
    private E unlinkNode(Node<E> node) {
        // 不接受null
        Objects.requireNonNull(node);

        // 存返回值
        E e = node.item;
        // 当前节点的上一个节点
        Node<E> prev = node.prev;
        // 当前节点的下一个节点
        Node<E> next = node.next;
        // 删除当前节点元素的数据数据
        node.item = null;

        // 如果就只有这么一个元素
        if (prev == null && next == null) {
            // 那么删除了这个元素,就是空链表,头,尾,全空.
            head = last = null;
            // 如果他在链表头
        } else if (prev == null) {
            // 下一个变成头
            head = next;
            // 让下一个的前一个节点是空.
            next.prev = null;
            // 如果再链表尾
        } else if (next == null) {
            // 那么他前一个版链表尾部
            last = prev;
            prev.next = null;
        } else {
            // 拼接节点
            prev.next = next;
            next.prev = prev;
            // 清空该节点
            node.prev = null;
            node.next = null;
        }
        size--;
        return e;
    }

    private void linkNode(Node<E> node, E e, int index) {

        // 下标是0,头插法
        if (index == 0) {
            // 获取当前头部节点信息,储存到temp
            Node<E> temp = head;
            // 创建新节点,prev指向空,next是原来的head节点
            Node<E> newNode = new Node<>(null, e, temp);
            // 新节点newNode为新的head节点
            head = newNode;
            // 如果是第一次创建,也要初始化last节点的值,让last指向刚刚新创建的节点
            if (temp == null) {
                last = newNode;
            } else {
                // 如果链表里有节点,让原来的head的节点的prev指向新建的newNode节点
                temp.prev = newNode;
            }
        } else if (index == size) {
            // 保存当前节点
            Node<E> temp = last;
            // 新建节点newNode,prev指向原来的last,next指向空
            Node<E> newNode = new Node<>(last, e, null);
            // 新节点newNode为新的last节点
            last = newNode;
            // 如果是第一次创建,也要初始化head节点的值,让head指向刚刚新创建的节点
            if (temp == null) {
                head = newNode;
            } else {
                // 如果链表里有节点,让原来的last节点的next指向新建节点newNode节点
                temp.next = newNode;
            }
        } else {
            // 如果是根据下标插值,先新建节点,
            // 其prev指向原下标节点node的prev
            // 其next指向原下标节点node
            Node<E> newNode = new Node<>(node.prev, e, node);
            // 让node的前一个节点的值的下一个节点指向newNode
            // 一定先让原节点的前一个节点的next先指向newNode.
            node.prev.next = newNode;
            // 让node的prev指向newNode
            node.prev = newNode;
        }
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    private Node<E> getNode(E e) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(e, node.item)) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    private int getIndex(E e) {
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(e, node.item)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private void checkIndex(int index, int size) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> node = new Node<>(null, null, head);

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public E next() {
                node = node.next;
                return node.item;
            }

            @Override
            public void remove() {
                // 这里需要新开辟一块空间,用来存储node的节点.
                // 当执行unlinkNode是,node的所用内容都将变为null
                // 当执行完毕之后将temp交给node节点.
                // 为什么交给了当前的节点,这个就相当于 游标--,的操作,就像最开始赋值是head的头一个
                // 因为进入next就直接node=next节点了,所以要给node赋值下一个节点是原来未删除时node的节点,只需要保留node.next就好
                Node<E> temp = new Node<>(null, null, node.next);
                unlinkNode(node);
                node = temp;
            }
        };
    }

    // 重写foreach
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        Node<E> temp = last;
        while (temp != null) {
            action.accept(temp.item);
            temp = temp.prev;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public MyLinkedList<E> clone() throws CloneNotSupportedException {
        return (MyLinkedList<E>) super.clone();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head == null) {
            sb.append("]");
        } else {
            Node<E> node = head;
            while (node != last) {
                sb.append(node.item).append(", ");
                node = node.next;
            }
            sb.append(last.item).append("]");
        }
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + item + "]";
        }
    }
}
