package Q5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        Integer [] list = new Integer[3];
        list[0]=4;
        list[1]=2;
        list[2]=7;
        QuickSort.sort(list);
        assertEquals(2,list[0].intValue());
    }
}