package StackQueue;
import java.util.*;
//Count contiguous subarrays
//An array where each index i contains an integer denoting the maximum number of contiguous subarrays of a[i]
public class SubArrayCount {

    public static void main(String args[]){

        int arr[] = {3, 4, 1, 6, 2};
        SubArrayCount obj = new SubArrayCount();
        obj.countSubArray(arr);
    }

    int[] countSubArray(int arr[]){
        Stack<Integer> stack = new Stack<Integer>();
        int ans[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            //System.out.println("the stack item extract for :"+i);
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                //System.out.println("the stack item is:"+stack.peek());
                ans[i]+=ans[stack.pop()];
            }
            stack.push(i);
            ans[i]++;
        }
        stack.clear();
        int[] temp = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                ans[i] += temp[idx];
                temp[i] += temp[idx];
            }

            stack.push(i);
            temp[i]++;
        }

        for(int j=0; j<ans.length; j++){
            System.out.println("The item is:"+ans[j]);
        }
        return ans;
    }
}
