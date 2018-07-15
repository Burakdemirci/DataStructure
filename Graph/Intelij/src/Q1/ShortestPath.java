package Q1;

import java.util.Iterator;
import java.util.Stack;

public class ShortestPath {


    public String shortest_path(DirectedAcyclicGraph g ,int v1 , int v2){

        String str = "";
        int size = g.Size();
        int maxInt=Integer.MAX_VALUE;

        if(v1 >= size||v2 >= size)
            return "There is no vertex "+v1+" or "+v2;

        Stack stack = new Stack();
        int totalWeight[] = new int[size];

        boolean visited[] = new boolean[size];
        for (int i = 0; i < size; i++)
            visited[i] = false;

        g.getFullPath(v1, visited, stack);
        for (int i = 0; i < size; i++)
            totalWeight[i] =  maxInt;
        totalWeight[v1]=0;
        while (stack.empty() == false){
            int u = (int)stack.pop();
            Iterator<DirectedAcyclicGraph.GraphNode> it;
            if (totalWeight[u] != maxInt)
            {
                it = g.getEdges()[u].iterator();
                while (it.hasNext())
                {
                    DirectedAcyclicGraph.GraphNode i= it.next();
                    if (totalWeight[i.getVertex()] > totalWeight[u] + i.getWeight())
                        totalWeight[i.getVertex()] = totalWeight[u] + i.getWeight();
                }
            }
        }
        if(totalWeight[v2]!=maxInt)
            str += v1+" -> " +v2+" Shortest path weight : "+totalWeight[v2];
        else
            str += v1+" -X-> " +v2+" There is no connection this vertexes";
        return str;
    }


}
