package Graph;
import java.util.*;
//802. Find Eventual Safe States
//TC=>O(V+E) ,SC=>O(V)
//T/S: O(m + n)/O(m + n), where m = size(graph), n = sum(size(graph[i]))
public class SafeNode {
    public static void main(String args[]){

        int graph[][] = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        //int graph[][] = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        //[[1,2,3,4],[1,2],[3,4],[0,4],[]]
        SafeNode obj = new SafeNode();
        List<Integer> result = obj.eventualSafeNodes(graph);

        System.out.println(result);
    }

    public List<Integer> eventualSafeNodes(int graph[][]){

        Map<Integer,Boolean> nodeToSafe = new HashMap<Integer, Boolean>();
        List<Integer> safe = new ArrayList<Integer>();

        for(int i=0;i<graph.length;i++){
            //System.out.println(graph[i].length);
            System.out.println("inner loop"+i);
            if(this.isSafe(graph,i,nodeToSafe))
                safe.add(i);

            System.out.println(nodeToSafe);
        }



        return safe;
    }

    private boolean isSafe(int[][] graph, int node, Map<Integer, Boolean> nodeToSafe) {
        if (nodeToSafe.containsKey(node))
            return nodeToSafe.get(node);


        nodeToSafe.put(node, false);
        System.out.println("node is :"+node);
        for (int neighbor : graph[node]){
            System.out.println("here"+neighbor);
            if (!isSafe(graph, neighbor, nodeToSafe))
                return false;
        }
        nodeToSafe.put(node,true);
        System.out.println("the true value node is :"+node);
        return true;
        //return nodeToSafe.compute(node, (k, v) -> true);
    }
}
