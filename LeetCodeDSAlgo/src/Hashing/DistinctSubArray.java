package Hashing;
import java.util.*;
//1852. Distinct Numbers in Each Subarray
public class DistinctSubArray {
    public static void main(String args[]){

        int item[] = new int[]{1,2,3,2,2,1,3};
        int k =3;
        DistinctSubArray obj = new DistinctSubArray();
        int result[] = obj.getDistinctNumber(item,k);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    int[] getDistinctNumber(int[] nums, int k){

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ans[0] = map.size();
        for (int i = k; i < n; i++) {
            int prev = nums[i - k];
            int curr = nums[i];
            map.put(prev, map.get(prev) - 1);
            if (map.get(prev) == 0)
                map.remove(prev);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            ans[i - k + 1] = map.size();
        }

        return ans;

    }

}
