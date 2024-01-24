package StringProblem;

public class MinimumAppendPalindromeFront {
    public static void main(String args[]){
        String str = "AACECAAAA";
        MinimumAppendPalindromeFront obj = new MinimumAppendPalindromeFront();
        int len = obj.getMinCharToAddPalindrome(str);
        System.out.println("the len is :"+len);
    }

    private int getMinCharToAddPalindrome(String str){

        StringBuilder s = new StringBuilder();
        s.append(str);
        String rev = s.reverse().toString();
        System.out.println("the reverse is :"+rev);
        s.reverse().append("$").append(rev);
        System.out.println("the s is :"+s);

        int lps[] = computeLPSArray(s.toString());
        System.out.println("str arrays is :"+str.length());

        for(int i=0; i<lps.length; i++){
            System.out.println("array element is:"+lps[i]);
        }
        return str.length() - lps[s.length() - 1];

    }

    public  int[] computeLPSArray(String str){

        int n = str.length();
        System.out.println("n:"+n);
        int lps[] = new int[n];
        System.out.println("len:"+lps.length);
        int i = 1, len = 0;
        lps[0] = 0;
        System.out.println("string is:"+str);
        while (i < n){
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                System.out.println("i is :"+i);
                System.out.println("len is :"+len);
                if (len != 0)
                {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }

        }
        return lps;
    }
}
