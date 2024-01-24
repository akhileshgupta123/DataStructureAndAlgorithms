package Arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoNumberSum {

    public static void main(String args[]){
        int num1[] = new int[] {9,9,9};
        int num2[] = new int[] {9,9,9};
        int result[] = null;

        TwoNumberSum obj = new TwoNumberSum();
        TwoNumberSum.getSum(num1,num2);

    }


    private static int[] getSum(int num1[], int num2[]){
        int len1 = num1.length;
        int len2 = num2.length;
        List<Integer> item = new ArrayList<Integer>();
        int count = 0;
        if(len1>len2){
            count = len1-1;
        }else{
            count = len2-1;
        }
        int carry = 0;
        while(count>-1){
            int result = 0;
            if(len1-1==count){
                result = result+ num1[count];
                len1--;
            }

            if(len2-1==count){
                result = result+ num2[count];
                len2--;
            }

            result = result+carry;

            //result = 9;
            System.out.println(result/10);

            if(result/10>0){
                carry = result/10;
                result = result%10;
            }/*else{
                carry = 0;
            }*/

            count--;
            item.add(result);
        }
        if(carry>0){
            item.add(carry);
        }
        System.out.println(item);

        return null;
    }
}
