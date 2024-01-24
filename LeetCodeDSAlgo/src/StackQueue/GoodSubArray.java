package StackQueue;
//1793. Maximum Score of a Good Subarray
public class GoodSubArray {
    public static void main(String args[]){
        int[] nums = new int[]{1,4,3,7,4,5};
        int k = 3;

        GoodSubArray obj = new GoodSubArray();
        int result = obj.maximumScore(nums,k);
        System.out.println(result);
    }

    public int maximumScore(int[] nums, int k) {
        int res = nums[k], mini = nums[k], i = k, j = k, n = nums.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (nums[i - 1] < nums[j + 1])
                ++j;
            else
                --i;

            mini = Math.min(mini, Math.min(nums[i], nums[j]));

            res = Math.max(res, mini * (j - i + 1));
        }

        return res;
    }
}
