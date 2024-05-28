public class BestTimeBuySellStock {
    public static void main(String args[]){
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeBuySellStock obj = new BestTimeBuySellStock();
        int maxProfit = obj.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public  int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
