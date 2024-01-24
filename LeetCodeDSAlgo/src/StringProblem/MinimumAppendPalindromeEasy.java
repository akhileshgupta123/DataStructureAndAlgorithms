package StringProblem;

public class MinimumAppendPalindromeEasy {
    public static void main(String args[]){
        //String s = "abede";
        String s = "leetcode";
        MinimumAppendPalindromeEasy obj = new MinimumAppendPalindromeEasy();
        int result = obj.noOfAppend(s);
        System.out.println("result is:"+result);

    }

    private int noOfAppend(String s){
        System.out.println(s);
        if(isPalindrome(s.toCharArray()))
            return 0;
        s=s.substring(1);
        return 1+noOfAppend(s);
    }

    private boolean isPalindrome(char str[]){
        int len = str.length;

        if(len==1)
            return true;

        int ptr1 = 0;
        int ptr2 = len-1;

        while(ptr2>= ptr1){
            if (str[ptr1] != str[ptr2])
                return false;
            ptr1++;
            ptr2--;

        }

        return true;
    }
}
