package LinkedList;

public class DuplicateRemoveList {
    public static void main(String args[]){
        DuplicateRemoveList obj = new DuplicateRemoveList();
        DuplicateNodeList l1,l2;
        l1 = new DuplicateNodeList(1);
        l1.next = new DuplicateNodeList(1);
        l1.next.next = new DuplicateNodeList(4);
        l1.next.next.next = new DuplicateNodeList(5);
        l1.next.next.next.next = new DuplicateNodeList(7);


        l2 = new DuplicateNodeList(2);
        l2.next = new DuplicateNodeList(4);
        l2.next.next = new DuplicateNodeList(7);
        l2.next.next.next = new DuplicateNodeList(7);
        l2.next.next.next.next = new DuplicateNodeList(9);

        DuplicateNodeList result = obj.sortedMergeWithoutDuplicates(l1,l2);



        while(result!=null){
            System.out.println(result.data);
            result = result.next;
        }

    }

    DuplicateNodeList sortedMergeWithoutDuplicates(DuplicateNodeList head1, DuplicateNodeList head2){
        DuplicateNodeList dummy = new DuplicateNodeList(-1);
        DuplicateNodeList tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                head1 = head1.next;
            }else if(head1.data > head2.data){
                tail.next = head2;
                head2 = head2.next;
            }else{
                tail.next = head1;
                head1 = head1.next;
                head2 = head2.next;
            }

            tail = tail.next;
            tail.next = null;
        }

        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }


        DuplicateNodeList current = dummy.next;
        while (current != null && current.next != null) {
            if(current.data == current.next.data){
                DuplicateNodeList temp = current.next;
                current.next = current.next.next;
                temp = null;

            }else{
                current = current.next;
            }
        }
        return dummy.next;
    }
}

class DuplicateNodeList{
    int data;
    DuplicateNodeList next;
    DuplicateNodeList(int data){
        this.data = data;
        this.next = null;
    }

}
