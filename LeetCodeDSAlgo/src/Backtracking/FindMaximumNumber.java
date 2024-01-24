package Backtracking;

/*
* Given a string A and integer B, what is maximal lexicographical stringthat can be made from A if you do atmost B swaps.
* */
public class FindMaximumNumber {

    static String max = "";
    public static void main(String args[]){
        String str = "129814999";
        int k = 3;

        max = str;

        findMaximumNumber(str.toCharArray(), k);
        System.out.println("the max is :"+max);

    }

    static void findMaximumNumber(char[] str, int k){

        if(k==0)
            return;

        int n = str.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){

                if(str[i]<str[j]){
                    char t = str[i];
                    str[i]= str[j];
                    str[j] = t;

                    //System.out.println("first str:"+String.valueOf(str));

                    if(String.valueOf(str).compareTo(max)>0){
                        max = String.valueOf(str);
                        System.out.println("max str:"+max);
                    }

                    findMaximumNumber(str, k-1);

                    char ch = str[i];
                    str[i] = str[j];
                    str[j] = ch;

                    //System.out.println("last str:"+String.valueOf(str));
                }

            }
        }

    }
}
