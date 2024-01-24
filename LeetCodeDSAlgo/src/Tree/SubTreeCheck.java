package Tree;

public class SubTreeCheck {
    SubTreeNode root;
    SubTreeNode childroot;
    public static void main(String args[]){
        SubTreeCheck obj = new SubTreeCheck();
        obj.root = obj.createNode(3);
        obj.root.left = obj.createNode(4);
        obj.root.right = obj.createNode(5);
        obj.root.left.left = obj.createNode(1);
        obj.root.left.right = obj.createNode(2);




        obj.childroot = obj.createNode(4);
        obj.childroot.left = obj.createNode(1);
        obj.childroot.right = obj.createNode(2);

        boolean result = obj.isSubTree(obj.root, obj.childroot);

        System.out.println("the result is :"+result);

    }

    private SubTreeNode createNode(int data){
        SubTreeNode obj = new SubTreeNode(data);
        return obj;
    }


    private boolean isSubTree(SubTreeNode root, SubTreeNode child){
        if(root==null)
            return false;

        if(root.data == child.data){
            if(compareTree(root,child))
                return true;
        }

        if(isSubTree(root.left, child) || isSubTree(root.right, child))
            return true;

        return false;
    }

    private boolean compareTree(SubTreeNode root, SubTreeNode child){
        if(root==null && child==null)
            return true;

        if(root == null || child == null)
            return false;

        if(root.data!=child.data)
            return false;

        return compareTree(root.left, child.left) && compareTree(root.right, child.right);

    }
}

class SubTreeNode{
    int data;
    SubTreeNode left, right;

    public SubTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
