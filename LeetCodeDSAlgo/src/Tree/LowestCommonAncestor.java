package Tree;
//236. Lowest Common Ancestor of a Binary Tree
public class LowestCommonAncestor {

    AncestorTree root;
    public static void main(String args[]){
        LowestCommonAncestor obj = new LowestCommonAncestor();
        /*obj.root = obj.createNode(1);
        obj.root.left = obj.createNode(2);
        obj.root.right = obj.createNode(3);
        obj.root.left.left = obj.createNode(4);
        obj.root.left.right =obj.createNode(5);

        obj.root.right.left = obj.createNode(6);
        obj.root.right.right = obj.createNode(7);

        AncestorTree result = obj.findCommonAncester(obj.root, obj.root.left.left,obj.root.left.right );*/




        obj.root = obj.createNode(3);
        obj.root.left = obj.createNode(5);
        obj.root.right = obj.createNode(1);
        obj.root.left.left = obj.createNode(6);
        obj.root.left.right =obj.createNode(2);

        obj.root.right.left = obj.createNode(0);
        obj.root.right.right = obj.createNode(8);


        obj.root.left.right.left =obj.createNode(7);
        obj.root.left.right.right =obj.createNode(4);

        AncestorTree result = obj.findCommonAncester(obj.root, obj.root.left,obj.root.left.right.right );


        System.out.println("result:"+result.data);


    }


    private AncestorTree createNode(int data){
        AncestorTree obj = new AncestorTree(data);
        return obj;
    }

    private AncestorTree findCommonAncester(AncestorTree root, AncestorTree p, AncestorTree q){
        if(p==root){
            System.out.println("left match");
        }

        if(q==root){
            System.out.println("right match");
        }
        if(root==null || p==root || q==root)
            return root;

        AncestorTree left=findCommonAncester(root.left, p, q);


        if(left!=null)
            System.out.println("left:"+left.data);
        else
            System.out.println("left null:"+left);

        AncestorTree right=findCommonAncester(root.right, p, q);

        if(right!=null)
            System.out.println("right:"+right.data);
        else
            System.out.println("right null:"+right);

        System.out.println(" root:"+root.data);

        if(left!=null && right!=null)
            return root;

        if(left!=null)
            return left;
        if(right!=null)
            return right;

        return null;

    }
}

class AncestorTree{
    int data;
    AncestorTree left, right;

    public AncestorTree(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
