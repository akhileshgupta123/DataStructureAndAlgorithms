package Hashing;
import java.util.*;
//139. Word Break
public class WordDictionary {
    private TrieNode root;
    public WordDictionary(){
        root = new TrieNode();
    }
    public static void main(String args[]){
        WordDictionary obj = new WordDictionary();

        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");


        obj.addWord("cats");
        obj.addWord("dog");
        obj.addWord("sand");
        obj.addWord("and");
        obj.addWord("cat");


        boolean result = obj.search("pad");
        System.out.println("result :"+result);
        result = obj.search("bad");
        System.out.println("result :"+result);
        result = obj.search(".ad");
        System.out.println("result :"+result);
        result = obj.search("b..");
        System.out.println("result :"+result);

        result = obj.search("catsandog");
        System.out.println("result :"+result);
    }


    public void addWord(String word) {
        Map<Character,TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode t = null;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }
            children = t.children;
            if(i == word.length()-1){
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String word){
        return dfsSearch(root.children,word,0);
    }

    public boolean dfsSearch(Map<Character, TrieNode> children, String word, int start){
        if(start==word.length()){
            if(children.size()==0)
                return true;
            else
                return false;
        }

        char c = word.charAt(start);

        if(children.containsKey(c)){
            if(start == word.length()-1 && children.get(c).isLeaf)
                return true;

            return dfsSearch(children.get(c).children,word,start+1);
        }else if(c == '.'){
            boolean result = false;
            for(Map.Entry<Character,TrieNode> child:children.entrySet()){
                if(start == word.length()-1 && child.getValue().isLeaf){
                    return true;
                }

                if(dfsSearch(child.getValue().children, word, start+1)){
                    result = true;
                }

            }
            return result;
        }
        else{
            return false;
        }

    }
}

class TrieNode{
    char c;
    boolean isLeaf;
    Map<Character,TrieNode> children = new HashMap<Character, TrieNode>();
    public TrieNode(){

    }
    public TrieNode(char c){
        this.c = c;
    }
}
