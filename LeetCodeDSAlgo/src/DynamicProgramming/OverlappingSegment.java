package DynamicProgramming;
//1621. Number of Sets of K Non-Overlapping Line Segments
//Time Complexity: O(n*k)
public class OverlappingSegment {
    public static void main(String args[]){
        OverlappingSegment obj = new OverlappingSegment();
        /*
        int n = 4;
        int k = 2;*/

        /*
        int n = 3;
        int k = 1;
         */


        int n = 30;
        int k = 7;



        int result = obj.numberOfSets(n,k);

        System.out.println("The result is :"+result);
    }

    private int numberOfSets(int n, int k){
        long dp[][] = new long[n+1][k + 1];
        //int mod = 1_000_000_007;
        int mod = 1000000007;
        //dp[0][0] = 1;
        //long sums[] = new long[k+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int j=1;j<=k; j++){
            long sum = 0;
            for(int i=1; i<=n; i++){
                dp[i][j] = (dp[i-1][j] + sum)%mod;
                sum = (sum+dp[i][j-1])%mod;

            }

        }

        return (int)dp[n][k];
    }
}
