package practice.datastructure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class BST {

    private Node root;

    public BST() {
        this.root = null;
    }

    public void add(int key) {
        Node node = new Node(key);

        if (root == null) {
            root = node;
        } else {
            // 当前节点
            Node current = root;
            boolean isLoop = true;

            // 每一个数据都要循环好多边,才能插进去,数据越多插入的时间就越长
            while (isLoop) {

                if (key > current.data) {
                    System.out.println("key > data--->right " + key + ":" + node.data);
                    if (current.rChild != null) {
                        current = current.rChild;
                    } else {
                        current.rChild = node;
                        node.parent = current;
                        isLoop = false;
                    }
                } else if (key < current.data) {
                    System.out.println("key > data--->left " + key + ":" + node.data);
                    if (current.lChild != null) {
                        current = current.lChild;
                    } else {
                        current.lChild = node;
                        node.parent = current;
                        isLoop = false;
                    }
                } else {
                    isLoop = false;
                }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + ", ");
            preOrder(node.lChild);
            preOrder(node.rChild);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.lChild);
            System.out.print(node.data + ", ");
            inOrder(node.rChild);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.lChild);
            postOrder(node.rChild);
            System.out.print(node.data + ", ");
        }
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        if (node != null) {
            Deque<Node> queue = new LinkedList<>();
            queue.add(node);
            while (queue.size() != 0) {
                Node tmp = queue.poll();
                if (tmp.lChild != null) {
                    queue.add(tmp.lChild);
                }
                if (tmp.rChild != null) {
                    queue.add(tmp.rChild);
                }

                System.out.print(tmp.data + ", ");
            }
        }
    }

    public int maximum() {
        Objects.requireNonNull(root);
        Node p = maximum(root);
        return p.data;
    }

    private Node maximum(Node node) {
        while (node.rChild != null) {
            node = node.rChild;
        }
        return node;
    }

    public int minimum() {
        Objects.requireNonNull(root);
        Node p = minimum(root);
        return p.data;

    }

    private Node minimum(Node node) {

        while (node.lChild != null) {
            node = node.lChild;
        }
        return node;
    }

    public int predecessor() {
        Node node = predecessor(root);
        if (node != null) {
            return node.data;
        } else {
            return 0;
        }
    }

    private Node predecessor(Node node) {
        if (node.lChild != null) {
            // 如果节点有左孩子,那么直接在左子树中找出最大的
            return maximum(node.lChild);
        } else {

            // 该节点是:左孩子->左孩子->左孩子->...->左孩子没有前驱节点

            // 如果节点没有左孩子.
            // 1. 该节点是右孩子--> 那么直接返回其父结点
            // 2. 该节点是左孩子--> 该节点要在(父/祖父/曾祖父.....节点)的右子树中.
            Node parent = node.parent;

            while ((parent != null) && (parent.lChild == node)) {
                // 该节点的父节点不为空，并且该节点是父节点的左孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public int successor() {
        Node node = successor(root.rChild.rChild);
        if (node != null) {
            return node.data;
        } else {
            return 0;
        }
    }

    private Node successor(Node node) {
        if (node.rChild != null) {
            return minimum(node.rChild);
        } else {

            // 该节点是:右孩子->右孩子->右孩子->...->右孩子没有后继节点

            // 该节点没有右孩子
            // 该节点是左孩子-->后继就是他的父节点
            // 该节点是有孩子-->那么该节点要在(父/祖父/曾祖父...)的左子树中
            Node parent = node.parent;

            while (parent != null && parent.rChild == node) {
                // 该节点的父节点不为空，并且该节点是父节点的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static class Node {
        int data;
        Node lChild;
        Node rChild;

        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

}
