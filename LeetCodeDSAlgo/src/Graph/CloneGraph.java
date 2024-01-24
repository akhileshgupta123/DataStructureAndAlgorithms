package Graph;
import java.util.*;
//133. Clone Graph

public class CloneGraph {
    public static void main(String args[]){

        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        n0.neighbourlist.add(n1);
        n0.neighbourlist.add(n2);
        n1.neighbourlist.add(n2);
        n1.neighbourlist.add(n3);
        n1.neighbourlist.add(n4);
        n2.neighbourlist.add(n3);
        n3.neighbourlist.add(n4);

        CloneGraph obj = new CloneGraph();
        HashSet<GraphNode> visitedNodes = new HashSet<GraphNode>();
        obj.printGraph(n0,visitedNodes);

        HashMap<GraphNode, GraphNode> nodes_completed =
                new HashMap<GraphNode, GraphNode>();

        GraphNode c0 = obj.cloneGraph(n0,nodes_completed);

        HashSet<GraphNode> visitedNodes1 = new HashSet<GraphNode>();

        obj.printGraph(c0,visitedNodes1);


    }

    private void printGraph(GraphNode root, HashSet<GraphNode> visitedNodes){
        if(root==null || visitedNodes.contains(root)){
            return;
        }

        visitedNodes.add(root);

        System.out.print(root.data + ": {");

        for(GraphNode n: root.neighbourlist){
            System.out.print(n.data + " ");
        }


        System.out.println("}");

        for (GraphNode n : root.neighbourlist) {
            printGraph(n, visitedNodes);
        }
    }

    private GraphNode cloneGraph(GraphNode root, HashMap<GraphNode, GraphNode> nodes_completed){
        if (root == null) {
            return null;
        }

        GraphNode pNew = new GraphNode(root.data);
        nodes_completed.put(root, pNew);

        for (GraphNode p : root.neighbourlist) {
            GraphNode x = nodes_completed.get(p);

            if(x==null){
                pNew.neighbourlist.add(cloneGraph(p, nodes_completed));

            }else{
                pNew.neighbourlist.add(x);
            }

        }


        return pNew;

    }
}

class GraphNode{
    public int data;
    public List<GraphNode> neighbourlist = new ArrayList<GraphNode>();
    public GraphNode(int data){
        this.data = data;
    }
}
