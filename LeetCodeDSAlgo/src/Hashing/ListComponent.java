package Hashing;
import java.util.*;
//817. Linked List Components
//O(n) Time and Space Solution
class ListComponentNode{
    int data;
    ListComponentNode next;
    public ListComponentNode(int data){
        this.data = data;
        this.next = null;
    }

}
public class ListComponent {
    ListComponentNode head;
    public static void main(String args[]){
        ListComponent obj = new ListComponent();
        obj.head = new ListComponentNode(0);
        obj.head.next = new ListComponentNode(1);
        obj.head.next.next = new ListComponentNode(2);
        obj.head.next.next.next = new ListComponentNode(3);
        obj.head.next.next.next.next = new ListComponentNode(4);
        int nums[] = new int[]{0,3,1,4};
        obj.getNumComponents(obj.head,nums);
    }

    private int getNumComponents(ListComponentNode head, int[] nums){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : nums) set.add(n);
        int components = 0;// connected = 0;
        ListComponentNode temp = head;

        while(temp != null){
            boolean isPresentNode = false;
            while(temp != null && set.contains(temp.data)) {
                isPresentNode = true;
                temp = temp.next;
            }

            if(isPresentNode) {
                components++;
            }

            if(temp!=null) {
                temp = temp.next;
            }


        }

        System.out.println(components);
        return components;

    }
}
