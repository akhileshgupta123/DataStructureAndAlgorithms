import java.util.*;
public class TrieNode {
    public boolean end = false;
    public final Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
}
