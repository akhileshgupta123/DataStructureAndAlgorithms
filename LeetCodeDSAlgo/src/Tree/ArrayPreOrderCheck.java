package Tree;
import java.util.*;
//2764 - is Array a Preorder of Some ‌Binary Tree
public class ArrayPreOrderCheck {
    private int k;
    Map<Integer, List<Integer>> g = new HashMap<>();

    List<List<Integer>> nodeList = new ArrayList<List<Integer>>();

    public static void main(String args[]){
        ArrayPreOrderCheck obj = new ArrayPreOrderCheck();
        int[][] nodes = new int[][]{{0,-1},{1,0},{2,0},{3,2},{4,2}};

        //int[][] nodes = new int[][]{{0,-1},{1,0},{2,0},{3,1},{4,1}};



        for(int[] item: nodes){
            List<Integer> innerItem = new ArrayList<Integer>();
            innerItem.add(item[0]);
            innerItem.add(item[1]);
            obj.nodeList.add(innerItem);
        }

        boolean isPreorder = obj.isPreorder(obj.nodeList);

        System.out.println("is preorder:"+isPreorder);

    }

    public boolean isPreorder(List<List<Integer>> nodes){

        for (List<Integer> node : nodes) {

            final int id = node.get(0);
            final int parentId = node.get(1);
            if(g.containsKey(parentId)){
                List<Integer> innerItem = g.get(parentId);
                innerItem.add(id);
                g.put(parentId,innerItem);
            }else{
                List<Integer> innerItem = new ArrayList<Integer>();
                innerItem.add(id);
                g.put(parentId,innerItem);
            }
        }

        System.out.println("###############"+k);

        System.out.println("###############"+nodes.size());
        System.out.println("###############"+ (k == nodes.size()));

        //System.out.println("############final output"+  (dfs(nodes.get(0).get(0))));

        return dfs(nodes.get(0).get(0)) && k == nodes.size();

    }

    private boolean dfs(int i) {

        System.out.println("value of i"+i);
        if (i != this.nodeList.get(k).get(0)) {
            return false;
        }
        ++k;

        List<Integer> innerItem = g.get(i);
        if(innerItem!=null && innerItem.size()>0){
            System.out.println("inner item size:"+innerItem.size());
            for(int j:innerItem){

                System.out.println("inner item is:"+j);
                if (!dfs(j)) {
                    return false;
                }
            }
        }


        return true;

    }
}
