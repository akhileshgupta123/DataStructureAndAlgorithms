import java.util.*;
public class ArraySplit {

    public static void main(String args[]){
        int[] array = new int[]{1,2,3,4,5,5};




    }

    private List<List<Integer>> splitArray(int[] array){
        //Arrays.sort(array);
        int sum =0;
        for(int i=0; i<array.length; i++){
            sum = sum+array[i];
        }
        if(sum%2!=0){
            return null;
        }
        sum = sum/2;

        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();


        for(int i=0; i<array.length; i++){

            if(sum==0){
                List<Integer> item = new ArrayList<Integer>();
                item.add()
            }

            sum = sum-array[i];


            if(map.containsKey(sum)){


            }else{
                map.put(sum,i);
            }
            
        }






    }
}
