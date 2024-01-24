package Arrays;
import java.util.*;
//135. Candy
public class DistributeCandy {
    public static void main(String args[]){
        DistributeCandy obj = new DistributeCandy();
        int arr[] = new int[]{1, 5, 2, 1};
        int result = obj.candy(arr);
        System.out.println("The result is:"+result);
    }

    public int candy(int[] ratings) {
        int[] candiesL = new int[ratings.length];
        Arrays.fill(candiesL, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candiesL[i] = candiesL[i - 1] + 1;
        }


        int[] candiesR = new int[ratings.length];
        Arrays.fill(candiesR, 1);

        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                candiesR[i] = candiesR[i + 1] + 1;
        int sum = 0;

        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(candiesL[i], candiesR[i]);
        }
        return sum;
    }
}
