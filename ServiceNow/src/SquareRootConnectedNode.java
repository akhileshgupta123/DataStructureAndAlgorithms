import java.util.*;
/*
You are given total number of nodes and NodeFrom and NodeFrom, which indicates their relation.
We need to calculate the square root on total count of connected node and apply ceiling. Then sum them all.
*/

public class SquareRootConnectedNode {
    public static void main(String args[]){
        SquareRootConnectedNode obj = new SquareRootConnectedNode();
        int nodes = 10;
        int[] nodeFrom  = new int[]{1,1,2,3,6};
        int[] nodeTo = new int[]{2,3,4,5,7};


        double result = obj.calculateClusterSum(nodes,nodeFrom,nodeTo);
        System.out.println(result);
    }

    public double calculateClusterSum(int totalNum, int[] nodeFrom, int[] nodeTo) {
        Map<Integer, Vertax> hashTable = new HashMap<Integer,Vertax>();
        // Build vertaxs
        for (int i = 1; i <= totalNum; i++) {
            hashTable.put(i, new Vertax(i));
        }

        for (int i = 0; i < nodeFrom.length; i++) {
            hashTable.get(nodeFrom[i]).adjacentNodes.put(nodeTo[i],hashTable.get(nodeTo[i]));
        }

        double res = 0;
        Set<Integer> visited = new HashSet<Integer>();

        for(Map.Entry<Integer,Vertax> entry: hashTable.entrySet()){
            if(visited.contains(entry.getKey())){
                continue;
            }

            int count = 0;
            Stack<Vertax> stack = new Stack<Vertax>();
            stack.add(entry.getValue());

            System.out.println("here :"+entry.getKey());

            while(stack.size()>0){
                Vertax cur = stack.pop();
                visited.add(cur.name);
                count += 1;
                for(Map.Entry<Integer, Vertax> neighbour: cur.adjacentNodes.entrySet()){
                    if(visited.contains(neighbour.getKey())){
                        continue;
                    }
                    stack.add(neighbour.getValue());
                }
            }
            res = res + Math.ceil(Math.sqrt(count));

        }
        return res;
    }
}

class Vertax{
    public  int name;
    public Map<Integer, Vertax> adjacentNodes = new HashMap<Integer,Vertax>();
    public Vertax(int name) {
        this.name = name;
    }
}
