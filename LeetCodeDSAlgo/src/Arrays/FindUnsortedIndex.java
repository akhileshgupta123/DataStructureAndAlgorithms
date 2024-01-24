package Arrays;

public class FindUnsortedIndex {
    public static void main(String args[]){
        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};

        //int arr[] = {1, 2, 3, 4, 5};

        int arr_size = arr.length;
        FindUnsortedIndex obj = new FindUnsortedIndex();
        obj.printUnsorted(arr,arr_size);
    }

    private void printUnsorted(int arr[], int n){
        int s=0,e=n-1,i, min,max;

        for (s = 0; s < n-1; s++)
        {
            if (arr[s] > arr[s+1])
                break;
        }

        if (s == n-1)
        {
            System.out.println("The complete array is sorted");
            return;
        }

        for(e = n - 1; e > 0; e--)
        {
            if(arr[e] < arr[e-1])
                break;
        }

        max = arr[s];
        min = arr[s];
        for(i=s+1;i<=e; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }

        System.out.println("max"+max);
        System.out.println("min"+min);

        for(i=0; i<s; i++){
            if(arr[i]>min){
                s=i;
                break;
            }
        }

        for(i=n-1;i>=e-1; i--){

            if(arr[i] < max)
            {
                e = i;
                break;
            }
        }

        System.out.println(" The unsorted subarray which"+
                " makes the given array sorted lies"+
                "  between the indices "+s+" and "+e);
        return;
    }
}
