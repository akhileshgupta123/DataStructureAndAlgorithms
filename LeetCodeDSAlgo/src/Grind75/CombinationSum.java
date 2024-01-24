package Grind75;
//39. Combination Sum
import java.util.*;
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String args[]){
        int[] candidates = new int[]{2,3,5};
        int target = 8;

        CombinationSum obj = new CombinationSum();
        List<List<Integer>> res  = obj.combinationSum(candidates,target);

        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] num, int target){
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num, 0, list, 0, target);
        return res;
    }

    private void dfs(int[] num, int start, List<Integer> result, int sum, int target){
        if(sum == target){
            res.add(new ArrayList<Integer>(result));
            return;
        }

        for(int i=start; i < num.length;i++){

            if(num[i] + sum > target) break ;
            result.add(num[i]);
            //System.out.println("passed index is"+i);
            //System.out.println("start index is"+start);
            dfs(num, i, result, sum+num[i], target);
            result.remove(result.size() -1);
        }

    }
}
