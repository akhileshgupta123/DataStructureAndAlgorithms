package DynamicProgramming;
//300. Longest Increasing Subsequence
public class LongestSequence {
    public static void main(String args[]){
        LongestSequence obj = new LongestSequence();
        int nums[] = new int[]{10,9,2,5,3,7,101,18};
        //int nums[] = new int[]{10,9,8,7,6,5,4,3,1};
        int result = obj.lengthOfLIS(nums);
        System.out.println("result is"+result);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int len = 1;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len++] = nums[i];
            } else {
                int index = findPositionToReplace(dp, 0, len - 1, nums[i]);
                System.out.println("index :"+index+" i:"+i);
                dp[index] = nums[i];
            }
        }


        for(int i=0; i<dp.length; i++){
            System.out.println(dp[i]);
        }


        return len;
    }

    public int findPositionToReplace(int[] a, int low, int high, int x) {

        System.out.println("high:"+high);
        int mid=low;
        while (low <= high) {
            //mid = low + (high - low) / 2;
            mid = (low + high) / 2;
            System.out.println("mid index:"+mid);
            System.out.println("mid:"+a[mid]);
            if (a[mid] == x)
                return mid;
            else if (a[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return mid;
    }
}
