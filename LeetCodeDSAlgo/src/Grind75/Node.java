package Grind75;

public class Node {
    int key;
    int val;
    Node prev,next;
    Node(){

    }
    Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = next =null;
    }
}
