package Arrays;

import java.util.*;

public class SignatureCount {

    public static void main(String args[]){

        SignatureCount obj = new SignatureCount();
        //int arr[] ={2, 1};
        int arr[] ={4,3,2,5,1};

        int result[] = obj.findSignatureCounts(arr);

        for(int i=0; i<result.length; i++){
            System.out.println("item is:"+result[i]);
        }
    }


    int[] findSignatureCounts(int[] arr) {
        int[] result = new int[arr.length];
        List<LinkedHashSet<Integer>> loops = new ArrayList<LinkedHashSet<Integer>>();

        Arrays.fill(result, 0);
        for (int i = 0; i < arr.length; i++) {
            for(LinkedHashSet<Integer> loop : loops) {
                if(loop.contains(arr[i])) {
                    result[i]=loop.size();
                    break;
                }
            }

            if(result[i]==0) {
                LinkedHashSet<Integer> loop = new LinkedHashSet<Integer>();
                loop.add(arr[i]);
                int index = arr[i] - 1;
                while (index != i) {
                    loop.add(arr[index]);
                    index = arr[index] - 1;
                }
                result[i] = loop.size();
            }
        }
        return result;
    }
}
