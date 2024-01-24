package DynamicProgramming;
import java.util.*;
//1626. Best Team With No Conflicts


/*
        Time: O(n^2)O(n2)
        Space: O(n)O(n)*/

public class BestTeamScore {
    public static void main(String args[]){
        BestTeamScore obj = new BestTeamScore();
        /*
        int scores[] = new int[]{1,3,5,10,15};
        int ages[] = new int[]{1,2,3,4,5};

         */

        int scores[] = new int[]{4,5,6,5};
        int ages[] = new int[]{2,1,2,1};
        //scores = [4,5,6,5], ages = [2,1,2,1]

        obj.bestScore(scores,ages);

    }

    private int bestScore(int scores[], int ages[]){

        int maxScore = 0;
        int[][] dp = new int[scores.length][2];
        for(int i=0; i<scores.length; i++){
            dp[i][0] = scores[i];
            dp[i][1] = ages[i];
            maxScore = Math.max(maxScore, scores[i]);
        }
        System.out.println("the max score is:"+maxScore);
        Arrays.sort(dp, (a, b) -> (a[1] == b[1]) ? (a[0] - b[0]) : (a[1] - b[1]));

        for(int i=0; i<dp.length; i++){
            System.out.println("element is :"+dp[i][0]+"    "+dp[i][1] );
        }

        int dp1[] = new int[scores.length];
        int max = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = dp[i][0];


            dp1[i] = dp[i][0];


            for (int j = i - 1; j >= 0; j--) {
                if (dp[i][0] >= dp[j][0]) {
                    dp1[i] = Math.max(dp1[i], score + dp1[j]);
                }
            }
            max = Math.max(max, dp1[i]);
        }
        return max;
    }
}
