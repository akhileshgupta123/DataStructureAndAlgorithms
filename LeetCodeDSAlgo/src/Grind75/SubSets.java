package Grind75;
import java.util.*;
//78. Subsets
//TC: O(n * 2^n)
//SC: O(n * 2^n)
public class SubSets {
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3};
        SubSets obj = new SubSets();
        List<List<Integer>> result = obj.subset(nums);
        System.out.println(result);
    }

    List<List<Integer>> subset(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, 0, cur);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int start, List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        for(int i=start; i< nums.length; i++){
            cur.add(nums[i]);
            dfs(nums, res, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
