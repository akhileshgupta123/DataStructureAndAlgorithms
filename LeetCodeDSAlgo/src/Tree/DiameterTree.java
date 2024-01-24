package Tree;
import java.util.*;

public class DiameterTree {
    DiameterTreeNode root;
    public static void main(String args[]){
        DiameterTree obj = new DiameterTree();

        obj.root = obj.createNode(1);
        obj.root.left = obj.createNode(2);
        obj.root.right = obj.createNode(3);
        obj.root.left.left = obj.createNode(4);
        obj.root.left.right =obj.createNode(5);

        obj.root.right.left = obj.createNode(6);
        obj.root.right.right = obj.createNode(7);
        obj. root.right.left.right = obj.createNode(8);

        int result = obj.diameterTree(obj.root);

        System.out.println("the final result :"+result);
    }


    private int diameterTree(DiameterTreeNode root){
        return diameter(root);
    }

    private int diameter(DiameterTreeNode root){
        if(root==null)
            return 0;

        int opt1 = height(root.left) + height(root.right);
        int opt2 = diameter(root.left);
        int opt3 = diameter(root.right);
        return Math.max(opt1, Math.max(opt2, opt3));
    }

    private int height(DiameterTreeNode root){
        if(root==null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private DiameterTreeNode createNode(int data){
        DiameterTreeNode obj = new DiameterTreeNode(data);
        return obj;
    }
}

class DiameterTreeNode{
    int data;
    DiameterTreeNode left, right;

    public DiameterTreeNode(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
