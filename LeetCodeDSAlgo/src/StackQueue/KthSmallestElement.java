package StackQueue;

import java.util.PriorityQueue;
import java.util.*;

public class KthSmallestElement {

    public static void main(String args[]){
        KthSmallestElement obj = new KthSmallestElement();
        int arr[] = { 3,2,3,1,2,4,5,5,6 };
        int k = 4;



        int result = obj.findKthSmallest(arr,k);

        System.out.println("the kth smallest element is :"+result);

    }

    private int findKthSmallest(int nums[], int k){

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){


                public int compare(Integer obj1, Integer obj2){
                    return obj2-obj1;
                }
        });

/*
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0]*a[0]+ a[1]*a[1])  - (b[0]*b[0]+b[1]*b[1]);
            }
        });*/


        int n = nums.length;
        if(n==1)
            return nums[0];

        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }

        System.out.println("pq:"+pq);

        for(int i=k;i<n;i++){
            System.out.println("peek element"+pq.peek());
            if(nums[i]<pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }

            System.out.println(pq.toString());
        }
        return pq.peek();
    }
}
