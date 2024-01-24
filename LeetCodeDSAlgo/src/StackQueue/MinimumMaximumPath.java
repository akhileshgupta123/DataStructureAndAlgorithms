package StackQueue;
import java.util.*;
//1102. Path With Maximum Minimum Value

//difficult question
public class MinimumMaximumPath {
    public static void main(String args[]){
        MinimumMaximumPath obj = new MinimumMaximumPath();
        int input[][] = new int[][]{{5,4,5},{1,2,6},{7,4,6}};
    }

    private int findmaxminpath(int arr[][]){
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }

        int row = arr.length, col = arr[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){


                return a[0]-b[0];
            }
        });






        return -1;

    }
}
