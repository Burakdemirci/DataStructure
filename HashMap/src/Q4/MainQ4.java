package Q4;
import java.util.ArrayList;
import java.util.Random;

public class MainQ4 {

    public static void main(String[] argv){
        System.out.println("*******         TEST Q5           ******");
        System.out.println("****************************************");

        Integer [] mlist10 = new Integer[10];
        Integer [] mlist100 = new Integer[100];
        Integer [] mlist1000 = new Integer[1000];
        Integer [] mlist10000 = new Integer[10000];
        Integer [] mlist11111 = new Integer[11111];
        Integer [] mlist50 = new Integer[50];
        Integer [] mlist500 = new Integer[500];
        Integer [] mlist5000 = new Integer[5000];
        Integer [] mlist15000 = new Integer[15000];
        Integer [] mlist12122 = new Integer[12122];

        Integer [] qlist10 = new Integer[10];
        Integer [] qlist100 = new Integer[100];
        Integer [] qlist1000 = new Integer[1000];
        Integer [] qlist10000 = new Integer[10000];
        Integer [] qlist11111 = new Integer[11111];
        Integer [] qlist50 = new Integer[50];
        Integer [] qlist500 = new Integer[500];
        Integer [] qlist5000 = new Integer[5000];
        Integer [] qlist15000 = new Integer[15000];
        Integer [] qlist12122 = new Integer[12122];

        Integer [] ilist10 = new Integer[10];
        Integer [] ilist100 = new Integer[100];
        Integer [] ilist1000 = new Integer[1000];
        Integer [] ilist10000 = new Integer[10000];
        Integer [] ilist11111 = new Integer[11111];
        Integer [] ilist50 = new Integer[50];
        Integer [] ilist500 = new Integer[500];
        Integer [] ilist5000 = new Integer[5000];
        Integer [] ilist15000 = new Integer[15000];
        Integer [] ilist12122 = new Integer[12122];

        Integer [] hlist10 = new Integer[10];
        Integer [] hlist100 = new Integer[100];
        Integer [] hlist1000 = new Integer[1000];
        Integer [] hlist10000 = new Integer[10000];
        Integer [] hlist11111 = new Integer[11111];
        Integer [] hlist50 = new Integer[50];
        Integer [] hlist500 = new Integer[500];
        Integer [] hlist5000 = new Integer[5000];
        Integer [] hlist15000 = new Integer[15000];
        Integer [] hlist12122 = new Integer[12122];

        DoubleLinkedListMergeSort<Integer> mymerge10 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge100 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge1000 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge10000 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge11111 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge50 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge500 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge5000 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge15000 = new DoubleLinkedListMergeSort<>();
        DoubleLinkedListMergeSort<Integer> mymerge12122 = new DoubleLinkedListMergeSort<>();


        Random randomGenerator = new Random();
        int randomInt;

        for (int i =0; i<10; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist10[i] = randomInt;
            ilist10[i] = randomInt;
            hlist10[i] = randomInt;
            qlist10[i] = randomInt;
            mymerge10.add(randomInt);
        }
        for (int i =0; i<50; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist50[i] = randomInt;
            ilist50[i] = randomInt;
            hlist50[i] = randomInt;
            qlist50[i] = randomInt;
            mymerge50.add(randomInt);
        }
        for (int i =0; i<100; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist100[i] = randomInt;
            ilist100[i] = randomInt;
            hlist100[i] = randomInt;
            qlist100[i] = randomInt;
            mymerge100.add(randomInt);
        }

        for (int i =0; i<500; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist500[i] = randomInt;
            ilist500[i] = randomInt;
            hlist500[i] = randomInt;
            qlist500[i] = randomInt;
            mymerge500.add(randomInt);
        }

        for (int i =0; i<1000; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist1000[i] = randomInt;
            ilist1000[i] = randomInt;
            hlist1000[i] = randomInt;
            qlist1000[i] = randomInt;
            mymerge1000.add(randomInt);
        }

        for (int i =0; i<5000; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist5000[i] = randomInt;
            ilist5000[i] = randomInt;
            hlist5000[i] = randomInt;
            qlist5000[i] = randomInt;
            mymerge5000.add(randomInt);
        }

        for (int i =0; i<10000; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist10000[i] = randomInt;
            ilist10000[i] = randomInt;
            hlist10000[i] = randomInt;
            qlist10000[i] = randomInt;
            mymerge10000.add(randomInt);
        }

        for (int i =0; i<15000; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist15000[i] = randomInt;
            ilist15000[i] = randomInt;
            hlist15000[i] = randomInt;
            qlist15000[i] = randomInt;
            mymerge15000.add(randomInt);
        }

        for (int i =0; i<11111; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist11111[i] = randomInt;
            ilist11111[i] = randomInt;
            hlist11111[i] = randomInt;
            qlist11111[i] = randomInt;
            mymerge11111.add(randomInt);
        }

        for (int i =0; i<12122; i++){
            randomInt = randomGenerator.nextInt(2150007);
            mlist12122[i] = randomInt;
            ilist12122[i] = randomInt;
            hlist12122[i] = randomInt;
            qlist12122[i] = randomInt;
            mymerge12122.add(randomInt);
        }


        Integer [][] hlists = new Integer[10][];
        Integer [][] mlists = new Integer[10][];
        Integer [][] qlists = new Integer[10][];
        Integer [][] ilists = new Integer[10][];

        hlists[0] = hlist10;
        hlists[1] = hlist50;
        hlists[2] = hlist100;
        hlists[3] = hlist500;
        hlists[4] = hlist1000;
        hlists[5] = hlist5000;
        hlists[6] = hlist10000;
        hlists[7] = hlist15000;
        hlists[8] = hlist11111;
        hlists[9] = hlist12122;

        mlists[0] = mlist10;
        mlists[1] = mlist50;
        mlists[2] = mlist100;
        mlists[3] = mlist500;
        mlists[4] = mlist1000;
        mlists[5] = mlist5000;
        mlists[6] = mlist10000;
        mlists[7] = mlist15000;
        mlists[8] = mlist11111;
        mlists[9] = mlist12122;

        qlists[0] = qlist10;
        qlists[1] = qlist50;
        qlists[2] = qlist100;
        qlists[3] = qlist500;
        qlists[4] = qlist1000;
        qlists[5] = qlist5000;
        qlists[6] = qlist10000;
        qlists[7] = qlist15000;
        qlists[8] = qlist11111;
        qlists[9] = qlist12122;

        ilists[0] = ilist10;
        ilists[1] = ilist50;
        ilists[2] = ilist100;
        ilists[3] = ilist500;
        ilists[4] = ilist1000;
        ilists[5] = ilist5000;
        ilists[6] = ilist10000;
        ilists[7] = ilist15000;
        ilists[8] = ilist11111;
        ilists[9] = ilist12122;

        ArrayList<DoubleLinkedListMergeSort> myMerges = new ArrayList<>();
        myMerges.add(mymerge10);
        myMerges.add(mymerge50);
        myMerges.add(mymerge100);
        myMerges.add(mymerge500);
        myMerges.add(mymerge1000);
        myMerges.add(mymerge5000);
        myMerges.add(mymerge10000);
        myMerges.add(mymerge15000);
        myMerges.add(mymerge11111);
        myMerges.add(mymerge12122);

        sortTest(mlists,"mdll",myMerges);
        sortTest(hlists,"h",null);
        sortTest(qlists,"q",null);
        sortTest(mlists,"m",null);
        sortTest(ilists,"i",null);


    }

