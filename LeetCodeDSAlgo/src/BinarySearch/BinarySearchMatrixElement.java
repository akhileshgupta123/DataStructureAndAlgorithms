package BinarySearch;

public class BinarySearchMatrixElement {

    public static void main(String args[]){
        int row = 4;
        int col = 5;
        int arr[][] = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};
        int key =31;

        findRow(arr, row, col, key);
    }

    static void findRow(int arr[][], int row, int col, int key){
        int left = 0;
        int right = row-1;
        int mid;

        while(left<=right){
            mid = (left+right)/2;

            if(key== arr[mid][0]) {
                System.out.println("Found at (" + mid + ","
                        + "0)");
                return;
            }

            if(key== arr[mid][col-1]){
                int t = col - 1;
                System.out.println("Found at (" + mid + ","
                        + t + ")");
                return;
            }

            if(key> arr[mid][0] && key<arr[mid][col-1]){
                binarySearchCurrRow(arr, row, col, key,
                        mid);
                return;

            }

            if(key<arr[mid][0]){
                right = mid - 1;
            }

            if(key>arr[mid][col-1]){
                left = mid + 1;
            }
        }

    }



    static void binarySearchCurrRow(int arr[][], int row, int col, int key, int currrow){
        int left = 0;
        int right = col-1;
        int mid;

        while(left<=right){
            mid = (left+right)/2;
            if(arr[currrow][mid] == key){
                System.out.println("Found at (" + currrow + ","
                        + mid + ")");
                return;
            }

            if(arr[currrow][mid]> key)
                right = mid - 1;
            if(arr[currrow][mid]<key)
                left = mid + 1;

        }

    }
}
