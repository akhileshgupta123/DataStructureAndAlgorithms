package Tree;
import java.util.*;

class PairNode{
    int data;
    PairNode left,right;


}

public class FindTreeNodePair {

    public static void main(String args[]){

        FindTreeNodePair obj = new FindTreeNodePair();
        PairNode root = null;
        root = obj.insert(root, 15);
        root = obj.insert(root, 10);
        root = obj.insert(root, 20);
        root = obj.insert(root, 8);
        root = obj.insert(root, 12);
        root = obj.insert(root, 16);
        root = obj.insert(root, 25);
        root = obj.insert(root, 10);

        int sum = 33;

        HashSet<Integer> set = new HashSet<Integer>();

        obj.findPairUtil(root, sum, set);

    }


    PairNode NewNode(int data){
        PairNode temp = new PairNode();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    PairNode insert(PairNode root, int key){
        if(root==null)
            return  this.NewNode(key);

        if(key<root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);


        return root;

    }

    boolean findPairUtil(PairNode root, int sum, HashSet<Integer> set){
        if(root==null)
            return false;

        if(findPairUtil(root.left,sum,set))
            return true;

        if(set.contains(sum-root.data)){
            System.out.println("Pair is found ("
                    + (sum - root.data) + ", "
                    + root.data + ")");
            return true;
        }else{
            set.add(root.data);
        }
        return findPairUtil(root.right, sum, set);
    }
}
