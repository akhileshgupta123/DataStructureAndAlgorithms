package Hashing;
//2743 - Count Substrings Without Repeating Character
public class CountSubstring {
    public static void main(String args[]){
        CountSubstring obj = new CountSubstring();
        String s = "abab";
        int result = obj.numberOfSpecialSubString(s);
        System.out.println(result);
    }

    private int numberOfSpecialSubString(String s){
        int n = s.length();
        int ans = 0;
        int[] cnt = new int[26];
        for (int i = 0, j = 0; i < n; ++i) {
            int k = s.charAt(i) - 'a';
            ++cnt[k];

            while (cnt[k] > 1) {
                --cnt[s.charAt(j++) - 'a'];
            }
            ans += i - j + 1;
        }
        return ans;
    }
}
