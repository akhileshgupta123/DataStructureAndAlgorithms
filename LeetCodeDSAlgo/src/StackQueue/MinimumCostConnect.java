package StackQueue;
import java.util.*;
//1167 Minimum cost to connect sticks
//Time complexity = O(n), space complexity = O(n)
//O(nlogn)
public class MinimumCostConnect {
    public static void main(String args[]){
        MinimumCostConnect obj = new MinimumCostConnect();
        //int sticks[] = new int[]{2,4,3};

        int sticks[] = new int[]{1,8,3,5};


        int result = obj.connectSticks(sticks);

        System.out.println(result);

    }

    private int connectSticks(int[] sticks){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int stick: sticks){
            pq.offer(stick);
        }
        int cost = 0;
        while(!pq.isEmpty()) {
            if(pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                cost += first + second;
                pq.offer(first + second);

            }else{
                pq.poll();
            }
        }

        return cost;
    }
}
