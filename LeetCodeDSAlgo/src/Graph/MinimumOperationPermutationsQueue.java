package Graph;
import java.util.*;
import java.util.stream.*;
public class MinimumOperationPermutationsQueue {
    public static void main(String args[]){
        MinimumOperationPermutationsQueue obj = new MinimumOperationPermutationsQueue();
        //int[] arr_1 = {1, 2, 5, 4, 3};
        int[] arr_1 = {3, 1, 2};

        int count = obj.minOperation(arr_1);

        System.out.println("count is :"+count);
    }

    int minOperation(int arr[]){
        int ret=0;
        int[] target = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            target[i] = i+1;
        }
        //int[] target = IntStream.rangeClosed(1, arr.length).toArray();

        System.out.println("target is :"+Arrays.toString(target));
        Set<String> seen = new HashSet<String>();
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(arr);
        seen.add(Arrays.toString(arr));

        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.println("size is :"+size);
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (Arrays.equals(target, curr)) {
                    return ret;
                }

                for (int j = 0; j < curr.length; j++) {
                    for (int k = j + 1; k < curr.length; k++) {

                        int[] next = curr.clone();
                        System.out.println("here");
                        System.out.println("target is :"+Arrays.toString(next));
                        reverse(next, j, k);

                        if (!seen.contains(Arrays.toString(next))) {
                            queue.offer(next);
                            seen.add(Arrays.toString(next));
                        }
                    }
                }
            }



            ret++;
        }


        return ret;
    }


    private void reverse(int[] arr, int from, int to) {
        for(; from < to; from++, to--) {
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }
}
