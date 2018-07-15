package Q3;

public class MainQ3 {

    public static void main(String[]a) {

        AVLTree<Integer> avlTreeInt = new AVLTree<>();

        System.out.println("*******         TEST Q3       ******");
        System.out.println("****************************************");
        System.out.println("    Test Integer");
        System.out.println("avlTreeInt.add(1) ->"+avlTreeInt.add(1));
        System.out.println("avlTreeInt.add(2) ->"+avlTreeInt.add(2));
        System.out.println("avlTreeInt.add(3) ->"+avlTreeInt.add(3));
        System.out.println("avlTreeInt.add(4) ->"+avlTreeInt.add(4));
        System.out.println("avlTreeInt.add(5) ->"+avlTreeInt.add(5));
        System.out.println("avlTreeInt.add(6) ->"+avlTreeInt.add(6));
        System.out.println("avlTreeInt.add(6) ->"+avlTreeInt.add(6));

        System.out.println("\n   Test Binary Tree is an AVLTree ? ");

        System.out.println("BinaryTree<Integer> binaryTree = new BinaryTree()\n");

        BinaryTree<Integer> binaryTree = new BinaryTree();

        System.out.println("binaryTree.root = new BinaryTree.Node<Integer>(new Integer(12))");
        binaryTree.root = new BinaryTree.Node<Integer>(new Integer(12));

        System.out.println("binaryTree.root.right = new BinaryTree.Node<Integer>(new Integer(15))");
        binaryTree.root.right = new BinaryTree.Node<Integer>(new Integer(15));


        System.out.println("binaryTree.root.left = new BinaryTree.Node<Integer>(new Integer(10))");
        binaryTree.root.left = new BinaryTree.Node<Integer>(new Integer(10));

        System.out.println("\nTest 1");

        AVLTree<Integer> binCheckAvl = new AVLTree<>(binaryTree);

        System.out.println();

        System.out.println("binaryTree.root.left.left = new BinaryTree.Node<Integer>(new Integer(9))");
        binaryTree.root.left.left = new BinaryTree.Node<Integer>(new Integer(9));

        System.out.println("binaryTree.root.left.left.left = new BinaryTree.Node<Integer>(new Integer(7)");
        binaryTree.root.left.left.left = new BinaryTree.Node<Integer>(new Integer(7));

        System.out.println();
        System.out.println("\nTest 2");
        binCheckAvl = new AVLTree<>(binaryTree);
    }
}
