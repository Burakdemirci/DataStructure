import Part1.MainPart1;
import Part2.MainPart2;
import Part3.MainPart3;

public class MainTest {


    public static void main(String[] args){

        try {
            System.out.println("###############################################");
            System.out.println("########         THE MAIN TEST        #########");
            System.out.println("###############################################\n");
            /*Part1*/
            System.out.println("****************************************");
            MainPart1.main(args);
            Thread.sleep(750);
            /*Part2*/
            System.out.println("\n"+"****************************************");
            MainPart2.main(args);

            /*Part3*/
            System.out.println("\n"+"****************************************");
            MainPart3.main(args);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
