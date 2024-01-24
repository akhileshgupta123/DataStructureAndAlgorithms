package Tree;

public class TreeNodeDistance {
    TreeNodeDistanceItem root;

    public static void main(String args[]){
        TreeNodeDistance obj = new TreeNodeDistance();
        obj.root = obj.createTreeNode(1);
        obj.root.left = obj.createTreeNode(2);
        obj.root.right = obj.createTreeNode(3);

        obj.root.left.left = obj.createTreeNode(4);
        obj.root.left.right = obj.createTreeNode(5);

        obj.root.right.left = obj.createTreeNode(6);
        obj.root.right.right = obj.createTreeNode(7);

        obj.root.right.left.right = obj.createTreeNode(8);


        int result = obj.findDistance(obj.root,4,6);

        System.out.println("the result is :"+result);





    }

    private int findDistance(TreeNodeDistanceItem root,int a, int b){
        TreeNodeDistanceItem node = LCA(root, a,b);
        int d1 = findLevel(node, a, 0);
        int d2 = findLevel(node, b, 0);

        return d1+d2;

    }

    private int findLevel(TreeNodeDistanceItem root, int a, int level){
        if(root==null)
            return -1;

        if(root.data == a)
            return level;

        int left = findLevel(root.left, a, level+1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);

        return left;

    }

    private TreeNodeDistanceItem LCA(TreeNodeDistanceItem root, int n1, int n2){

        if(root==null || n1==root.data || n2==root.data)
            return root;

        TreeNodeDistanceItem left=LCA(root.left, n1, n2);




        TreeNodeDistanceItem right=LCA(root.right, n1, n2);



        if(left!=null && right!=null)
            return root;

        if(left!=null)
            return left;
        if(right!=null)
            return right;

        return null;

    }


    private TreeNodeDistanceItem createTreeNode(int data){
        TreeNodeDistanceItem obj = new TreeNodeDistanceItem(data);
        return obj;
    }
}

class TreeNodeDistanceItem{
    int data;
    TreeNodeDistanceItem left, right;
    public TreeNodeDistanceItem(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
