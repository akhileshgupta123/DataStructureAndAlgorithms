package DynamicProgramming;

import java.util.Stack;
//32. Longest Valid Parentheses
public class LongestValidParenthesisDynamic {
    public static void main(String args[]){
        LongestValidParenthesisDynamic obj = new LongestValidParenthesisDynamic();
        String test = ")()())";

        String result = obj.findValidString(test);
        System.out.println(result);

    }


    private String findValidString(String str){

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.size()>0 && str.charAt(st.peek())=='('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }

        char[] arr = str.toCharArray();

        while(st.size() > 0){
            int idx = st.pop();
            arr[idx] = '.'; // to avoid alphabets
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != '.'){
                sb.append(arr[i]);
            }
        }



        return sb.toString();
    }
}
