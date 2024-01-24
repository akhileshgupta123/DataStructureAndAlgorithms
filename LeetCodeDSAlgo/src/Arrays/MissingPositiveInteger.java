package Arrays;
/*Given an unsorted integer array, find the first missing positive integer.
*/
public class MissingPositiveInteger {

    public static void main(String args[]){
        //int arr[] = {2,3,-7,6,8,1,-10,15};

        //int arr[] = {1,2,0};
        //int arr[] = {3,4,-1,1};
        int arr[] = {-8, -7, -6};



        int n = arr.length;
        int ans = findMissingNumber(arr, n);
        System.out.println("the missing positive integer is :"+ans);
    }

    static int findMissingNumber(int arr[], int n){
        for(int i=0; i<n; i++){
            while(arr[i]>=1 && arr[i] <=n &&
                    arr[i] != arr[arr[i]-1]){
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println("element is :"+arr[i]);
            if (arr[i] != i + 1)
                return (i + 1);
        }

        return (n + 1);
    }
}
