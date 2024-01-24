package Backtracking;
import java.util.*;

public class FindBackTracking {
    public static void main(String args[]){
        List<List<Integer>> subset = new ArrayList<List<Integer>>();

        List<Integer> input = new ArrayList<Integer>();
        List<Integer> output = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);

        FindBackTracking obj = new FindBackTracking();
        obj.findSubset(subset, input, output,0);


        System.out.println("subset size is:"+subset.size());
        for(int i=0; i<subset.size(); i++){
            for(int j=0; j<subset.get(i).size(); j++){
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }

    private void findSubset(List<List<Integer>> subset, List<Integer> nums, List<Integer> output, int index){

        if(index == nums.size()){
            System.out.println("######the size is:"+output.size());
            subset.add(output);
            return;
        }

        List<Integer> output1 = new ArrayList<Integer>(output);
        findSubset(subset, nums,output1, index + 1);

        output.add(nums.get(index));
        System.out.println("######the output is:"+output.toString());

        List<Integer> output2 = new ArrayList<Integer>(output);
        findSubset(subset, nums,output2, index + 1);

    }
}
