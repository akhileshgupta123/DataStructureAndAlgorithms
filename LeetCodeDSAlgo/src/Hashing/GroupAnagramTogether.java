package Hashing;
import java.util.*;
//49. Group Anagrams
public class GroupAnagramTogether {
    public static void main(String args[]){
        String atr[] = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagramTogether obj = new GroupAnagramTogether();
        List<List<String>>  result = obj.groupAnagram(atr);

        System.out.println(result);
    }

    private List<List<String>> groupAnagram(String strs[]){

        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String,List<String>>();

        for(String str: strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> strList = new ArrayList<String>();
                strList.add(str);
                map.put(key, strList);
            }

        }

        for(Map.Entry<String, List<String>> it: map.entrySet()){
            result.add(it.getValue());
        }

        return result;
    }
}
