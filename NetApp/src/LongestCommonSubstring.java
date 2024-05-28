//Longest Common Substring question.
public class LongestCommonSubstring {
    public static void main(String args[]){
        String[] input = new String[]{"peta", "pet", "peas"};
        LongestCommonSubstring obj =  new LongestCommonSubstring();

        String result = input[0];
        for(int i=1; i<input.length; i++){
            result = obj.commonSubString(result , input[i]);
        }

        System.out.println("result is :"+result);
    }


    public String commonSubString(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        if (maxLength == 0) {
            return ""; // No common substring found
        }

        return x.substring(endIndex - maxLength, endIndex);
    }
}
