//209. Minimum Size Subarray Sum
//https://leetcode.com/problems/minimum-size-subarray-sum/description/
//SLIDING WINDOW
public class SlidingWindowVMCount {
    public static void main(String[] args){
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};

        //int target = 4;
        //int[] nums = new int[]{1,4,4};

        SlidingWindowVMCount obj = new SlidingWindowVMCount();
        int result = obj.minSubArray(target,nums);
        System.out.println("result is:"+result);
    }

    public int minSubArray(int target, int[] nums){
        int i=0;
        int j=0;
        int sum=0;
        int min = Integer.MAX_VALUE;

        for(int x: nums){
            sum = sum+x;
        }
        if(sum<target){
            return 0;
        }else if(sum==target){
            return nums.length;
        }

        sum = 0;

        while(i<nums.length){
            sum = sum + nums[i];

            while(sum>=target){
                sum = sum - nums[j];
                min = Math.min(min,i-j+1);
                j++;
            }
            i++;

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
