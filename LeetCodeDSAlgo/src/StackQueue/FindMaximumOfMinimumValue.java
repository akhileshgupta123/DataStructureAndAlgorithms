package StackQueue;
import java.util.*;
//1950 - Maximum of Minimum Values in All Subarrays
public class FindMaximumOfMinimumValue {
    public static void main(String args[]){
        FindMaximumOfMinimumValue obj = new FindMaximumOfMinimumValue();
        int nums[] = new int[]{0,1,2,4};
        //int nums[] = new int[]{10,20,50,10};


        int result[] = obj.findMaximums(nums);
        //int result[] = obj.findMaximums1(nums);
        for(int item: result){
            System.out.println(item);
        }
    }

    public int[] findMaximums(int[] nums) {
                int n = nums.length;
                int [] res = new int[n];
                Stack<Integer> stk = new Stack<>();
               for(int i = 0; i <= n; i++){
                        while(!stk.isEmpty() && (i == n || nums[stk.peek()] >= nums[i])){
                                int j = stk.pop();
                                int k = i - 1;
                                //System.out.println(stk.size());
                                if(!stk.isEmpty()){
                                        k -= stk.peek() + 1;
                                    }

                                res[k] = Math.max(res[k], nums[j]);
                             }

                         stk.push(i);
                     }
/*
                 for(int i = n - 1; i > 0; i--){
                         res[i - 1] = Math.max(res[i - 1], res[i]);
                     }*/

                 return res;
            }

    public int[] findMaximums1(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(right, length);
        int minimum = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            minimum = Math.min(minimum, nums[i]);
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
                right[stack.pop()] = i;
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for(int item: right){
            //System.out.println(item);
        }

        for(int item: left){
            //System.out.println(item);
        }

        return null;
    }

}
