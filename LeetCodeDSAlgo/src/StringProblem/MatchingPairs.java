package StringProblem;
import java.util.*;

public class MatchingPairs {

    public static void main(String args[]){

        MatchingPairs obj = new MatchingPairs();
        //int result = obj.matchingPair("abcde","abcbe");

        int result = obj.matchingPair("abcde","adcbe");



        System.out.println("the result is :"+result);

    }

    int matchingPair(String s, String t){
        Set<String> mismatchS = new HashSet<String>();
        char sToChar[] = s.toCharArray();
        char tToChar[] = t.toCharArray();
        int matching = 0;

        for (int i =0;i<sToChar.length;i++) {
            if(sToChar[i]!=tToChar[i]) {
                mismatchS.add(sToChar[i]+""+tToChar[i]);
            }
            else
                matching++;
        }

        System.out.println("the set length is:"+mismatchS.size());
        System.out.println("the set length is:"+mismatchS);

        for(String mism : mismatchS) {
            String reverse=mism.charAt(1)+""+mism.charAt(0);
            if(mismatchS.contains(reverse)) {

                System.out.println("match found");
                return matching+2;
            }
        }

        System.out.println("the matching is:"+matching);

        if(mismatchS.size()==1)
            matching--;
        if(mismatchS.size()==0)
            matching--;
        return matching;


    }
}
