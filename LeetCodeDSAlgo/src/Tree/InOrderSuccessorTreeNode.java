package Tree;


//510. Inorder Successor in BST II
/*
Time Complexity: O(h),
        Auxiliary Space: O(1)*/
class SuccessorNode{
    int data;
    SuccessorNode left,right;

    SuccessorNode(int data){
        this.data = data;
        this.left = this.right = null;
    }

}
public class InOrderSuccessorTreeNode {

    public static void main(String args[]){
        InOrderSuccessorTreeNode obj = new InOrderSuccessorTreeNode();
        SuccessorNode root = new SuccessorNode(15);
        root.left = new SuccessorNode(10);
        root.right = new SuccessorNode(20);
        root.left.left = new SuccessorNode(8);
        root.left.right = new SuccessorNode(12);
        root.right.left = new SuccessorNode(16);
        root.right.right = new SuccessorNode(25);

        SuccessorNode res = obj.inOrderSuccessor(root, root.left.right );

        System.out.println(res.data);
    }

    private SuccessorNode inOrderSuccessor(SuccessorNode root, SuccessorNode n){
        if (n.right != null) {
            return minValue(n.right);
        }

        SuccessorNode succ = null;




        // Start from root and search for
        // successor down the tree
        while (root != null)
        {
            if (n.data < root.data)
            {
                succ = root;
                root = root.left;
            }
            else if (n.data > root.data)
                root = root.right;
            else
                break;
        }

        return succ;

    }

    private SuccessorNode minValue(SuccessorNode t){
        SuccessorNode current = t;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
