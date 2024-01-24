package Arrays;

public class PickFromBothSides {

    public static void main(String args[]){
        int arr[] = {5, -2, 3 , 1, 2};
        //int arr[] = {1, 2};

        //int arr[] = {8, 4, 4, 8, 12, 3, 2, 9};

        //int arr[] = {2, 1, 14, 6, 4, 3};



        int result = findMax(arr, 3);

        System.out.println("the result is:"+result);
    }

    private static int findMax(int arr[], int count){
        int n = arr.length;
        int result = 0;

        for(int i=0; i<count; i++){
            result += arr[i];
        }

        int sum = result;

        System.out.println("the sum is:"+sum);

        for(int i=0; i<count; i++){

            sum -= arr[count - 1 - i];
            sum += arr[n - 1 - i];

            System.out.println("the inner sum is:"+sum);

            result = Math.max(result, sum);

            System.out.println("the inner result is:"+result);
        }

        return result;

    }
}
