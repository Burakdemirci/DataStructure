package Part2;

import Part1.Course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MainPart2 extends MyLinkedList {


    public static void main(String[] args){

        try {

            String fileName = "src/Courses.csv";
            MyLinkedList<Course> list = new MyLinkedList<>();

            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                list.add(new Course(Integer.valueOf(data[0]),data[1],data[2],Integer.valueOf(data[3]),Integer.valueOf(data[4]),data[5]));
            }
            reader.close();

            /****************** TEST ***********************************/
            System.out.println("*******         TEST PART 2       ******");
            System.out.println("****************************************");

            System.out.println(" disable(0) disable(1) disable(10)");
            list.disable(0);
            list.disable(1);
            list.disable(10);

            System.out.println("        SHOW DISABLED");

            List<Course> show = list.showDisabled();
            for (int i=0; i<show.size(); i++)
                System.out.println(show.get(i).toString());

            System.out.println("\n        GET METHOD FOR DISABLED ELEMENT");
            list.get(0);
            list.get(10);

            System.out.println("\n        SET METHOD FOR DISABLED ELEMENT");
            list.set(1,list.get(2));

            System.out.println("\n   SIZE() and SUPERSIZE()");
            System.out.println("    "+list.size()+"          "+list.superSize());

            System.out.println("\n enable(10) ");
            list.enable(10);
            System.out.println(list.get(10).toString());

            System.out.println("        SHOW DISABLED");
            show = list.showDisabled();
            for (int i=0; i<show.size(); i++)
                System.out.println(show.get(i).toString());


        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
