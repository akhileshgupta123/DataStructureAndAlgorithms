package DynamicProgramming;
//322. Coin Change
public class CoinChangeEasy {
    public static void main(String args[]){
        int coins[] = new int[]{1,2,5};
        int amount = 11;
        CoinChangeEasy obj = new CoinChangeEasy();
        int result = obj.coinChange(coins,amount);
        System.out.println("result is"+result);

    }

    private int coinChange(int[] coins, int amount){
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            int minc_req = Integer.MAX_VALUE;

            for(int denom : coins){
                if(i-denom>=0 && dp[i-denom]!=-1 && dp[i-denom]<minc_req){
                    minc_req = dp[i-denom];
                }
            }


            if(minc_req == Integer.MAX_VALUE){
                dp[i] = -1;
            }else{
                dp[i] = minc_req + 1;
            }

        }

        return dp[amount];
    }
}
