package Arrays;
//1615. Maximal Network Rank
public class MaximumNetworkRank {
    public static void main(String args[]){
        MaximumNetworkRank obj = new MaximumNetworkRank();
        int n = 4;
        int roads[][] = new int[][]{{0,1},{0,3},{1,2},{1,3}};
        int result = obj.findMaxRank(n,roads);
        System.out.println("the result is:"+result);
    }

    private int findMaxRank(int n, int[][] roads){
        boolean[][] connected = new boolean[n][n];
        int[] cnts = new int[n];
        for(int r[]: roads){
            cnts[r[0]]++;
            cnts[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;
        }
        for(int i=0; i<n; i++){
            System.out.println("the element count is:"+cnts[i]);
        }
        int res = 0;
        for(int i=0;i<n; i++){
            for(int j=i+1; j<n; j++){
                res = Math.max(res, cnts[i] + cnts[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return res;
    }
}
