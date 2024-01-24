package Tree;
import java.util.*;

class BSTTreeNode {
    int val;
    BSTTreeNode left;
    BSTTreeNode right;
    BSTTreeNode(int x){
        val = x;
    }
}
public class BSTIterator {

    Stack<BSTTreeNode> st;
    BSTTreeNode root;
    public static void main(String args[]){

        BSTIterator bstITR = new BSTIterator();

        bstITR.root  = new BSTTreeNode(5);

        bstITR.root.left = new BSTTreeNode(3);
        bstITR.root.right = new BSTTreeNode(7);

        bstITR.root.left.left = new BSTTreeNode(2);
        bstITR.root.left.right = new BSTTreeNode(4);
        bstITR.root.right.left = new BSTTreeNode(6);
        bstITR.root.right.right = new BSTTreeNode(8);

        bstITR.st = new Stack<BSTTreeNode>();

        BSTTreeNode curr = bstITR.root;

        while(curr!=null){
            System.out.println(curr.val);
            bstITR.st.push(curr);
            curr = curr.left;
        }

        bstITR.iterate();
    }


    BSTTreeNode curr(){
        return st.peek();
    }

    void next(){
        BSTTreeNode temp = st.peek().right;
        st.pop();
        while(temp!=null){
            st.push(temp);
            temp = temp.left;
        }
    }

    boolean isEnd(){
        return !st.isEmpty();
    }

    void iterate(){
        while(isEnd()){
            System.out.print(curr().val + " ");
            next();
        }
    }

}
