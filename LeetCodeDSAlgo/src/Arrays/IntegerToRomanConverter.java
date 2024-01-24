package Arrays;
import java.util.*;
public class IntegerToRomanConverter {
    public static void main(String args[]){
        IntegerToRomanConverter obj = new IntegerToRomanConverter();
        String result = obj.getRomanNumber(77);

        System.out.println("the result is :"+result);

    }


    private String getRomanNumber(int number){
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();

        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);

        String result = "";
        for(Map.Entry<String,Integer> entry: roman_numerals.entrySet()){
            int matches = number/entry.getValue();
            result += repeat(entry.getKey(), matches);
            number = number % entry.getValue();

            System.out.println("the outer result str is :"+result);
            System.out.println("the outer number str is :"+number);
        }
        return result;
    }

    private String repeat(String s, int number){
        System.out.println("the repeat str is :"+s);
        System.out.println("the repeat number is :"+number);
        if(s==null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number; i++) {
            System.out.println("the inner sb is:"+sb.toString());
            sb.append(s);
        }

        return sb.toString();
    }
}
