//647. Palindromic Substrings
public class PalindromeSubstring {
    int count = 0;
    public static void main(String args[]){
        String  s = "aaa";
        PalindromeSubstring obj = new PalindromeSubstring();
        int result = obj.countSubstrings(s);
        System.out.println("here result : "+result);
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for(int i=0; i<s.length(); i++){
            extendPalindrome(s, i, i,"odd"); // odd length;
            extendPalindrome(s, i, i + 1,"even"); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right, String type){
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            System.out.println("type is :"+type);
            System.out.println("String is :"+s.substring(left,right+1));
            count++;
            left--;
            right++;
        }
    }
}
