package StackQueue;
import java.util.*;

public class ReverseWord {
    public static void main(String args[]){

        String str = "Geeks for Geeks";
        ReverseWord obj = new ReverseWord();
        obj.reverseWord(str);
    }

    private void reverseWord(String str){
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ' ' ){
                st.push(str.charAt(i));
            }else{
                while(!st.isEmpty()){
                    System.out.print(st.pop());
                }
                System.out.print(" ");
            }

        }

        while (!st.isEmpty()) {
            System.out.print(st.pop());

        }

    }


}
