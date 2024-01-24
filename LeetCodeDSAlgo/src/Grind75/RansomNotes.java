package Grind75;
import java.util.*;

//time  O(m+n)
//Space complexity: O(m)
//383. Ransom Note
public class RansomNotes {
    public static void main(String args[]){
        String ransom="aa";
        String magazine="aab";

        RansomNotes obj = new RansomNotes();
        boolean result = obj.canConstruct(ransom,magazine);

        System.out.println("result is :"+result);
    }

    public boolean canConstruct(String ransome, String magazine){
        HashMap<Character, Integer> dictionary = new HashMap<Character,Integer>();
        for(int i=0; i<magazine.length(); i++){
            char ch = magazine.charAt(i);
            if(!dictionary.containsKey(ch)){
                dictionary.put(ch,1);
            }else{
                dictionary.put(ch,dictionary.get(ch)+1);
            }
        }

        for(int i=0; i<ransome.length(); i++){
            char ch = ransome.charAt(i);
            if(dictionary.containsKey(ch) && dictionary.get(ch)>0){
                dictionary.put(ch,dictionary.get(ch)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}
