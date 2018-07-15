package part2;

import Part1.Course;
import Part2.MyLinkedList;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<Course> list = new MyLinkedList<>();
    private Course course = new Course(1,"CSE 107","Introduction To Computer Science Laboratory",2,1,"0+0+2");
    public MyLinkedListTest(){
        readData();
    }

    private void readData(){

        try {
            String fileName = "src/Courses.csv";
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                list.add(new Course(Integer.valueOf(data[0]), data[1], data[2], Integer.valueOf(data[3]), Integer.valueOf(data[4]), data[5]));
            }
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    void showDisabled() {
        list.disable(1);
        assertEquals(1,list.showDisabled().size());
    }

    @Test
    void add() {
        MyLinkedList<Course> n=new MyLinkedList<>();
        assertEquals(true,n.add(new Course()));
    }

    @Test
    void remove() {
        MyLinkedList<Course> n=new MyLinkedList<>();
        n.add(new Course());
        assertEquals(new Course(),n.remove(0) );
    }

    @Test
    void listIterator() {
       assertEquals(course,list.listIterator(2).next());
    }

    @Test
    void get() {
        assertEquals(course,list.get(2));
    }

    @Test
    void  set(){
        MyLinkedList n = new MyLinkedList();
        n.add(course);
        assertEquals(course,n.set(0, new Course()));
    }
}