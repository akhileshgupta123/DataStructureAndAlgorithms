package StackQueue;
import java.util.*;
/*
* You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside), and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning of the minute, then after you've finished you'll find that floor(x/2) pieces are now inside.
You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
*
* */
public class MagicalCandyBags {

    public static void main(String args[]){
        MagicalCandyBags obj = new MagicalCandyBags();
        int arr[] = {2, 1, 7, 4, 2};
        int k = 3;
        int result = obj.maxCandies(arr,k);

        System.out.println("the result is :"+result);
    }

    private int maxCandies(int arr[], int k){

        int candies = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });

        for (int a : arr)
            pq.add(a);

        for (int m = 0; m < k; m++) {
            int pieces = pq.remove();
            candies += pieces;

            pieces = (int)pieces/2;
            pq.add(pieces);

        }
        return candies;
    }
}
