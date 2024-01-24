package StringProblem;

//1456. Maximum Number of Vowels in a Substring of Given Length
//O(n) time O(1) space
public class MaximumVowels {
    public static void main(String args[]){
        MaximumVowels obj = new MaximumVowels();
        String s = "abciiidef";
        int k = 3;
        int result = obj.maxVowels(s,k);

        System.out.println("result is:"+result);
    }


    private int maxVowels(String s, int k) {
        int vowel = 0;
        for(int i =0; i< k; i++)
            if(isVowel(s.charAt(i))) vowel++;
        int max = vowel;
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))) vowel++;
            if(isVowel(s.charAt(i-k))) vowel--;
            max = Math.max(max, vowel);
        }
        return max;
    }
    private boolean isVowel(char c){
        if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) return true;
        return false;
    }
}
