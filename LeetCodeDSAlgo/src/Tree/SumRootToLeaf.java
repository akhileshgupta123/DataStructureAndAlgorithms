package Tree;

public class SumRootToLeaf {
    SumRootLeafNode root;
    public static void main(String args[]){
        SumRootToLeaf obj = new SumRootToLeaf();
        obj.root = new SumRootLeafNode(6);
        obj.root.left = new SumRootLeafNode(3);
        obj.root.right = new SumRootLeafNode(5);
        obj.root.right.right = new SumRootLeafNode(4);
        obj.root.left.left = new SumRootLeafNode(2);
        obj.root.left.right = new SumRootLeafNode(5);
        obj.root.left.right.right = new SumRootLeafNode(4);
        obj.root.left.right.left = new SumRootLeafNode(7);
        int result = obj.treePathSumUtil(obj.root, 0);

        System.out.println("result is :"+result);
    }

    private int treePathSumUtil(SumRootLeafNode node,int val){
        if (node == null)
            return 0;

        val = (val * 10 + node.data);

        if (node.left == null && node.right == null) {
            System.out.println(val);
            return val;
        }

        return treePathSumUtil(node.left, val)
                + treePathSumUtil(node.right, val);

    }
}

class SumRootLeafNode{
    int data;
    SumRootLeafNode left, right;
    public SumRootLeafNode(int data){
        this.data = data;
    }
}
