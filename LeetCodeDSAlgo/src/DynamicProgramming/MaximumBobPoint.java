package DynamicProgramming;
//2212. Maximum Points in an Archery Competition
public class MaximumBobPoint {
    public static void main(String args[]){
        MaximumBobPoint obj = new MaximumBobPoint();
        //int numArrows = 3;
        int numArrows = 9;
        //int aliceArrows[] = new int[]{0,0,1,0,0,0,0,0,0,0,0,2};
        int aliceArrows[] = new int[]{1,1,0,1,0,0,2,1,0,1,2,0};
        int result[] = obj.findMaxPoint(numArrows,aliceArrows);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    private int[] findMaxPoint(int numArrows, int[] aliceArrows){
        int[][] dp = new int[13][numArrows+1];
        for(int i=0; i<=12; i++){
            for(int j=0; j<=numArrows; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(j>=(aliceArrows[i-1]+1)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-(aliceArrows[i-1]+1)]+(i-1));
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }

        }

        int[] ans = new int[12];
        int result = dp[12][numArrows];
        System.out.println("result"+dp[12][numArrows]);
        int total = 0;
        for (int i=12, j=numArrows; i > 0 && result > 0; i--) {

            if (result == dp[i-1][j])
                continue;
            else{
                // This item is included.
                ans[i-1] = aliceArrows[i-1]+1;
                result -=  (i-1);  // subtracting profit
                j -= (aliceArrows[i-1]+1); // subtracting weight
                total += aliceArrows[i-1]+1;
            }
        }
        if(total<numArrows){
            System.out.println("here"+ans[0]);
            ans[0] = numArrows-total;
        }
        return ans;
    }
}
