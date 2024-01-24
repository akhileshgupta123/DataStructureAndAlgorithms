package Tree;
//979. Distribute Coins in Binary Tree
class DistributeTree{
    int data;
    DistributeTree left,right;
    public DistributeTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
public class DistributeCoinTree {
    DistributeTree root;
    int steps = 0;
    public static void main(String args[]){
        DistributeCoinTree obj = new DistributeCoinTree();
        obj.root = new DistributeTree(0);
        obj.root.left = new DistributeTree(3);
        obj.root.right = new DistributeTree(0);
        int result = obj.distributeCoins(obj.root);
        System.out.println("result is :"+result);

    }

    private int distributeCoins(DistributeTree root) {
        this.postorder(root);
        return steps;
    }

    private int postorder(DistributeTree node) {
        if(node == null) return 0;

        // coin from children -- post-order traversal
        int coin = postorder(node.left) + postorder(node.right);

        System.out.println("before coin is:"+coin);
        System.out.println("node data is:"+node.data);
        // current node coin
        if(node.data == 0) coin += -1; // current node need one coin
        else coin += node.data - 1; // keep one coin for current node

        System.out.println("after coin is:"+coin);
        steps += Math.abs(coin); // each coin move up to parent node need 1 step
        System.out.println("step is:"+steps);
        return coin;
    }
}
