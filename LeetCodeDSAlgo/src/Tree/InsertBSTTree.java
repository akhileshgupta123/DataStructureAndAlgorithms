package Tree;
//701. Insert into a Binary Search Tree
// Time Complexity : O(N)
// Space Complexity : O(1)

class InsertBST{
    int data;
    InsertBST left,right;
    public InsertBST(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
public class InsertBSTTree {
    InsertBST root;
    public static void main(String args[]){
        InsertBSTTree obj = new InsertBSTTree();
        obj.root = new InsertBST(4);
        obj.root.left = new InsertBST(2);
        obj.root.right = new InsertBST(7);
        obj.root.left.left = new InsertBST(1);
        obj.root.left.right = new InsertBST(3);

        InsertBST result = obj.insertIntoBSTTree(obj.root,5);
        System.out.println("data is"+result.data);
        obj.display(result);


    }

    private void display(InsertBST root){
        if(root.left!=null)
            display(root.left);
        System.out.println(root.data);

        if(root.right!=null)
            display(root.right);

    }

    private InsertBST insertIntoBSTTree(InsertBST root, int val){
        InsertBST temp = root;

        while(true){
            if(temp == null){
                root = new InsertBST(val);
                return root;
            }
            if(val<temp.data){

                if(temp.left == null){
                    temp.left = new InsertBST(val);
                    return root;
                }
                temp = temp.left;
            }

            if(val>temp.data){
                if(temp.right == null){
                    temp.right = new InsertBST(val);
                    return root;
                }
                temp = temp.right;
            }
        }

    }


    public InsertBST insertIntoBST(InsertBST root, int val) {
        if(root==null){
            root = new InsertBST(val);
            return root;
        }

        if(val<root.data){
            root.left = insertIntoBST(root.left , val);
        }
        else if(val>root.data){
            root.right = insertIntoBST(root.right , val);
        }

        return root;

        // Time Complexity : O(N)
        // Space Complexity : O(1)

    }
}
