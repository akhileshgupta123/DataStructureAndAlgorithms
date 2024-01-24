package BinarySearch;
import java.util.*;
//LeetCode 259. 3Sum Smaller
public class ThreeSumSmaller {
    public static void main(String args[]){
        int[] nums = new int[]{-2,0,1,3};
        int target = 2;
        ThreeSumSmaller obj = new ThreeSumSmaller();
        int result = obj.threeSumSmaller(nums,target);
        System.out.println(result);
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums); // sort array
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    ans += r - l;
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}
