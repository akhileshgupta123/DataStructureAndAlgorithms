package Tree;
//250  Count Univalue Subtrees
class UniValueTree{
    int data;
    UniValueTree left,right;
    public UniValueTree(int data){
        this.data = data;
        this.left = this.right = null;
    }

}
public class UniValueSubTreeCount {
    UniValueTree root;
    int res = 0;
    public static void main(String args[]){
        UniValueSubTreeCount obj = new UniValueSubTreeCount();
        obj.root = new UniValueTree(5);
        obj.root.left = new UniValueTree(1);
        obj.root.right = new UniValueTree(5);
        obj.root.left.left = new UniValueTree(5);
        obj.root.left.right = new UniValueTree(5);
        obj.root.right.right = new UniValueTree(5);
        int result = obj.countUnivalSubtrees(obj.root);
        System.out.println("result is"+result);
    }

    public int countUnivalSubtrees(UniValueTree root) {


        this.isUnival(root, -1);
        return res;
    }


    boolean isUnival(UniValueTree root, int val) {
        if (root == null) {
            return true;
        }

        System.out.println("before it is current:"+root.data);
        System.out.println("before it is parent:"+val);
        boolean left = isUnival(root.left, root.data); // return meaning left is, and left-val == root-val
        boolean right = isUnival(root.right, root.data);
        System.out.println("left is:"+left);
        System.out.println("right is:"+right);
        if (!left || !right) {
            return false;
        }

        ++res;
        System.out.println("res:"+res);
        System.out.println("root element:"+root.data);
        System.out.println("parent element:"+val);
        return root.data == val;

    }
}
