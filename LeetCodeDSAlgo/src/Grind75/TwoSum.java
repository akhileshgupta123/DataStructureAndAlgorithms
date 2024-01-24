package Grind75;
import java.util.*;
//1. Two Sum
//Time Complexity: O(n) due to the sorting step.
  //      Space Complexity: O(n) due to the temp array.
public class TwoSum {

    public static void main(String args[]){
        int nums[] = new int[]{2,7,11,15};
        int target = 9;
        TwoSum obj = new TwoSum();
        int[] index = obj.twoSum(nums,target);

        System.out.println(index[0]);
        System.out.println(index[1]);


    }

    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }

        return new int[]{0,0};

    }
}
