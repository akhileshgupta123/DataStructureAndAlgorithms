package StackQueue;
import java.util.*;

public class LongestValidParentheses {

    public static void main(String args[]){

        LongestValidParentheses obj = new LongestValidParentheses();
        String test = "()())";
        int len = obj.longestValidParentheses(test);

        System.out.println("the length is:"+len);
    }

    private int longestValidParentheses(String str){

        int result = 0;

        Stack<int[]> st = new Stack<>();

        for(int i=0; i< str.length();i++){
            char ch = str.charAt(i);

            if(ch==')'){

                if(!st.isEmpty()){
                    System.out.println("here:"+st.peek()[0]);
                    System.out.println("here:"+st.peek()[1]);
                }

                if(!st.isEmpty() && st.peek()[0]==0){

                    st.pop();

                    System.out.println("when pop i:"+i);
                    if(!st.isEmpty()){
                        System.out.println("@@@@@@@"+st.peek()[1]);
                    }


                    System.out.println("%%%%%%"+(st.isEmpty()?-1:st.peek()[1]));
                    result = Math.max(result, i-(st.isEmpty()?-1:st.peek()[1]));
                    System.out.println("when pop:"+result);

                }else{
                    System.out.println("when insert:"+i);
                    st.push(new int[]{1, i});
                }

            }else{
                System.out.println("########inside else:"+i);
                st.push(new int[]{0, i});
            }
        }

        return result;
    }
}
