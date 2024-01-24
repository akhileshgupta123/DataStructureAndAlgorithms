package Tree;
import java.util.*;
public class DiameterTreeEasy {
    DiameterTreeEasyNode root;
    int max = 0;
    int leftitem = 0;
    int rightitem = 0;
    int prev = 0;
    Stack<Integer> st = new Stack<Integer>();
    public static void main(String args[]){
        DiameterTreeEasy obj = new DiameterTreeEasy();
        obj.root = obj.createNode(1);
        obj.root.left = obj.createNode(2);
        obj.root.right = obj.createNode(3);
        obj.root.left.left = obj.createNode(4);
        obj.root.left.right =obj.createNode(5);
        obj.root.right.left = obj.createNode(6);
        obj.root.right.right = obj.createNode(7);
        obj. root.right.left.right = obj.createNode(8);
        int result = obj.diameterOfBinaryTree(obj.root);
        System.out.println("result is :"+result);
    }
    private DiameterTreeEasyNode createNode(int data){
        DiameterTreeEasyNode obj = new DiameterTreeEasyNode(data);
        return obj;
    }


    private int diameterOfBinaryTree(DiameterTreeEasyNode root){

        maxDepth(root);
        return max;
    }

    private int maxDepth(DiameterTreeEasyNode root){
        if(root!=null && root.left==null && root.right==null){
            st.push(root.data);
        }
        if(root==null)
            return 0;

        int left = this.maxDepth(root.left);
        if( root.data == 1)
            System.out.println("left data is and max value is:"+left + "  "+ st.peek());
        int right = this.maxDepth(root.right);
        if( root.data == 1)
            System.out.println("right data is and max value is:"+right + "  "+st.peek());



        int before = max;
        max = Math.max(max,left+right);



        //prev = max;

        return Math.max(left,right)+1;
    }
}

class DiameterTreeEasyNode{
    int data;
    DiameterTreeEasyNode left, right;
    public DiameterTreeEasyNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
