package Part1;

public class GeneralTree<E> extends BinaryTree<E> {

    private int size =0;
    private static boolean find=false;
    private Node<E> root,value;
    /**
     *  Level Order Search
     * @param root root Node
     * @param target the searching value
     * @return id find return true else false
     */
    public boolean levelOrderSearch (Node<E> root , E target){
        if(root==null||target==null)
            return false;
        levelOrderRecursive(root,target);
        boolean findVal = find;
        find=false;

        return findVal;
    }

    /**
     *  Helper method for levelOrderSearch
     * @param root the root of the tree
     * @param target searching value
     */
    private void levelOrderRecursive(Node<E> root , E target){

        if(root.data==target){
            find=true;
            return;
        }
        if(root.left!=null)
            levelOrderRecursive(root.left,target);
        if(root.right!=null)
            levelOrderRecursive(root.right,target);
    }


    /**
     * Post Order Search
     * @param root root Node
     * @param target the searching value
     * @return the finding elements Node
     */
    public Node<E> postOrderSearch(Node<E> root , E target){

        postOrderRecursive(root,target);
        if(!find)
            return null;
        find=false;
        return this.value;
    }

    /**
     * Helper method for postOrderSearch
     * @param root the Root
     * @param target the searching value
     */
    private void postOrderRecursive(Node<E> root , E target){

        if(root==null||target==null)
            return;
        if(root.data.equals(target)){
            value=root;
            find=true;
            return;
        }
        if(root.left!=null)
            postOrderRecursive(root.left,target);
        if(root.right!=null)
            postOrderRecursive(root.right,target);
    }
    /**
     *  The add method give parent and new child to add
     * @param parent parent value
     * @param child child value
     * @return add success(true) or not(false)
     */
    public boolean add(E parent, E child){

        if(size==0) {
            this.root = new Node<>(child);
            size++;
            return true;
        }
        if(parent==null || child ==null) {
            System.out.println("Wrong (null) parameter ");
            return false;
        }
        if(!levelOrderSearch(this.root,parent)){
            System.out.println("Parent Not Found !");
            return false;
        }

        if(levelOrderSearch(this.root,child)){
            System.out.println("The value already in tree");
            return false;
        }

        Node<E> parentNode = postOrderSearch(this.root,parent);
        Node<E> childNode  = new Node<>(child);

        if(parentNode.right==null){
            parentNode.right = childNode;
            size++;
            return true;
        }else {
            Node<E> sibling = parentNode.right;
            while (sibling.left!=null){
                sibling= sibling.left;
            }
            sibling.left=childNode;
        }
        return false;
    }


    /**
     * preOrderTravers the tree and add data to StringBuffer
     * @param root the root
     * @param str StringBuffer
     */
    public void preOrderTraverse(Node<E> root,StringBuffer str){
        if(root==null)
            return;
        str.append(root.toString()+" ");
        if(root.left!=null)
            preOrderTraverse(root.left,str);
        if(root.right!=null)
            preOrderTraverse(root.right, str);
    }

    public int getSize(){return size;}

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        preOrderTraverse(root,str);
        return String.valueOf(str);
    }
}
