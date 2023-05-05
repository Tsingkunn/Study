package practice.datastructure.tree;

public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(8);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(4);
        bst.add(7);
        bst.add(14);
        bst.add(13);

        System.out.print("前序遍历:");
        bst.preOrder();
        System.out.println();
        System.out.print("中序遍历:");
        bst.inOrder();
        System.out.println();
        System.out.print("后序遍历:");
        bst.postOrder();
        System.out.println();
        System.out.println("maximum is " + bst.maximum());
        System.out.println("minimum is " + bst.minimum());
        System.out.println("predecessor of root is " + bst.predecessor());
        System.out.println("successor of root is " + bst.successor());
        bst.levelOrder();
    }
}
