package Hashing;
import java.util.*;
//1940. Longest Common Subsequence Between Sorted Arrays
public class LongestCommonSubSequence {
    public static void main(String args[]){
        LongestCommonSubSequence obj = new LongestCommonSubSequence();
        int[][] arrays = new int[][]{{2,3,6,8},{1,2,3,5,6,7,10},{2,3,4,6,9}};
        List<Integer> result = obj.longestCommonSubSequence(arrays);
        System.out.println(result);
    }

    private List<Integer> longestCommonSubSequence(int[][] arrays){
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int[] item: arrays){
            for(int a: item){
                count.put(a, count.getOrDefault(a, 0) + 1);

                if (count.get(a) == arrays.length) {
                    ans.add(a);
                }
            }
        }

        return ans;
    }
}
