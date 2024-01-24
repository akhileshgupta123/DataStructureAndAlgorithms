package Hashing;
import java.util.*;
//736. Parse Lisp Expression
public class LispExpression {
    public static void main(String args[]){
        LispExpression obj = new LispExpression();
        String expression ="(let x 2 (mult x (let x 3 y 4 (add x y))))";
        obj.evaluate(expression);

    }
    public int evaluate(String expression) {
        //String[] strs = split(expression);
        return eval(expression, new HashMap<>());
    }

    public int eval(String expression, Map<String, Integer> map){
        if (isNumber(expression)) return Integer.valueOf(expression);

        if (isVariable(expression)) return map.get(expression);

        int res = 0;

        List<String> list = parse(expression);

        //System.out.println(list);

        if (list.get(0).equals("add"))
            res = eval(list.get(1), map) + eval(list.get(2), map);
        else if(list.get(0).equals("mult"))
            res = eval(list.get(1), map) * eval(list.get(2), map);
        else{
            Map<String, Integer> newMap = new HashMap<>();
            newMap.putAll(map);
        }

        return -1;
    }

    public boolean isNumber(String expr){
        char c = expr.charAt(0);
        return Character.isDigit(c) || c == '-';
    }

    public boolean isVariable(String expr){
        char c = expr.charAt(0);
        return Character.isLowerCase(c);
    }

    public List<String> parse(String expr){
        List<String> res = new ArrayList<>();
        expr = expr.substring(1, expr.length() - 1);
        int i = 0;
        while (i < expr.length()){

            int j = find(expr, i);
            res.add(expr.substring(i, j));
            i = j + 1;
        }
        return res;
    }

    public int find(String expr, int i){
        int index = i;
        if (expr.charAt(index) == '('){
            int count = 1;
            index++;
            while (index < expr.length() && count > 0){
                if (expr.charAt(index) == '(') count++;
                else if (expr.charAt(index) == ')') count--;
                index++;
            }

        }else{

            while(index< expr.length() && expr.charAt(index)!=' ')
                index++;
        }
        return index;
    }
}
