package LinkedList;
//708. Insert into a Sorted Circular Linked List
class CircularListNode{
    int data;
    CircularListNode next;

    CircularListNode(int d)
    {
        data = d;
        next = null;
    }
}
public class InsertSortedCircularList {
    CircularListNode head;
    public static void main(String args[]){
        InsertSortedCircularList obj = new InsertSortedCircularList();

        int arr[] = new int[] {12, 56, 2, 11, 1, 90};

        CircularListNode temp = null;

        for (int i = 0; i < arr.length;i++)
        {
            temp = new CircularListNode(arr[i]);
            obj.sortedInsert(temp);
        }
        obj.printList();
    }

    private void printList()
    {
        if (head != null)
        {
            CircularListNode temp = head;
            do
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }while (temp != head);
        }
    }

    private void sortedInsert(CircularListNode new_node){
        CircularListNode current = head;

        if (current == null)
        {
            new_node.next = new_node;
            head = new_node;
        }
        else if(current.data >= new_node.data){
            while(current.next!=head){
                current = current.next;
            }
            current.next = new_node;
            new_node.next = head;
            head = new_node;
        }
        else{
            while (current.next != head &&
                    current.next.data < new_node.data){
                current = current.next;
            }

            new_node.next = current.next;
            current.next = new_node;
        }
    }
}
