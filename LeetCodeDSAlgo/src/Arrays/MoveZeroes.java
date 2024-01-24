package Arrays;
import java.util.*;

public class MoveZeroes {

    public static void main(String args[]){
        MoveZeroes obj = new MoveZeroes();
        int arr[] = new int[] {1, 10, 20, 0, 59, 63, 0, 88, 0};

        obj.moveZeroLeft(arr);
        System.out.println("the arr is :"+Arrays.toString(arr));

        int arr1[] = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        obj.moveZeroRight(arr1);
        System.out.println("the arr is :"+Arrays.toString(arr1));
    }

    private void moveZeroLeft(int arr[]){
        if(arr.length<1) {
            return;
        }

        int writeIndex = arr.length-1;
        int readIndex = arr.length-1;

        while(readIndex>=0){
            if(arr[readIndex]!=0){
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }

            readIndex--;
        }

        while(writeIndex >= 0) {
            arr[writeIndex] = 0;
            writeIndex--;
        }



    }

    private void moveZeroRight(int arr[]){
        if(arr.length<1) {
            return;
        }

        int writeIndex = 0;
        int readIndex = 0;

        while(readIndex<arr.length){
            if(arr[readIndex]!=0){
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }

            readIndex++;
        }

        while(writeIndex < arr.length) {
            arr[writeIndex] = 0;
            writeIndex++;
        }
    }


}
