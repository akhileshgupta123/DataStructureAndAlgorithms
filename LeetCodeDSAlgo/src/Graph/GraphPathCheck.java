package Graph;
import java.util.*;
//need to correct code
public class GraphPathCheck {

    private int V;
    private  LinkedList<Integer> adj[];

    GraphPathCheck(int v){
        this.V = v;
        this.adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            this.adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        this.adj[v].add(w);
    }

    Boolean isReachable(int s, int d){
        LinkedList<Integer> temp;
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s]= true;
        queue.add(s);

        Iterator<Integer> i;
        while(queue.size()!=0){
            s = queue.poll();
            int n;
            i = adj[s].listIterator();

            while(i.hasNext()){

                n = i.next();

                if(n==d)
                    return true;

                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }

        return false;
    }



    Boolean isReachable1(int s, int d){

        Set<Integer> visitedSet= new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visitedSet.add(s);
        queue.add(s);
        ArrayList<Character> tempItem ;
        while(queue.size()!=0){
            s = queue.poll();
            LinkedList<Integer>  innerItem = adj[s];
            for(Integer item : innerItem){
                if(item==d)
                    return true;

                if(!visitedSet.contains(item)){
                    visitedSet.add(item);
                    queue.add(item);
                }

            }

        }
        return false;
    }

    public static void main(String args[]){

        GraphPathCheck g = new GraphPathCheck(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;

        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);


        u = 3;
        v = 1;
        if (g.isReachable1(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;

    }
}
