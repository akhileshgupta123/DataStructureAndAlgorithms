import java.util.HashSet;

public class VowelSubSequence {

    static HashSet<String> st = new HashSet<String>();
    public static void main(String args[]){
        String str = "xabcef";

        subsequence(str);

        for(String str1: st){
            System.out.println(str1);
        }
    }

    static boolean isVowels(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }

    static boolean isConsonant(char ch){
        return !isVowels(ch);
    }


    static void subsequence(String str){

        for(int i=0; i< str.length(); i++){
            if(isVowels(str.charAt(i))){

                for (int j = (str.length() - 1); j >= i; j--){

                    if (isConsonant(str.charAt(j))){
                        String str_sub = str.substring(i, j-i + 1);
                        st.add(str_sub);

                        System.out.println("the str is:"+str_sub);


                        for (int k = 1; k < str_sub.length() - 1; k++)
                        {
                            StringBuilder sb = new StringBuilder(str_sub);
                            sb.delete(k, 1);
                            subsequence(sb.toString());
                        }
                    }

                }

            }
        }
    }
}



