package Hashing;
import java.util.*;

public class CustomRateLimiter {
    private Map<String, Map<Long, Integer>> apiCallCounts;

    public CustomRateLimiter(){
        apiCallCounts = new HashMap<String, Map<Long, Integer>>();
    }
    public static void main(String args[]) throws InterruptedException{
        CustomRateLimiter obj = new CustomRateLimiter();

        obj.isAllowed("first");
        Thread.sleep(0);
        obj.isAllowed("first");
        Thread.sleep(0);
        obj.isAllowed("first");
        Thread.sleep(0);
        obj.isAllowed("first");
        Thread.sleep(5);
        obj.isAllowed("first");
        Thread.sleep(1);
        obj.isAllowed("first");
        Thread.sleep(1);
        obj.isAllowed("first");
    }

    public boolean isAllowed(String apiName){
        long currentTime = System.currentTimeMillis();
        Map<Long, Integer> timestampCounts = apiCallCounts.get(apiName);

        if (timestampCounts == null) {
            timestampCounts = new HashMap<Long,Integer>();
            apiCallCounts.put(apiName, timestampCounts);
        }

        long fiveMinutesAgo = currentTime - 5 * 60 * 1000;

        System.out.println(" fiveMinutesAgo :"+fiveMinutesAgo);

        for(Map.Entry<Long, Integer> entry: timestampCounts.entrySet()){
            if(entry.getKey() < fiveMinutesAgo){

                System.out.println(" ############inside when entry does not match in limit");
                timestampCounts.remove(entry.getKey());
            }else{
                System.out.println(" ############inside else");
            }
        }

        int count = timestampCounts.getOrDefault(currentTime, 0) + 1;
        timestampCounts.put(currentTime, count);


        if (count > 2) {
            System.out.println("Error: Rate limit exceeded for API " + apiName);
            return false;
        }


        System.out.println("200 OK: API " + apiName + " called at " + currentTime);
        return true;

    }
}
