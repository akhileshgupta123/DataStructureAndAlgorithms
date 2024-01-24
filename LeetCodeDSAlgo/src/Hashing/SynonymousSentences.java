package Hashing;
import java.util.*;
//1258 - Synonymous Sentences
/*
Time complexity
        The total time complexity of finding the synonym group is approximately O(n), and the time complexity of recursion is O(2^n *L), where L is the length of the string O(L) time is required for each word replacement).

        Therefore, the total time complexity is O(2^n *L).

        Space complexity
        Union search requires O(n) space, and recording answers requires O(2&n *L) space, so the total space complexity is O(2^n *L).
*/
public class SynonymousSentences {
    public static void main(String args[]){
        SynonymousSentences obj = new SynonymousSentences();
        List<List<String>> synonymsList = new ArrayList<List<String>>();

        List<String> l1 = new ArrayList<String>();
        l1.add("happy");
        l1.add("joy");

        List<String> l2 = new ArrayList<String>();
        l2.add("sad");
        l2.add("sorrow");


        List<String> l3 = new ArrayList<String>();
        l3.add("joy");
        l3.add("cheerful");
        synonymsList.add(l1);
        synonymsList.add(l2);
        synonymsList.add(l3);


        String text = "I am happy today but was sad yesterday";

        Map<String, Set<String>> map = new HashMap<String,Set<String>>();

        List<String> result = obj.generateSentences(synonymsList,text,map);

        for(String item:result){
            System.out.println(item);
        }
    }


    public List<String> generateSentences(List<List<String>> synonyms, String text, Map<String, Set<String>> map  ) {

        //build graph.
        for (List<String> s : synonyms) {
            String a = s.get(0);
            String b = s.get(1);
            System.out.println(a);
            System.out.println(b);
            if(map.containsKey(a)){
                Set<String> itema = map.get(a);
                itema.add(b);

            }else{
                Set<String> itema = new HashSet<String>();
                itema.add(b);
                map.put(a,itema);
            }

            if(map.containsKey(b)){
                Set<String> itemb = map.get(b);
                itemb.add(a);

            }else{
                Set<String> itemb = new HashSet<String>();
                itemb.add(a);
                map.put(b,itemb);
            }
            //map.getOrDefault(a, new HashSet<String>()).add(b);
            //map.getOrDefault(b, new HashSet<String>()).add(a);
        }

        System.out.println("size:"+map.size());
        List<String> res = new ArrayList<String>();
        //String[] split = text.split("\\W+");
        String[] split = text.split(" ");
        helper(split, 0, "", res, map);

        Collections.sort(res);
        return res;
    }

    public void helper(String[] wordsArray, int index, String cur,  List<String> res, Map<String, Set<String>> map) {

        if (index == wordsArray.length) {
            res.add(cur);
            return;
        }

        if (map.containsKey(wordsArray[index])) {
            List<String> choices = new ArrayList<String>();
            //find all synonyms related to s
            getSynonyms(wordsArray[index], new HashSet<String>(), choices, map);

            System.out.println(choices.size());
            for(String s: choices){
                System.out.println("internal"+s);
            }

            //try to change word at index to every possible synonyms word
            for (String s : choices) {
                //System.out.println("here"+s);
                helper(wordsArray, index + 1, cur + (index == wordsArray.length - 1 ? s : s + " "),res,map);
            }
        } else {
            //if the word at index has no synonyms, just go for next.
            helper(wordsArray, index + 1, cur + (index == wordsArray.length - 1 ? wordsArray[index] : wordsArray[index] + " "),res,map);
        }
    }


    public void getSynonyms(String s, Set<String> visited, List<String> choices, Map<String, Set<String>> map) {
        choices.add(s);
        visited.add(s);
        for (String each : map.get(s)) {
            if (!visited.contains(each)) {
                getSynonyms(each, visited, choices,map);
            }
        }
    }
}
