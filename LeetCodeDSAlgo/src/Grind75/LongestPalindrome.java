package Grind75;
import java.util.*;
//409. Longest Palindrome
// Time Complexity : O(n)
public class LongestPalindrome {
    public static void main(String args[]){
        String str = "abccccdd";

        LongestPalindrome obj = new LongestPalindrome();
        int result = obj.longestPalindrome(str);
        System.out.println(result);

    }

    public int longestPalindrome(String str){
        int length = 0;
        HashSet<Character> hset = new HashSet<Character>();
        for(int id=0; id<str.length(); id++){
            char ch = str.charAt(id);
            if(hset.contains(ch)){
                length += 2;
                hset.remove(ch);
            }else{
                hset.add(ch);
            }
        }

        if(hset.size()>0){
            length++;
        }
        return  length;
    }
}
