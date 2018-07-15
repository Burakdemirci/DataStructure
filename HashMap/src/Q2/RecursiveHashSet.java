package Q2;
import java.util.*;

public class RecursiveHashSet<E> implements Set<E> {

    private Table<E>[] table ;
    private int size;
    private int elements;

    /**
     *  Constructor
     *  Set first table size 101
     */
    public RecursiveHashSet(){
        this.elements=0;
        this.table = new Table[101];
        this.size  =101;
    }

    /**
     * Constructor
     * @param size get first table size
     */
    public RecursiveHashSet(int size){
        this.table = new Table[size];
        this.size  = size;
        this.elements=0;
    }

    /**
     *  The table inner Class
     * @param <E> the generic type
     */
    private class Table<E> {
        E data;
        int size;
        Table [] nextTable;

        /**
         *  get data
         * @return the data
         */
        public E getData() {
            return data;
        }

        /**
         * get table size
         * @return integer
         */
        public int getSize() {
            return size;
        }

        /**
         * get next table
         * @return the table
         */
        public Table[] getNextTable() {
            return nextTable;
        }

        /**
         * Constructor
         * @param data the data
         */
        public Table(E data){
            size=0;
            this.data=data;
        }

        /**
         * Constructor without data
         */
        public Table(){
            this.data=null;
        }

        /**
         * Setter for next table
         * @param nextTable the new table
         */
        public void setNextTable(Table[] nextTable) {
            this.size=nextTable.length;
            this.nextTable = nextTable;
        }

        /**
         * toString for an element
         * @return string
         */
        @Override
        public String toString(){
            String str ="";
            str += data.toString();
            return str;
        }

    }

    /**
     *  The hashSet iterotor inner class
     * @param <E> Generic type
     */
    private class HashSetIterator<E> implements Iterator<E>{
        private Table<E>[] itTable;
        private ArrayList<E> datas;
        int index ;

        /**
         *  The iterator Constructor
         * @param itTable the first table
         */
        public  HashSetIterator( Table<E>[] itTable){
            this.itTable=itTable;
            this.index = 0;
            this.datas = new ArrayList<>();
            findNext(this.itTable,index);
        }

        /**
         * table have any data
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return datas.size() > index;
        }

        /**
         * next element
         * @return the element
         */
        @Override
        public E next() {
            E ret = datas.get(index);
            index++;
            return ret;
        }

        /**
         * helper method for traverse tables
         * @param table the table
         * @param curr the index
         */
        private void findNext(Table<E> [] table ,int curr){
            if(table==null)
                return ;
            if(table.length <= curr)
                return ;
            if(table[curr]==null){
                findNext(table,++curr);
            }else{
                datas.add(table[curr].data);
                if(table[curr].nextTable!=null){
                    findNext(table[curr].nextTable,0);
                }
                findNext(table,++curr);
            }
        }
    }

    /**
     * the table size
     * @return integer
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Table is empty or not
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return elements==0;
    }

    /**
     *  Contains an giving elemet
     * @param o the element
     * @return boolean
     */
    @Override
    public boolean contains(Object o) {
        if(o==null)
            return false;
        return find(this.table, (E) o);
    }

    /**
     *  helper method for Contains
     * @param table the table
     * @param value the searching data
     * @return boolean
     */
    private boolean find(Table<E>[] table ,E value){
        int hashCode = value.hashCode() % table.length;
        if(table[hashCode]==null)
            return false;
        if(table[hashCode].data != null){
            if(table[hashCode].data.equals(value))
                return true;
            if(table[hashCode].nextTable==null)
                return false ;
            else
                return false || find(table[hashCode].nextTable,value);
        }
        return false;
    }

    /**
     *  The iterator method
     * @return the iterator
     */
    @Override
    public Iterator<E> iterator() {
        HashSetIterator iter = new HashSetIterator(table);
        return iter;
    }

    /**
     * toArray method
     * @return Array
     */
    @Override
    public Object[] toArray() {
        return this.table;
    }

