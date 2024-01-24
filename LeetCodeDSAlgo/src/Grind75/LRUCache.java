package Grind75;
import java.util.*;
//146. LRU Cache
public class LRUCache {
    private int mSize;
    private int mCapacity;
    private Node start;
    private Node end;
    Map<Integer,Node> map = new HashMap<Integer,Node>();

    public LRUCache(int mCapacity){
        mSize = 0;
        mCapacity = mCapacity;
        start = new Node();
        end = new Node();
        start.next = end;
        end.prev = start;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }else{
            return -1;
        }
    }

    private void clearCache(){
        while(mSize >= mCapacity){
            Node tail = end.prev;
            if(tail == start) break;

            tail.prev.next = end;
            end.prev = tail.prev;


            map.remove(tail.key);
            mSize--;

        }
    }

    public void set(int key, int value){
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            Node node = map.get(key);
            node.val = value;
        }else{
            Node node = new Node(key , value);
            if(mSize >= mCapacity){
                clearCache();
            }

            insertToHead(node);
            mSize++;
            map.put(key, node);
        }

    }


    private void moveToHead(Node node){
        if(node.prev == start) return;

        node.prev.next = node.next;
        node.next.prev = node.prev;
        insertToHead(node);

    }

    private void insertToHead(Node node){
        Node next = start.next;
        node.next = next;
        next.prev = node;

        start.next = node;
        node.prev = start;
    }

}
