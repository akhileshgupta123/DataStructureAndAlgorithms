package LinkedList;


class SwapPairNode{
    int data;
    SwapPairNode next;

    SwapPairNode(int data, SwapPairNode next){
        this.data = data;
        this.next = next;
    }
}
public class SwapPairList {

    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        SwapPairNode head = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            head = new SwapPairNode(arr[i], head);
        }

        printList(head);
        SwapPairList obj = new SwapPairList();
         head =  obj.rearrange(head);
        System.out.println("");
        printList(head);

    }


    public static void printList(SwapPairNode node){

        SwapPairNode ptr = node;

        while(ptr!=null){
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }
    }

    public  SwapPairNode rearrange(SwapPairNode head)
    {
        // if the list is empty or contains just one node
        if (head == null || head.next == null) {
            return head;
        }


        //a fake head

        SwapPairNode h = new SwapPairNode(0, head);

        h.next = head;

        //SwapPairNode curr = head, prev = null;


        SwapPairNode curr = head;
        SwapPairNode curr1 = head.next;
        SwapPairNode prev = h;


        System.out.println("first:"+curr.data);
        System.out.println("second:"+curr1.data);
        // consider two nodes at a time and swap their links
        while (curr != null && curr1 != null)
        {

            prev.next = curr1;

            SwapPairNode temp = curr1.next;
            curr1.next = curr;

            /*if(prev.data==0){
                System.out.println("here");
                h.next = curr1;
            }*/
            prev = curr;
            curr.next = temp;





            System.out.println("inner first:"+curr.data);
            System.out.println("inner second:"+curr1.data);

            curr = curr.next;
            if(temp!=null)
                curr1 = temp.next;


            //System.out.println("final inner first:"+curr.data);
            //System.out.println("final inner second:"+curr1.data);

        }

        return h.next;
    }
}
