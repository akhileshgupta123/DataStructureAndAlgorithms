import java.util.HashSet;

//15. 3Sum
public class FindThreeSum {
    public static void main(String[] args){

        int A[] = {-1,0,1,2,-1,-4};
        int sum = 0;
        int arr_size = A.length;

        FindThreeSum obj = new FindThreeSum();
        obj.findNumberArray(A,arr_size,sum);
    }

    private boolean findNumberArray(int A[], int arr_size, int sum){
        for(int i=0; i<arr_size-2; i++){
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum- A[i];
            for(int j=i+1; j<arr_size; j++){
                if(s.contains(curr_sum-A[j])){
                    System.out.printf("Triplet is %d, %d, %d", A[i],
                            A[j], curr_sum - A[j]);
                }

                s.add(A[j]);
            }
        }

        return false;
    }
}
