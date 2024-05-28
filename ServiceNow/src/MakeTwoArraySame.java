//Making elements of two arrays same with minimum increment/decrement
import java.util.*;
public class MakeTwoArraySame {
    public static void main(String[] args){
        int[] a = new int[]{ 3, 1, 1 };
        int[] b = new int[]{ 1, 2, 2 };
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;

        int result = 0;

        for (int i = 0; i < n; ++i){
            if(a[i]>b[i] || a[i]<b[i]){
                result = result + Math.abs(a[i]-b[i]);
            }
        }

        System.out.println("result is :"+result);

    }
}
