package Graph;

import java.util.*;

public class GraphSongCheck {
    private int V;
    private Map<Character, ArrayList<Character>> nodeMap;
    private Map<Character, Boolean> visitedMap;

    GraphSongCheck(int v){
        this.V = v;
        this.nodeMap = new HashMap<Character, ArrayList<Character>>();
        this.visitedMap = new HashMap<Character, Boolean>();
    }

    public void addEdge(Character source, Character destination){
        if(this.nodeMap.containsKey(source)){
            ArrayList<Character> listItem = this.nodeMap.get(source);
            listItem.add(destination);
            this.nodeMap.put(source,listItem);
        }else{
            ArrayList<Character> listItem = new ArrayList<Character>();
            listItem.add(destination);
            this.nodeMap.put(source,listItem);
        }

        this.visitedMap.put(source, false);
        this.visitedMap.put(destination, false);
    }

    Boolean isReachable(Character s, Character d){

        Set<Character> visitedSet= new HashSet<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        visitedSet.add(s);
        queue.add(s);
        ArrayList<Character> tempItem ;
        while(queue.size()!=0){
            s = queue.poll();
            if(this.nodeMap.containsKey(s)){
                tempItem = this.nodeMap.get(s);

                for(Character item : tempItem){
                    if(item==d)
                        return true;

                    if(!visitedSet.contains(item)){
                        visitedSet.add(item);
                        queue.add(item);
                    }
                }
            }
        }
        return false;
    }

    ArrayList<Character> getPath(Character s){
        LinkedList<Character> queue = new LinkedList<Character>();
        this.visitedMap.put(s,true);
        queue.add(s);
        ArrayList<Character> tempItem ;
        ArrayList<Character> path = new ArrayList<Character>();
        while(queue.size()!=0){
            s = queue.poll();
            path.add(s);
            if(this.nodeMap.containsKey(s)){
                tempItem = this.nodeMap.get(s);
                for(Character item : tempItem){
                    if(!this.visitedMap.get(item)){
                        this.visitedMap.put(item,true);
                        queue.add(item);
                    }
                }
            }
        }
        return path;
    }

    public static void main(String args[]){
        GraphSongCheck g = new GraphSongCheck(5);
        g.addEdge('A', 'B');
        g.addEdge('B', 'A');
        g.addEdge('B', 'C');
        g.addEdge('C', 'B');
        g.addEdge('D', 'E');
        g.addEdge('E', 'D');

        for(Map.Entry<Character,ArrayList<Character>> entrySet: g.nodeMap.entrySet()){
            System.out.println("key : "+entrySet.getKey());
            System.out.println("value :"+ entrySet.getValue());
        }

        Character s = 'A';
        Character d = 'C';
        if (g.isReachable(s, d))
            System.out.println("There is a path from " + s +" to " + d);
        else
            System.out.println("There is no path from " + s +" to " + d);

        for(Map.Entry<Character,Boolean> entrySet: g.visitedMap.entrySet()){
            if(!entrySet.getValue()){
                ArrayList<Character>  result =  g.getPath(entrySet.getKey());
                System.out.println(result);
            }

        }
    }
}
