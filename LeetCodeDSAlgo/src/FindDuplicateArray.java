/*Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space
        and traversing the stream sequentially O(1) times.*/

public class FindDuplicateArray {

    public static void main(String args[]){

        FindDuplicateArray obj = new FindDuplicateArray();
        //int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr[] = {3,4,1,4,1};
        //int arr[] = {0,1,2,3,4,5};
        //int arr[] = {5,4,3,2,1,0};
        obj.printRepeating(arr, arr.length);
    }

    public void printRepeating(int arr[], int size){

        for(int i=0; i<size; i++){
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
                System.out.print(" ");
            }
            else
                System.out.print(j + " ");
        }
        System.out.println(" ");

        for(int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
