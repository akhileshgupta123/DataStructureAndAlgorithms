package StackQueue;
import java.util.*;

//1029. Two City Scheduling
public class TwoCityScheduleCost {
    public static void main(String args[]){

        int city[][]=new int[][]  {{10,20},{30,200},{400,50},{30,20}};
        TwoCityScheduleCost obj = new TwoCityScheduleCost();
        int result = obj.twoCityCost(city);

        System.out.println("result is :"+result);
    }

    private int twoCityCost(int costs[][]){
        int costA = 0;
        for(int cost[]:costs){
            costA = costA+ cost[0];
        }

        System.out.println("first"+costA);

        int len = costs.length / 2;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int[] cost: costs){
            int dif = cost[1] - cost[0];
            pq.offer(dif);
        }
        int i = 0;

        while(!pq.isEmpty() && i < len){
            int item = pq.poll();
            System.out.println("item is:"+item);
            costA += item;
            i++;
        }
        return costA;
    }
}
