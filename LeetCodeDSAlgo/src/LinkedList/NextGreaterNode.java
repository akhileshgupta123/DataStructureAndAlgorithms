package LinkedList;
import java.util.*;
//1019. Next Greater Node In Linked List
public class NextGreaterNode {
    GreaterNodeList root;
    public static void main(String args[]){
        NextGreaterNode obj = new NextGreaterNode();
        obj.root  = new GreaterNodeList(2);
        obj.root.next = new GreaterNodeList(7);
        obj.root.next.next = new GreaterNodeList(4);
        obj.root.next.next.next = new GreaterNodeList(3);
        obj.root.next.next.next.next  = new GreaterNodeList(5);
        int result[] = obj.nextLargeNode(obj.root);



        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    private int[] nextLargeNode(GreaterNodeList root){
        List<Integer> temp = new ArrayList<Integer>();
        GreaterNodeList current = root;
        while(current!=null){
            temp.add(current.val);
            current = current.next;
        }
        int res[] = new int[temp.size()];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<temp.size(); i++){

            while(!st.isEmpty() && temp.get(st.peek())<temp.get(i)){

                res[st.pop()] = temp.get(i);
            }

            st.push(i);
        }
        return res;
    }
}

class GreaterNodeList{
    int val;
    GreaterNodeList next;

    public GreaterNodeList(int x){
        this.val = x;
    }
}
