package DynamicProgramming;

public class PalindromeSubstringCount {
    public static void main(String args[]){
        PalindromeSubstringCount obj  = new PalindromeSubstringCount();
        String s = "aaa";
        int count = obj.countSubstring(s);

        System.out.println("The count is :"+count);
    }

    private int countSubstring(String s){

        int len = s.length();
        char[] ch = s.toCharArray();

        boolean isSub[][] = new boolean[len][len];

        int count = 0;

        for(int i=len-1; i>=0; i--){

            for(int j=len-1; j>=i; j--){

                if (ch[i] != ch[j])
                    isSub[i][j] = false;
                else{
                    if (i == j)
                        isSub[i][j] = true;
                    else if (j == i + 1)
                        isSub[i][j] = true;
                    else
                        isSub[i][j] = isSub[i + 1][j - 1];

                    if (isSub[i][j]) count++;
                }
            }
        }

        return count;
    }
}
