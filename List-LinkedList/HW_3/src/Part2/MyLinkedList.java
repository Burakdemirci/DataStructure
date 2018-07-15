package Part2;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> extends LinkedList<E> {

    private List<Integer> situation = new LinkedList<>();
    private int disableCount=0;
    /**
     *  The situation of the element
     *      1  is enable
     *      0  is disable
     */

    /**
     *  disable the(indexes element) some methods
     * @param index index of element which is want to disable
     */
    public void disable(int index){
        if(index<0 || index > situation.size())
            throw new InvalidParameterException();
        else{
            situation.set(index,0);
            disableCount++;
        }
    }

    /**
     * enable the(indexes element) some methods
     * @param index index of element which is want to enable
     */
    public void enable(int index){
        if(index<0 || index > situation.size())
            throw new InvalidParameterException();
        else{
            situation.set(index,1);
            disableCount--;
        }
    }

    /**
     *  Show the disabled elements
     * @return List of disable elements
     */
    public List<E> showDisabled(){
        List<E> ret = new LinkedList<E>();
        for (int i=0; i<situation.size(); i++){
            if(situation.get(i)==0){
                enable(i);
                ret.add(this.get(i));
                disable(i);
            }
        }
        return ret;
    }

    /**
     *  add method
     * @param index index of add
     * @param element the adding element
     */
    @Override
    public void add(final int index, final E element) {
        /* 1 : enable
        *  0 : disable
        * */
        situation.add(index,1);
        super.add(index,element);
    }

    /**
     *  add method
     * @param e element of add
     * @return adding success or not
     */
    @Override
    public boolean add(E e) {

        situation.add(1);
        return super.add(e);
    }


    /**
     *  the remove method
     * @param index index of removing
     * @return removed element
     */
    @Override
    public E remove(final int index) {

        if(situation.get(index)==0){
            System.out.println("The index of : "+index+" is Disabled");
            return null;
        }
        situation.remove(index);
        return super.remove(index);
    }

    /**
     *  List iterator
     * @param index index of iterator
     * @return Iterator
     */
    @Override
    public ListIterator<E> listIterator(final int index) {
        if(index<0 || index > situation.size())
            throw new InvalidParameterException();
        if(situation.get(index)==0){
            System.out.println("The index of : "+index+" is Disabled");
            return null;
        }
        return super.listIterator(index);
    }

    /**
     *  Set element given index
     * @param index the index of the set element
     * @param element the new element
     * @return The new element
     */
    @Override
    public E set(final int index, final E element) {

        if(index<0 || index > situation.size())
            throw new InvalidParameterException();
        if(situation.get(index)==0){
            System.out.println("The index of : "+index+" is Disabled");
            return null;
        }
        return super.set(index,element);
    }

    /**
     *  Get given index of element
     * @param index the index of element
     * @return the element
     */
    @Override
    public E get(final int index) {
        if(index<0 || index > situation.size())
            throw new InvalidParameterException();
        if(situation.get(index)==0){
            System.out.println("The index of : "+index+" is Disabled");
            return null;
        }
        return super.get(index);
    }

    /**
     *  The enable element count
     * @return enable element count
     */
    @Override
    public int size() {
        return super.size()-disableCount;
    }

    /**
     * The all element count
     * @return the size of list
     */
    public int superSize(){
        return super.size();
    }
}
