package paypal;
import java.math.*;
import java.util.Arrays;

/*
https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
Input: nums = ["3","6","7","10"], k = 4
Output: "3"
Explanation:
The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
The 4th largest integer in nums is "3".

imp: 1 <= nums[i].length <= 100

Integer Long, can not hold this much value
 */


public class KLargestIntegerString {
    public static void main(String args[]){
        //String[] nums = new String[] {"3343434343434343434343434343", "3", "34343", "1"};
        String[] nums = new String[] {"1","2","2"};

        //String result = kthLargestNumber(nums, 2);
        String result = kthLargestNumber(nums, 2);
        System.out.println(result);
    }

    public static String kthLargestNumber(String[] nums, int k) {
        BigInteger[] numsInt = new BigInteger[nums.length];

        int index = 0;

        for(String num : nums) {
            numsInt[index] = new BigInteger(num);
            index++;
        }

        Arrays.sort(numsInt);

        int kLargestIndex = nums.length-k;
        return numsInt[kLargestIndex].toString();
    }
}
