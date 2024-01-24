package Arrays;
//1109. Corporate Flight Bookings
public class CorporateFlightBooking {
    public static void main(String args[]){

        int booking[][] = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;

/*
        int booking[][] = new int[][]{{1,2,10},{2,2,15}};
        int n = 2;*/

        CorporateFlightBooking obj = new CorporateFlightBooking();
        obj.flightBooking(booking,n);
    }

    private int[] flightBooking(int[][] bookings, int n){

        int[] ret = new int[n];

        for(int[] item: bookings){
            ret[item[0]-1] = ret[item[0]-1] + item[2];
            System.out.println("outer is :"+ret[item[0]-1]);
            if(item[1] < n) {
                ret[item[1]] -= item[2];
                System.out.println("here is :"+ret[item[1]]);
            }
        }


        for(int i = 1; i < n; ++i) {
            System.out.println("before add:"+ret[i-1]);
            ret[i] += ret[i-1];
        }
        for(int item: ret){
            System.out.println(item);
        }

        return ret;
    }
}
