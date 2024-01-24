package Grind75;
import java.util.*;
//23. Merge k Sorted Lists
public class MergeKSortedList {
    public static void main(String args[]){
        MergeListNode l1 = new MergeListNode(1);
        l1.next = new MergeListNode(4);
        l1.next.next = new MergeListNode(5);

        MergeListNode l2= new MergeListNode(1);
        l2.next = new MergeListNode(3);
        l2.next.next = new MergeListNode(4);

        MergeListNode l3= new MergeListNode(2);
        l3.next = new MergeListNode(6);


        MergeListNode[] lists = {l1,l2,l3};

        MergeKSortedList obj = new MergeKSortedList();
        MergeListNode node =  obj.mergeKLists(lists);

        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

    public MergeListNode mergeKLists(MergeListNode[] lists) {
        PriorityQueue<MergeListNode> heap = new PriorityQueue<MergeListNode>(new Comparator<MergeListNode>(){
            public int compare(MergeListNode n1, MergeListNode n2){
                return n1.val-n2.val;
            }
        });

        for(MergeListNode list: lists){
            if(list != null)
                heap.offer(list);

        }

        MergeListNode head = null;
        MergeListNode tail = null;

        while(heap.size() > 0){
            MergeListNode node = heap.poll();

            if(head == null){
                head = tail = node;
            }else{
                tail.next = node;
                tail = tail.next;
            }

            if(node.next != null){
                heap.offer(node.next);
            }
        }



        return head;
    }
}

class MergeListNode{
    int val;
    MergeListNode next;
    MergeListNode(int val){
        this.val = val;
        this.next = null;
    }
}
