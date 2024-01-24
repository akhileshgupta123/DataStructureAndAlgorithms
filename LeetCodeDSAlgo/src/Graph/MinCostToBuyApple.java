package Graph;
//LeetCode 2473. Minimum Cost to Buy Apples
//TBD to fix
import java.util.*;
public class MinCostToBuyApple {
    public static void main(String args[]){
        MinCostToBuyApple obj = new MinCostToBuyApple();
        int n = 4;
        int k = 2;
        int[][] roads = new int[][] {{1,2,1}, {2,3,3}, {3,4,2}, {1,4,2}};
        int[] appleCost = new int[]{1, 2, 3, 4};

        int[] result = obj.minCost(n,roads,appleCost,k);

        for(int item:result){
            System.out.println(item);
        }


    }

    public int[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<Pair>[] adj = new List[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] road : roads) {
            int u = road[0] - 1, v = road[1] - 1, w = road[2];
            adj[u].add(new Pair(v, w));
            adj[v].add(new Pair(u, w));
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = dijkstra(adj, i, appleCost, k);
        }

        return ans;
    }

    private int dijkstra(List<Pair>[] adj, int src, int[] appleCost, int k) {
        int n = appleCost.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.weight - b. weight;
            }
        });
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int u = pair.station, d = pair.weight;

            System.out.println("the station is u"+u);
            System.out.println("the weight is d"+d);
            System.out.println("the dist is d"+dist[u]);
            if (d != dist[u]) continue;
            for (Pair p : adj[u]) {
                int v = p.station, w = p.weight;
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.add(new Pair(v, dist[v]));
                }

            }
        }

        System.out.println("this is new");

        for(int i=0; i<dist.length; i++){
            System.out.println("here:"+dist[i]);
        }

        int ans = appleCost[src];
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, (k + 1) * dist[i] + appleCost[i]);
        return ans;
    }
}


class Pair{
    int station;
    int weight;
    Pair(int station, int weight){
        this.station = station;
        this.weight = weight;
    }
}
