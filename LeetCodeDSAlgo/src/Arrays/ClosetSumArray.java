package Arrays;

import java.util.*;

public class ClosetSumArray {

    public static void main(String args[]){
        /*int arr[]= {-1, 2, 1, -4};
        int target = 1;*/
        int arr[]= {2, 2, -1, 5, -3, -2 };
        int target = 7;

        ClosetSumArray obj = new ClosetSumArray();
        int result = obj.findThreeSum(arr,target);

        System.out.println("result :"+result);

    }

    private int findThreeSum(int nums[], int target){
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);

        for(int i=0; i < nums.length; i++){
            int j = i+1;
            int k = nums.length - 1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff == 0)
                    return sum;


                if(diff < min){
                    min = diff;
                    result = sum;
                }
                if(sum <= target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}
