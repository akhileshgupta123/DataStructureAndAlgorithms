import java.util.*;

/*
*
/// 1 operation have 2 function

conditions - even, odd, prime, composite, perfectsquare, perfectcube,

operations - count, sum, biggest, smallest, minimum, median
* generic function to support all operations
*
* */
public class BinaryTreeOddNumberCount {

    public static void main(String args[]){

        BinaryTreeOddNumberCount obj = new BinaryTreeOddNumberCount();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = obj.findEvenNumberCountFromTreeNode(root);

        System.out.println(result);
    }


    public int findCountOddNumber(TreeNode root){
        int node_count = 0;
        node_count  = this.treeTraversal(root, node_count);

        return node_count;
    }


    private int treeTraversal(TreeNode root, int node_count ){
        if(root.left!=null){
            node_count = this.treeTraversal(root.left, node_count);
        }

        if(root.data%2!=0){
            node_count++;
        }

        if(root.right!=null){
            node_count = this.treeTraversal(root.right, node_count);
        }

        return node_count;

    }

    public int findEvenNumberCountFromTreeNode(TreeNode root){
        int even_node_count = 0;
        even_node_count  = this.evenTreeNodeTraversalProcessing(root, even_node_count);

        return even_node_count;
    }

    private int evenTreeNodeTraversalProcessing(TreeNode root, int even_node_count ){
        if(root.left!=null){
            even_node_count = this.evenTreeNodeTraversalProcessing(root.left, even_node_count);
        }

        if(root.data%2==0){
            //System.out.println(root.data);
            even_node_count++;
        }

        if(root.right!=null){
            even_node_count = this.evenTreeNodeTraversalProcessing(root.right, even_node_count);
        }

        return even_node_count;
    }
}

class TreeNode{
    int data;
    TreeNode left, right;
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
