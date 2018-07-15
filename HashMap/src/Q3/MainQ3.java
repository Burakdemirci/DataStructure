package Q3;
public class MainQ3 {

    private static DoubleLinkedListMergeSort<Integer > list = new DoubleLinkedListMergeSort();
    public static void main(String[] argv){

        System.out.println("*******         TEST PART Q3       ******");
        System.out.println("****************************************");
        System.out.println("\n--- Test add operation ---");

        System.out.println("list.add(25) ");
        list.add(25);
        System.out.println("list.add(45) ");
        list.add(45);
        System.out.println("list.add(29) ");
        list.add(29);
        System.out.println("list.add(26) ");
        list.add(26);
        System.out.println("list.add(1) ");
        list.add(1);
        System.out.println("list.add(85) ");
        list.add(85);
        System.out.println("list.add(12) ");
        list.add(12);
        System.out.println("list.add(33) ");
        list.add(33);

        System.out.println("\nPrint The List");
        System.out.println(list.toString());

        System.out.println("\n * MERGE SORT *");
        System.out.println("list.mergeSort()");
        list.mergeSort();
        System.out.println("Print The List");
        System.out.println(list.toString());



    }



}
