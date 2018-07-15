package Part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultidimensionalTest {
    Multidimensional multi = new Multidimensional(7,2,3);
    @Test
    void compareToX() {
        assertEquals(3,multi.compareToX(new Multidimensional(4,3,6)));
    }

    @Test
    void compareToY() {
        assertEquals(-1,multi.compareToY(new Multidimensional(4,3,6)));
    }

    @Test
    void compareToZ() {
        assertEquals(-3,multi.compareToZ(new Multidimensional(4,3,6)));
    }

    @Test
    void compareTo() {
        assertEquals(0,multi.compareTo(new Multidimensional(4,3,6)));
    }

    @Test
    void equals() {
        assertEquals(true,multi.equals(new Multidimensional(7,2,3)));
    }
}