package Q1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DirectedAcyclicGraph {

    private int size;
    private LinkedList<GraphNode> edges[];

    public DirectedAcyclicGraph(int size){
        this.size=size;
        edges = new LinkedList[size];
        for (int i=0; i<size; ++i)
            edges[i] = new LinkedList<GraphNode>();
    }

    /**
     *  get the Graph edges
     * @return the LinkedList array
     */
    public LinkedList<GraphNode>[] getEdges() {
        return edges;
    }

    /**
     * Node of Graph
     */
    protected class GraphNode{
        private int vertex;
        private int weight;
        private GraphNode(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        int getVertex() { return vertex; }
        int getWeight()  { return weight; }
    }

    /**
     *  add new edge to graph
     * @param u the index || the connected element
     * @param v the new vertex
     * @param weight the weight
     * @return boolean
     */
    public boolean addEdge(int u, int v, int weight){
        if(u >= size || v  >= size)
            return false;

        GraphNode node = new GraphNode(v,weight);

        for (int i = 0; i <edges[u].size() ; i++) {
            if(edges[u].get(i).getVertex()==v)
                return false;
        }
        edges[u].add(node);
        if(!is_acyclic_graph()) {

            //edges[u].remove(v);
            edges[u].removeLast();
            return false;
        }
        return true;
    }

    /**
     *  Plot the graph
     */
    public void plot_graph(){
        for (int i = 0; i <size ; i++) {
            System.out.print(i);
            for (int j = 0; j < edges[i].size() ; j++) {
                System.out.print("-> "+edges[i].get(j).vertex );
            }
            System.out.println();
        }
    }


    /**
     *  check the graph is undirected
     * @return boolean
     */
    public boolean is_undirected(){

        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < edges[i].size(); j++) {
                if(!edges[edges[i].get(j).getVertex()].contains(i))
                    return false;
            }
        }
        return false;
    }

    /**
     * Check the graph is acyclic
     * @return boolean
     */
    public boolean is_acyclic_graph(){
        return !isCyclic();
    }

    /**
     *  is any cycle in the graph
     * @return boolean
     */
    private boolean isCyclic() {
        boolean[] visited = new boolean[size];
        boolean[] recurStack = new boolean[size];
        for (int i = 0; i < size; i++)
            if (isCyclicHelper(i, visited, recurStack))
                return true;
        return false;
    }

    /**
     *  isCycle helper
     * @param index the index
     * @param visited visited array
     * @param recurStack recursive array
     * @return boolean
     */
    private boolean isCyclicHelper(int index, boolean[] visited, boolean[] recurStack){
        if (recurStack[index])
            return true;
        if (visited[index])
            return false;
        visited[index] = true;
        recurStack[index] = true;
        Iterator<GraphNode> it = edges[index].iterator();
        while (it.hasNext()) {
            GraphNode node =it.next();
            if(node.getVertex() < size )
                if (isCyclicHelper(node.getVertex(), visited, recurStack))
                    return true;
        }
        recurStack[index] = false;
        return false;
    }
    /**
     * Vertex size
     */
    public int Size(){
        return size;
    }

    /**
     *  The method get given vertexes all connection
     * @param index the vertex
     * @param visited visited vertex
     * @param stack The Stack
     */
    public void getFullPath(int index, boolean visited[], Stack stack){
        visited[index] = true;
        Iterator<GraphNode> it = edges[index].iterator();
        while (it.hasNext())
        {
            GraphNode node =it.next();
            if (!visited[node.getVertex()])
                getFullPath(node.getVertex(), visited, stack);
        }
        stack.push(new Integer(index));
    }

}
