package Tree;

//1123. Lowest Common Ancestor of Deepest Leaves

//Time O(N) for one pass
//Space O(H) for recursion management
class DeepLeaveTree{
    int data;
    DeepLeaveTree left, right;
    public DeepLeaveTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class LowestCommonAncestorDeepLeave {
    DeepLeaveTree root;
    public static void main(String args[]){
        LowestCommonAncestorDeepLeave obj = new LowestCommonAncestorDeepLeave();
        obj.root = new DeepLeaveTree(3);
        obj.root.left = new DeepLeaveTree(5);
        obj.root.right = new DeepLeaveTree(1);
        obj.root.left.left = new DeepLeaveTree(6);
        obj.root.left.right = new DeepLeaveTree(2);
        obj.root.left.right.left = new DeepLeaveTree(7);
        obj.root.left.right.right = new DeepLeaveTree(4);

        obj.root.right.left = new DeepLeaveTree(0);
        obj.root.right.right = new DeepLeaveTree(8);

        DeepLeaveTree result = obj.lcaDeepestLeaves(obj.root);

        System.out.println(result.data);
        System.out.println(result.right.data);
        System.out.println(result.left.data);
    }




    private DeepLeaveTree lcaDeepestLeaves(DeepLeaveTree root) {

        if(root == null)
            return root;

        int left = height(root.left);
        int right = height(root.right);

        if(left == right)
            return root;
        else if(left < right)
            return lcaDeepestLeaves(root.right);
        else
            return lcaDeepestLeaves(root.left);

    }

    private int height(DeepLeaveTree root){
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
