package StackQueue;
import java.util.*;

//907. Sum of Subarray Minimums
public class SumSubArrayMinimum {
    public static void main(String args[]){
        SumSubArrayMinimum obj = new SumSubArrayMinimum();
        //int arr[] = new int[]{3,1,2,4};
        int arr[] = new int[]{11,81,94,43,3};

        obj.minSumArray(arr);
    }

    private int minSumArray(int arr[]){
        long res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        long M = 1000000007;
        for (int i2 = 0; i2 < arr.length+1; i2++){
            int currVal = (i2<arr.length)? arr[i2] : 0;
            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long result = ((long)arr[index]) % M;
                System.out.println("left is:"+left);
                System.out.println("right is:"+right);
                //System.out.println("result is:"+result);

                System.out.println("arr[index] is:"+arr[index]);
                long add = (long)(left * right * (long)arr[index]) % M;
                System.out.println("add is:"+add);
                res += add ;
                System.out.println("res is:"+res);
            }
            stack.push(i2);
        }
        return (int)res;
    }
}
