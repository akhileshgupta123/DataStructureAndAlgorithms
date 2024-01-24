package Graph;

public class MinimumOperationPermutations {
    public static void main(String args[]){
        MinimumOperationPermutations obj = new MinimumOperationPermutations();
        //int[] arr_1 = {1, 2, 5, 4, 3};
        //int[] arr_1 = {3, 1, 2};
        //int[] arr_1 = {2, 1};
        //int[] arr_1 = {5, 2, 3, 4, 1};
        int[] arr_1 = {7, 5, 8, 2, 3, 6, 4, 1};
        int count = obj.minOperations(arr_1);

        System.out.println("count is :"+count);

    }

    private int minOperations(int arr[]){
        int count = 0;
        boolean sorted = false;
        int i=0;

        while(!sorted){
            int low = -1;
            int high = -1;
            int j = arr.length-1;

            while(i < arr.length && arr[i] == i+1){
                i++;
            }




            while(j >= 0 && arr[j] != i+1){

                j--;
            }


            low = i;
            high = j;

            while(low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }

            if(i >= j) {
                sorted = true;
            } else {
                count++;
            }

        }
        return count;
    }
}
