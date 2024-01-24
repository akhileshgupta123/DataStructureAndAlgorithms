package Tree;
//LeetCode 776. Split BST

public class SplitBST {
    public static void main(String args[]){
        SplitBST obj = new SplitBST();
        SplitTreeNode root = new SplitTreeNode(4);
        root.left = new SplitTreeNode(2);
        root.right = new SplitTreeNode(6);
        root.left.left = new SplitTreeNode(1);
        root.left.right = new SplitTreeNode(3);
        root.right.left = new SplitTreeNode(5);
        root.right.right = new SplitTreeNode(7);
        SplitTreeNode[]  result = obj.splitBST(root,2);

        System.out.println(result[0].val);
        System.out.println(result[1].val);
    }

    public SplitTreeNode[] splitBST(SplitTreeNode root, int V){
        if (root == null) {
            return new SplitTreeNode[]{null, null};
        }else if (root.val <= V) {
            System.out.println("when find less");
            SplitTreeNode[] bns = splitBST(root.right, V);
            System.out.println("inside if"+bns[0]);
            System.out.println("inside if"+bns[1]);
            root.right = bns[0];
            return new SplitTreeNode[]{root, bns[1]};
        }else{
            System.out.println("when find greater");
            SplitTreeNode[] bns = splitBST(root.left, V);
            System.out.println(bns[0]);
            System.out.println(bns[1]);
            System.out.println("root data:"+root.val);
            root.left = bns[1];
            return new SplitTreeNode[]{bns[0], root};
        }

    }
}

class SplitTreeNode{
    int val;
    SplitTreeNode left,right;
    SplitTreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}
