package DynamicProgramming;
//97. Interleaving String
/*
Time complexity: O(m⋅n)
        Space complexity: O(m⋅n).*/
public class InterleavingString {
    public static void main(String args[]){
        String str1 = "aabcc";
        String str2 = "dbbca";
        //String str3 = "aadbbcbcac";
        String str3 = "aadbbbaccc";
        InterleavingString obj = new InterleavingString();
        boolean result = obj.isInterleave(str1.toCharArray(),str2.toCharArray(), str3.toCharArray());
        System.out.println("result is :"+result);
    }


    private boolean isInterleave(char S1[], char S2[], char S3[]){
        if(S3.length!= S1.length + S2.length)
            return  false;

        boolean DP[][] = new boolean[S1.length+1][S2.length+1];

        for(int i=0; i<=S1.length; i++){
            for(int j=0; j<=S2.length; j++){
                if(i==0 && j==0)
                    DP[i][j] = true;
                else if(i == 0){
                    //DP[i][j] =  DP[i][j-1] && (S2[j-1] == S3[i+j-1]);


                    if (S2[j - 1] ==  S3[j - 1])
                        DP[i][j] = DP[i][j - 1];
                }
                else if(j == 0){
                    //DP[i][j] =  DP[i][j-1] && (S2[j-1] == S3[i+j-1]);


                    if (S1[i - 1] ==  S3[i - 1])
                        DP[i][j] = DP[i-1][j];
                }else if (S1[i - 1] ==
                        S3[i + j - 1] &&
                        S2[j - 1] != S3[i + j - 1]){

                    DP[i][j] = DP[i-1][j];
                }
                else if (S1[i - 1] !=
                        S3[i + j - 1] &&
                        S2[j - 1] ==
                                S3[i + j - 1]){

                    DP[i][j] = DP[i][j-1];

                }
                else if (S1[i - 1] ==
                        S3[i + j - 1] &&
                        S2[j - 1] ==
                                S3[i + j - 1]){


                    DP[i][j] = (DP[i-1][j] || DP[i][j-1]);

                }

            }
        }

        return DP[S1.length][S2.length];
    }
}
