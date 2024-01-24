/*
Given an 1D integer array A of size N you have to find and return the B largest elements of the array A.
* */
import java.util.*;
public class FirstKElements {

    public static void main(String args[]){
        int arr[] = { 11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };

        int size = arr.length;

        // Size of Min Heap
        int k = 3;

        FirstKElementsFind(arr, size, k);
    }

    public static void FirstKElementsFind(int arr[], int size, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<k; i++){
            minHeap.add(arr[i]);
        }

        //System.out.println(minHeap);

        for(int i = k; i < size; i++) {
            if(minHeap.peek()>arr[i]){
                continue;
            }else{
                minHeap.poll();
                minHeap.add(arr[i]);
            }


            //System.out.println("after add :"+minHeap);
        }
        //System.out.println(minHeap);

        Iterator  itr = minHeap.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next()+" ");
        }

    }
}
