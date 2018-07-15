package Part3;

import Part1.Course;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CourseList{

    private static Node head;
    private static Node tail;
    private static int countNodes;


    /**
     * Constructor of the CourseList
     * set some private data
     */
    public CourseList(){
        head = null;
        tail = null;
        countNodes=0;
    }


    /**
     *  The CourseListIterator iterate the list
     * @return iterator
     */
    public CourseListIterator iterator(){
        return new CourseListIterator(head);
    }

    /**
     *  The CourseListIterator class
     *  The Node contains Course object
     */
    public class CourseListIterator implements Iterator<Course> {

        private Node nextNode,head,semNext;
        private Node lastReturnedNode;
        private Node previousNode;
        private boolean flag = false;
        /**
         * The Iterator Constructor
         * @param node The Node contains Course object
         */
        public CourseListIterator(Node node){
            this.head=node;
            this.nextNode = node;
            this.semNext=node;
        }

        /**
         * is there a next element on list
         * @return boolean
         */
        public boolean hasNext ()
        {
            if(flag)
                return semNext!=null;
            return nextNode != null;
        }

        /**
         *  next element
         * @return Node
         * @throws NoSuchElementException
         */
        public Course next () throws NoSuchElementException
        {
            flag=false;
            if (!this.hasNext ())
                throw new NoSuchElementException();

            previousNode = lastReturnedNode;
            lastReturnedNode = nextNode;
            nextNode = nextNode.next;
            return lastReturnedNode.data;
        }

        /**
         * Remove the element
         * @throws IllegalStateException
         */
        public void remove() throws IllegalStateException
        {
            if (lastReturnedNode == null){
                throw new IllegalStateException ();
            }
            else{
                lastReturnedNode = lastReturnedNode.next;
                countNodes--;
            }
        }

        /**
         * Move next node in same semester
         * @param semester the semester
         * @return Course
         */
        public Course nextInSemester(int semester){
            flag=true;
            if(semester<1 || semester>8)
                throw new IllegalArgumentException();
            boolean find=false;
            while(!find){
                if(semesterSearch().getSemester()==semester)
                    find=true;
            }
            return  lastReturnedNode.getData();
        }

        /**
         * Helper for nextInSemester(int semester)
         * @return Node
         */
        private Node semesterSearch(){
            if(semNext.next==null)
                semNext.next=head;
            previousNode = lastReturnedNode;
            lastReturnedNode = semNext;
            semNext = semNext.next;
            return  lastReturnedNode;
        }
    }


    /**
     *  The node inner class
     *  the Course object for creating special node
     */
    public class Node
    {
        private Node next;
        private Course data;
        private int semester;
        /**
         * The Node constructor created with course object
         * @param dat the Course object
         */
        public Node(Course dat)
        {
            data = dat;
            semester = dat.getSemester();
            this.next = null;
        }

        /**
         *  Overload the constructor
         *  set some data
         */
        public Node() {
            this.data = null;
            this.next = null;
        }

        /**
         * get the Course
         * @return Course objects
         */
        public Course getData() {
            return data;
        }

        /**
         *  set node data(Course)
         * @param data the new (Course)data
         */
        public void setData(Course data) {
            if(data==null)
                throw  new NullPointerException();
            this.data = data;
        }

        /**
         * The semester information getter
         * @return
         */
        public int getSemester(){
            return semester;
        }
    }



    /**
     *  Add element to CourseList
     * @param data the new Course node
     * @return Adding operation success or not
     */
    public boolean add(Course data) {

        if (data == null) {
            return false;
        }
        Node currentNode = new Node(data);
        if (isEmpty()){
            head = currentNode;
            tail=head;


        } else {
            tail.next = currentNode;
            tail=tail.next;
        }
        countNodes++;
        return true;
    }


    /**
     *  CourseList Empty or nor
     * @return the CourseList empty or not
     */
    public boolean isEmpty(){
        return countNodes<=0;
    }

    /**
     *  CourseList size
     * @return size of list
     */
    public int size(){
        return countNodes;
    }

    /**
     * Get element given index
     * @param index the index of element
     * @return the given indexes located element
     */
    public Node get(int index){

        if(index<0)
            throw new IllegalArgumentException();
        if (index>=countNodes)
            throw new IndexOutOfBoundsException();
        Node temp = head;
        for (int i=1; i<=index; i++){
             temp=temp.next;
        }
        return temp;
    }

    /**
     *  Removed Nodes given index
     * @param index the index of remove element
     * @return Removed element
     */
    public Node remove(int index){

        if(index<0)
            throw new IllegalArgumentException();
        if (index>=countNodes)
            throw new IndexOutOfBoundsException();

        Node temp = head;
        Node element = null;
        for (int i=1; i<index; i++){
            temp=temp.next;
        }
        element = temp.next;
        temp.next=temp.next.next;
        countNodes--;
        return element;

    }


}
