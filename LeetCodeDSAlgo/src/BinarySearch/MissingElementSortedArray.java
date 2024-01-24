package BinarySearch;
//LeetCode 1060. Missing Element in Sorted Array
public class MissingElementSortedArray {
    public static void main(String args[]){
        int[] a = new int[]{4,7,9,10};
        int k=2;
        MissingElementSortedArray obj = new MissingElementSortedArray();
        int result = obj.missingElement(a,k);
        System.out.println(result);
    }

    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - nums[0] - mid >= k) right = mid;
            else left = mid + 1;
        }

        System.out.println("left is:"+left);
        System.out.println( nums[left - 1] + k);

        return nums[left - 1] + k - (nums[left - 1] - nums[0] - (left - 1));

    }
}
