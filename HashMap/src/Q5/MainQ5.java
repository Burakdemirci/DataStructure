package Q5;
import java.util.ArrayList;
import java.util.Random;

public class MainQ5 {

    public static void main(String[] argv){
        System.out.println("*******         TEST Q4           ******");
        System.out.println("****************************************");

        Integer [][] hlists = new Integer[4][];
        Integer [][] mlists = new Integer[4][];
        Integer [][] qlists = new Integer[4][];
        Integer [][] ilists = new Integer[4][];

        mlists[0] = new Integer[100];
        mlists[1] = new Integer[1000];
        mlists[2] = new Integer[5000];
        mlists[3] = new Integer[10000];

        qlists[0] = new Integer[100];
        qlists[1] = new Integer[1000];
        qlists[2] = new Integer[5000];
        qlists[3] = new Integer[10000];

        ilists[0] = new Integer[100];
        ilists[1] = new Integer[1000];
        ilists[2] = new Integer[5000];
        ilists[3] = new Integer[10000];

        hlists[0] = new Integer[100];
        hlists[1] = new Integer[1000];
        hlists[2] = new Integer[5000];
        hlists[3] = new Integer[10000];

        ArrayList<DoubleLinkedListMergeSort> myMerges = new ArrayList<>();
        myMerges.add(new DoubleLinkedListMergeSort<>());
        myMerges.add(new DoubleLinkedListMergeSort<>());
        myMerges.add(new DoubleLinkedListMergeSort<>());
        myMerges.add(new DoubleLinkedListMergeSort<>());

        int value = 10000;
        for (int i =0; i<10000; i++){

            if(i<100){
                hlists[0][i]=value;
                mlists[0][i]=value;
                qlists[0][i]=value;
                ilists[0][i]=value;
                myMerges.get(0).add(value);
            }

            if(i<1000){
                hlists[1][i]=value;
                mlists[1][i]=value;
                qlists[1][i]=value;
                ilists[1][i]=value;
                myMerges.get(1).add(value);

            }
            if(i<5000){
                hlists[2][i]=value;
                mlists[2][i]=value;
                qlists[2][i]=value;
                ilists[2][i]=value;
                myMerges.get(2).add(value);

            }
            if(i<10000){
                hlists[3][i]=value;
                mlists[3][i]=value;
                qlists[3][i]=value;
                ilists[3][i]=value;
                myMerges.get(3).add(value);

            }
            value--;
        }

        sortTest(mlists,"mdll",myMerges);
        sortTest(hlists,"h",null);
        sortTest(qlists,"q",null);
        sortTest(mlists,"m",null);
        sortTest(ilists,"i",null);


    }

    private static void sortTest(Integer[][] lists ,String type, ArrayList<DoubleLinkedListMergeSort> myMerges) {

        if(type.equals("h"))
            System.out.print(" THE HEAP SORT ");
        if(type.equals("q"))
            System.out.print(" THE QUICK SORT ");
        if(type.equals("m"))
            System.out.print(" THE MERGE SORT ");
        if(type.equals("i"))
            System.out.print(" THE INSERTION SORT ");
        if(type.equals("mdll"))
            System.out.print(" THE MERGEDLL SORT ");
        System.out.println(" Worst Case Analiysis");
        long totalTime=0;
        Integer totalSize = 16100;
        for (int i =0; i<4; i++) {
            long startTime = System.nanoTime();

            if(type.equals("h"))
                HeapSort.sort(lists[i]);
            if(type.equals("q"))
                QuickSort.sort(lists[i]);
            if(type.equals("m"))
                MergeSort.sort(lists[i]);
            if(type.equals("i"))
                InsertionSort.sort(lists[i]);
            if(type.equals("mdll"))
                myMerges.get(i).mergeSort();
            long estimatedTime = System.nanoTime() - startTime;
            if(!type.equals("mdll"))
                System.out.print("Array Size : "+lists[i].length);
            else
                System.out.print("Array Size : "+myMerges.get(i).size());
            if(i<3)
                System.out.print(" ");
            if(i<1)
                System.out.print(" ");


            totalTime += estimatedTime;
            System.out.print("  Sort Time(nanosecond) :"+estimatedTime+" \n");
        }
        System.out.println("\n");
    }



}
