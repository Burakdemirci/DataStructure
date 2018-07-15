package Part1;

public class MainPart1 {

    public static void main(String[] args){

        GeneralTree<String> generalTree = new GeneralTree<>();
        System.out.println("*******         TEST PART 1       ******");
        System.out.println("****************************************");
        System.out.println("\n--- Test add operation ---");

        System.out.println(" add(null,1) --> add 1 as a root ");
        generalTree.add("","1" );
        System.out.println(" add(parent,child) --> add(1,2) success!");
        generalTree.add("1","2");
        System.out.println(" add(parent,child) --> add(1,3) success!");
        generalTree.add("1","3");
        System.out.println(" add(parent,child) --> add(3,4) success!");
        generalTree.add("3","4");
        System.out.println(" add(parent,child) --> add(3,5) success!");
        generalTree.add("3","5");
        System.out.println(" add(parent,child) --> add(2,6) success!");
        generalTree.add("2","6");
        System.out.println(" add(parent,child) --> add(2,7) success!");
        generalTree.add("2","7");
        System.out.println(" add(parent,child) --> add(1,15) success!");
        generalTree.add("1","15");

        System.out.print(" add(parent,child) --> add(10,8) ");
        generalTree.add("10","8");

        System.out.print(" add(parent,child) --> add(1,2) ");
        generalTree.add("1","2");

        System.out.print(" add(parent,child) --> add(1,null) ");
        generalTree.add("1",null);

        System.out.print(" add(parent,child) --> add(null,25) ");
        generalTree.add(null,"25");

        System.out.print(" add(parent,child) --> add(null,null) ");
        generalTree.add(null,null);


        System.out.println("\n--- Test preOrderTraverse ---");
        StringBuffer str = new StringBuffer();
        generalTree.preOrderTraverse(generalTree.getRoot(),str);
        System.out.println(str);

    }
}