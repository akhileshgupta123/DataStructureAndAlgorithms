package Arrays;
import java.util.*;
//2401. Longest Nice Subarray
// TC: O(n), SC: O(1)
public class LongestNiceSubArray {

    public static void main(String args[]){
        LongestNiceSubArray obj = new LongestNiceSubArray();
        int nums[] = new int[]{1,3,8,48,10};
        int result = obj.longestNiceSubarray(nums);
        System.out.println("result is:"+result);
    }

    public int longestNiceSubarray(int[] nums) {
        int start = 0,
                maxLen = 1, subarrayOR = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println("current active element is :"+nums[i]);
            System.out.println(subarrayOR);
            while ((subarrayOR & nums[i]) != 0) {
                System.out.println("while loop subarrayOR"+subarrayOR);
                subarrayOR ^= nums[start++];
                System.out.println("while loop subarrayOR after xor"+subarrayOR);
            }

            System.out.println("inner subarray element:"+subarrayOR);
            subarrayOR |= nums[i];

            int currLen = i - start + 1;
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}
