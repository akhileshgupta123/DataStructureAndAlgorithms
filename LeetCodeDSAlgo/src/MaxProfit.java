import java.util.*;

public class MaxProfit {

    public static void main(String args[]){
        int seat[] = {2, 3, 4, 5, 1};
        int k = seat.length;
        int n = 6;
        maxProfit(seat, k ,n);
    }

    public static int maxProfit(int seats[], int k, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            pq.add(seats[i]);
        }
        System.out.println(pq);

        int profit = 0;
        int c = 0;

        while(c<n){

            int top = pq.remove();
            System.out.println("the top is:"+top);
            if(top==0)
                break;

            profit = profit + top;
            pq.add(top-1);

            System.out.println("queue is :"+pq);
            c++;
        }

        System.out.println("the profit is:"+profit);
        return -1;

    }
}
