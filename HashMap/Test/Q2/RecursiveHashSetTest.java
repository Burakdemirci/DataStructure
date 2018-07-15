package Q2;

import Q2.RecursiveHashSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveHashSetTest {

    RecursiveHashSet<String> hashSet = new RecursiveHashSet<>();

    @Test
    void size() {
        assertEquals(101,hashSet.size());
    }

    @Test
    void isEmpty() {

        assertEquals(true,hashSet.isEmpty());
    }

    @Test
    void contains() {
        hashSet.add("burak");
        assertEquals(true,hashSet.contains("burak"));
    }

    @Test
    void add() {
        assertEquals(true,hashSet.add("burak"));
    }

    @Test
    void remove() {
        hashSet.add("burak");
        assertEquals(true,hashSet.remove("burak"));
    }
}