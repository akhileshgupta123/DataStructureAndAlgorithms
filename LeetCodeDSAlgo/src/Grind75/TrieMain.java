package Grind75;
//208. Implement Trie (Prefix Tree)
//Time complexity: O(n)
//        Space complexity: O(n)
public class TrieMain {
    public static void main(String args[]){
        Trie trie = new Trie();
        trie.insert("apple");
        boolean result =  trie.search("apple");

        System.out.println(result);

        result = trie.search("app");
        System.out.println(result);
        result = trie.startsWith("app");
        System.out.println(result);

        trie.insert("app");
        result = trie.search("app");
        System.out.println(result);


    }
}
