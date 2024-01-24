package StringProblem;

public class KMPStrStr {
    public static void main(String args[]){

        KMPStrStr obj = new KMPStrStr();
        int result = obj.strStr("hello","ll");

        System.out.println("the result is:"+result);

    }

    private int strStr(String haystack, String needle){
        int h = haystack.length();
        int n = needle.length();

        if(needle.isEmpty())
            return 0;

        if(n>h)
            return -1;

        for(int i=0; i<h-n+1; i++){
            int j=0,k;

            if((haystack.charAt(i) == needle.charAt(j)) &&
                    (haystack.charAt(i+n-1) == needle.charAt(j+n-1))){

                k=i;

                while(k<h && j<n && haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                }


                if(j==n)
                    return i;
            }
        }

        return -1;
    }
}
