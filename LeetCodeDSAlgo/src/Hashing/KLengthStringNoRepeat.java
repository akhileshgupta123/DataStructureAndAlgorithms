package Hashing;
import java.util.*;
//1100.Find-K-Length-Substrings-With-No-Repeated-Characters
public class KLengthStringNoRepeat {
    public static void main(String args[]){
        KLengthStringNoRepeat obj = new KLengthStringNoRepeat();
        String S = "havefunonleetcode";
        int K = 5;
        int result = obj.numKLenSubstrNoRepeats(S,K);

        System.out.println("result is:"+result);
    }

    public int numKLenSubstrNoRepeats(String S, int K) {
        HashSet<Character> cur = new HashSet<Character>();
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); j++) {

            while (cur.contains(S.charAt(j))) {
                cur.remove(S.charAt(i++));
            }
            cur.add(S.charAt(j));

            if (j - i + 1 >= K) {
                res += 1;
            }
        }

        return res;
    }
}
