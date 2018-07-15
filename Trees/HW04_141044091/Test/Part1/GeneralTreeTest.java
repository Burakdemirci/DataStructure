package Part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTreeTest {
    GeneralTree<String> generalTree = new GeneralTree<>();

    @Test
    void levelOrderSearch() {
        generalTree.add("","1" );
        generalTree.add("1","2");
        generalTree.add("1","3");
        assertEquals(true,generalTree.levelOrderSearch(generalTree.getRoot(),"3"));
    }

    @Test
    void postOrderSearch() {
        generalTree.add("","1" );
        generalTree.add("1","2");
        generalTree.add("1","3");
        assertEquals("2",generalTree.postOrderSearch(generalTree.getRoot(),"2").data);
    }

    @Test
    void add() {
        assertEquals(true,generalTree.add("","1" ));
    }

    @Test
    void preOrderTraverse() {
        generalTree.add("","1" );
        generalTree.add("1","2");
        generalTree.add("1","3");
        StringBuffer str = new StringBuffer();
        generalTree.preOrderTraverse(generalTree.getRoot(), str);
        assertEquals("1 2 3 ",str.toString());

    }
}