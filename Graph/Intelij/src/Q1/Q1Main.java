package Q1;

import java.util.Random;

public class Q1Main {

    public static void main(String[]a){
        Random random = new Random();

        ShortestPath shortestPath = new ShortestPath();
        DirectedAcyclicGraph graph = new DirectedAcyclicGraph(10);

        System.out.println("*******         TEST Q1       ******");
        System.out.println("****************************************");
        System.out.println("Create a random graph (v=10, e=20) ");
        for (int i = 0; i < 20; i++) {
            int random1 = random.nextInt(10);
            int random2 = random.nextInt(10);
            int weight = random.nextInt(123);
            if(!graph.addEdge(random1,random2,weight))
                i--;
            else
                System.out.println("graph.addEdge("+random1+" , "+random2 + " , " +weight+")");
        }
        System.out.println("\nPlot The Graph");
        graph.plot_graph();

        System.out.println("graph.is_acyclic_graph() -> "+graph.is_acyclic_graph());
        System.out.println("graph.is_undirected() ->"+graph.is_undirected());
        System.out.println("\n SHORTEST PATH TEST ");
        System.out.println("shortestPath.shortest_path(graph,1,5)\n"+shortestPath.shortest_path(graph,1,5));

        System.out.println("shortestPath.shortest_path(graph,7,3)\n"+shortestPath.shortest_path(graph,7,3));

        System.out.println("shortestPath.shortest_path(graph,6,4)\n"+shortestPath.shortest_path(graph,6,4));

    }

}
