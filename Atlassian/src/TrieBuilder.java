import java.util.*;
public class TrieBuilder {
    public TrieNode createTrie(List<String> words){
        TrieNode trie = new TrieNode();
        for (String word: words) {
            placeNodes(word, trie);
        }
        return trie;
    }

    private void placeNodes(String word, TrieNode node){
        Map<Character,TrieNode> children = node.children;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode t = null;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode();
                children.put(c,t);
            }
            children = t.children;
            if(i == word.length()-1){
                t.end = true;
            }
        }
    }
}
