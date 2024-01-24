package Tree;
//513. Find Bottom Left Tree Value
class BottomTree{
    int data;
    BottomTree left,right;
    BottomTree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
public class BottomLeftTreeValue {
    int maxlevel=0;
    int val=0;
    public static void main(String args[]){
        BottomLeftTreeValue obj = new BottomLeftTreeValue();
        BottomTree root = new BottomTree(1);
        root.left = new BottomTree(2);
        root.right = new BottomTree(3);
        root.left.left = new BottomTree(4);
        root.right.left = new BottomTree(5);
        root.right.right = new BottomTree(6);
        root.right.left.left = new BottomTree(7);

        obj.findval(root,1);

        System.out.println("val is:"+obj.val);

    }


    public void findval(BottomTree root, int level){
        if(root==null)
            return;

        findval(root.left,level+1);
        if(level>maxlevel)
        {
            System.out.println("data is"+root.data);
            System.out.println("level is"+level);
            maxlevel=level;
            val=root.data;
        }

        findval(root.right,level+1);
    }
}
