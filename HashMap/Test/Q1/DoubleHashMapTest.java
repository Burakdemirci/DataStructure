package Q1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleHashMapTest {

    DoubleHashMap<String,Integer> myMap = new DoubleHashMap<>();
    @Test
    void size() {
        myMap.put("burak",45);
        myMap.put("Murat",54);
        assertEquals(2,myMap.size());
    }
    @Test
    void isEmpty() {
        myMap.put("burak",45);
        myMap.put("Murat",54);
        assertEquals(false,myMap.isEmpty());
    }
    @Test
    void containsKey() {
        myMap.put("burak",45);
        myMap.put("Murat",54);
        assertEquals(false,myMap.containsKey("hakkı"));
    }
    @Test
    void get() {
        myMap.put("burak",45);
        myMap.put("Murat",54);
        int v =0;
        v = myMap.get("burak");
        assertEquals(45,v);
    }
    @Test
    void put() {
        int v =0;
        v =myMap.put("burak",45);
        assertEquals(45,v);
    }
    @Test
    void remove() {
        myMap.put("burak",45);
        myMap.put("Murat",54);
        myMap.put("mustafa",62);
        int v =0;
        v = myMap.remove("burak");
        assertEquals(45,v);
    }
}