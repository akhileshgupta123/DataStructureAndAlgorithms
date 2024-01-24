package BinarySearch;
//153. Find Minimum in Rotated Sorted Array
public class FindMinRotatedArray {
    public static void main(String args[]){
        FindMinRotatedArray obj = new FindMinRotatedArray();
        int arr1[] = { 4,5,6,7,0,1,2};
        //int arr1[] = { 11,13,15,17};
        int n1 = arr1.length;
        int result = obj.findMin(arr1, 0, n1 - 1);
        System.out.println("the result is"+result);
    }

    private int findMin(int arr[], int low, int high){

        if(arr.length==1||arr[0]<arr[arr.length-1]){
            return arr[0];
        }
        int mid = 0;
        while(low<high){
            //int mid = low + (high-low)/2;
             mid = (low+high)/2;
            System.out.println("mid is :"+mid);
            //if(arr[mid] == arr[high])
               // high--;

            if(arr[mid]>arr[high])
                low = mid+1;
            else
                high = mid;
        }

        return arr[mid];
    }
}
