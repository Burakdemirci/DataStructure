package Q2;

public class MainQ2 {

    public static void main(String[]a){
        BTree<Integer> bTree = new BTree(4);
        BTree<String> bTree2 = new BTree(4);

        System.out.println("*******         TEST Q2       ******");
        System.out.println("****************************************");

        System.out.println("bTree.add(12) ->"+bTree.add(12));
        System.out.println("bTree.add(15) ->"+bTree.add(15));
        System.out.println("bTree.add(15) ->"+bTree.add(15));
        System.out.println("bTree.add(17) ->"+bTree.add(17));
        System.out.println("bTree.add(5)  ->"+bTree.add(5));
        System.out.println("bTree.find(5) ->"+bTree.find(5));
        System.out.println("bTree.find(25) ->"+bTree.find(25));
        System.out.println("\nPrint the Tree");
        System.out.print(bTree.toString());

        System.out.println("Try new BTree");
        System.out.println("bTree2.add(\"burak\")    ->"+bTree2.add("burak"));
        System.out.println("bTree2.add(\"demirci\")  ->"+bTree2.add("demirci"));
        System.out.println("bTree2.add(\"computer\") ->"+bTree2.add("computer"));
        System.out.println("bTree2.add(\"engineer\") ->"+bTree2.add("engineer"));
        System.out.println("bTree2.add(\"student\")  ->"+bTree2.add("student")+"\n");
        System.out.println("bTree2.contains(\"burak\") ->"+bTree2.contains("burak"));
        System.out.println("bTree2.find(\"burak\") ->"+bTree2.find("burak"));
        System.out.println("bTree2.find(\"BURAK\") ->"+bTree2.find("BURAK"));
        System.out.println("\nPrint the Tree");
        System.out.print(bTree2.toString());



    }

}
