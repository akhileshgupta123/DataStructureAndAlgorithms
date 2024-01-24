package Grind75;
import java.util.*;
//Minimum sum of two numbers formed from digits of an array using Sorting:
public class MinimumSumTwoNum {
    public static void main(String args[]){
        int arr[] = { 6, 8, 4, 5, 2, 3 };
        int N = arr.length;

        System.out.print("Sum is " + solve(arr, N));
    }

    static int solve(int arr[], int N){
        Arrays.sort(arr);
        int a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            if (i % 2 != 0){
                a = a * 10 + arr[i];
            }else{
                b = b * 10 + arr[i];
            }
        }

        System.out.println("a :"+a);
        System.out.println("b :"+b);
        return a + b;
    }
}
