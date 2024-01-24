package Arrays;

public class FindSplitPoint {
    public static void main(String args[]){
        //int arr[] = new int[]{1, 5, 7, 1};
        //int arr[] = new int[]{1,2,1,1,3};
        //int arr[] = new int[]{5,2,3};
        int arr[] = new int[]{1,1,1,1,1,5};

        int n = arr.length;

        FindSplitPoint obj = new FindSplitPoint();
        obj.printTwoPairs(arr,n);
    }

    private void printTwoPairs(int arr[], int n){
        int splitpoint = findSplitPoint(arr,n);
        System.out.println("split point is:"+splitpoint);
        if (splitpoint == -1 || splitpoint == n )
        {
            System.out.println("Not Possible" );
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if(splitpoint == i)
                System.out.println();

            System.out.print(arr[i] + " ");
        }

    }

    private int findSplitPoint(int arr[], int n){
        int leftsum = 0;

        for(int i=0;i<n; i++){
            leftsum = leftsum+arr[i];
        }

        int rightsum = 0;

        for(int i=n-1;i>=0;i--){
            rightsum = rightsum + arr[i];
            leftsum = leftsum - arr[i] ;

            if (rightsum == leftsum)
                return i ;
        }

        return -1;

    }
}
