package Tree;
import java.util.*;
//889. Construct Binary Tree from Preorder and Postorder Traversal
//O(N)
class PrePostTree{
    int data;
    PrePostTree left,right;
    public PrePostTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
public class ConstructTreeFromPrePostOrder {
    int postpreindex=0;
    public static void main(String args[]){
        ConstructTreeFromPrePostOrder obj = new ConstructTreeFromPrePostOrder();
        int preorder[] = new int[]{1,2,4,5,3,6,7};
        int postorder[] = new int[]{4,5,2,6,7,3,1};
        obj.constructFromPrePost(preorder,postorder);
    }


    private  PrePostTree constructFromPrePost(int[] pre, int[] post) {

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<post.length;i++) {
            map.put(post[i], i);
        }
        return helper(pre,post,map,0,post.length-1);
    }

    private  PrePostTree helper(int[] preorder, int[] postorder,HashMap<Integer, Integer> map, int start, int end) {
        if(start>end) {
            return null;
        }
        PrePostTree root=new PrePostTree(preorder[postpreindex++]);
        System.out.println("index is:"+postpreindex);
        if(start==end) {
            return root;
        }

        int index=map.get(preorder[postpreindex]);

        System.out.println("map index is:"+index);
        root.left=helper(preorder,postorder,map,start,index);
        root.right=helper(preorder,postorder,map,index+1,end-1);
        return root;
    }
}
