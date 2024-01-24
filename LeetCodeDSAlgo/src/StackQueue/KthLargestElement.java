package StackQueue;
import java.util.*;

public class KthLargestElement {
    public static void main(String args[]){
        KthLargestElement obj = new KthLargestElement();
        /*int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };
        int k = 3;*/

        int arr[] = { 3,2,3,1,2,4,5,5,6 };
        int k = 4;


        int result = obj.findKthLargest(arr,k);

        System.out.println("the kth largest element is :"+result);

    }

    private int findKthLargest(int nums[], int k){

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = nums.length;
        if(n==1)
            return nums[0];

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }

        System.out.println("element is :"+pq);


        for(int i=k;i<n;i++){
            System.out.println("peek element"+pq.peek());
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }

            System.out.println(pq.toString());
        }
        return pq.peek();
    }
}
