package DynamicProgramming;

public class CombinationSum {
    public static void main(String args[]){
        CombinationSum obj = new CombinationSum();
        int nums[] = new int[]{1,2,3};
        int target = 4;
        int result = obj.combinationSum4(nums, target);
        System.out.println("result is : "+result);
    }

    public int combinationSum4(int[] nums, int target) {
        // Knapsack complete, get permutations instead of combinations
        int[] dp = new int[target+1];
        dp[0] = 1; // 0 only has one permutation

        for(int i = 0; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                int cur = nums[j];
                if(i >= cur) dp[i] += dp[i-cur];
            }
        }

        for(int i=0; i<dp.length; i++){
            System.out.println(dp[i]);
        }

        return dp[target];
    }
}
