package Q4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListMergeSortTest {
    DoubleLinkedListMergeSort<String> list = new DoubleLinkedListMergeSort();
    @Test
    void add() {
        assertEquals(true,list.add("25"));
    }

    @Test
    void remove() {
        list.add("25");
        list.add("26");
        assertEquals(true,list.remove("26"));
    }

    @Test
    void size() {
        list.add("25");
        list.add("26");
        assertEquals(2,list.size());
    }

    @Test
    void isEmpty() {
        list.add("25");
        list.add("26");
        assertEquals(false,list.isEmpty());
    }

    @Test
    void contains() {
        list.add("25");
        list.add("26");
        assertEquals(true,list.contains("25"));
    }

    @Test
    void get() {
        list.add("25");
        list.add("26");
        assertEquals("26",list.get(1));
    }

    @Test
    void set() {
        list.add("25");
        list.add("26");
        assertEquals("25",list.set(0,"2"));
    }
    @Test
    void mergeSort(){
        list.add("125");
        list.add("26");
        list.mergeSort();
        assertEquals("26",list.get(1));
    }
}