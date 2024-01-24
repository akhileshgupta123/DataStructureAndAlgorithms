package DynamicProgramming;

public class StockPrice {

    public static void main(String args[]){
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        StockPrice obj = new StockPrice();
        Tuple result = obj.findBuySellStockPrices(array);

        System.out.println("purchase price :"+ result.start);
        System.out.println("sell price :"+ result.end);
    }


    private Tuple findBuySellStockPrices(int arr[]){
        if(arr==null || arr.length<2){
            return null;
        }

        int curr_buy = arr[0];
        int global_sell = arr[1];
        int global_profit = global_sell-curr_buy;
        int curr_profit = Integer.MIN_VALUE;

        for(int i=1;i<arr.length; i++){
            curr_profit = arr[i]-curr_buy;
            if(curr_profit > global_profit) {
                global_profit = curr_profit;
                global_sell = arr[i];
            }

            if(curr_buy > arr[i]) {
                curr_buy = arr[i];
            }

        }

        Tuple obj = new Tuple(global_sell-global_profit,global_sell);

        return obj;

    }
}

class Tuple{
    int start;
    int end;
    Tuple(int start, int end){
        this.start = start;
        this.end = end;
    }
}
