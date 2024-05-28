import java.util.*;
public class ClosetElements {
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;

        ClosetElements obj = new ClosetElements();
        List<Integer> result = obj.findClosestElements(arr,k,x);

        System.out.println(result);

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x){

        int lo = 0;
        int hi = arr.length - 1;
        while (hi - lo >= k) {
            if(Math.abs(arr[lo] - x)> Math.abs(arr[hi] - x)){
                lo++;
            }else{
                hi--;
            }
        }

        List<Integer> result = new ArrayList<Integer>(k);

        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
