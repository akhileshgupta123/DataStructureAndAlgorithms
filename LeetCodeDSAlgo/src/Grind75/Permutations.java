package Grind75;
import java.util.*;
//46. Permutations
//Time complexity: (O(n!))
//Space complexity: (O(n))
public class Permutations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    public static void main(String args[]){
        int[] nums = new int[]{1,2,3};
        Permutations obj = new Permutations();
        obj.permute(nums);
        System.out.println(obj.res);
    }

    public List<List<Integer>> permute(int[] nums){
        permute_(nums, 0, nums.length-1);
        return res;
    }

    private void permute_(int[] nums, int start, int end){
        if(start==end){
            List<Integer> l = new ArrayList<Integer>();
            for(int v : nums) l.add(v);
            res.add(l);
            return ;
        }

        for(int i=start; i<=end; i++){
            swap(nums, i, start);
            permute_(nums, start+1, end);
            swap(nums, i, start);
        }

    }

    private void swap(int[] nums, int l, int r){
        if(r == l) return;

        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
