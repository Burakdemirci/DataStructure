package Part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultidimSearchTreeTest {

    MultidimSearchTree gst = new MultidimSearchTree();
    @Test
    void add() {
        assertEquals(true,gst.add(new Multidimensional(1,2,0)));
    }

    @Test
    void contains() {
        gst.add(new Multidimensional(1,2,0));
        gst.add(new Multidimensional(2,3,5));
        gst.add(new Multidimensional(1,7,9));
        assertEquals(true ,gst.contains(new Multidimensional(1,7,9)));
    }

    @Test
    void find() {
        gst.add(new Multidimensional(1,2,0));
        gst.add(new Multidimensional(2,3,5));
        gst.add(new Multidimensional(1,7,9));
        gst.add(new Multidimensional(16,85,23));
        assertEquals("(1,7,9)",gst.find(new Multidimensional(1,7,9)).toString());
    }

    @Test
    void delete() {
        gst.add(new Multidimensional(1,2,0));
        gst.add(new Multidimensional(2,3,5));
        gst.add(new Multidimensional(1,7,9));
        gst.add(new Multidimensional(16,85,23));
        assertEquals("(1,7,9)",gst.delete(new Multidimensional(1,7,9)).toString());
    }

    @Test
    void remove() {
        gst.add(new Multidimensional(1,2,0));
        gst.add(new Multidimensional(2,3,5));
        gst.add(new Multidimensional(1,7,9));
        gst.add(new Multidimensional(16,85,23));
        assertEquals(true,gst.remove(new Multidimensional(1,7,9)));
    }
}