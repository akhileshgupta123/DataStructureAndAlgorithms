//Find the middle element of an array without using its length.
public class MiddleElementWithoutLength {
    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        MiddleElementWithoutLength obj = new MiddleElementWithoutLength();
        int result = obj.findMiddle(arr,0);
        System.out.println(result);
    }


    private int findMiddle(int[] arr, int index){
        int slowindex=0;
        int fastIndex=0;
        try{
            while(arr[fastIndex]>0 && arr[fastIndex+1]>0){
                slowindex++;
                fastIndex++;
                fastIndex++;
            }

        }catch(Exception ex){

        }

        System.out.println("slowindex"+slowindex);
        return arr[slowindex];
    }
}
