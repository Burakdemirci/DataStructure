package Q1;
import java.io.BufferedReader;
import java.io.FileReader;

public class MainQ1 {

    public static void main(String[] args){

        DoubleHashMap<String,String> myMap = new DoubleHashMap<>();
        DoubleHashMap<Integer,Integer> myMap2 = new DoubleHashMap<>();

        System.out.println("*******         TEST Q1       ******");
        System.out.println("****************************************");
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/Q1/Plaka.txt"));
            String line;
            System.out.println("\n--- put operation read data from file ---");
            System.out.println("DoubleHashMap<String,String> myMap");
            System.out.println("myMap.put(Sehir,plakaKodu) \n");

            while ( (line = in.readLine() ) != null) {
                String[] tokens = line.split(" ");

                myMap.put(tokens[1],tokens[0]);
            }

            System.out.println("myMap.size() => "+ myMap.size());
            System.out.println("myMap.get(\"Erzurum\") => "+ myMap.get("Erzurum"));
            System.out.println("myMap.containsKey(\"Kocaeli\") => "+myMap.containsKey("Kocaeli"));
            System.out.println("myMap.remove(\"Kocaeli\") => "+myMap.remove("Kocaeli"));
            System.out.println("myMap.containsValue(\"Kocaeli\") => "+myMap.containsValue("Kocaeli"));

            System.out.println("\nDoubleHashMap<Integer,Integer> myMap2");
            System.out.println("myMap.put(Integer,Integer) \n");
            System.out.println("myMap2.put(11,11)");
            myMap2.put(11,11);
            System.out.println("myMap2.put(12,12)");
            myMap2.put(12,12);
            System.out.println("* myMap2.put(13,13)");
            myMap2.put(13,13);
            System.out.println("* myMap2.put(13,17)");
            myMap2.put(13,17);
            System.out.println("myMap2.put(17,13)");
            myMap2.put(17,13);
            System.out.println("myMap2.put(18,13)");
            myMap2.put(18,13);
            System.out.println("myMap2.put(19,13)");
            myMap2.put(19,13);

            System.out.print("myMap2.get(13) => ");
            System.out.println(myMap2.get(13));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
