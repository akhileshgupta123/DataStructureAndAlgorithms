package StackQueue;
import java.util.*;

public class LargestTripletsMultiplication {
    public static void main(String args[]){
        //int arr[] = {1,2,3,4,5};


        //int arr[] = {2, 1, 2, 1, 2};


        int arr[] = {1, 2, 3, 4, 3, 2, 1};


        int n = arr.length;

        LargestTripletsMultiplication obj = new LargestTripletsMultiplication();
        int result[]  = obj.LargestTriplet(arr,n);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    private int[] LargestTriplet(int arr[], int n){

        int result[]=new int[n];
        if(n==1)
        {
            result[0]=-1;
            return  result;
        }

        if(n==2){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        result[0]    = result[1] = -1;
        int prod    = arr[0] * arr[1] * arr[2];
        result[2]    = prod;

        PriorityQueue<Integer> maxVals = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return x-y;
            }
        });

        maxVals.add(arr[0]);
        maxVals.add(arr[1]);
        maxVals.add(arr[2]);

        for (int i = 3; i < n; i++) {
            System.out.println("element:"+maxVals.peek());

            //System.out.println(arr[i] );
            // **** update max values (if needed) ****

            //System.out.println(maxVals.peek());
            if (arr[i] > maxVals.peek()) {

                //System.out.println("inside");
                // **** remove from head of the queue (smallest value) ****
                maxVals.remove();

                // **** add new highest value ****
                maxVals.add(arr[i]);
                //maxVals.toArray()

                // **** compute the max product ****
                //Integer[] tmp = (Integer[]) maxVals.toArray(new Integer[0]);
                Integer temp[] = (Integer[])maxVals.toArray(new Integer[1]);
                int x = temp[0];
                int y = temp[1];
                int z = temp[2];

                //System.out.println(maxVals.size());
                prod = x*y*z;
            }

            // **** set the max product in the array ****
            result[i] = prod;
        }



        return result;
    }
}
