package Arrays;
//1701. Average Waiting Time
//Time: O(n)O(n)
//Space: O(1)O(1)
public class AverageWaitingTime {
    public static void main(String args[]){
        AverageWaitingTime obj = new AverageWaitingTime();
        //int cust[][] = new int[][]{{1,2},{2,5},{4,3}};
        int cust[][] = new int[][]{{5,2},{5,4},{10,3},{20,1}};


        double result = obj.averageWaitingTime(cust);
        System.out.println(result);
    }

    private double averageWaitingTime(int[][] customers){
        double sumOfTime = 0;
        int preFinishTime = 0;

        for(int[] customer : customers){
            preFinishTime = Math.max(customer[0], preFinishTime);

            System.out.println("preFinishTime :"+preFinishTime);
            sumOfTime = sumOfTime + (preFinishTime+customer[1])-customer[0];
            System.out.println("sum time :"+sumOfTime);
            preFinishTime = preFinishTime + customer[1];

        }
        return sumOfTime/customers.length;
    }
}
