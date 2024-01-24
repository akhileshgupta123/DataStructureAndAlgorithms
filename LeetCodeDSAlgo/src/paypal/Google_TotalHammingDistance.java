package paypal;
/*
https://leetcode.com/problems/total-hamming-distance/
Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

efficient solution: good read here https://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/

here we are finding for each bit, how many numbers are set and how many numbers are not set.
 */

public class Google_TotalHammingDistance {
    public static void main(String args[]){

        Google_TotalHammingDistance obj = new Google_TotalHammingDistance();
        int nums[] = new int[]{4,14,2};
        int result = obj.totalHammingDistance(nums);
        System.out.println("Result is :"+result);
    }

    public int totalHammingDistance(int[] nums) {
        int answer = 0;

        for (int bit = 0; bit < 32; bit++) {
            int tempNumber = 1 << bit;
            int isBitSetCount = 0;

            //System.out.println(tempNumber);


            for (int j = 0; j < nums.length; j++) {

                if ((nums[j] & tempNumber) != 0) {
                    System.out.println(" tempNumber"+tempNumber);
                    System.out.println(" nums[j]"+nums[j]);
                    isBitSetCount++;
                }

            }

            //System.out.println("isBitSetCount is:"+isBitSetCount);
            answer += isBitSetCount * (nums.length - isBitSetCount);

        }
        return answer;
    }
}
