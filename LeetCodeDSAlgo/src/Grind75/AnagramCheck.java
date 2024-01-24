package Grind75;
//242. Valid Anagram
//Time Complexity: O(n)

//        Auxiliary space: O(n)

import java.util.*;
public class AnagramCheck {
    public static void main(String args[]){
        String source = "anagram";
        String target = "nagaram";

        AnagramCheck obj = new AnagramCheck();
        boolean result = obj.isAnagram(source,target);

        System.out.println("result is:"+result);

    }

    public boolean isAnagram(String source, String target){
        if(source.length()!= target.length())
            return false;


        HashMap<Character, Integer> map = new HashMap<Character,Integer>();


        for (int i = 0; i < source.length(); i++) {

            if(map.containsKey(source.charAt(i))){
                map.put(source.charAt(i),map.get(source.charAt(i))+1);
            }else{
                map.put(source.charAt(i),1);
            }

        }

        for (int i = 0; i < target.length(); i++) {

            if(map.containsKey(target.charAt(i))){
                map.put(target.charAt(i),map.get(target.charAt(i))-1);
            }else{
                map.put(target.charAt(i),1);
            }

        }

        for(Map.Entry<Character,Integer> obj : map.entrySet()){
            if(obj.getValue()!=0){
                return false;
            }
        }


        return true;
    }
}
