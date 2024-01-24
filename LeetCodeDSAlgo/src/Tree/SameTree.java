package Tree;

public class SameTree {
    SameTreeNode root1;
    SameTreeNode root2;
    public static void main(String args[]){
        SameTree obj = new SameTree();
        obj.root1 = obj.createNode(1);
        obj.root1.left = obj.createNode(3);
        obj.root1.right = obj.createNode(2);



        obj.root2 = obj.createNode(1);
        obj.root2.left = obj.createNode(2);
        obj.root2.right = obj.createNode(3);

        boolean result = obj.isSameTree(obj.root1, obj.root2);

        System.out.println("the status is :"+result);
    }

    private SameTreeNode createNode(int data){
        SameTreeNode obj = new SameTreeNode(data);
        return obj;
    }

    private boolean isSameTree(SameTreeNode root1, SameTreeNode root2){
        if(root1==null && root2==null){
            return true;
        }

        if(root1==null || root2 == null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);

    }
}

class SameTreeNode{
    int data;
    SameTreeNode left, right;

    SameTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }

}
