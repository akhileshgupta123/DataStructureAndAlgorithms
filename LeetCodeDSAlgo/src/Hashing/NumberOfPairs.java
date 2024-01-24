package Hashing;
import java.util.*;
//2023. Number of Pairs of Strings With Concatenation Equal to Target
public class NumberOfPairs {
    public static void main(String args[]){
        NumberOfPairs obj = new NumberOfPairs();
        /*String nums[] = new String[]{"777","7","77","77"};
        String target = "7777";*/
        String nums[] = new String[]{"123","4","12","34"};
        String target = "1234";
        int result = obj.getPairs(nums,target);
        System.out.println(result);
    }

    private int getPairs(String[] nums, String target){
        HashMap<String, Integer> map = new HashMap<String,Integer>() ;
        int N = nums.length ;
        int n = target.length() ;
        int result = 0 ;

        for (int i = 0; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1) ;
        }

        for (int i = 0; i < N; i++) {
            int m = nums[i].length() ;
            if (target.startsWith(nums[i])) {
                String suffix = target.substring(m) ;
                if (map.containsKey(suffix))
                    result += map.get(suffix) ;
            }
/*
            if (target.endsWith(nums[i])) {
                String prefix = target.substring(0, n-m) ;
                if (map.containsKey(prefix))
                    result += map.get(prefix) ;
            }

            map.put(nums[i], map.getOrDefault(nums[i], 0)+1) ;*/

        }
        return result;
    }
}
