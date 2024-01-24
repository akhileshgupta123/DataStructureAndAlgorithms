package Grind75;
//Time Complexity : O(n)
//        Auxiliary Space : O(1)
public class SplitTwoSubArray {
    public static void main(String args[]){
        int arr[] = new int[] { 1 , 2 , 3 , 4 , 5 , 5  };
        //int arr[] = new int[] { 4, 3, 2, 1 };


        int n = arr.length;

        SplitTwoSubArray obj = new SplitTwoSubArray();

        int index = obj.findSplitPoint(arr, n);
        if(index!=-1){
            for(int i=0; i<index; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println(" ");
            for(int i=index;i<arr.length; i++){
                System.out.print(arr[i]+" ");
            }

        }


    }


    private int findSplitPoint(int[] arr, int n){
        int leftSum = 0;
        for (int i = 0 ; i < n ; i++)
            leftSum += arr[i];

        int rightSum = 0;

        for (int i = n-1; i >= 0; i--){
            rightSum += arr[i];
            leftSum -= arr[i] ;
            if (rightSum == leftSum)
                return i ;
        }
        return -1;
    }
}
