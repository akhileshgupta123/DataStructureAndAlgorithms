package Arrays;
//53. Maximum Subarray
public class MaxSubArraySum {
    public static void main(String args[]){
        MaxSubArraySum obj = new MaxSubArraySum();
        //int arr[] = new int[] {5,4,-1,7,8};
        //int arr[] = new int[] {1,2,3,4,-10};
        int arr[] = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = obj.maxSubArray(arr);

        System.out.println("result is :"+result);
    }

    private int maxSubArray(int arr[]){
        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0; i<size; i++){
            max_ending_here = max_ending_here + arr[i];
            if(max_so_far<max_ending_here){
                max_so_far = max_ending_here;
            }

            if (max_ending_here < 0)
                max_ending_here = 0;

        }

        return max_so_far;
    }
}
