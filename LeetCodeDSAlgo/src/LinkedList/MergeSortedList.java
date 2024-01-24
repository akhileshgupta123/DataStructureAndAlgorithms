package LinkedList;

public class MergeSortedList {
    MergeListNode node1;
    MergeListNode node2;
    public static void main(String args[]){
        MergeSortedList obj = new MergeSortedList();
        obj.node1 = new MergeListNode(5);
        obj.addToLast(obj.node1, new MergeListNode(10));
        obj.addToLast(obj.node1, new MergeListNode(15));
        obj.addToLast(obj.node1, new MergeListNode(30));

        obj.node2 = new MergeListNode(2);

        obj.addToLast(obj.node2, new MergeListNode(3));
        obj.addToLast(obj.node2, new MergeListNode(20));
        obj.addToLast(obj.node2, new MergeListNode(25));
        MergeListNode result = obj.mergeList(obj.node1, obj.node2);
        obj.printList(result);
    }

    private MergeListNode mergeList(MergeListNode node1, MergeListNode node2){
        MergeListNode newHead = new MergeListNode(0);
        MergeListNode curr = newHead;
        while(node1 != null && node2 != null){

            if(node1.data < node2.data){
                curr.next = node1;
                node1= node1.next;
            }else{
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }

        if (node1 != null) {
            curr.next = node1;
        }

        if (node2 != null) {
            curr.next = node2;
        }

        return newHead.next;
    }

    private void addToLast(MergeListNode head, MergeListNode item){
        MergeListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = item;
    }

    private void printList(MergeListNode head)
    {
        MergeListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class MergeListNode{
    int data;
    MergeListNode next;
    public MergeListNode(int data){
        this.data = data;
        this.next = null;
    }
}
