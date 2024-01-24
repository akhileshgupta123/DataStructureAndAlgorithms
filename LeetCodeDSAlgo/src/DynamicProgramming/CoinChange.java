package DynamicProgramming;
//322. Coin Change
public class CoinChange {
    public static void main(String args[]){
        CoinChange obj = new CoinChange();
        //int denomination[] = new int[]{4, 17, 29};
        //int targetMoney = 75;

        int denomination[] = new int[]{1,2,5};
        int targetMoney = 11;

        boolean result = obj.change(targetMoney, denomination);
        System.out.println("result is :"+result);
    }

    private boolean change(int amount, int coins[]){
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i<coins.length; i++) {
            for(int j = coins[i]; j<dp.length; j++) {
                System.out.println("here");
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        if(dp[amount]>0)
            return true;
        else
            return false;
        //return dp[amount];
    }
}
