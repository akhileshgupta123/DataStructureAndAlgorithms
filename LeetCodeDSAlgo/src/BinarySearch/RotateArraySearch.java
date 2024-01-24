package BinarySearch;
//33. Search in Rotated Sorted Array
//Time: O(log n)
public class RotateArraySearch {

    public static void main(String args[]){
        RotateArraySearch obj = new RotateArraySearch();
        //int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        //int key = 3;

        int arr[] = {4,5,6,7,0,1,2};
        int key = 0;



        int result = obj.search(arr, key);

        System.out.println("result is :"+result);
    }

    public int search(int nums[], int target){
        int l=0;
        int r = nums.length-1;

        while(l<=r){
            //final int m = l + (r-l)/2;

            int m =( l + r)/2;

            if (nums[m] == target)
                return m;

            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else{
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            }
        }

        return -1;
    }
}
