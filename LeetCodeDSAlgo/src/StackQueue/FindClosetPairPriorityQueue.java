package StackQueue;
import java.util.*;
//973. K Closest Points to Origin
public class FindClosetPairPriorityQueue {
    public static void main(String args[]){


        int k=2;
        int points[][] = new int[][] {{3,3},{5,-1},{-2,4}};
        FindClosetPairPriorityQueue obj = new FindClosetPairPriorityQueue();
        int[][] result = obj.findClosetPair(points,k);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i][0]+ " "+result[i][1]);
        }

        System.out.println(result.length);
    }

    private int[][] findClosetPair(int point[][], int k){

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0]*a[0]+ a[1]*a[1])  - (b[0]*b[0]+b[1]*b[1]);
            }
        });


        int res[][]= new int[k][2];

        for(int temp[]: point){

            pq.add(temp);
        }

        for (int i = 0; i < k; i++){
            res[i] = pq.poll();
            System.out.println(res[i][0]);
            System.out.println(res[i][1]);
        }

        return res;

    }
}
