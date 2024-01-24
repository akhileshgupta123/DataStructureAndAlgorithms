package Hashing;
import java.util.*;
public class ShortUniquePrefix {
    TrieNodePrefix root;
    public static void main(String args[]){
        //String words[] = new String[]{ "AND", "BONFIRE", "BOOL", "CASE", "CATCH", "CHAR" };

        String words[] = new String[]{ "zebra", "dog", "duck", "dove" };

        ShortUniquePrefix obj = new ShortUniquePrefix();
        obj.root = new TrieNodePrefix();
        for (String s: words) {
            obj.insert(obj.root, s);
        }

        obj.printShortestPrefix(obj.root, "");
    }

    private void insert(TrieNodePrefix root, String word){
        TrieNodePrefix curr = root;
        for (char c: word.toCharArray()){
            if(curr.child.containsKey(c)){

            }else{
                curr.child.put(c, new TrieNodePrefix());
            }

            curr.child.get(c).freq++;
            curr = curr.child.get(c);
        }

       // System.out.println(root.child.get(0).child.size());

    }


    private void printShortestPrefix(TrieNodePrefix root, String word_so_far)
    {
        if (root == null) {
            return;
        }

        // print `word_so_far` if the current Trie node is visited only once
        if (root.freq == 1)
        {
            System.out.println(word_so_far);
            return;
        }

        // recur for all child nodes
        for (Map.Entry<Character, TrieNodePrefix> child: root.child.entrySet()) {
            printShortestPrefix(child.getValue(), word_so_far + child.getKey());
        }
    }
}


class TrieNodePrefix{
    Map<Character, TrieNodePrefix> child = new HashMap<Character, TrieNodePrefix>();
    int freq = 0;
}