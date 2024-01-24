package Hashing;
import java.util.*;

//76. Minimum Window Substring
public class MinimumWindowSubString {
    public static void main(String args[]){
        MinimumWindowSubString obj = new MinimumWindowSubString();
        String result = obj.minWindow("ADOBECODEBANC","ABC");

        System.out.println("result is :"+result);


        int len = obj.minWindowLength("ADOBECODEBANC","ABC");

        System.out.println("length is :"+len);

    }

    public String minWindow(String s1, String s2){
        HashMap<Character,Integer> freq = new HashMap<Character,Integer>();
        HashMap<Character,Integer> test = new HashMap<Character,Integer>();

        for(int i=0;i<s2.length(); i++){
            char ch = s2.charAt(i);
            int fre = freq.getOrDefault(ch, 0);
            freq.put(ch, fre + 1);
        }

        System.out.println("size is"+freq.size());

        int count = 0;
        int i = 0, j = 0;
        int n = s2.length();
        int ans = Integer.MAX_VALUE;
        String res = "";

        while(i < s1.length() || count == n) {
            char ch = s1.charAt(i);
            int og = test.getOrDefault(ch, 0) + 1;
            if(freq.containsKey(ch))
                if(og <= freq.get(ch))
                    count++;
            test.put(ch, og);

            while(count == n) {

                if(ans > i - j + 1) {
                    ans = i - j + 1;
                    res = s1.substring(j, i + 1);
                    System.out.println("iner res:"+res);
                }

                ch = s1.charAt(j);
                og = test.get(ch) - 1;
                if(freq.containsKey(ch))
                    if(og < freq.get(ch))
                        count--;

                System.out.println("inner counter is :"+count);
                System.out.println("inner ch is :"+ch);
                test.put(ch, og);
                j++;
            }

            i++;
        }

        return res;
    }


    public int minWindowLength(String s, String t){
        int len = -1;
        HashMap<Character,Integer> freq = new HashMap<Character,Integer>();
        HashMap<Character,Integer> test = new HashMap<Character,Integer>();

        for(int i=0;i<t.length(); i++){
            char ch = t.charAt(i);
            int fre = freq.getOrDefault(ch, 0);
            freq.put(ch, fre + 1);
        }

        int count = 0;
        int i = 0, j = 0;
        int n = t.length();
        int ans = Integer.MAX_VALUE;
        String res = "";


        while(i < s.length() || count == n) {
            char ch = s.charAt(i);
            int og = test.getOrDefault(ch, 0) + 1;
            if(freq.containsKey(ch))
                if(og <= freq.get(ch))
                    count++;
            test.put(ch, og);

            while(count == n) {

                if(ans > i - j + 1) {
                    ans = i - j + 1;
                    res = s.substring(j, i + 1);
                }

                ch = s.charAt(j);
                og = test.get(ch) - 1;
                if(freq.containsKey(ch))
                    if(og < freq.get(ch))
                        count--;
                test.put(ch, og);
                j++;
            }

            i++;
        }

        len = res.length();
        if(len==0)
            len = -1;
        return len;
    }
}
