package BinarySearch;

/*
Given an sorted array A of size N. Find number of elements which are less than or equal to B.
* * */
public class BinarySearchCountElement {

    public static void main(String args[]){
        int arr[] = { 1, 2, 4, 11, 11, 16 };
        int key = 11;
        int n = arr.length;
        int count = searchCount(arr, n, key);

        System.out.println("The count of element is :"+count);

    }

    static int searchCount(int arr[], int n , int key){

        int left = 0;
        int right = n-1;
        int count = 0;

        while(left<=right){
            int mid = (left+right)/2;

            System.out.println("mid:"+mid);

            if(arr[mid]<=key){
                count = mid + 1;

                left = mid + 1;
                System.out.println("count:"+count);
                System.out.println("left:"+left);
            }else{
                right = mid - 1;
                System.out.println("right:"+right);
            }
        }

        return count;

    }
}
