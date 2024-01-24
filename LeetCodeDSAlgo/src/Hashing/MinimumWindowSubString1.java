package Hashing;
import java.util.*;
public class MinimumWindowSubString1 {
    public static void main(String args[]){
        MinimumWindowSubString1 obj = new MinimumWindowSubString1();
        String result = obj.minWindow("ADOBECODEBANC","ABC");

        System.out.println("result is :"+result);

    }

    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        HashMap<Character,Integer> mapt= new HashMap<>();
        for(int i=0; i<t.length(); i++)
            mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);

        int totalcount=t.length();
        int count=0;

        String ans="";

        int j=0;
        HashMap<Character,Integer> maps= new HashMap<>();
        System.out.println("total count is:"+totalcount);
        for(int i=0; i<s.length(); i++)
        {
            char ch= s.charAt(i);
            maps.put(ch,maps.getOrDefault(ch,0)+1);
            if(mapt.containsKey(ch) && maps.get(ch)<=mapt.get(ch))
                count++;

            System.out.println("count is:"+count);
            while(totalcount==count)
            {
                if(ans.equals("") || ans.length()>i-j+1)
                    ans=s.substring(j,i+1);

                System.out.println("ans is:"+ans);
                char c= s.charAt(j);
                maps.put(c,maps.getOrDefault(c,0)-1);
                if(mapt.containsKey(c) && maps.get(c)<mapt.get(c))
                    count--;
                j++;
                System.out.println("j is:"+j);
            }
        }
        return ans;
    }
}
