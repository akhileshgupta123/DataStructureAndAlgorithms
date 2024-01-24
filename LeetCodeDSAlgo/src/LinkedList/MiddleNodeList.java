package LinkedList;

class MiddleNode{
    int data;
    MiddleNode next;
    MiddleNode(int data){
        this.data = data;
        this.next = null;
    }

}
public class MiddleNodeList {

    MiddleNode start;
    MiddleNodeList(){
        this.start = null;
    }


    private int getCount(MiddleNode start){
        MiddleNode temp = start;
        int cnt =0;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    private void addData(int data){
        MiddleNode temp1 = new MiddleNode(data);
        if(this.start==null){
            start = temp1;
        }else{
            MiddleNode travers = start;
            while(travers.next!=null){
                travers = travers.next;
            }
            travers.next = temp1;
        }
    }

    private int printKFromGivenNode(MiddleNode start, int k){
        int n = getCount(start);
        System.out.println("node count is:"+n);
        int reqNode = ((n+1)/2)-k;

        System.out.println("reqnode count is:"+reqNode);

        if(reqNode<=0){
            return -1;
        }else{
            MiddleNode current = start;
            int count = 1;
            int ans = 0;
            while(current!=null){

                if(count == reqNode){

                    ans = current.data;
                    break;
                }
                count++;
                current = current.next;

            }
            return ans;
        }

    }

    public static void main(String args[]){

        MiddleNodeList obj = new MiddleNodeList();
        obj.addData(1);
        obj.addData(2);
        obj.addData(3);
        obj.addData(4);
        obj.addData(5);
        obj.addData(6);
        obj.addData(7);
        obj.addData(8);


        int data = obj.printKFromGivenNode(obj.start, 3);

        System.out.println(data);



    }
}
