import java.util.Map;

public class TrieFinder {

    //private final char wildcard;

    /*TrieFinder(char wildcard) {
        this.wildcard = wildcard;
    }*/


    public boolean find(String word, TrieNode trie){
        return dfsSearch(trie.children,word,0);
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
            if(start == word.length()-1 && children.get(c).end)
                return true;
            return dfsSearch(children.get(c).children,word,start+1);
        }else if(c == '.' || c =='*'){
            boolean result = false;
            for(Map.Entry<Character,TrieNode> child:children.entrySet()){
                if(start == word.length()-1 && child.getValue().end){
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
