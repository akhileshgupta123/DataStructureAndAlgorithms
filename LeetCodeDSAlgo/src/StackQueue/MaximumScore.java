package StackQueue;
import java.util.*;
//1753. Maximum Score From Removing Stones
//Time: O(nlogn).
//        Space: O(n)
public class MaximumScore {
    public static void main(String args[]){
        MaximumScore obj = new MaximumScore();
        int result = obj.findMaxScore(4,4,6);
        System.out.println("The result is :"+result);
    }

    private int findMaxScore(int a, int b, int c){
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return b-a;
                    }
                }
        );




        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        while(pq.size()>=2){
            int x = pq.remove()-1;
            int y = pq.remove()-1;
            ans++;
            if(x>0)pq.offer(x);
            if(y>0)pq.offer(y);
        }
        return ans;
    }
}
