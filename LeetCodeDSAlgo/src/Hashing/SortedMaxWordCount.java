package Hashing;
import java.util.*;

public class SortedMaxWordCount {
    public static void main(String args[]){
        int n = 2;
        List<String> listMessage = new ArrayList<String>();
        listMessage.add("<alice> how are you");
        listMessage.add("<bom> hi !!!!!");
        listMessage.add("<akhil> how are you");
        listMessage.add("<alice> i am fine");
        listMessage.add("<ritu> i am going to indore");
        listMessage.add("<moksh> hello");
        SortedMaxWordCount obj = new SortedMaxWordCount();
        List<String> resultList = obj.findUser(listMessage, n);

        for(String str:resultList){
            System.out.println("item is :"+str);
        }

    }

    private List<String> findUser(List<String> messageList, int count){
        Map<String, Integer> sortedMap = new HashMap<String,Integer>();
        for(String item:messageList){
            String strarr[] = item.split(" ");
            if(strarr!=null && strarr.length>0){
                String user = strarr[0].substring(1,strarr[0].length()-1);
                if(sortedMap.containsKey(user)){
                    sortedMap.put(user, sortedMap.get(user)+strarr.length-1);
                }else{
                    sortedMap.put(user, strarr.length-1);
                }
            }
        }

        PriorityQueue<MessageContent> pq = new PriorityQueue<MessageContent>(new Comparator<MessageContent>(){
            public int compare(MessageContent obj1, MessageContent obj2){
                return obj2.wordcount-obj1.wordcount;
            }
        });

        for(Map.Entry<String,Integer> obj: sortedMap.entrySet()){
            System.out.println("key :"+obj.getKey());
            System.out.println("val :"+obj.getValue());
            pq.add(new MessageContent(obj.getKey(), obj.getValue()));
        }

        List<String> resultList = new ArrayList<String>();

        for(int i=0; i<count; i++){
            resultList.add(pq.poll().username);
        }

        return resultList;
    }



}

class MessageContent{
    String username;
    int wordcount;

    public MessageContent(String username, int wordcount){
        this.username = username;
        this.wordcount = wordcount;
    }
}
