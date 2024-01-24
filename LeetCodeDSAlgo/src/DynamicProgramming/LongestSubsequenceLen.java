package DynamicProgramming;

public class LongestSubsequenceLen {

    public static void main(String args[]){
        LongestSubsequenceLen obj = new LongestSubsequenceLen();
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int result = obj.lengthofLIS(arr);

        System.out.println("result "+result);

    }

    private int lengthofLIS(int arr[]){
        int dp[] = new int[arr.length];
        for(int i=0;i<dp.length; i++){
            dp[i]=1;
        }

        int maxResult = dp[0];
        for(int i=0;i<dp.length;i++){
            for (int j = 0; j < i; ++j) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxResult = Math.max(dp[i], maxResult);
            }
        }
        return maxResult;
    }
}
