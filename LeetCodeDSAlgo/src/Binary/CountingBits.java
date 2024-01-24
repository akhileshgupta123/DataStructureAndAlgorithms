package Binary;

public class CountingBits {
    public static void main(String args[]){

        int arr[] = countBits(5);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] countBits(int n)
    {
        int ans[] = new int[n+1];
        for(int i=0;i<ans.length;i++)
        {
            ans[i] = count(i);
        }
        return ans;
    }
    private static int count(int i)
    {
        int count = 0;
        System.out.println("#####");
        while(i!=0)
        {
            System.out.println("element"+i);
            int rsbm = (i & -i);
            System.out.println("rsbm"+rsbm);
            i = (i - rsbm);
            count++;
        }
        return count;
    }
}
