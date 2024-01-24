package Backtracking;
import java.util.*;
//1339. Maximum Product of Splitted Binary Tree
class SplitTree{
    int data;
    SplitTree left,right;
    public SplitTree(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
public class MaxProductSplitBinaryTree {
    SplitTree root;
    public static void main(String args[]){
        MaxProductSplitBinaryTree obj = new MaxProductSplitBinaryTree();
        obj.root = new SplitTree(1);
        obj.root.left = new SplitTree(2);
        obj.root.right = new SplitTree(3);
        obj.root.left.left = new SplitTree(4);
        obj.root.left.right = new SplitTree(5);
        obj.root.right.left = new SplitTree(6);
        int result = obj.maxProduct(obj.root);
        System.out.println(result);
    }



    private int maxProduct(SplitTree root) {
        int MOD = (int) 1000000007;
        Set<Long> sums = new HashSet<Long>();
        int total = dfs(root, sums);
        System.out.println("total is:"+total);
        long max = 0;
        for (long sum : sums) {
            System.out.println(sum);
            max = Math.max(max, sum * (total - sum));
        }
        //return (int) (max % MOD);
        return (int)max;
    }

    private int dfs(SplitTree root, Set<Long> sums) {
        if (root == null)
            return 0;
        root.data += dfs(root.left, sums);
        root.data += dfs(root.right, sums);
        sums.add((long) (root.data));
        return root.data;
    }
}
