package Q2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class MainQ2 {
    private static RecursiveHashSet<String> hashSetStr = new RecursiveHashSet<>();
    private static RecursiveHashSet<Integer> hashSetInt = new RecursiveHashSet<>();

    public static void main(String[] args){

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Q2/Sehirler.txt"));
            String line;
            System.out.println("*******         TEST Q2           ******");
            System.out.println("****************************************");

            System.out.println(" # RecursiveHashSet<Integer> hashSetInt");
            System.out.println("hashSetInt.add(15) -> "  +  hashSetInt.add(15));
            System.out.println("hashSetInt.add(16) -> "  +  hashSetInt.add(16));
            System.out.println("hashSetInt.add(61) -> "  +  hashSetInt.add(61));
            System.out.println("hashSetInt.add(25) -> "  +  hashSetInt.add(25));
            System.out.println("hashSetInt.add(15) -> "  +  hashSetInt.add(15));
            System.out.println("hashSetInt.add(32) -> "  +  hashSetInt.add(32));
            System.out.println("hashSetInt.add(41) -> "  +  hashSetInt.add(41));

            System.out.println("\n"+"hashSetInt.contains(41) -> "+hashSetInt.contains(41));
            System.out.println("hashSetInt.remove(41) -> "+hashSetInt.remove(41));
            System.out.println("hashSetInt.contains(41) -> "+hashSetInt.contains(41));

            System.out.println("--------------------------------------------------");
            System.out.println("\n"+" # RecursiveHashSet<String> hashSetStr");

            System.out.println("Read file and add data to hash set");
            while ( (line = in.readLine() ) != null) {
                hashSetStr.add(line);
            }
            System.out.println("hashSet.add(line);");
            System.out.println("\nCreate an iterator for print hash set elements ");

            System.out.println("Iterator iter = hashSetStr.iterator() \n");
            Iterator iter = hashSetStr.iterator();
            while (iter.hasNext())
                System.out.println(iter.next());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
