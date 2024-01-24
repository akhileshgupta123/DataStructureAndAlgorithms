package DynamicProgramming;
import java.util.*;
//140. Word Break II
/*
Time Complexity: O(2^N), where N is the length of the given string.
        Auxiliary Space: O(S + N). where S is the sum of all characters of wordDict1.

 */
public class WordBreak2 {
    public static void main(String args[]){
        WordBreak2 obj = new WordBreak2();
        String str = "pineapplepenapple";
        List<String> dict = new ArrayList<String>();
        dict.add("apple");
        dict.add("pen");
        dict.add("applepen");
        dict.add("pine");
        dict.add("pineapple");

        List<String> result = obj.wordBreak(str,dict);
        System.out.println(result);

    }

    private List<String> wordBreak(String s, List<String> wordDict){
        List<String> ans = new ArrayList<String>();
        StringBuilder str=new StringBuilder();
        HashSet<String> hset=new HashSet<String>(wordDict);
        helper(s,hset,ans,str,0);
        return ans;
    }

    private void helper(String s, HashSet<String> hset, List<String> ans, StringBuilder str, int index){
        if(index==s.length()){
            ans.add(str.toString().trim());
            return;
        }

        for(int i=index;i<s.length();i++){
            String subStr= s.substring(index,i+1);
            if(hset.contains(subStr)){
                str.append(subStr);str.append(" ");
                helper(s,hset,ans,str,i+1);

                str.setLength(str.length()-subStr.length()-1);
            }
        }

    }
}
