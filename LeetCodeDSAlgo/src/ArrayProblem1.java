

/*
Given an integer array A of size N.

        You can pick B elements from either left or right end of the array A to get maximum sum.

        Find and return this maximum possible sum.

        NOTE: Suppose B = 4 and array A contains 10 elements then

        You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.

Input Format
First argument is an integer array A.

Second argument is an integer B.


Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2
*/
public class ArrayProblem1 {

    public static void main(String args[]){
        int arr[] = { 8, 4, 4, 8, 12, 3, 2, 9 };
        int K = 3;
        int n = arr.length;

        maxPointCount(arr, K, n);
    }

    public static int maxPointCount(int arr[], int K, int size){
        int curr_point = 0;
        int max_point = 0;

        for(int i=0; i<K; i++){
            curr_point += arr[i];
        }

        max_point = curr_point;
        int j = size - 1;

        for(int i=K-1; i>=0; i--){
            curr_point = curr_point + arr[j] - arr[i];
            max_point = Math.max(curr_point, max_point);
            System.out.println("inner curr point is"+curr_point);
            j--;
        }
        System.out.println("the max point is"+max_point);
        return max_point;

    }

}
