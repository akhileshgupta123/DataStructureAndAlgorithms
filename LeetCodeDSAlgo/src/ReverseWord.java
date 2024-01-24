/*
Given an input string s, reverse the order of the words.

        A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

        Return a string of the words in reverse order concatenated by a single space.*/

public class ReverseWord {
    public static void main(String args[]){
        String result = reverseWord("i like this program very much");
        System.out.println(result);
    }

    public static String reverseWord(String word){
        String words[] = word.split(" ");
        String reverseString = "";
        for(int i = words.length-1; i>=0; i--){
            reverseString = reverseString+words[i]+" ";
        }

        return reverseString;
    }
}
