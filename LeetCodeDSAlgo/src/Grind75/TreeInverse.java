package Grind75;
//226. Invert Binary Tree

//Time complexity: O(n)
// Space complexity: O(n)
public class TreeInverse {
    public static void main(String args[]){

        TreeInverse obj = new TreeInverse();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode result = obj.invertTree(root);

        System.out.println(result.left.val);
        System.out.println(result.right.val);

    }

    public TreeNode invertTree(TreeNode root){

        if(root==null)
            return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);


        root.left = right;
        root.right = left;

        return root;

    }
}
