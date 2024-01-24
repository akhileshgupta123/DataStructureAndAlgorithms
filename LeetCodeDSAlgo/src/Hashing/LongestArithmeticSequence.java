package Hashing;
import java.util.*;
//1027. Longest Arithmetic Subsequence
public class LongestArithmeticSequence {
    public static void main(String args[]){
        LongestArithmeticSequence obj = new LongestArithmeticSequence();
        //int arr[] = new int[]{9,4,7,2,10};
        int arr[] = new int[]{20,1,15,3,10,5,8};

        int result = obj.longestSequence(arr);

        System.out.println("the final result is :"+result);
    }

    private int longestSequence(int nums[]){
        int len = nums.length;
        HashMap<Integer,Integer> dp[] = new HashMap[len];
        int ans = 1;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            dp[i] = new HashMap<Integer,Integer>();

            for(int j=0; j<i; j++){
                int diff = Math.abs(curr-nums[j]);

                int count = dp[j].getOrDefault(diff, 0)+1;


                dp[i].put(diff, count);
                ans = Math.max(ans, count);
            }
        }

        for(int i=0; i<dp.length; i++){
            System.out.println(dp[i]);

        }

        return ans+1;

    }
}
