package paypal;
/**
 * https://leetcode.com/problems/house-robber/
 *
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Algorithm:
 *
 * 1. Taking extra array map for storing the max robbery value till that point
 *
 * 2. Iterating reverse
 * 3. For last index, max will be itself only
 * so maxRobValueArr = ,,,,,,3
 * then
 * for second last index, its only 2 values right, so compare it and last and which ever is bigger store that
 * so maxRobValueArr = ,,,,,3,3
 *
 * 4. Now for rest of the index, i just need to find the max Value from maxRobValueArr after skipping adjacent index
 * till will give us all possible rob values if we start at any home
 *
 */

public class MaxRobbery {
    public static void main(String args[]){
        //int[] nums = {1, 4, 5, 6, 1, 1, 3};
        int[] nums = {2,7,9,3,1};

        int result = rob(nums);
        System.out.println(result);
    }

    private static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length == 1)
            return dp[0];
        dp[1] = Math.max(dp[0],nums[1]);

        if(nums.length == 2)
            return dp[1];

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            System.out.println("dp"+dp[i]);
        }

        return dp[nums.length -1];
    }
}
