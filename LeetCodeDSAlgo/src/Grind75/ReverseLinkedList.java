package Grind75;
//206. Reverse Linked List
public class ReverseLinkedList {
    public static void main(String args[]){
        ReverseLinkedList obj = new ReverseLinkedList();
        MergeList root = new MergeList(1);
        root.next = new MergeList(2);
        root.next.next = new MergeList(3);
        root.next.next.next = new MergeList(4);
        root.next.next.next.next = new MergeList(5);

        //ReverseLinkedList obj = new ReverseLinkedList();
        MergeList result = obj.reverseList(root);

        System.out.println(result.val);
    }


    private MergeList reverseList(MergeList head){
        MergeList prev = null;
        MergeList current = head;

        while(current!=null){
            MergeList next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }
}
