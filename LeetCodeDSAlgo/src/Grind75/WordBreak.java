package Grind75;
import java.util.*;
//139. Word Break
public class WordBreak {
    public static void main(String args[]){
        String s = "leetcode";
        String[] wordDict = new String[]{"leet","code"};

        //String s = "applepenapple";
        //String[] wordDict = new String[]{"apple","pen"};


        //String s = "catsandog";
        //String[] wordDict = new String[]{"cats","dog","sand","and","cat"};

        WordBreak obj = new WordBreak();
        boolean result = obj.wordBreak(s, wordDict);

        System.out.println(result);
    }

    public boolean wordBreak(String str, String[] wordDict){
        Set<String> wordSet = new HashSet<String>();

        for(int i=0; i<wordDict.length; i++){
            wordSet.add(wordDict[i]);

        }

        int n = str.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                System.out.println(str.substring(j, i));
                if (dp[j] && wordSet.contains(str.substring(j, i))) {
                    dp[i] = true;

                    System.out.println("index set true"+i);
                    break;
                }
            }
        }

        System.out.println("final is:"+n);
        return dp[n];
    }
}
