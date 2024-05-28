import java.util.*;
//895. Maximum Frequency Stack
public class FrequencyStack {
    int pushCount;
    PriorityQueue<Node> pq;
    Map<Integer, Integer> map;

    public FrequencyStack() {
        pushCount = 0;
        map = new HashMap<Integer, Integer>();
        pq= new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.freq!=o2.freq){
                    return o2.freq -o1.freq;
                }
                return o2.pushIndex - o1.pushIndex;
            }
        });
    }

    public int pop() {
        return pq.poll().value;
    }

    public void push(int x) {
        if (!map.containsKey(x)){
            map.put(x, 0);
        }
        map.put(x, map.get(x) + 1);
        Node n = new Node(x, map.get(x), pushCount++);
        pq.offer(n);
    }
    public static void main(String[] args){
        FrequencyStack obj = new FrequencyStack();
        /*
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
*/




        obj.push(4);
        obj.push(6);
        obj.push(7);
        obj.push(6);
        obj.push(8);

        int result = obj.pop();
        System.out.println("result :"+result);
        result = obj.pop();
        System.out.println("result :"+result);
        result = obj.pop();
        System.out.println("result :"+result);
        result = obj.pop();
        System.out.println("result :"+result);

        result = obj.pop();
        System.out.println("result :"+result);


    }
}

class Node{
    public int value;
    int freq;
    int pushIndex;

    public Node(int v, int f, int p){
        this.value = v;
        this.freq = f;
        this.pushIndex = p;
    }

}