    private static void sortTest(Integer[][] lists ,String type, ArrayList<DoubleLinkedListMergeSort> myMerges) {

        if(type.equals("h"))
            System.out.println("\n THE HEAP SORT Average Case");
        if(type.equals("q"))
            System.out.println("\n THE QUICK SORT Average Case");
        if(type.equals("m"))
            System.out.println("\n THE MERGE SORT Average Case");
        if(type.equals("i"))
            System.out.println("\n THE INSERTION SORT Average Case");
        if(type.equals("mdll"))
            System.out.println("\n THE MERGEDLL SORT Average Case");


        DoubleLinkedListMergeSort<Integer> sortAr = new DoubleLinkedListMergeSort();
        for (int i =0; i<10; i++) {
            long estimatedTime=0,totalTime=0;
            Integer [] sorted = new Integer[lists[i].length];
            for( int j=0; j<10; j++ ){

                if(!type.equals("mdll"))
                    copyArray(sorted,lists[i]);
                else{
                    sortAr.clear();
                    copyArrayList(sortAr,myMerges.get(i));
                }
                long startTime = System.nanoTime();
                if(type.equals("h"))
                    HeapSort.sort(sorted);
                if(type.equals("q"))
                    QuickSort.sort(sorted);
                if(type.equals("m"))
                    MergeSort.sort(sorted);
                if(type.equals("i"))
                    InsertionSort.sort(sorted);
                if(type.equals("mdll"))
                    sortAr.mergeSort();

                estimatedTime = System.nanoTime() - startTime;
                totalTime += estimatedTime;
            }
            if(!type.equals("mdll"))
                System.out.print("Array Size : "+lists[i].length);
            else
                System.out.print("Array Size : "+myMerges.get(i).size());
            if(i<2)
                System.out.print("   ");
            if(i>=2 && i<4)
                System.out.print("  ");
            if(i>=4 && i<6)
                System.out.print(" ");
            System.out.print("  Sort Time(nanosecond) :"+totalTime/10+"\n");
        }

    }

    private static void copyArray(Integer[] list1,Integer[] list2){

        for (int i=0; i<list2.length; i++)
            list1[i]=list2[i];
    }

    private static void copyArrayList(DoubleLinkedListMergeSort<Integer> list1,DoubleLinkedListMergeSort<Integer> list2){

        for (int i=0; i<list2.size(); i++)
            list1.add(list2.get(i));
    }



}
