import java.util.*;
//input = {1,2,3}, sum=4
//output = {1,1,1,1}, {2,2}, {1,3},{1,1,2}
//output count = 4
public class IBSSumArray {
    public static void main(String args[]){
        int[] arr = new int[]{1,2,3};
        //expected output
        int sum = 4;
        IBSSumArray obj = new IBSSumArray();
        int result = obj.findSumArray(arr, sum);

        System.out.println("count:"+result);
    }

    private int findSumArray(int[] array, int sum ){
        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        Map<Integer,Integer> uniqueArrayMap = new HashMap<Integer,Integer>();
        for(int i=0;i<array.length; i++){
            //unique elements
            int diff = sum-array[i];
            if(uniqueArrayMap.containsKey(diff)){
                List<Integer> item = new ArrayList<Integer>();
                item.add(diff);
                item.add(array[i]);
                sumList.add(item);
            }else{
                uniqueArrayMap.put(array[i], 1);
            }

            int item = array[i];
            if(sum % item ==0){
                int division = sum/item;
                List<Integer> result = new ArrayList<Integer>();
                for(int j=0; j<division; j++){
                    result.add(item);
                }
                sumList.add(result);
            }
        }

        /*

        int[][]  arrayElement= new int[sum+1][sum+1];

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                arrayElement[i][j-1] + arrayElement[i-1][j]
            }
        }*/


/*
        for(int i=0; i<array.length; i++){
            int item = array[i];
            if(sum % item ==0){
                int division = sum/item;
                List<Integer> result = new ArrayList<Integer>();
                for(int j=0; j<division; j++){
                    result.add(item);
                }
                sumList.add(result);
            }
        }*/


        return sumList.size();
    }
}
