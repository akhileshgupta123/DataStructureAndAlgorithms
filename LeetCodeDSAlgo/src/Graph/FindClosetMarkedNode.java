package Graph;
//LeetCode 2737. Find the Closest Marked Node
import java.util.*;
public class FindClosetMarkedNode {
    public static void main(String args[]){
        int n = 5;
        int[][] edges = new int[][]{{0,1,2}, {0,2,4}, {1,3,1}, {2,3,3}, {3,4,2}};
        int s=1;
        int[] marked = new int[]{0,4};

        FindClosetMarkedNode obj = new FindClosetMarkedNode();
        int result = obj.minimumDistance(n,edges,s,marked);
        System.out.println(result);
    }

    public int minimumDistance(int n, int[][] edges, int s, int[] marked){
        List<List<int[]>> graph = new ArrayList<List<int[]>>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
        }

        });



        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.offer(new int[]{s, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            System.out.println("node:"+node);

            int d = current[1];
            System.out.println("distance:"+d);
            if(dist[node] < d) continue;

            for(int[] edge : graph.get(node)){
                int v = edge[0];
                int w = edge[1];
                System.out.println("inner node:"+v);
                if(d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }

        }



        int minDist = Integer.MAX_VALUE;
        for(int i : marked) {
            System.out.println("here dist:"+dist[i]);
            if(dist[i] != Integer.MAX_VALUE)
                minDist = Math.min(minDist, dist[i]);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;

    }
}
