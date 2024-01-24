package Grind75;
import java.util.*;
//416. Partition Equal Subset Sum
//Space Complexity: O(sum),
//Time Complexity: O(n * sum),
public class CanPartitionArray {
    public static void main(String args[]){
        CanPartitionArray obj = new CanPartitionArray();

        int[] array = new int[]{1,5,11,5};

        //int[] array = new int[]{16,22,35,8,20,1,21,11};


        boolean result = obj.canPartition(array);

        System.out.println(result);
    }

    public boolean canPartition(int[] nums) {

        int totalSum = 0;// Arrays.stream(nums).sum();

        for(int i=0; i<nums.length; i++){
            totalSum = totalSum + nums[i];
        }

        if(totalSum%2!=0){
            return false;
        }

        int targetSum = totalSum / 2;
        Arrays.sort(nums);

        Set<Integer> sums = new HashSet<Integer>();
        sums.add(0);
        for (int num : nums) {
            if (num > targetSum) {
                break;
            }

            Set<Integer> newSums = new HashSet<Integer>();

            System.out.println("########num val is:"+num);
            for (int val : sums) {
                int newSum = val + num;
                if (newSum == targetSum) {
                    System.out.println(newSums);
                    return true;
                } else if (newSum < targetSum) {
                    newSums.add(newSum);
                }
            }

            System.out.println("########here");
            System.out.println(newSums);
            sums.addAll(newSums);
            System.out.println("########final");
            System.out.println(sums);
        }

        return false;
    }


}
