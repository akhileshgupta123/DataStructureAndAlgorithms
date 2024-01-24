package Tree;
import java.util.*;
//508. Most Frequent Subtree Sum
class FrequentTreeNode{
    int val;
    FrequentTreeNode left,right;

    FrequentTreeNode(int data){
        this.val = data;
        this.left = this.right = null;
    }

}
public class MostFrequentSubtreeSum {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max;
    public static void main(String args[]){

        MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();

        FrequentTreeNode root = new FrequentTreeNode(5);
        root.left = new FrequentTreeNode(2);
        root.right = new FrequentTreeNode(-3);




        int arr[] = obj.findFrequentTreeSum(root);


    }

    public int[] findFrequentTreeSum(FrequentTreeNode root) {
        max = 0 ;
        List<Integer> list = new ArrayList<Integer>();

        int ans = solveTree(root);


System.out.println("and element"+ans);

        System.out.println("max element"+max);
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }


        int[] res = new int[list.size()];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = list.get(i);
            System.out.println(res[i]);
        }

        return res;

    }


    private int solveTree(FrequentTreeNode root){
        if(root==null)
            return 0;

        int left = solveTree(root.left);
        int right = solveTree(root.right);

        int sum =  root.val + left + right;

        System.out.println("sum of node"+root.val);
        System.out.println(sum);

        map.put(sum , map.getOrDefault(sum , 0)+1);

        System.out.println("map element is"+map.get(sum));

        max = Math.max(map.get(sum), max);

        return sum;
    }
}
