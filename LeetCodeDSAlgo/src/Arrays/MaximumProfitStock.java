package Arrays;

public class MaximumProfitStock {
    public static void main(String args[]){
        int prices[] = new int[]{7,1,5,3,6,4};
        //int prices[] = new int[]{7,6,4,3,1};

        MaximumProfitStock obj = new MaximumProfitStock();
        int profit = obj.maxProfit(prices);

        System.out.println("the profit is:"+profit);
    }

    private int maxProfit(int arr[]){
        int profit = 0;
        int curr = arr[0];

        for(int i=0; i<arr.length; i++){
            if(curr>arr[i]){
                curr = arr[i];
            }

            profit = Math.max(profit, arr[i]-curr);

            System.out.println("the inner profit is:"+profit);
        }

        return profit;
    }
}
