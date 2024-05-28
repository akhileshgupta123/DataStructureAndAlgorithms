//Minimize operations to make minimum value of one array greater than maximum value of the other
/*
Given two arrays A[] and B[] consisting of N and M integers, the task is to find the minimum number of operations required
to make the minimum element of the array A[] at least the maximum element of the array B[]
such that in each operation any array element A[] can be incremented by 1 or any array element B[] can be decremented by 1.
*/
/*
Time Complexity: O(K*log K), where the value of K is max(N, M).
Auxiliary Space: O(1)
 */
import java.util.*;
/*
static class CustomComparator implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        return o2.compareTo(o1);
    }
}*/
public class MinOperationTwoArray {
    public static void main(String args[]){
        int[] A= new int[]{1,2,2,3};
        Integer[] B= new Integer[]{1,2,3,4};
        MinOperationTwoArray obj = new MinOperationTwoArray();
        obj.findMinMoves(A,B);

    }


    public int findMinMoves(int[] A, Integer[] B){
        int n, m;
        n = A.length;
        m = B.length;

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };


        /*Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }*/
        Arrays.sort(A);

        Arrays.sort(B,comparator);
        int ans = 0;

        //System.out.println(A[0]);
        //System.out.println(B[0]);

        for(int i=0; i < Math.min(m, n) && A[i] < B[i] ; i++){
            ans += (B[i] - A[i]);
            System.out.println("ans is:"+ans);

            System.out.println("inner data is:"+(B[i] - A[i]));
        }

        System.out.println("######ans :"+ans);
        return ans;
    }

    public  boolean cmp(int a, int b)
    {
        return a > b;
    }


}


