package Q3;

import java.util.Random;

public class Q3Main {


    public static void main(String []a){

        Random random = new Random();
        System.out.println("*******         TEST Q3       ******");
        System.out.println("****************************************");
        UndirectedCyclicGraph graph = new  UndirectedCyclicGraph(10);

        System.out.println("Create a  UndirectedCyclicGraph  ( v=10 ) ");

        System.out.println("addEdge 10 for Testing  ");
        for (int i = 0; i < 10; i++) {
            int random1 = random.nextInt(15);
            int random2 = random.nextInt(15);
            if(!graph.addEdge(random1,random2))
                i--;
            else
                System.out.println("graph.addEdge("+random1+" , "+random2 + ")");
        }

        System.out.println("\nPlot The Graph");
        graph.plot_graph();
        System.out.println("graph.is_acyclic_graph() -> "+graph.is_acyclic_graph());
        System.out.println("graph.is_undirected() ->"+graph.is_undirected());

    }

}
