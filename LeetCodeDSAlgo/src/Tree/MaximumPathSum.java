package Tree;

public class MaximumPathSum {
    MaxPathNode root;
    int max_path_sum = Integer.MIN_VALUE;

    public static void main(String args[]){
        MaximumPathSum obj = new MaximumPathSum();
        obj.root = obj.createNode(10);
        obj.root.left = obj.createNode(2);
        obj.root.right= obj.createNode(10);
        obj.root.left.left=obj.createNode(20);
        obj.root.left.right=obj.createNode(1);
        obj.root.right.right=obj.createNode(-25);

        obj.root.right.right.left = obj.createNode(3);
        obj.root.right.right.right = obj.createNode(4);
        int result = obj.maxPathSum(obj.root);

        System.out.println("the result is :"+result);

    }

    MaxPathNode createNode(int data){
        MaxPathNode obj = new MaxPathNode(data);
        return obj;
    }

    private int maxPathSum(MaxPathNode root){
       maxTreePath(root);
        return max_path_sum;
    }

    private int maxTreePath(MaxPathNode root){
        if (root == null)
            return 0;

        /*int left_gain = Math.max(maxTreePath(root.left), 0);
        int right_gain = Math.max(maxTreePath(root.right), 0);*/
        int left_gain = maxTreePath(root.left);
        int right_gain = maxTreePath(root.right);
        System.out.println("root is:"+root.data);
        System.out.println("left_gain is:"+left_gain);
        System.out.println("right_gain is:"+right_gain);

        int price = root.data + left_gain + right_gain;
        max_path_sum = Math.max(price, max_path_sum);

        System.out.println("return value is:"+(root.data + Math.max(left_gain, right_gain)));
        return root.data + Math.max(left_gain, right_gain);

    }
}

class MaxPathNode{
    int data;
    MaxPathNode left,right;
    public MaxPathNode(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
