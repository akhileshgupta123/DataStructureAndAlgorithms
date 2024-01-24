package LinkedList;


class RotateNode {
    int data;
    RotateNode  next;

}
public class RotateList {
    RotateNode head = null;
    RotateNode last = null;

    public static void main(String args[]){
        RotateList obj = new RotateList();
        for (int i = 10; i < 70; i += 10)
            obj.push( i);
        obj.printList(obj.head);


        obj.rotate( 4);
        obj.printList(obj.head);

    }

    private void rotate(int k){
        if(k==0)
            return;


        RotateNode current = head;

        while(current.next!=null){
            current = current.next;
        }

        current.next = head;
        current = head;

        System.out.println("The current is :"+current.data);

        for(int i=0; i<k-1; i++){
            current = current.next;
        }

        System.out.println("The final current is :"+current.data);
        head = current.next;
         current.next = null;
    }

    private void push(int new_data){
        RotateNode new_node = new RotateNode();
        new_node.data = new_data;
        //new_node.next = this.head;
        new_node.next = null;
        if(this.head==null)
            this.head = new_node;

        if(this.last == null)
            this.last = new_node;
        else
        {
            this.last.next = new_node;
            this.last = new_node;

        }

    }

    private void printList(RotateNode node){
        while(node!=null){
            System.out.println(node.data+ " ");
            node = node.next;
        }
    }
}
