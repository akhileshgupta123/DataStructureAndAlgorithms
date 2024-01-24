package StackQueue;
import java.util.*;
//2410. Maximum Matching of Players With Trainers
public class MatchPlayerAndTrainerQueue {
    public static void main(String args[]){
        MatchPlayerAndTrainerQueue obj = new MatchPlayerAndTrainerQueue();
        int players[] = new int[]{1,1,1};
        int trainers[] = new int[]{10};
        int result = obj.getMatcher(players,trainers);
        System.out.println("result is"+result);
    }
    int getMatcher(int[] players, int[] trainers){
        Queue<Integer> q1=new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> q2=new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int x:players)q1.add(x);
        for(int y:trainers)q2.add(y);
        int c=0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            int t1=q1.peek();
            int t2=q2.peek();
            if(t1<=t2){
                System.out.println("first");
                q1.poll();
                q2.poll();
                c++;
            }else{
                System.out.println("second");
                q1.poll();
            }

        }
        return c;
    }
}
