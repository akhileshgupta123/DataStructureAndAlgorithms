import java.util.*;
public class TestExample {

    //"abcabcbc" => "abc"
    //"abcabcdabcd" => "abcd"

    public static void main(String args[]){
        String str = "abcabcdabcd";
        //String str = "abaabbaab";

        //String str = "abcabcbc";



        Map<Character, Integer>  charMap = new HashMap<Character,Integer>();

        String result = "";

        char[] strArray = str.toCharArray();
        int startIndex = 0;
        int endIndex = 0;

        for(int i=0; i<strArray.length; i++){
            if(charMap.containsKey(strArray[i])){

                startIndex = charMap.get(strArray[i]);
                int tempCount = 0;
                int startIndexTemp = startIndex;
                while((i+tempCount)<strArray.length && startIndex<strArray.length && (strArray[startIndex] == strArray[i+tempCount])){

                    startIndex++;
                    tempCount++;


                }


                charMap.put(strArray[i],i);



                if(result.length() < str.substring(startIndexTemp,startIndex).length()){
                    result = str.substring(startIndexTemp,startIndex);
                }
                //result = Math.max(str.substring(startIndexTemp,startIndex))




            }else{
                charMap.put(strArray[i],i);
            }
        }

        System.out.println(result);

    }
}
