package StackQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;
//295. Find Median from Data Stream
public class FindMedian {

    public static void main(String args[]){
        FindMedian obj = new FindMedian();

        int arr[] = {20,1,11,19,21,17,6};
        int result[] = obj.findMedian(arr);

        for(int i=0; i<result.length; i++){
            System.out.println("The item is :"+result[i]);
        }
    }

    private int[] findMedian(int arr[]){

        PriorityQueue<Integer> small = new PriorityQueue<Integer>();
        PriorityQueue<Integer> large = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });

        int output[]=new int[arr.length];

        for(int i=0;i<arr.length; i++){

            if((i+1)%2==0){
                large.add(arr[i]);
                small.add(large.poll());
                int first = small.peek();
                int second = large.peek();
                System.out.println("first:"+first);
                System.out.println("second:"+second);
               // output[i] = (int)((small.peek()+ large.peek())/2);
                output[i] = (int)((first+ second)/2);

            }else{
                small.add(arr[i]);


/*
                System.out.print("inside else ");

                Iterator<Integer> itr = large.iterator();
                while(itr.hasNext())
                {
                    System.out.print(itr.next() + " ");
                }*/
                large.add(small.poll());
                output[i] = large.peek();


            }
        }
        return output;
    }
}
