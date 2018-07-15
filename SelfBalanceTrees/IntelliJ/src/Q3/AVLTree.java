package Q3;

/**
 * Self-balancing binary search tree using the algorithm defined
 * by Adelson-Velskii and Landis.
 * @author Koffman and Wolfgang
 */
public class AVLTree<E extends Comparable<E>>
        extends BinarySearchTreeWithRotate<E> {

    boolean isAvl ;

    public  AVLTree(BinaryTree binTree){
        isAvl= false;
        if(binTree==null)
            isAvl=true;
        else
            isAvl=checkIsAvl(binTree);
        if(isAvl)
            System.out.println("The Given Binary Tree is an AVLTree");
        else
            System.out.println("The Given Binary Tree is NOT an AVLTree");
    }

    private boolean isBalanced(BinaryTree root) {
        if (root == null)
            return true;
        int leftHeigh = height(root.getLeftSubtree());
        int rightHeigh = height(root.getRightSubtree());

        if (Math.abs(leftHeigh - rightHeigh) <= 1 && isBalanced(root.getLeftSubtree())
                && isBalanced(root.getRightSubtree()))
            return true;
        return false;
    }
    private int height(BinaryTree node) {

        if (node == null)
            return 0;
        return 1 + maxim(height(node.getLeftSubtree()), height(node.getRightSubtree()));
    }
    private int maxim(int a, int b){
        return (a >= b) ? a : b;
    }


    private boolean checkIsAvl(BinaryTree binTree) {
        if(isBalanced(binTree))
            return true;
        else
            return false;
    }

    public AVLTree() {
        // default constructor
    }


    /** Class to represent an AVL Node. It extends the
     * BinaryTree.Node by adding the balance field.
     */
    private static class AVLNode<E> extends Node<E> {

        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;
        /** Constant to indicate balanced */
        public static final int BALANCED = 0;
        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;
        /** balance is right subtree height - left subtree height */
        private int balance;

        // Methods
        /**
         * Construct a node with the given item as the data field.
         * @param item The data field
         */
        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        /**
         * Return a string representation of this object.
         * The balance value is appended to the contents.
         * @return String representation of this object
         */
        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }

    // Data Fields
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

    // Methods
    /**
     * add starter method.
     * @pre the item to insert implements the Comparable interface.
     * @param item The item being inserted.
     * @return true if the object is inserted; false
     *         if the object already exists in the tree
     * @throws ClassCastException if item is not Comparable
     */
    @Override
    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }

    /**
     * Recursive add method. Inserts the given object into the tree.
     * @post addReturn is set true if the item is inserted,
     *       false if the item is already in the tree.
     * @param localRoot The local root of the subtree
     * @param item The object to be inserted
     * @return The new local root of the subtree with the item
     *         inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < data
            localRoot.left = add((AVLNode<E>) localRoot.left, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        } else { // item > data
            // Yukarinin tam tersi
            localRoot.right = add( (AVLNode < E > ) localRoot.right, item);
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY)
                    return rebalanceRight(localRoot);
                else
                    return localRoot;
            }
            else {
                return localRoot;
            }
        }
    }

    /**
     *  Rebalance Right
     * @param localRoot the local root
     * @return AVLNode
     */
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {

        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
        if (rightChild.balance < AVLNode.BALANCED) {
            AVLNode<E> rightChildLeft = (AVLNode<E>) rightChild.left;
            if (rightChildLeft.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightChildLeft.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }else if (rightChildLeft.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightChildLeft.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else {  // == durumuna
                rightChild.balance = AVLNode.BALANCED;
                rightChildLeft.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // set flag
            increase = false;
            localRoot.right = rotateRight(rightChild);
            return (AVLNode < E > ) rotateLeft(localRoot);
        }else{
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            return (AVLNode < E > ) rotateLeft(localRoot);
        }
    }

    /**
     * Method to rebalance left.
     * @pre localRoot is the root of an AVL subtree that is
     *      critically left-heavy.
     * @post Balance is restored.
     * @param localRoot Root of the AVL subtree
     *        that needs rebalancing
     * @return a new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED) {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            // Adjust the balances to be their new values after
            // the rotations are performed.
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-Left case
            // In this case the leftChild (the new root)
            // and the root (new right child) will both be balanced
            // after the rotation.
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>) rotateRight(localRoot);
    }


    /**
     * Method to decrement the balance field and to reset the value of
     * increase.
     * @pre The balance field was correct prior to an insertion [or
     *      removal,] and an item is either been added to the left[
     *      or removed from the right].
     * @post The balance is decremented and the increase flags is set
     *       to false if the overall height of this subtree has not
     *       changed.
     * @param node The AVL node whose balance is to be incremented
     */
    private void decrementBalance(AVLNode<E> node) {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            // If now balanced, overall height has not increased.
            increase = false;
        }
    }

    private void incrementBalance(AVLNode < E > node) {
        node.balance++;
        if (node.balance > AVLNode.BALANCED)
            increase = true;
        else
            increase = false;
    }


}
