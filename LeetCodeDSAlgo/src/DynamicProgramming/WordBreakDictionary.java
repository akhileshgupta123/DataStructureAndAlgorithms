package DynamicProgramming;
import java.util.*;

//139. Word Break

//Time is O(n^2)


//using dynamic programming Time: O(string length * dict size).
public class WordBreakDictionary {

    public static void main(String args[]){
        List<String> dict = new ArrayList<String>();
        dict.add("mobile");
        dict.add("samsung");
        dict.add("sam");
        dict.add("sung");
        dict.add("man");
        dict.add("mango");
        dict.add("icecream");
        dict.add("and");
        dict.add("go");
        dict.add("i");
        dict.add("like");
        dict.add("ice");
        dict.add("cream");

        dict.add("apple");
        dict.add("pen");

        dict.add("my");
        dict.add("interview");
        dict.add("trainer");



        WordBreakDictionary obj = new WordBreakDictionary();
        //String item = "applepenapple";

        String item = "myinterviewtrainer";





        boolean result = obj.wordBreak(item,dict);

        System.out.println("the result is :"+result);


        boolean result1 = obj.wordBreakDynamicProgramming(item,dict);

        System.out.println("the result1 is :"+result1);


    }

    private boolean wordBreak(String str, List<String> dict){
        int size = str.length();
        boolean dp[] = new boolean[size+1];

        for(int i=1; i<=size; i++){
            if(dp[i]==false && dict.contains(str.substring(0,i))){
                dp[i]=true;
            }

            if(dp[i] == true){

                if(i== size)
                    return true;


                for (int j = i+1; j <= size; j++){
                    if (dp[j] == false && dict.contains( str.substring(i, j) ))
                        dp[j] = true;

                    if (j == size && dp[j] == true)
                        return true;
                }

            }
        }


        return false;
    }


    private boolean wordBreakDynamicProgramming(String str, List<String> dict){
        boolean t[] = new boolean[str.length()+1];
        t[0] = true;
        for(int i=0; i<str.length(); i++){

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > str.length())
                    continue;

                if(t[end]) continue;

                if(str.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }

        }
        return t[str.length()];
    }
}
