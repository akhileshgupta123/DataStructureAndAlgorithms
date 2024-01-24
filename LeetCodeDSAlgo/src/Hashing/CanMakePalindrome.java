package Hashing;
import java.util.*;
//1177. Can Make Palindrome from Substring
public class CanMakePalindrome {
    public static void main(String args[]){
        CanMakePalindrome obj = new CanMakePalindrome();
        int[][] queries = new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        List<Boolean> result = obj.canMakePalindrome("abcda",queries);
        System.out.println(result);

    }

    private List<Boolean> canMakePalindrome(String s, int[][] queries){
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(canMakePal(s, query[0], query[1], query[2]));
        }
        return res;
    }

    private boolean canMakePal(String s, int start, int end, int max) {
        if (max >= 13) return true;
        Set<Character> set = new HashSet();
        for (int i = start; i <= end; i++) {
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }

        }
        System.out.println(set);
        return max >= set.size()/2;
    }
}