    /**
     * toArray method
     * @param a an array
     * @param <T> type
     * @return an new array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(table, size, a.getClass());
        System.arraycopy(table, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    /**
     * Add element to set table
     * @param e an elemet
     * @return boolean
     */
    @Override
    public boolean add(E e) {
        if(e==null)
            return false;
        return  addRec(this.table,e);
    }

    /**
     *  Helper method for add
     * @param table the table
     * @param data the new data
     * @return boolean
     */
    private boolean addRec(Table<E>[]table,E data){

        int hashCode = data.hashCode() % table.length;
        if(hashCode<0)
            hashCode += table.length;
        if(table[hashCode]==null){
            table[hashCode] = new Table<>();
            table[hashCode].data = data;
            this.elements++;
            return true;
        }else if(table[hashCode].data != null){

            if(table[hashCode].data.equals(data))
                return false;
            if(table[hashCode].nextTable==null)
                table[hashCode].setNextTable(new Table[setNewTable(table.length)]);
            return true && addRec(table[hashCode].nextTable,data);

        }else
            table[hashCode].data = data;
        return true;
    }

    /**
     * remove elemet to table
     * @param o an removed element
     * @return boolean
     */
    @Override
    public boolean remove(Object o) {
        if(o==null)
            return false;
        return removeRec(table,(E)o);
    }

    /**
     * Remove method helper
     * @param table the table
     * @param value the removed element
     * @return boolean
     */
    private boolean removeRec(Table [] table, E value){
        int hashCode = value.hashCode() % table.length;
        if(table[hashCode]==null)
            return false;
        if(table[hashCode].data != null){
            if(table[hashCode].data.equals(value)){
                if(table[hashCode].nextTable==null)
                    table[hashCode] = null;
                else
                    reDesign(table[hashCode].nextTable,table[hashCode]);
                elements--;
                return true;
            }
            if(table[hashCode].nextTable==null)
                return false ;
            else
                return false || removeRec(table[hashCode].nextTable,value);
        }
        return false;
    }

    /**
     *  The removed elements have a table re design to this tables
     * @param table the table
     * @param deleted deleted elements node
     */
    private  void reDesign(Table [] table, Table deleted){
        boolean flag = false;
        int index=-1;
        for(int i=0; i<table.length; i++){
            if(table[i]!=null){
                if(table[i].nextTable==null){
                    deleted.data=table[i].data;
                    table[i] = null;
                    flag = true;
                    break;
                }else
                    index =i ;
            }

        }
        if(!flag){
            reDesign(table[index].getNextTable(), deleted);
        }
    }

    /**
     * Contains all method
     * @param c the collection obj
     * @return boolean
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator it = c.iterator();
        while (it.hasNext()){
            Object val = it.next();
            if(!contains(val))
                return false;
        }
        return true;
    }

    /**
     * addAll method for collection
     * @param c the collection obj
     * @return boolean
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = false;
        if(!c.isEmpty())
            for (E element : c) {
                if (add(element))
                    flag = true;
            }
        return flag;
    }

    /**
     * retainAll method
     * @param c the collection obj
     * @return boolean
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        ArrayList<E> temp = new ArrayList<>();
        Iterator it = c.iterator();
        while (it.hasNext()){
            E val = (E)it.next();
            if(contains(val)) {
                flag=true;
                temp.add(val);
            }
        }
        if(flag) {
            clear();
            for (int i = 0; i < temp.size(); i++)
                add(temp.get(i));
        }
        return flag;
    }

    /**
     * RemoveAll method
     * @param c collection obj
     * @return boolean
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        Iterator it = c.iterator();
        while (it.hasNext()){
            Object val = it.next();
            if(contains(val)) {
               remove(val);
            }
        }
        return flag;
    }

    /**
     * Clear the table
     */
    @Override
    public void clear() {
        size =0;
        this.table = null;
    }

    /**
     *  Determine new table size if  new table size smaller than ( 7 ) it determine 7
     * @param oldTableSize the old table size
     * @return the new table size integer
     */
    private int setNewTable(int oldTableSize){
        if(oldTableSize/2 < 7)
            return 7;
        return oldTableSize/2+1;
    }
}
