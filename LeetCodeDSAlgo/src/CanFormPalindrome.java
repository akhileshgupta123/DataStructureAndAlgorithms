/*

Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.
 */


import java.util.ArrayList;
import java.util.List;

public class CanFormPalindrome {

    public static void main(String args[]){
        boolean result = isPalindrome("abbaee");
        System.out.println("result is:"+result);
    }

    static boolean isPalindrome(String str){
        List<Character> list = new ArrayList<Character>();

        for(int i=0; i<str.length(); i++){
            if(list.contains(str.charAt(i))){
                list.remove((Character)str.charAt(i));
            }else{
                list.add(str.charAt(i));
            }
        }

        if((str.length() % 2==0 && list.isEmpty() )|| (str.length() %2 == 1 && list.size()==1)){
            return true;
        }else{
            return false;
        }
    }
}

