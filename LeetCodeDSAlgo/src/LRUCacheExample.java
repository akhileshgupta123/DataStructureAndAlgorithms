import java.util.*;
class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public String toString(){
        return String.valueOf(value);
    }
}


class LRUCache{
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<Integer,Node>(capacity);
    }

    public int get(int key){
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            moveToFront(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value){
        if(this.cache.containsKey(key)){
            Node node = cache.get(key);

            node.value = value;
            moveToFront(node);
            return;
        }

        Node node = new Node(key, value);
        if(cache.size()==this.capacity){
            cache.remove(tail.key);
            removeNode(tail);
        }

        cache.put(key, node);
        addFirst(node);
    }

    private void addFirst(Node node) {

        node.next = head;
        node.prev = null;

        if(head!=null){
            head.prev= node;
        }
        head = node;
        if(tail==null){
            tail =node;
        }
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if(prevNode!=null){
            prevNode.next = nextNode;
        }else{
            head = nextNode;
        }

        if(nextNode!=null){
            nextNode.prev = prevNode;
        }else{
            tail = prevNode;
        }
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }
}
public class LRUCacheExample {

    public static void main(String args[]){
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);

        // it will store a key (1) with value 10 in the cache.
        cache.put(2, 20);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10

        cache.put(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)



        cache.put(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40

    }
}
