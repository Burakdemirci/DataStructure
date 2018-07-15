package Part2;


import java.util.ArrayList;
import java.util.List;

public class MultidimSearchTree extends BinaryTree implements SearchTree<Multidimensional> {


    private Node<Multidimensional> root = null;
    private Node<Multidimensional> parent = null;
    private boolean finder = false;
    private boolean addFlag = false;
    /**
     *  Add new item to tree
     * @param item The item to be inserted
     * @return true or false
     */
    @Override
    public boolean add(Multidimensional item) {
        if(item==null)
            return false;
        if(root==null){
            root = new Node<>(item);
            parent = root;
            return true;
        }
        addHelper(root, item,0);
        addFlag=false;
        return true;
    }

    /**
     *  The method help add operation
     * @param root the root Node
     * @param item the new item
     * @param depth the depth(level) of tree
     */
    private void addHelper(Node<Multidimensional> root,Multidimensional item,int depth){

        if(addFlag)
            return;
        if(depth%3==0){       // Compare x axis

            if(root.data.compareToX(item)>0){
                if(root.right==null) {
                    root.right = new Node<>(item);
                    addFlag=true;
                    return;
                }else
                    addHelper(root.right,item,++depth);
            }
            if(root.data.compareToX(item)<=0){

                if(root.left==null){
                    root.left= new Node<>(item);
                    addFlag=true;
                    return;
                }else
                    addHelper(root.left,item,++depth);
            }
        }

        if(depth%3==1){ //compare y axis

            if(root.data.compareToY(item)>0){
                if(root.right==null) {
                    root.right = new Node<>(item);
                    addFlag=true;
                    return;
                }else
                    addHelper(root.right,item,++depth);
            }
            if(root.data.compareToY(item)<=0){

                if(root.left==null) {
                    root.left = new Node<>(item);
                    addFlag=true;
                    return;
                }else
                    addHelper(root.left,item,++depth);
            }
        }

        if(depth%3==2){ //compare z axis

            if(root.data.compareToZ(item)>0){
                if(root.right==null) {
                    root.right = new Node<>(item);
                    addFlag=true;
                    return;
                }else
                    addHelper(root.right,item,++depth);
            }
            if(root.data.compareToZ(item)<=0){

                if(root.left==null) {
                    root.left = new Node<>(item);
                    addFlag=true;
                    return;
                }else
                    addHelper(root.left,item,++depth);
            }
        }
    }

    /**
     * Check the tree contains the given element
     * @param target Item being sought in tree
     * @return true or false
     */
    @Override
    public boolean contains(Multidimensional target) {
        finder=false;
        if(find(target)!=null)
            return true;
        return false;
    }

    /**
     * Find the given element in tree
     * @param target The item being sought
     * @return finding element
     */
    @Override
    public Multidimensional find(Multidimensional target) {
        if(target==null)
            return null;
        Node<Multidimensional> finding = null;
        findHelper(root,target,0, finding);

        if(finder)
            return target;
        finder = false;
        return null;
    }

    /**
     *  The method find the target recursively
     * @param root the root Node
     * @param item the searching value
     * @param depth the depth(level) of tree
     * @param find the searching item parent's Node
     */
    private void findHelper(Node<Multidimensional> root,Multidimensional item,int depth,Node<Multidimensional>find){
        if(finder)
            return;
        if(depth%3==0){       // Compare x axis

            if(root.data.compareToX(item)>0){

                if(root.data.equals(item)){
                    parent=find;
                    finder=true;
                    return;
                }
                else
                    findHelper(root.right,item,++depth,root);
            }
            if(root.data.compareToX(item)<=0){

                if(root.data.equals(item)){
                    parent=find;
                    finder=true;
                    return;
                }
                else
                    findHelper(root.left,item,++depth,root);
            }
        }

        if(depth%3==1){ //compare y axis

            if(root.data.compareToY(item)>0){

                if(root.data.equals(item)){
                    parent=find;
                    finder=true;
                    return;
                }
                else
                    findHelper(root.right,item,++depth,root);
            }
            if(root.data.compareToY(item)<=0){
                if(root.data.equals(item)){
                    parent=find;
                    finder=true;
                    return;
                }
                else
                    findHelper(root.left,item,++depth,root);
            }
        }

        if(depth%3==2){ //compare z axis

            if(root.data.compareToZ(item)>0){
                if(root.data.equals(item)){
                    parent=find;
                    finder=true;
                    return;
                }
                else
                    findHelper(root.right,item,++depth,root);
            }
            if(root.data.compareToZ(item)<=0){
                if(root.data.equals(item)){
                    parent=find;
                    finder=true;
                    return;
                }
                else
                    findHelper(root.left,item,++depth,root);
            }
        }
    }

    /**
     * delete the given element from tree
     * @param target Item to be removed
     * @return deleted element
     */
    @Override
    public Multidimensional delete(Multidimensional target) {

        if(target==null)
            return null;
        finder=false;

        Node<Multidimensional> child  = null;
        Node<Multidimensional> watch  = null;
        findHelper(this.root,target,0, watch);

        if(!finder)
            return null;
        finder =false;

        if(parent.left!=null)
            if(parent.left.data.equals(target))
                child=parent.left;
        if(parent.right!=null)
            if(parent.right.data.equals(target))
                child=parent.right;

        List<Multidimensional> data = new ArrayList<>();
        preOrderTraverse(child,data);

        if(parent.left!=null)
            if(parent.left.data.equals(target))
                parent.left = null;
        if(parent.right!=null)
            if(parent.right.data.equals(target))
                parent.right = null;

        for (int i=1; i<data.size(); i++){
            add(data.get(i));
        }
        return target;
    }

    /**
     *  travers the tree and add element to List
     * @param root the root node
     * @param list the list
     */
    private void preOrderTraverse(Node<Multidimensional> root,List<Multidimensional> list){
        if(root!=null){
            list.add(root.data);
            preOrderTraverse(root.left, list);
            preOrderTraverse(root.right,list);
        }
    }

    /**
     * Remove the element from tree
     * @param target Item to be removed
     * @return true or false
     */
    @Override
    public boolean remove(Multidimensional target) {
        if(delete(target)!=null)
            return true;
        return false;
    }

    /**
     * get tree and add to string
     * @return String
     */
    @Override
    public String toString(){
        String str = "";
        List<Multidimensional> list = new ArrayList<>();
        preOrderTraverse(root,list);
        for (int i=0; i<list.size(); i++)
            str += list.get(i).toString()+" ";
        return str;
    }

}
