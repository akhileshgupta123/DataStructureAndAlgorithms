package BinarySearch;

public class FirstLastPositionSearch {
    public static void main(String args[]){

        int arr[] = { 5,7,7,8,8,10 };
        int n = arr.length;
        int x = 8;

        FirstLastPositionSearch obj = new FirstLastPositionSearch();
        System.out.println("First Occurrence = " + obj.first(arr, 0, n - 1, x, n));
        System.out.println("Last Occurrence = " + obj.last(arr, 0, n - 1, x, n));
    }

    private int first(int arr[], int low, int high, int x, int n){

        /*

        if(high>=low){
            int mid = (low+high)/2;


            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
             else if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid - 1), x, n);
        }*/

        while(high>=low){
            int mid = (low+high)/2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if (x > arr[mid]){
                low = mid+1;
            }
                //return first(arr, (mid + 1), high, x, n);
            else{
                high = mid - 1;
            }
                //return first(arr, low, (mid - 1), x, n);

        }
        return -1;

    }

    private int last(int arr[], int low, int high, int x, int n){

        while(high>=low){
            int mid = (low+high)/2;

            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid]){
                high = mid-1;
            }
                //return last(arr, low, (mid - 1), x, n);
            else{
                low = mid+1;
            }
                //return last(arr, (mid + 1), high, x, n);
        }

        return -1;

    }
}
