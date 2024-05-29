package Recursion;

public class EncryptedWord {

    public static void main(String args[]){
        EncryptedWord obj = new EncryptedWord();
        String test = "abcxcba";
        String result = obj.findEncryptedWord(test);

        System.out.println("The result is :"+result);

    }

    private String findEncryptedWord(String s){

        String r = "";
        int mid = 0;

        mid = s.length()/2;

        if(s.length()%2==0){
            mid = mid-1;
        }

        r += s.substring(mid, mid+1);

        if(mid>0){
            String ls = s.substring(0,mid);
            System.out.println("left side:"+ls);

            r += findEncryptedWord(ls);

            System.out.println("final left side:"+r);
        }

        if(mid<s.length()-1){
            String rs = s.substring(mid+1, s.length());
            System.out.println("right side:"+rs);
            r += findEncryptedWord(rs);

            System.out.println("final right side:"+r);
        }

        return r;

    }
}
