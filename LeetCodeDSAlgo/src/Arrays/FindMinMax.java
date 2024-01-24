package Arrays;

public class FindMinMax {

    public static void main(String args[]){
        int arr[] = {-2, 1, -4, 5, 3};
        findMinMaxElement(arr, arr.length);
    }

    private static void findMinMaxElement(int arr[], int n){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        boolean isOdd = false;
        if(n%2 == 1){
            isOdd = true;
            n--;
        }

        for(int i=0; i<n; i=i+2){
            int minimum, maximum;

            if(arr[i]> arr[i+1]){
                minimum = arr[i+1];
                maximum = arr[i];
            }else{
                minimum = arr[i];
                maximum = arr[i+1];
            }

            if(maximum>max){
                max = maximum;
            }

            if(minimum < min){
                min = minimum;
            }
        }



        if(isOdd){
            if(arr[n]> max){
                max = arr[n];
            }

            if(arr[n]< min){
                min = arr[n];
            }
        }

        System.out.println("The minimum array element is " + min);
        System.out.println("The maximum array element is " + max);

    }
}
