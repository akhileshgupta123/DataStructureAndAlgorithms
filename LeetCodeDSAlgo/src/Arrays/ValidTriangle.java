package Arrays;
import java.util.*;
//611. Valid Triangle Number

public class ValidTriangle {
    public static void main(String args[]){
        ValidTriangle obj = new ValidTriangle();
        //int arr[] = new int[]{2,2,3,4};
        int arr[] = new int[]{4,2,3,4};
        int result = obj.triangleNumber(arr);
        System.out.println("result is:"+result);
    }

    private int triangleNumber(int a[]){
        int n = a.length;
        int cnt =0;
        Arrays.sort(a);
        for(int k = n-1;k>=0;k--){
            int i = 0;
            int j = k - 1;
            while(i < j){
                if(a[i] + a[j] > a[k]){
                    System.out.println("here is val:"+(j-i));
                    cnt = cnt + (j - i);
                    System.out.println("j is val:"+j);
                    System.out.println("i is val:"+i);
                    j--;
                }else{
                    i++;
                }
            }

        }

        return cnt;
    }
}
