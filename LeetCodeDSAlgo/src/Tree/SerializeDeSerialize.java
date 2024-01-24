package Tree;
import java.util.*;
//297. Serialize and Deserialize Binary Tree
public class SerializeDeSerialize {
    SerializeDeserializeTree root;
    public static void main(String args[]){
        SerializeDeSerialize obj = new SerializeDeSerialize();
        obj.root = obj.createNode(20);
        obj.root.left = obj.createNode(8);
        obj.root.right = obj.createNode(22);
        obj.root.left.left = obj.createNode(4);
        obj.root.left.right = obj.createNode(12);
        obj.root.left.right.left = obj.createNode(10);
        obj.root.left.right.right = obj.createNode(14);

        String serialized = obj.serialize(obj.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        SerializeDeserializeTree t = obj.deserialize(serialized);
        obj.inorder(t);

    }

    SerializeDeserializeTree createNode(int data){
        SerializeDeserializeTree obj = new SerializeDeserializeTree(data);
        return obj;
    }

    private String serialize(SerializeDeserializeTree root){
        if(root==null)
            return "";
        Queue<SerializeDeserializeTree> queue = new LinkedList<SerializeDeserializeTree>();
        queue.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            SerializeDeserializeTree item = queue.poll();
            if(item==null)
                sb.append("#,");
            else{
                sb.append(item.data+",");
                queue.offer(item.left);
                queue.offer(item.right);
            }
        }
        return sb.toString();
    }

    private SerializeDeserializeTree deserialize(String s){
        if(s.length()==0)
            return null;

        String str[] = s.split(",");

        SerializeDeserializeTree root1 = createNode(Integer.parseInt(str[0]));

        Queue<SerializeDeserializeTree> queue1 = new LinkedList<SerializeDeserializeTree>();
        queue1.offer(root1);
        int a = 1;

        while(!queue1.isEmpty() && a<str.length){
            SerializeDeserializeTree item = queue1.poll();
            String n = str[a++];
            if("#".equals(n)){
                item.left = null;
            }else{
                item.left= createNode(Integer.parseInt(n));
                queue1.offer(item.left);
            }

            n=str[a++];

            if("#".equals(n)){
                item.right = null;
            }else{
                item.right= createNode(Integer.parseInt(n));
                queue1.offer(item.right);
            }

        }
        return root1;
    }


    private void inorder(SerializeDeserializeTree root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

class SerializeDeserializeTree{
    int data;
    SerializeDeserializeTree left,right;
    public SerializeDeserializeTree(int data){
        this.data = data;
        this.left=this.right=null;
    }
}
