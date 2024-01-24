package Arrays;
import java.util.*;
//424. Longest Repeating Character Replacement
//sliding window
public class CharacterReplacement {
    public static void main(String args[]){
        CharacterReplacement obj = new CharacterReplacement();
        String s = "PPSPZZP";
        int k = 1;
        //String s = "AABABBA";
        //int k = 1;
        int result = obj.characterReplacement(s,k);
        System.out.println("result is :"+result);
    }

    private int characterReplacement(String s, int k){
        int dic[]=new int[26];
        int start = 0;
        int maxLen = 0;
        int ans=0;
        for(int end=0; end<s.length(); end++){
            maxLen = Math.max(maxLen, ++dic[s.charAt(end)-'A']);


            System.out.println("maxLen is :"+maxLen);
            System.out.println("array is :"+Arrays.toString(dic));
            if (end - start + 1 > maxLen + k) {
                System.out.println("end is :"+end);
                System.out.println("inside");
                System.out.println("result " + dic[s.charAt(start) - 'A']);
                dic[s.charAt(start) - 'A']--;
                start++;

                System.out.println("start is :"+start);
            }
            ans=Math.max(ans,end-start+1);
        }
        return ans;//s.length()-start;
    }
}
