package Q2;

import Q1.DirectedAcyclicGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class UndirectedAcyclicGraph {

    private int size;
    private LinkedList<Integer> edges[];

    public UndirectedAcyclicGraph(int size){
        this.size=size;
        edges = new LinkedList[size];
        for (int i=0; i<size; ++i)
            edges[i] = new LinkedList<Integer>();
    }

    /**
     *  get the Graph edges
     * @return the LinkedList array
     */
    public LinkedList<Integer>[] getEdges() {
        return edges;
    }


    /**
     *  add new edge to graph
     * @param v1 the vertex 1
     * @param v1 the vertex 2
     * @return boolean
     */
    public boolean addEdge(int v1, int v2){
        if(v1 >= size || v2  >= size)
            return false;

        if(edges[v1].contains(v2) && edges[v2].contains(v1) )
            return false;
        edges[v1].add(v2);
        edges[v2].add(v1);
        if(!is_acyclic_graph()) {
            edges[v1].removeLast();
            edges[v2].removeLast();
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
                System.out.print("-> "+edges[i].get(j));
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
            for (int j = 0; j <edges[i].size() ; j++) {
                if(!edges[edges[i].get(j)].contains(i))
                    return false;
            }
        }
        return true;
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
        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++)
            visited[i] = false;

        for (int j = 0; j < size; j++)
            if (!visited[j])
                if (isCyclicHelper(j, visited, -1))
                    return true;
        return false;
    }

    /**
     *  isCycle helper
     * @param v1 the given vertex
     * @param visited visited array
     * @param parent the parent og given vertex
     * @return boolean
     */
    private boolean isCyclicHelper(int v1, boolean[] visited, int parent){
        visited[v1] = true;
        Integer i;
        Iterator<Integer> it = edges[v1].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
            {
                if (isCyclicHelper(i, visited, v1))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    /**
     * Vertex size
     */
    public int Size(){
        return size;
    }

    /**
     * The method get given vertexes all connection
     * @param index the vertex
     * @param visited visited vertex
     * @param stack The Stack
     */
    public void getFullPath(int index, boolean visited[], Stack stack){
        visited[index] = true;
        Iterator<Integer> it = edges[index].iterator();
        Integer val;
        while (it.hasNext()) {
            val =it.next();
            if (!visited[val])
                getFullPath(val, visited, stack);
        }
        stack.push(new Integer(index));
    }

}
