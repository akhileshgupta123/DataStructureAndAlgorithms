/**
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 *
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 */


import java.util.*;
public class DistinctNumber {

    public static void main(String args[]){
        //int arr[]={1, 2, 1, 3, 4, 2, 3};
        //int k =4;

        //int arr[]={1, 2, 1, 3, 4, 3};
        //int k =3;

        int arr[]={1, 1, 2, 2};
        int k =1;

        countDistinct(arr,k);
    }

    static void countDistinct(int arr[], int k){
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for(int i=0; i<k; i++){
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }

        System.out.println(countMap);
        System.out.println(countMap.size());



        for(int i=k;i<arr.length;i++){

            // Remove first element of previous window
            // If there was only one occurrence
            //System.out.println("####element is :"+arr[i-k]);
            if (countMap.get(arr[i - k]) == 1) {
                countMap.remove(arr[i - k]);
            }
            else {
                // reduce count of the removed element
                countMap.put(arr[i - k],  countMap.get(arr[i - k]) - 1);
            }

            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);

            // Print count of current window
            //System.out.println(countMap.size());
            System.out.println(countMap);
        }

    }
}
