package Grind75;
//121. Best Time to Buy and Sell Stock
public class MaximumProfit {
    public static void main(String args[]){
        int[] prices = new int[]{7,1,5,3,6,4};
        //int[] prices = new int[]{7,6,4,3,1};

        int buy=Integer.MAX_VALUE;
        int sell=0;

        for(int i=0;i<prices.length;i++){

            buy = Math.min(buy,prices[i]);
            sell=Math.max(sell,prices[i]-buy);
        }

        System.out.println("sell:"+sell);
    }
}
