package Hashing;
import java.util.*;
//1. Two Sum
public class TwoSum {
    public static void main(String args[]){
        TwoSum obj = new TwoSum();

        int nums[] = new int[]{2,7,11,15};
        int target = 9;

        int result[] = obj.findTwoSum(nums,target);

        System.out.println(Arrays.toString(result));

    }

    private int[] findTwoSum(int nums[], int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int arr[] = new int[]{map.get(nums[i]),i};
                return arr;
            }else{
                map.put(target-nums[i], i);
            }
        }
        return new int[2];
    }

}
