package Q2;

import java.util.Random;

public class Q2Main {

    public static void main(String []a){

        Random random = new Random();
        System.out.println("*******         TEST Q2       ******");
        System.out.println("****************************************");
        UndirectedAcyclicGraph graph = new UndirectedAcyclicGraph(15);
        Connect con = new Connect();


        System.out.println("Create a UndirectedAcyclicGraph  ( v=15 ) ");

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
        System.out.println("\n IS_CONNECTED TEST ");
        System.out.println("con.is_connected(graph,1,4) -> "+con.is_connected(graph,1,4));
        System.out.println("con.is_connected(graph,2,7) -> "+con.is_connected(graph,2,7));
        System.out.println("con.is_connected(graph,6,0) -> "+con.is_connected(graph,6,0));

    }


}
