package Hashing;
import java.util.*;
//953. Verifying an Alien Dictionary
public class AlienDictionaryCheck {
    HashMap<Character, Integer> map;
    public static void main(String args[]){
        AlienDictionaryCheck obj = new AlienDictionaryCheck();

        String words[] = new String[] {"word","world","row"};//{"hello","leetcode"};
        String order = "worldabcefghijkmnpqstuvxyz";//"hlabcdefgijkmnopqrstuvwxyz";
        boolean result = obj.isAlienSorted(words,order);

        System.out.println("result :"+result);
    }


    private boolean isNotAlien(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int min = Math.min(m, n);
        for(int i =0; i < min; i++){
            char first = word1.charAt(i);
            char second = word2.charAt(i);
            if(first != second){
                return map.get(first) > map.get(second);
            }
        }
        return m > n;
    }

    private boolean isAlienSorted(String[] words, String order){
        map = new HashMap<Character, Integer>();
        for(int i =0; i< order.length(); i++){
            map.put(order.charAt(i), i);
        }



        System.out.println(Arrays.asList(map));
        System.out.println(map.get('h'));

        for(int i =0; i< words.length -1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(isNotAlien(word1, word2)){
                return false;
            }
        }

        return true;
    }
}
