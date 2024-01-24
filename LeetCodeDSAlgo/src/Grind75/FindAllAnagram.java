package Grind75;
import java.util.*;
//Time complexity:O(N*M)
//        Space complexity:O(N+N)
//438. Find All Anagrams in a String
public class FindAllAnagram {
    public static void main(String args[]){

        FindAllAnagram obj = new FindAllAnagram();
        /*String word = "cbaebabacd";
        String pattern = "abc";*/

        String word = "abab";
        String pattern = "ab";


        List<Integer> result = obj.findAnagram(word,pattern);
        System.out.println(result);

    }

    public List<Integer> findAnagram(String word, String pat){
        //find the pattern length
        int length=pat.length();
        // stores the occurences of characters in pattern string
        int[] patMap=new int[26];
        // stores the occurences of characters in word string
        int[] wordMap=new int[26];
        int startWindow=0;
        List<Integer> result=new ArrayList<Integer>();

        //Find the occurences os pattern string
        for(int i=0;i<length;i++){
            patMap[ pat.charAt(i)-'a']++;
        }

        // Find the occurences and Find the anagram start point using start window variable.
        for(int i=0;i<word.length();i++){
            //map the occurences of characters in word
            wordMap[word.charAt(i)-'a']++;


            // word occurence substring crosses the pattern reduce      the wordMap move the startWindow
            if(i-startWindow+1>pat.length()){
                wordMap[word.charAt(startWindow++)-'a']--;
            }
            //If subString of word is exactly equal to pattern check the anagrams with occurences map of pattern and wordMap
            if(i-startWindow+1==length && isAnagram(wordMap,patMap)){
                result.add(startWindow);
            }

        }
        return result;
    }
    private boolean isAnagram(int[] str1, int[] str2){
        for(int i=0;i<str1.length;i++)
        {
            if(str1[i] != str2[i]){
                return false;
            }
        }
        return true;
    }
}
