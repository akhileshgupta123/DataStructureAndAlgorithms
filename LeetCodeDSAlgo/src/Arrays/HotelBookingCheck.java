package Arrays;
import java.util.*;

//ety4Find if k bookings possible with given arrival and departure times
public class HotelBookingCheck {

    public static void main(String args[]){
        /*int arrival[] = {1, 2, 3};
        int departure[] = {2, 3, 4};*/
        int arrival[] = {1, 3, 5};
        int departure[] = {2, 6, 8};
        int k=1;



        HotelBookingCheck obj = new HotelBookingCheck();
        boolean result = obj.bookingCheck(arrival,departure,k);

        System.out.println("the result is:"+result);
    }

    private boolean bookingCheck(int arrival[], int departure[], int k){

        Arrays.sort(arrival);
        Arrays.sort(departure);

        for(int i=0; i<arrival.length; i++){
            if(i+k< arrival.length && arrival[i+k]<departure[i]){
                return false;
            }

        }



        return true;

    }
}
