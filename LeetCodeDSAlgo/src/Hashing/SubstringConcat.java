package Hashing;
import java.util.*;
//30. Substring with Concatenation of All Words
public class SubstringConcat {
    public static void main(String args[]){
        String str = "barfoothefoobarman";
        List<String> list = new ArrayList<String>();
        list.add("foo");
        list.add("bar");

        SubstringConcat obj = new SubstringConcat();
        List<Integer> result =obj.findSubString(str,list);

        System.out.println(result);

    }

    private List<Integer> findSubString(String str, List<String> item){

        int word_count = item.size();
        int size_word = item.get(0).length();
        int size_l = word_count*size_word;

        List<Integer> res = new ArrayList<Integer>();
        int n = str.length();

        if (size_l > n)
        {
            return res;
        }

        HashMap<String,Integer> hashmap = new HashMap<String,Integer>();

        for (String word : item)
        {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= n - size_l; i++){

            //Map<String, Integer> wordMap = new HashMap<>();

            //HashMap<String, Integer> wordMap = (HashMap<String, Integer>) hashmap.clone();
            HashMap<String, Integer> wordMap =
                    (HashMap<String, Integer>) hashmap.clone();

            System.out.println(wordMap);


            int j = i, count = word_count;
            while (j < i + size_l){

                String word = str.substring(j, j + size_word);

                if(!hashmap.containsKey(word)  || wordMap.get(word) == 0 ){
                    break;

                }else{
                    wordMap.put(word,wordMap.get(word) - 1);
                    count--;
                }

                j += size_word;
            }

            if (count == 0)
            {
                res.add(i);
            }
        }

        return res;
    }
}
