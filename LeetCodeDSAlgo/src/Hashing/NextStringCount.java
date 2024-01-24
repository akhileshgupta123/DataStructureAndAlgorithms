package Hashing;
import java.util.*;
//Amazon question hacker rank
public class NextStringCount {
    public static void main(String args[]){
        List<String> listItem = new ArrayList<String>();
        listItem.add("abcd");
        listItem.add("efgh");
        listItem.add("efgh");
        listItem.add("ijkl");
        listItem.add("mnop");
        listItem.add("bcde");
        listItem.add("bcde");
        listItem.add("fghi");
        listItem.add("wxyz");
        listItem.add("xyza");
        listItem.add("wxyZ");
        listItem.add("xyzA");
        NextStringCount obj = new NextStringCount();
        int result = obj.getNextStringCount(listItem);
        System.out.println(result);

    }

    private int getNextStringCount(List<String> itemList){
        int count = 0;
        Map<String,Integer> itemCountMap = new HashMap<String,Integer>();
        for(String str: itemList){
            if(itemCountMap.containsKey(str)){
                itemCountMap.put(str, itemCountMap.get(str)+1);
            }else{
                itemCountMap.put(str,1);
            }
        }
        for(String str: itemList){
            StringBuilder temp = new StringBuilder();
            char ch[] = str.toCharArray();
            for(int i=0; i<ch.length; i++){
                if(ch[i]=='z')
                    temp.append( 'a');
                else if(ch[i]=='Z')
                    temp.append( 'A');
                else
                    temp.append( (char)(ch[i]+1));
            }

            System.out.println(str);
            System.out.println(temp);
            if(itemCountMap.containsKey(temp.toString())){
                count = count+itemCountMap.get(temp.toString());
            }
        }
        return count;
    }
}
