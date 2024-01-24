package Tree;
import java.util.*;
public class VerticalTreeTraversal {
    VerticalTreeNode root;
    public static void main(String args[]){
        VerticalTreeTraversal obj = new VerticalTreeTraversal();

        obj.root = obj.createNode(1);
        obj.root.left = obj.createNode(2);
        obj.root.right = obj.createNode(3);
        obj.root.left.left = obj.createNode(4);
        obj.root.left.right = obj.createNode(5);
        obj.root.right.left = obj.createNode(6);
        obj.root.right.right = obj.createNode(7);
        obj.root.right.right.left = obj.createNode(8);
        obj.root.right.right.right = obj.createNode(9);

        obj.verticalOrder(obj.root);
    }


    private VerticalTreeNode createNode(int data){
        VerticalTreeNode obj = new VerticalTreeNode(data);
        return obj;
    }

    private void verticalOrder(VerticalTreeNode root){
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();

        findHorizontalDistance(root, 0, map);

        System.out.println(map.size());
        for(Map.Entry<Integer,List<Integer>> obj : map.entrySet()){
            System.out.println(obj.getKey());
            System.out.println(obj.getValue());
        }
    }


    public void findHorizontalDistance(
            VerticalTreeNode node,  int hd,
            Map<Integer, List<Integer> > map){

        if (node == null)
            return;

        List<Integer> item = map.get(hd);
        if(item==null){

            item = new ArrayList<Integer>();
            item.add(node.data);
        }else{
            item.add(node.data);
        }
        map.put(hd,item);

        findHorizontalDistance(node.left, hd - 1,
                map);


        findHorizontalDistance(node.right,
                hd + 1, map);

    }
}

class VerticalTreeNode{
    int data;
    VerticalTreeNode left,right;
    public VerticalTreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }

}
