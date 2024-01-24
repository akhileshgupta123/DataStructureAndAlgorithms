package Graph;
import java.util.*;

public class GraphCycle {

    private final int V;
    private final List<List<Integer>> adj;

    public GraphCycle(int V){
        this.V = V;
        adj = new ArrayList<>(V);

        for(int i=0;i<V;i++){
            adj.add(new LinkedList<Integer>());
        }
    }

    private void addEdge(int source, int dest){
        this.adj.get(source).add(dest);
    }

    private boolean isCyclic(){
        boolean visited[] = new boolean[this.V];
        boolean recStack[] = new boolean[this.V];
        for (int i = 0; i < V; i++){


            if(this.isCyclicUtil(i, visited, recStack))
                return true;
        }




        return false;
    }

    private boolean isCyclicUtil(int i, boolean visited[], boolean recStack[]){
        if(recStack[i])
            return true;

        if(visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;

        for (int j = 0; j < V; j++) {
            System.out.print(recStack[j]);
        }
        System.out.println(" ");

        List<Integer> children = adj.get(i);

        for(Integer c: children){
            if (isCyclicUtil(c, visited, recStack))
                return true;
        }

       recStack[i] = false;
        return false;
    }
    public static void main(String args[]){

        GraphCycle graph = new GraphCycle(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");

    }
}
