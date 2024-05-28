public class DiameterBinaryTree {

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        /*TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = null;
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(5);*/


        DiameterBinaryTree obj = new DiameterBinaryTree();





        int diameter = findDiameter(root);

        System.out.println("diameter:"+diameter);
    }


    private static int findDiameter(TreeNode root){

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return leftHeight + rightHeight;

    }



    private static int height(TreeNode node){
        if(node==null)
            return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
