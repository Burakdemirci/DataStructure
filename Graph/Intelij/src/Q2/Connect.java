package Q2;

public class Connect {
    /**
     *  Check the graph's given vertexes is connected
     * @param graph the graph
     * @param v1 vertex 1
     * @param v2 vertex 2
     * @return boolean
     */
    public boolean is_connected(UndirectedAcyclicGraph graph , int v1, int v2) {

        Integer parent = v1;
        Integer child;
        for (int i = 0; i<graph.getEdges()[parent].size() ; i++) {

            if( graph.getEdges()[parent].contains(v2))
                return true;
            for (int j = 0; j <graph.getEdges()[parent].size() ; j++) {
                child  =  graph.getEdges()[parent].get(j);
                if( graph.getEdges()[child ].contains(v2))
                    return true;
            }
            parent = graph.getEdges()[parent].get(i);

        }

        return false;
    }

}
