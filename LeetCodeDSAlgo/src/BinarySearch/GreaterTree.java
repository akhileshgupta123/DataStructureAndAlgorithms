package BinarySearch;
//Time Complexity =O(N)
//Space Complexity =O(N)
//538. Convert BST to Greater Tree
class GreatNode{
    int data;
    GreatNode left,right;
    public GreatNode(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
public class GreaterTree {
    int sum = 0;
    GreatNode root;
    public static void main(String args[]){
        GreaterTree obj = new GreaterTree();
        obj.root = new GreatNode(4);

        obj.root.left = new GreatNode(1);

        obj.root.right = new GreatNode(6);

        obj.root.left.left = new GreatNode(0);

        obj.root.left.right = new GreatNode(2);

        obj.root.left.right.right = new GreatNode(3);

        obj.root.right.left = new GreatNode(5);

        obj.root.right.right = new GreatNode(7);

        obj.root.right.right.right = new GreatNode(8);


        obj.root = obj.convertBST(obj.root);
        obj.display(obj.root);
    }

    private void display(GreatNode root){
        if (root == null)
            return;
        this.display(root.left);
        System.out.println(root.data);
        this.display(root.right);
    }

    private GreatNode convertBST(GreatNode root) {
        if(root==null){
            return root;
        }
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(GreatNode root){
        if(root==null){
            return;
        }
        reverseInorder(root.right);
        root.data = root.data + sum;
        sum = root.data;
        reverseInorder(root.left);
        return;
    }
}
