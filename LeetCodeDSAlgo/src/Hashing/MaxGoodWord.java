package Hashing;
import java.util.*;
public class MaxGoodWord {
    public static void main(String args[]){
        String sentences[] = new String[]{"I like dog", "I like cat","I like dog and cat","I like dog element"};
        String words[] = new String[]{"dog","cat"};
        MaxGoodWord  obj = new MaxGoodWord();
        List<String> result = obj.findGoodWord(sentences,words);

        System.out.println(result);
    }

    private List<String> findGoodWord(String sentences[], String words[]){
        List<String> result = new ArrayList<String>();
        if(sentences==null || words==null || sentences.length==0 || words.length==0)
            return result;
        int maxCount = Integer.MIN_VALUE;
        for(String sentence: sentences){
            String item[] = sentence.split(" ");
            Set<String> unique_item = new HashSet<String>();
            int count = 0;
            for(String str:item){
                unique_item.add(str);
            }

            for(String word: words){
                if(!unique_item.isEmpty() && unique_item.contains(word)){
                    count++;
                }
            }

            if(count>maxCount){
                result = new ArrayList<String>();
                result.add(sentence);
                maxCount = count;
            }else if(count==maxCount){
                result.add(sentence);
            }

        }

        return result;
    }
}
