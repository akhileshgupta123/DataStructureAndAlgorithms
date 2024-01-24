package Hashing;
import java.util.*;
//106. Construct Binary Tree from Inorder and Postorder Traversal
// O(n) time and O(n) space
class TreeInPostOrder{
    int data;
    TreeInPostOrder left,right;
    public TreeInPostOrder(int data){
        this.data = data;
        this.left = this.right = null;
    }

}
public class ConstructTreeInPostOrder {
    public static void main(String args[]){
        int inorder[] = new int[]{9,3,15,20,7};
        int postorder[] = new int[]{9,15,7,20,3};
        ConstructTreeInPostOrder obj = new ConstructTreeInPostOrder();
        obj.buildTreePostIn(inorder,postorder);
    }


    public TreeInPostOrder buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return this.buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);
    }


    private TreeInPostOrder buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeInPostOrder root = new TreeInPostOrder(postorder[pe]);
        System.out.println(root.data);
        int ri = hm.get(postorder[pe]);
        System.out.println("ri:"+ri);
        System.out.println("ps:"+ps);
        System.out.println("is:"+is);
        TreeInPostOrder leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeInPostOrder rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
