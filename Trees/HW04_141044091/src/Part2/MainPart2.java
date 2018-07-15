package Part2;

public class MainPart2 {

    public static void main(String[] args){

        MultidimSearchTree gst = new MultidimSearchTree();
        System.out.println("*******         TEST PART 2       ******");
        System.out.println("****************************************");
        System.out.println();

        System.out.println("gst.add(new Multidimensional(1,2,0))");
        gst.add(new Multidimensional(1,2,0));
        System.out.println("gst.add(new Multidimensional(2,3,5))");
        gst.add(new Multidimensional(2,3,5));
        System.out.println("gst.add(new Multidimensional(1,7,9))");
        gst.add(new Multidimensional(1,7,9));
        System.out.println("gst.add(new Multidimensional(2,13,5))");
        gst.add(new Multidimensional(2,13,5));
        System.out.println("gst.add(new Multidimensional(16,85,23))");
        gst.add(new Multidimensional(16,85,23));
        System.out.println("gst.add(new Multidimensional(45,28,95))");
        gst.add(new Multidimensional(45,28,95));
        System.out.println("gst.add(new Multidimensional(41,25,5))");
        gst.add(new Multidimensional(41,25,5));
        System.out.println("gst.add(new Multidimensional(95,85,65))");
        gst.add(new Multidimensional(95,85,65));

        System.out.println("\n"+gst.toString());

        System.out.println("\ngst.find(new Multidimensional(41,25,5))");
        Multidimensional find = gst.find(new Multidimensional(41,25,5));
        if(find!=null)
            System.out.println("Found --> "+find.toString());

        System.out.println("\ngst.contains(new Multidimensional(95,85,65))");
        if(gst.contains(new Multidimensional(95,85,65)))
            System.out.println("Contains ---> (95,85,65)");

        System.out.println("\ngst.delete(new Multidimensional(2,13,5))");
        if(gst.contains(new Multidimensional(2,13,5)))
            gst.delete(new Multidimensional(2,13,5));

        System.out.println(gst.toString());

        System.out.println("\ngst.remove(new Multidimensional(95,85,65))");
        if(gst.contains(new Multidimensional(95,85,65)))
            System.out.println("Removed -->(95,85,65) "+gst.remove(new Multidimensional(95,85,65)));
        System.out.println(gst.toString());


    }
}