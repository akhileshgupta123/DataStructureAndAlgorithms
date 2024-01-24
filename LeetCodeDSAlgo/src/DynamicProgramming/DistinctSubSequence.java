package DynamicProgramming;
//115. Distinct Subsequences
/*
Time Complexity: O(m*n).
        Only one traversal of the matrix is needed, so the time Complexity is O(m*n)
        Auxiliary Space: O(m*n).

 */
public class DistinctSubSequence {
    public static void main(String args[]){
        /*
        String T = "ge";
        String S = "geeksforgeeks";*/

        String T = "bag";
        String S = "babgbag";


        DistinctSubSequence obj = new DistinctSubSequence();
        int result = obj.subSequenceCount(S,T);
        System.out.println("the result is :"+result);
    }

    private int subSequenceCount(String S, String T){
        int m = T.length();
        int n = S.length();
        if (m > n)
            return 0;


        int mat[][] = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            mat[i][0] = 0;
        }

        for(int j=0; j<=n; j++){
            mat[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(T.charAt(i-1) != S.charAt(j - 1)){
                    /*System.out.println("not match");
                    System.out.println("T"+T.charAt(i-1));
                    System.out.println("S"+S.charAt(j-1));*/
                    mat[i][j] = mat[i][j-1];
                }else{
                    System.out.println(" match");
                    System.out.println("T"+mat[i][j-1]);
                    System.out.println("S"+mat[i-1][j-1]);
                    mat[i][j] = mat[i][j-1] + mat[i-1][j-1];
                }
            }
        }


        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                System.out.println ( "mat[i][j]  "+mat[i][j]);
        return mat[m][n];
    }
}
