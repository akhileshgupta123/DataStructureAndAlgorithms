package Hashing;
import java.util.*;

public class ElectoralVotingBallot {
    public static void main(String args[]){
        String votes[] = new String[] {"john", "johnny", "jackie", "johnny",
                "john", "jackie", "jamie",  "jamie",
                "john", "johnny", "jamie",  "johnny",
                "john"};

        findWinner(votes);
    }

    public static void findWinner(String votes[]){

        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String str : votes){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }

        int maxValueInMap = 0;
        String winner = "";

        for(Map.Entry<String,Integer> entrySet : map.entrySet()){
            String key = entrySet.getKey();
            Integer val = entrySet.getValue();
            System.out.println("winnner : "+winner);
            System.out.println("key : "+key);
            System.out.println(winner.compareTo(key));
            if(maxValueInMap<val){
                maxValueInMap = val;
                winner = key;
            }else if(val == maxValueInMap && winner.compareTo(key)>0){
                winner = key;
            }
        }

        System.out.println(winner);

    }
}
