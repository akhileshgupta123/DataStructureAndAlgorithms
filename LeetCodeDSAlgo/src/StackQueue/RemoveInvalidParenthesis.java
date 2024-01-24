package StackQueue;
import java.util.*;
public class RemoveInvalidParenthesis {
    public static void main(String args[]){
        RemoveInvalidParenthesis obj = new RemoveInvalidParenthesis();
        String expression = "()v)";//"()())()";
        List<String>result = obj.removeInvalidParentheses(expression);

        System.out.println(result);

    }

    public List<String> removeInvalidParentheses(String s) {
        if(s==null)
            return null;

        List<String> res = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(s);
        visited.add(s);
        boolean level = false;
        while (!q.isEmpty()){
            s = q.poll();

            if (isValid(s))
            {
                res.add(s);
                //System.out.println(s);

                // If answer is found, make level true
                // so that valid string of only that level
                // are processed.
                level = true;
            }

            if (level)
                continue;

            if(level==false){
                for (int i = 0; i < s.length(); i++){
                    if (!isParenthesis(s.charAt(i)))
                        continue;

                    String temp = s.substring(0, i) + s.substring(i + 1);
                    System.out.println("temp is:"+temp);
                    if (!visited.contains(temp))
                    {
                        q.add(temp);
                        visited.add(temp);
                    }

                }

            }



        }

        return res;

    }

    boolean isParenthesis(char c)
    {
        return ((c == '(') || (c == ')'));
    }

    private boolean isValid(String s){
        int c =0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                c++;
            else if (s.charAt(i) == ')')
                c--;

            if (c < 0)
                return false;

        }

        return c==0;
    }
}
