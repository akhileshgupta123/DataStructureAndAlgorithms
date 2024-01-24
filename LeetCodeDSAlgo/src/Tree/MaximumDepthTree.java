package Tree;

public class MaximumDepthTree {
    HeightTree root;
    public static void main(String args[]){
        MaximumDepthTree obj = new MaximumDepthTree();
        obj.root = obj.createNode(1);
        obj.root.left = obj.createNode(2);
        obj.root.right = obj.createNode(3);
        obj.root.left.left = obj.createNode(4);
        obj.root.left.right = obj.createNode(5);

        int result = obj.maxDepth(obj.root);

        System.out.println("result is:"+result);
    }

    private HeightTree createNode(int data){
        HeightTree obj = new HeightTree(data);
        return obj;
    }

    private int maxDepth(HeightTree root){
            if(root==null)
                return 0;
            else{
                int ldepth = maxDepth(root.left);
                int rdepth = maxDepth(root.right);

                if(ldepth>rdepth){
                    return ldepth+1;
                }else{
                    return rdepth+1;
                }
            }



    }
}

class HeightTree{
    int data;
    HeightTree left,right;

    public HeightTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
