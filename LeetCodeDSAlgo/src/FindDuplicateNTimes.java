/*Given an array of n elements that contains elements from 0 to n-1, with any of these numbers appearing any number of times.
        Find these repeating numbers in O(n) and using only constant memory space.*/

public class FindDuplicateNTimes {

    public static void main(String args[]){
        //int arr[] = { 1, 2, 3, 1, 1 };

        int arr[] = { 10, 10, 20, 30, 10, 10 };


        //int arr[] = { 20, 30, 10, 10, 5, 4, 20, 1, 2};

        int n = arr.length;
       int count =  NTimesFind(arr,n);

       System.out.println("the count is :"+count);
    }

    private static int NTimesFind(int arr[], int n){
        int count1=0;
        int count2=0;

        int first =  Integer.MIN_VALUE;;
        int second = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(first == arr[i])
                count1++;
            else if(second == arr[i])
                count2++;
            else if (count1 == 0) {
                count1++;
                first = arr[i];
            }

            else if (count2 == 0) {
                count2++;
                second = arr[i];
            } else {
                count1--;
                count2--;
            }



        }

        System.out.println("count1 is :"+count1);
        System.out.println("count2 is :"+count2);

        System.out.println("first is :"+first);
        System.out.println("second is :"+second);

        count1 = 0;
        count2 = 0;

        // Again traverse the array and
        // find the actual counts.
        for (int i = 0; i < n; i++) {
            if (arr[i] == first)
                count1++;

            else if (arr[i] == second)
                count2++;
        }

        if (count1 > n / 3)
            return first;

        if (count2 > n / 3)
            return second;

        return -1;
    }
}
