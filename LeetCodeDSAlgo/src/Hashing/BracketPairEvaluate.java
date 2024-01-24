package Hashing;
import java.util.*;
//1807. Evaluate the Bracket Pairs of a String
//Java O(n)
public class BracketPairEvaluate {
    public static void main(String args[]){
        BracketPairEvaluate obj = new BracketPairEvaluate();
        String str = "(name)is(age)yearsold";
        Map<String, String> knowledge = new HashMap<String,String>();
        knowledge.put("name","bob");
        knowledge.put("age","two");
        String result = obj.evaluate(str,knowledge);
        System.out.println(result);
    }

    String evaluate(String str, Map<String,String> knowledge){
        StringBuffer result = new StringBuffer();
        boolean isKey = false;
        StringBuffer key = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ')' && isKey==true) {
                isKey = false;
                if(knowledge.containsKey(key.toString())){
                    result.append(knowledge.get(key.toString()));
                }else{
                    result.append("?");
                }
                key.setLength(0);
            }else if(isKey){
                key.append(str.charAt(i));
            }else if(isKey == false && str.charAt(i) == '(') {
                isKey = true;
            }else
                result.append(str.charAt(i));
        }
        return result.toString();
    }
}
