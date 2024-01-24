package FileOperation;
import java.util.*;
public class DocuSign {
    public static void main(String args[]){

        String text = "The early bird gets the worm";
        String keyword1 = "bird";
        String keyword2 = "the";
        int range = 3;

        int actual = search2(text, keyword1, keyword2, range);

        System.out.println(actual);

    }

    static int search(String text, String keyword1, String keyword2, int range) {
        text = text.toLowerCase();
        keyword1 = keyword1.toLowerCase();
        keyword2 = keyword2.toLowerCase();

        if (range < 2) {
            return 0;
        }

        String[] data = text.split("\\s");
        Map<String, Integer> map = new HashMap<String, Integer>();

        int start = 0, result = 0;

        for (int i = start; i < data.length; i++) {
            String curr = data[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if (i >= range - 1) {
                if(i >= range && map.get(curr) > 1 &&  (curr.equalsIgnoreCase(keyword1) || curr.equalsIgnoreCase(keyword2))){
                    map.put(curr, map.get(curr) - 1);
                }

                if ( curr.equalsIgnoreCase(keyword1) || curr.equalsIgnoreCase(keyword2)) {
                    result = result + (map.getOrDefault(keyword1, 0) * map.getOrDefault(keyword2, 0));
                }
                map.put(data[start], map.get(data[start]) - 1);
                start++;
            }
        }

        return result;
    }



    static int search2(String text, String keyword1, String keyword2, int range) {
        text = text.toLowerCase();
        keyword1 = keyword1.toLowerCase();
        keyword2 = keyword2.toLowerCase();

        if (range < 2) {
            return 0;
        }

        String[] words = text.split("\\s");
        Map<String, Integer> freqMap = new HashMap<String, Integer>();

        int count = 0; int result= 0;
        int L = 0 ;
        for(int R = 0 ; R < words.length ; R++) {
            if (words[R].equals(keyword1) || words[R].equals(keyword2)) {
                freqMap.put(words[R], freqMap.getOrDefault(words[R], 0) + 1);
            }

            if (R - L + 1 > range) {
                if(freqMap.containsKey(words[L]) && (words[L].equals(keyword1) || words[L].equals(keyword2))){

                    freqMap.put(words[L], freqMap.get(words[L]) - 1);
                    if (freqMap.get(words[L]) == 0) freqMap.remove(words[L]);
                }
                L++;
            }

            if (words[R].equals(keyword1) || words[R].equals(keyword2)) {
                count += freqMap.getOrDefault(keyword1, 0) * freqMap.getOrDefault(keyword2, 0);
            }

        }



        return count;
    }
}
