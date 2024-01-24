package Grind75;
//5. Longest Palindromic Substring
//Time complexity: O(N^2)

//Space complexity:O(1)
public class LongestPalindromeSubString {
    public static void main(String args[]){
        String s = "babad";
        LongestPalindromeSubString obj = new LongestPalindromeSubString();
        String result = obj.longestSubString(s);
        System.out.println(result);
    }

    public String longestSubString(String s){
        int start=0;
        int end =0;

        for(int i=0;i<s.length()-1;i++) {
            int len1 = pal(s,i,i) ; // for odd length
            int len2 = pal(s,i,i+1) ; // for even length

            int len = Math.max(len1,len2);
            if(end-start<len) {
                start = i-(len-1)/2 ;
                end = i+len/2 ;
            }


        }

        return s.substring(start,end+1) ;
    }

    public int pal(String s ,int i,int j) {
        if(s.charAt(i)!=s.charAt(j)) return 0;
        while(i>=0 &&j<s.length() && s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }
}
