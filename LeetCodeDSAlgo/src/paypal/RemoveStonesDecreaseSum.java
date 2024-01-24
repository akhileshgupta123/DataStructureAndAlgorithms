package paypal;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.*;

/*
https://leetcode.com/problems/remove-stones-to-minimize-the-total/
Input: piles = [5,4,9], k = 2
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [5,4,5].
- Apply the operation on pile 0. The resulting piles are [3,4,5].
The total number of stones in [3,4,5] is 12.
 */

public class RemoveStonesDecreaseSum {

    public static void main(String args[]){

        int piles[] = new int[]{5,4,9};
        int k = 2;


        RemoveStonesDecreaseSum obj = new RemoveStonesDecreaseSum();
        int result = obj.minStoneSum(piles,k);

        System.out.println("result is :"+result);
    }

    public int minStoneSum(int[] piles, int k) {


        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer obj1, Integer obj2){
                return obj2-obj1;
            }
        });


        for(int i = 0; i<piles.length; i++) {

            maxHeap.add(piles[i]);


        }

        int sum = 0;
        while(k>0){

            //1. get and remove the first element
            double maxValue = maxHeap.poll();

            //divided by 2
            int newVal =  (int) Math.ceil(maxValue/2);


            maxHeap.add(newVal) ;
            k--;
        }
        while(!maxHeap.isEmpty()){
            sum = sum + maxHeap.poll();
        }




        return sum;
    }
}
