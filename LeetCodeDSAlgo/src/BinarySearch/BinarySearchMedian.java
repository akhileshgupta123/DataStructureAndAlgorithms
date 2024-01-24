package BinarySearch;

public class BinarySearchMedian {

    public static void main(String args[]){
        int A[] = new int[]{2, 3, 5, 8};
        int B[] = new int[]{10, 12, 14, 16, 18, 20};
        BinarySearchMedian obj = new BinarySearchMedian();
        double result = obj.median(A,B);
        System.out.println(result);

    }

    private double median(int arrayA[], int arrayB[]){
        int n = arrayA.length;
        int m = arrayB.length;

        if(n>m)
            return median(arrayB, arrayA);

        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;

        while(start<=end){
            int mid = (start + end) / 2;

            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;



            int leftA = (leftAsize > 0) ? arrayA[leftAsize - 1] : Integer.MIN_VALUE; // checking overflow of indices
            int leftB = (leftBsize > 0) ? arrayB[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA = (leftAsize < n) ? arrayA[leftAsize] : Integer.MAX_VALUE;
            int rightB = (leftBsize < m) ? arrayB[leftBsize] : Integer.MAX_VALUE;





            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return -1;
    }
}
