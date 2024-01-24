package StackQueue;
import java.util.*;
//Find the Order of Characters From an Alien Dictionary Problem
public class OrderOfCharacterDictionary {
    public static void main(String args[]){
        OrderOfCharacterDictionary obj = new OrderOfCharacterDictionary();
        String words[] = new String[] {"baa", "abcd", "abca", "cab", "cad"};//{"caa", "aaa", "aab" };
        int len = words.length;
        int alpha = 4;
        obj.printAlphaOrder(words, len , alpha);
    }

    private void printAlphaOrder(String[] words, int n, int alpha){

        GraphList graph = new GraphList(alpha);

        for(int i=0; i<n-1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];

            for(int j=0; j<Math.min(word1.length(), word2.length()); j++){
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a',
                            word2.charAt(j) - 'a');
                    break;
                }

            }
        }

        graph.topologicalSort();

    }
}

class GraphList{
    private LinkedList<Integer> adjacencyList[];

    GraphList(int nVertices){
        adjacencyList = new LinkedList[nVertices];

        for(int vertexIndex = 0;vertexIndex < nVertices;vertexIndex++){
            adjacencyList[vertexIndex] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int startVertex, int endVertex){
        adjacencyList[startVertex].add(endVertex);
    }

    private int getNoOfVerices(){
        return adjacencyList.length;
    }

    void topologicalSort(){
        Stack<Integer> stack = new Stack<Integer>();

        boolean visited[] = new boolean[getNoOfVerices()];

        for (int i = 0; i < getNoOfVerices(); i++) {
            visited[i] = false;
        }


        for(int i=0; i<getNoOfVerices(); i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print((char)('a' + stack.pop())
                    + " ");
        }
    }

    private void topologicalSortUtil(int currentVertex, boolean visited[], Stack<Integer> stack){

        visited[currentVertex] = true;

        for (int adjacentVertex :
                adjacencyList[currentVertex]) {
            if (!visited[adjacentVertex]) {
                topologicalSortUtil(adjacentVertex, visited,
                        stack);
            }
        }

        stack.push(currentVertex);


    }
}
