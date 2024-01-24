import java.util.Comparator;
import java.util.PriorityQueue;

class MergeNode{
    int data;
    MergeNode next;
    MergeNode(int data)
    {
        this.data = data;
        next = null;
    }
}

public class MergeKLists {

    public static void main(String args[]){
        int k =3;
        int n = 4;
        MergeNode nodeList[] = new MergeNode[k];
        nodeList[0] = new MergeNode(1);
        nodeList[0].next = new MergeNode(3);
        nodeList[0].next.next = new MergeNode(5);
        nodeList[0].next.next.next = new MergeNode(7);


        nodeList[1] = new MergeNode(2);
        nodeList[1].next = new MergeNode(4);
        nodeList[1].next.next = new MergeNode(6);
        nodeList[1].next.next.next = new MergeNode(8);


        nodeList[2] = new MergeNode(0);
        nodeList[2].next = new MergeNode(9);
        nodeList[2].next.next = new MergeNode(10);
        nodeList[2].next.next.next = new MergeNode(11);


        MergeNode head = mergeKSortedLists(nodeList, k);
        printList(head);
    }

    public static void printList(MergeNode head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static MergeNode mergeKSortedLists(MergeNode arr[], int k) {
        MergeNode head = null;
        MergeNode last = null;
        PriorityQueue<MergeNode> pq = new PriorityQueue<MergeNode>(
                new Comparator<MergeNode>(){
                    public int compare(MergeNode a, MergeNode b){
                        return a.data-b.data;
                    }
                }
        );


        for (int i = 0; i < k; i++){
            if (arr[i] != null)
                pq.add(arr[i]);
        }

        System.out.println(pq.size());



        while(!pq.isEmpty()){
            MergeNode top = pq.peek();
            pq.remove();
            //System.out.println(top.data);

            if (top.next != null)
                pq.add(top.next);

            if (head == null) {
                head = top;
                // points to the last node so far of
                // the final merged list
                last = top;
            }else{
                last.next = top;

                // update the 'last' pointer
                last = top;
            }
        }










        return head;
    }
}
