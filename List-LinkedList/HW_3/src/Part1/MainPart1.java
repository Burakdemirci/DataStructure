/**
 * Creted by
 * Burak Demirci
 * 141044091
 */
package Part1;

import java.util.List;

public class MainPart1 {


    public static void main(String[] args){

        try {

            String fileName = "src/Courses.csv";
            System.out.println("*******         TEST PART 1       ******");
            System.out.println("****************************************");
            GTUComputerEngineering gtu = new GTUComputerEngineering(fileName);

            System.out.println(" getByRange(1,2) ");
            List  n = gtu.getByRange(1,2);
            for (int i=0; i<n.size(); i++)
                System.out.println(n.get(i).toString());


            System.out.println(" getByCode( CSE 101 ) ");
            System.out.println(gtu.getByCode("CSE 101").get(0).toString());

            System.out.println(" listSemesterCourses(3) ");
            n = gtu.listSemesterCourses(3);
            for (int i=0; i<n.size(); i++)
                System.out.println(n.get(i).toString());

            System.out.println(" *** getByRange(2,1) -> Test for wrong index throw Exception");
            gtu.getByRange(2,1);
            Thread.sleep(850);
            System.out.println("\n");



        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
