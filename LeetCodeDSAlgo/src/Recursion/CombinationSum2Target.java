package Recursion;
import java.util.*;
public class CombinationSum2Target {
    public static void main(String args[]){
        CombinationSum2Target obj = new CombinationSum2Target();
        int candidates[] = new int[] {10,1,2,7,6,1,5};
        int target = 8;




        List<List<Integer>> result = obj.combinationSum2(candidates,target);
        System.out.println(result);

    }

    private List<List<Integer>> combinationSum2(int candidates[], int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        dfs(res, curr, target, candidates, 0);
        return res;
    }

    private void dfs(List<List<Integer>> result, List<Integer> curr, int target, int num[], int index){
        if(target==0){
            System.out.println("final is :"+curr);
            result.add(new ArrayList<Integer>(curr));
            return;
        }else if(target<0){
            return;
        }
        for(int i=index; i<num.length;i++){
            if(i>index && num[i-1] == num[i]){
                continue;
            }


            if (target - num[i] >= 0){
                curr.add(num[i]);
                System.out.println("before is :"+curr);
                dfs(result, curr, target - num[i], num, i + 1);
                curr.remove(curr.size() - 1);

                System.out.println("after is :"+curr);
            }
        }

    }
}
