package Backtracking;
import java.util.*;
// 988. Smallest String Starting From Leaf
class SmallLeaf{
    int data;
    SmallLeaf left,right;
    public SmallLeaf(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
public class SmallestFromLeaf {
    SmallLeaf root;
    public static void main(String args[]){
        SmallestFromLeaf obj = new SmallestFromLeaf();
        obj.root = new SmallLeaf(25);
        obj.root.left = new SmallLeaf(1);
        obj.root.right = new SmallLeaf(3);
        obj.root.left.left = new SmallLeaf(1);
        obj.root.left.right = new SmallLeaf(3);
        obj.root.right.left = new SmallLeaf(0);
        obj.root.right.right = new SmallLeaf(2);
        String result = obj.smallestFromLeaf(obj.root);
        System.out.println(result);
    }


    public String smallestFromLeaf(SmallLeaf root) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String a, String b){
                return a.compareTo(b);
            }
        });
        helper(root, sb, pq);
        System.out.println(sb.toString());
        System.out.println("size is:"+pq.size());
        return pq.poll();
    }

    private void helper(SmallLeaf root, StringBuilder sb, PriorityQueue<String> pq){
        if(root == null)
            return ;
        char c = (char)(root.data+'a');   // store the root value as char, it would be easy while deleting
        System.out.println("first:"+sb.toString());
        sb.append(c);

        if(root.left==null && root.right == null){

            pq.offer(sb.reverse().toString());  // sb.reverse does inplace reverse, hence reverse it back
            //System.out.println(sb.toString());
            sb.reverse();
            //System.out.println(sb.toString());
        }
        helper(root.left, sb, pq);
        helper(root.right, sb, pq);
        System.out.println(sb.toString());

        sb.deleteCharAt(sb.length()-1);
        System.out.println("last:"+sb.toString());
    }
}
