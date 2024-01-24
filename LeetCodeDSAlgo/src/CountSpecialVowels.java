public class CountSpecialVowels {

    public static void main(String args[]){
        String str = "adceba";
        //String str ="xabcef";

        long count = countSpecial(str);
        System.out.println(count);
    }



    public static long countSpecial(String str){
        long cnt = 0;
        int n = str.length();

        if(n==1 || n==0)
            return 0;

        long vow =0;
        long cons = 0;

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            vow+= isVowel(ch);

        }
        cons = n-vow;

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(isVowel(ch)==1){
                vow--;
                cnt+= cons;

            }else{
                cons--;
                cnt+= vow;
            }
        }

        return cnt;

    }
    public static int isVowel(char ch)
    {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
                || ch == 'u')
            return 1;
        return 0;
    }
}
