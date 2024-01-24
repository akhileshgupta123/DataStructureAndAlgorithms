package Hashing;
import java.util.*;
//1726. Tuple with Same Product
// O(n^2) time
public class SameProductTuple {
    public static void main(String args[]){
        SameProductTuple obj = new SameProductTuple();
        int nums[] = new int[]{1,2,4,5,10};
        int result = obj.tupleSameProduct(nums);
        System.out.println("result"+result);
    }

    private int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                ans += 8 * map.getOrDefault(nums[i] * nums[j], 0);
                System.out.println("ans is:"+ans);
                System.out.println("i is:"+nums[i]);
                System.out.println("j is:"+nums[j]);
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        System.out.println(map);

        return ans;
    }
}
