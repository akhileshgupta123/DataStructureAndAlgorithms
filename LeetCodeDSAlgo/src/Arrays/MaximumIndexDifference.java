package Arrays;

public class MaximumIndexDifference {

    public static void main(String args[]){
        MaximumIndexDifference max = new MaximumIndexDifference();
        int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        int n = arr.length;
        int maxDiff = max.maxIndexDiff(arr, n);
        System.out.println(maxDiff);
    }

    private int maxIndexDiff(int arr[], int n){
        int maxDiff;
        int i,j;
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = arr[0];
        RMax[n-1] = arr[n-1];

        for (i = 1; i < n; ++i){
            LMin[i] = min(arr[i], LMin[i-1]);
        }

        for(j=n-2; j>=0; j-- ){
            RMax[j] = max(arr[j], RMax[j + 1]);
        }

System.out.println("lower:"+LMin[n-1]);
        System.out.println("max:"+RMax[0]);


        for(int p=0; p<n; p++){
            System.out.println(LMin[p]);
            //System.out.println(RMax);
        }

        for(int p=0; p<n; p++){
            System.out.println(RMax[p]);
            //System.out.println(RMax);
        }


        i = 0;
        j = 0;
        maxDiff = -1;

        while(i<n && j<n){
            if (LMin[i] <= RMax[j]) {
                maxDiff = max(maxDiff, j - i);
                j= j+1;
            }else{
                i = i+1;
            }

        }
        return maxDiff;

    }

    int max(int x, int y)
    {
        return x > y ? x : y;
    }

    int min(int x, int y)
    {
        return x < y ? x : y;
    }
}
