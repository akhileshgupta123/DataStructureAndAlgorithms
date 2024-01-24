package Agoda;
import java.util.*;

public class GroupAnagram {
    public static void main(String args[]){

        String atr[] = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagram obj = new GroupAnagram();

        List<List<String>> result = obj.groupAnagram(atr);
        System.out.println(result);
    }

    private List<List<String>> groupAnagram(String str[]){
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();

        for(String strs: str){
            char ch[] = strs.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(map.containsKey(key)){
                map.get(key).add(strs);
            }else{
                List<String> strList = new ArrayList<String>();
                strList.add(strs);
                map.put(key,strList);
            }

        }

        for(Map.Entry<String, List<String>> it: map.entrySet()){
            result.add(it.getValue());
        }

        return result;
    }
}
