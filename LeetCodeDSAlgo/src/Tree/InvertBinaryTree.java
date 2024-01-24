package Tree;

public class InvertBinaryTree {
    InvertTreeNode root;
    public static void main(String args[]){
        InvertBinaryTree obj = new InvertBinaryTree();
        obj.root = obj.createNode(2);
        obj.root.left = obj.createNode(1);
        obj.root.right = obj.createNode(4);
        obj.root.right.left = obj.createNode(3);
        obj.root.right.right = obj.createNode(5);

        obj.print_tree(obj.root);
       obj.root =  obj.invertNode(obj.root);
       System.out.println("");
       obj.print_tree(obj.root);
    }

    private void print_tree(InvertTreeNode node)
    {
        if (node == null)
            return;

        print_tree(node.left);
        System.out.print(node.data + " ");

        print_tree(node.right);
    }
    private InvertTreeNode createNode(int data){
        InvertTreeNode obj = new InvertTreeNode(data);
        return obj;
    }

    private InvertTreeNode invertNode(InvertTreeNode root){
        if(root==null){
            return root;
        }

        InvertTreeNode left = invertNode(root.left);
        InvertTreeNode right = invertNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

class InvertTreeNode{
    int data;
    InvertTreeNode left,right;
    public InvertTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
