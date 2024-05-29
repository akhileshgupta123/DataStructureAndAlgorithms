import java.util.*;

//Design and write the code for a router service . input: /bar/qw/ert should route to lets say result input /bar/*/ert should
// also route to result. You must provide a solution which supports wildcard.

public class TrieDictionaryWildCard {

    public static void main(String args[]){

        List<String> dict = Arrays.asList("all", "also", "always", "book", "bold", "bounce", "bouldering", "car", "cat", "cattle", "cafe",
                "caf","bad","dad","mad","cats","dog","sand","and");
        TrieBuilder builder = new TrieBuilder();
        TrieNode trie = builder.createTrie(dict);
        System.out.println(trie.children.size());

        TrieFinder finder = new TrieFinder();
        boolean result  = finder.find("pad", trie);

        System.out.println("result :"+result);



        result  = finder.find("bad", trie);
        System.out.println("result :"+result);
        result  = finder.find(".ad", trie);

        System.out.println("result :"+result);

        result  = finder.find("b..", trie);
        System.out.println("result :"+result);


        result  = finder.find("catsandog", trie);
        System.out.println("result :"+result);



        System.out.println("#########################new updated result #########################");


        result  = finder.find("a", trie);
        System.out.println("result :"+result);
        result  = finder.find("al", trie);
        System.out.println("result :"+result);
        result  = finder.find("b", trie);
        System.out.println("result :"+result);
        result  = finder.find("bo", trie);
        System.out.println("result :"+result);
        result  = finder.find("b*", trie);
        System.out.println("result :"+result);


        result  = finder.find("bou*", trie);
        System.out.println("result :"+result);
        result  = finder.find("b**l", trie);
        System.out.println("result :"+result);
        result  = finder.find("b***", trie);
        System.out.println("result :"+result);
    }
}
