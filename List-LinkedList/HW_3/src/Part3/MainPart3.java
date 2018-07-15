package Part3;

import Part1.Course;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainPart3 {

    public static void main(String[] args){

        try {

            String fileName = "src/Courses.csv";
            CourseList list = new CourseList();

            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                list.add(new Course(Integer.valueOf(data[0]),data[1],data[2],Integer.valueOf(data[3]),Integer.valueOf(data[4]),data[5]));
            }
            reader.close();

            System.out.println("*******         TEST PART 3       ******");
            System.out.println("****************************************");

            System.out.println("LIST SIZE : "+list.size());

            System.out.println("Get(2) :>  "+list.get(2).getData().toString());
            System.out.println("Get(3) :>  "+list.get(3).getData().toString());

            System.out.println("REMOVED(2) :> "+list.remove(2).getData().toString());
            System.out.println("LIST SIZE :> "+list.size());

            System.out.println("Get(2) :>  "+ list.get(2).getData().toString());
            System.out.println("Get(3) :>  "+ list.get(3).getData().toString());


            CourseList.CourseListIterator itr = list.iterator();
            System.out.println("\n The Iterator Use next()  for  i < 15 ");
            for (int i=0; i<15; i++) {
                Object element = itr.next();
                System.out.print(element);
            }

            System.out.println("\n The Iterator Use nextInSemester(3)  for  i < 20 ");
            for (int i=0; i<20; i++) {
                Object element = itr.nextInSemester(3);
                System.out.print(element);
            }


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
