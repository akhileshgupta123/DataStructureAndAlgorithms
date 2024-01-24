package Tree;
import java.util.*;
//two sum from tree using different level
//n space and n time complexity
public class TwoSumBSTDifferentLevel {
    TreeNodeDifferentLevel root;

    public static void main(String args[]){
        TwoSumBSTDifferentLevel obj = new TwoSumBSTDifferentLevel();
        obj.root = new TreeNodeDifferentLevel(5);
        //obj.root.left = new TreeNodeDifferentLevel(3);
        obj.root.left = new TreeNodeDifferentLevel(4);
        obj.root.right = new TreeNodeDifferentLevel(6);
        obj.root.left.left = new TreeNodeDifferentLevel(2);
        obj.root.left.right = new TreeNodeDifferentLevel(4);
        obj.root.right.right = new TreeNodeDifferentLevel(7);


        obj.root.right.left = new TreeNodeDifferentLevel(5);
        int k = 9;
        List<Integer> result = obj.findTwoSum(obj.root, k);

        for(Integer node : result){
            System.out.println("the element is:"+node);
        }



    }

    private List<Integer> findTwoSum(TreeNodeDifferentLevel root, int k){
        if(root==null){
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();

        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        Queue<TreeNodeDifferentLevel> queue = new LinkedList<TreeNodeDifferentLevel>();
        queue.add(root);
        TreeNodeDifferentLevel curr = null;
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                curr = queue.poll();

                if(map.containsKey((k-curr.data))){
                    List<Integer> itemList = map.get(k- curr.data);
                    for(Integer item: itemList){
                        if(item!=level){
                            result.add(k-curr.data);
                            result.add(curr.data);
                            //return result;
                        }
                    }
                    /*if((Integer) map.get((k-curr.data))!=level){
                        result.add(k-curr.data);
                        result.add(curr.data);
                        return result;
                    }*/

                }

                if(map.containsKey(curr.data)){
                    List<Integer> itemList = map.get(curr.data);
                    itemList.add(level);
                    map.put(curr.data,itemList);
                }else{
                    List<Integer> itemList = new ArrayList<Integer>();
                    itemList.add(level);
                    map.put(curr.data,itemList);
                }

                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            level++;
        }
        return result;
    }
}

class TreeNodeDifferentLevel{
    int data;
    TreeNodeDifferentLevel left, right;
    public TreeNodeDifferentLevel(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
