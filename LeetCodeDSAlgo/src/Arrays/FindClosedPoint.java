package Arrays;
import java.util.*;
//973. K Closest Points to Origin
public class FindClosedPoint {
    public static void main(String args[]){
        FindClosedPoint obj = new FindClosedPoint();
        int k=2;
        int points[][] = new int[][] {{3,3},{5,-1},{-2,4}};


        obj.pClosetPoint(points, k);
    }

    private void pClosetPoint(int pts[][], int k){
        int n = pts.length;
        int distance[]=new int[n];

        for(int i=0; i<n; i++){
            int x = pts[i][0];
            int y = pts[i][1];
            distance[i] = x*x + y*y;
        }

        Arrays.sort(distance);

        int distk = distance[k - 1];

        for(int i = 0; i < n; i++)
        {
            int x = pts[i][0], y = pts[i][1];
            int dist = (x * x) + (y * y);

            if (dist <= distk)
                System.out.println("[" + x + ", " + y + "]");
        }

    }
}
