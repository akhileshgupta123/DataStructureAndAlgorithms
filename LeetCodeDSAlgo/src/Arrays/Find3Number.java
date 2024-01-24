package Arrays;
import java.util.*;
//15. 3Sum
public class Find3Number {

    public static void main(String args[]){
        //int A[] = { -1, 0, 1, 2, -1, -4 };
        //int A[] = {0, -1, 2, -3, 1};
        int A[] = {-1,0,1,2,-1,-4};





        int sum = 0;
        int arr_size = A.length;

        Find3Number obj = new Find3Number();
        obj.find3NumberArray(A,arr_size,sum);
    }

    private boolean find3NumberArray(int A[], int arr_size, int sum){

        for(int i=0; i<arr_size-2; i++){

            HashSet<Integer> s = new HashSet<Integer>();
            //System.out.println("sum is:"+sum);
            int curr_sum = sum - A[i];
            //System.out.println("before inner for loop"+curr_sum);
            for (int j = i + 1; j < arr_size; j++){

                if(s.contains(curr_sum - A[j])){

                    System.out.printf("Triplet is %d, %d, %d", A[i],
                    A[j], curr_sum - A[j]);
                    //return true;
                }

                s.add(A[j]);
                //System.out.println(" inner for loop"+s);
            }

        }
        return false;
    }
}
