package Hashing;

import java.util.*;
//3. Longest Substring Without Repeating Characters
public class LongestSubString {

    public static void main(String args[]){
        LongestSubString obj = new LongestSubString();
        String s = "geeksforgeeks";
        int len = obj.lengthOfLongestSubstring(s);
        System.out.println("the longest length is :"+len);
    }

    public int lengthOfLongestSubstring(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }

        int maxsize = 0;
        int lastDupIndex = -1;

        char chars[] = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i<chars.length; i++){
            Integer lastIndex = map.get(chars[i]);

            System.out.println("last index:"+lastIndex);

            System.out.println("lastDupIndex index:"+lastDupIndex);
            if (lastIndex != null && lastDupIndex < lastIndex) {
                /*System.out.println("last index:"+lastIndex);
                System.out.println("element:"+chars[i]);
                System.out.println("lastDupIndex index:"+lastDupIndex);*/
                lastDupIndex = lastIndex;
            }

            maxsize = Math.max(maxsize, i-lastDupIndex);
            System.out.println("max size:"+maxsize);
            map.put(chars[i], i);
        }


        return maxsize;
    }
}
