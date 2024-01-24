package Grind75;
import java.util.*;
//310. Minimum Height Trees
//Time complexity:
//        O(V+E)

//        Space complexity:
 //       O(V+E)
/*
Preprocess data
    Build an adjacency list representation.
    Calculate the degree of each node.
Initialize a queue with nodes with degree 1.
While nodes are in the queue
    Copy the queue into a results list in case this is the final level.
    For all nodes in the queue
        Pop the node
        Decrement its neighbors' degrees.
        Add neighbors to the queue for the next level if they now have degree 1.
Return the results list.

 */
public class MinimumHeightTree {
    public static void main(String args[]){
        MinimumHeightTree  obj = new MinimumHeightTree();
        //int n = 4;
        //int[][] edges = new int[][]{{1,0},{1,2},{1,3}};


        int n = 6;
        int[][] edges = new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}};
        //List<Integer> result = obj.findMinHeightTree(n,edges);

        List<Integer> result = obj.findMinHeightTrees(n,edges);

        System.out.println(result);

    }

    public List<Integer> findMinHeightTree(int n, int[][] edges){
        if(edges.length == 0 || n == 1){
            List<Integer> res = Arrays.asList(0);
            return res;
        }

        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];



        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e: edges){
            int v = e[0];
            int u = e[1];

            adj[v].add(u);
            adj[u].add(v);
            indegree[u]++;
            indegree[v]++;

            //System.out.println("u:"+u);
            //System.out.println("v:"+v);

        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<n; ++i){
            if(indegree[i] == 1){
                queue.add(i);
            }else{
                System.out.println("#######here item i is:"+i);
                System.out.println("#######here item:"+indegree[i]);
            }
        }


        while(n > 2){
            int size = queue.size();
            n -= size;

            while(size-- > 0){
                //remove
                int rem = queue.remove();

                //mark*
                //work
                for(int i: adj[rem]){
                    indegree[i]--;
                    if(indegree[i] == 1){
                        queue.add(i);
                    }
                }
                //add*
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(queue.size()>0){
            res.add(queue.pop());
        }


        return res;

        //return null;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0 || n == 1){
            List<Integer> res = Arrays.asList(0);
            return res;
        }

        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int[] degree  = new int[n];
        // Build adjacency list and degree array.
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        // Build a queue for BFS, which will be performed by level.
        Queue<Integer> queue = new ArrayDeque<Integer>();

        // Add all leaves to the queue.
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        // Create a list to hold the results.
        List<Integer> results = new ArrayList<Integer>();


        // Perform BFS.
        while (!queue.isEmpty()) {
            results = new ArrayList<>(queue);
            System.out.println("the inner result is");
            System.out.println(results);
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int curr = queue.poll();
                degree[curr]--;
                for (int neighbor : graph.get(curr)) {
                    if (--degree[neighbor] == 1) {
                        queue.add(neighbor);
                        System.out.println("adding"+neighbor);
                    }
                }
            }

        }
        return results;
    }
}
