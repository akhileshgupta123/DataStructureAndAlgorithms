package Arrays;
import java.util.*;

public class PlusOneArray {

    public static void main(String args[]){
        int digit[] = {1,2,9};
        //int digit[] = {9,9,9};

        PlusOneArray obj = new PlusOneArray();
        digit = obj.addOne(digit);
        System.out.println(Arrays.toString(digit));
    }

    private int[] addOne(int digit[]){
        int i = digit.length-1;

        System.out.println("the i is:"+i);
        while(i>=0){
            if(digit[i]!=9){
                digit[i] = digit[i] + 1;
                return digit;
            }
            digit[i] = 0;
            i--;
        }

        int res[] = new int[digit.length+1];
        System.out.println(Arrays.toString(res));
        res[0] = 1;
        System.out.println(Arrays.toString(res));
        return res;
    }
}
