package BinarySearch;
import java.util.*;
//1870. Minimum Speed to Arrive on Time
public class MinimumSpeedOnTime {
    public static void main(String args[]){
        int dist[] = new int[]{1,3,2};
        double hour = 1.9;
        MinimumSpeedOnTime obj = new MinimumSpeedOnTime();
        int result = obj.getMinSpeed(dist,hour);
        System.out.println("result :"+result);
    }

    private int getMinSpeed(int[] dist, double hour){
        int left = 1;
        int right = 10000000;
        while (left < right) {
            int middle = (left + right) / 2;
            if (arriveOnTime(dist, hour, middle))
                right = middle;
            else
                left = middle + 1;

        }
        return right == 10000000 ? -1 : right;
    }

    private boolean arriveOnTime(int[] dist, double hour, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length-1; i++) {
            time = time + (double)Math.ceil((double) (dist[i] / speed));
        }

        time  = time +  (double) (dist[dist.length - 1] / speed);
        System.out.println("time is :"+time);
        return time<=hour;
    }
}
