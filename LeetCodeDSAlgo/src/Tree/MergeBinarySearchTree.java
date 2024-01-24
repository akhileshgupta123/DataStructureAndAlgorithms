package Tree;

import java.util.*;

class MergeTreeNode{
    int data;
    MergeTreeNode left,right;

    MergeTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }

}

class StackNode{
    MergeTreeNode l, r;
}

public class MergeBinarySearchTree {

    public static void main(String args[]){

        MergeBinarySearchTree obj = new MergeBinarySearchTree();
        MergeTreeNode root1 = obj.CreateMergeTreeNode(1);
        root1.left = obj.CreateMergeTreeNode(2);
        root1.right = obj.CreateMergeTreeNode(3);
        root1.left.left = obj.CreateMergeTreeNode(4);
        root1.left.right = obj.CreateMergeTreeNode(5);
        root1.right.right = obj.CreateMergeTreeNode(6);


        MergeTreeNode root2 = obj.CreateMergeTreeNode(4);
        root2.left = obj.CreateMergeTreeNode(1);
        root2.right = obj.CreateMergeTreeNode(7);
        root2.left.left = obj.CreateMergeTreeNode(3);
        root2.right.left = obj.CreateMergeTreeNode(2);
        root2.right.right = obj.CreateMergeTreeNode(6);

        MergeTreeNode root3 = obj.mergeTrees(root1, root2);
        System.out.printf("The Merged Binary Tree is:\n");
        obj.inorder(root3);

    }

    private MergeTreeNode CreateMergeTreeNode(int data){
        MergeTreeNode new_node = new MergeTreeNode(data);
        return new_node;
    }

    private void inorder(MergeTreeNode node){
        if(node==null)
            return;

        this.inorder(node.left);
        System.out.println( node.data);
        this.inorder(node.right);
    }

    private MergeTreeNode mergeTrees(MergeTreeNode t1, MergeTreeNode t2){
        if(t1==null)
            return t2;
        if(t2==null)
            return t1;

        Stack<StackNode> st = new Stack<StackNode>();


        StackNode temp = new StackNode();
        temp.l = t1;
        temp.r = t2;


        st.add(temp);
        StackNode n;


        while (! st.isEmpty())
        {
            n = st.peek();
            st.pop();
            if (n.l == null|| n.r == null)
                continue;
            n.l.data += n.r.data;
            System.out.println("the final"+n.l.data);
            if (n.l.left == null){
                if(n.r.left!=null)
                    System.out.println("only left"+n.r.left.data);
                n.l.left = n.r.left;
            }
            else
            {
                StackNode t = new StackNode();
                t.l = n.l.left;
                t.r = n.r.left;
                st.add(t);
            }
            if (n.l.right == null){
                n.l.right = n.r.right;
                if(n.r.right!=null)
                    System.out.println("only right"+n.r.right.data);
            }
            else
            {
                StackNode t = new StackNode();
                t.l = n.l.right;
                t.r = n.r.right;
                st.add(t);
            }
        }
        return t1;
    }
}
