package StackQueue;
import java.util.*;
//Dijkstra's algorithm
//min-heap
//difficult question
public class MinimumEffortPath {
    public static void main(String args[]){
        MinimumEffortPath obj = new MinimumEffortPath();

        int heights[][] = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        //int heights[][] = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        int result = obj.minEffortPath(heights);

        System.out.println("The result is :"+result);

    }

    private int minEffortPath(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;
        /*
        int dx[] = new int[]{1 , 0 , -1 , 0};
        int dy[] = new int[]{0 , 1 , 0 , -1};
        */



        int dx[] = new int[]{-1 , 1 , 0 , 0};
        int dy[] = new int[]{0 , 0 , -1 , 1};


        int dis[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j = 0; j<m ; j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        dis[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1 , int[] a2){
                //return Integer.compare(a1[2] ,a2[2]);
                return a1[2]-a2[2];
            }
        });

        pq.add(new int[]{0 , 0 , 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0] , j = curr[1] , curr_max = curr[2];
            for(int k = 0; k< 4 ; k++){
                int ni = i + dx[k];
                int nj = j + dy[k];

                if(ni <  0 || ni >= n || nj < 0 || nj >= m) continue;

                //System.out.println("old arr element"+arr[i][j]);
                //System.out.println("new arr element"+arr[ni][nj]);
                int diff = Math.abs(arr[i][j] - arr[ni][nj]);
                int max = Math.max(curr_max , diff);

                if(dis[ni][nj] > max){
                    dis[ni][nj] = max;
                    pq.add(new int[]{ni , nj , max});
                }
            }

           // System.out.println("when start new loop");

        }

        return dis[n-1][m-1];
    }
}
