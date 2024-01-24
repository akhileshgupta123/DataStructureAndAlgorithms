package StackQueue;
import java.util.*;
//1135. Connecting Cities With Minimum Cost
public class ConnectingCityMinCost {
    private int[] p;
    public static void main(String args[]){
        ConnectingCityMinCost obj = new ConnectingCityMinCost();
        int N = 3;
        int[][] connections = new int[][]{{1,2,5},{1,3,6},{2,3,1}};
/*
        int N = 4;
        int[][] connections = new int[][]{{1,2,3},{3,4,4}};*/


        int result = obj.minimumCost(N,connections);
        System.out.println(result);
    }

    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int ans = 0;
        for (int[] e : connections) {
            int x = e[0] - 1, y = e[1] - 1, cost = e[2];
            if (find(x) == find(y)) {
                continue;
            }
            p[find(x)] = find(y);
            ans += cost;
            if (--n == 1) {
                return ans;
            }
        }
        return -1;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
