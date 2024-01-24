package BinarySearch;
import java.util.*;
public class TopVotedCandidate {

    public static void main(String args[]){
        TopVotedCandidate obj = new TopVotedCandidate();


        // declaring global arrays for the persons and times array
        //int [] person;
        //int [] time;
        // stores the winner at any point of time

        int [] person = new int[]{0, 1, 1, 0, 0, 1, 0};
        int [] time = new int[]{0, 5, 10, 15, 20, 25, 30};


        int [] winners = obj.FetchTopVotedCandidate(person,time);
        for(int item : winners){
            System.out.println(item);
        }

        System.out.println("the final result after is:");
        int result = obj.q(3, time, winners);
        System.out.println(result);
         result = obj.q(12, time, winners);
        System.out.println(result);

        result = obj.q(25, time, winners);
        System.out.println(result);

        result = obj.q(15, time, winners);
        System.out.println(result);

        result = obj.q(24, time, winners);
        System.out.println(result);

        result = obj.q(8, time, winners);
        System.out.println(result);

    }

    public int[] FetchTopVotedCandidate(int[] persons, int[] times) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] winners =  new int[times.length];

        // map stores the person which comes at time t and his vote number is updated in the map
        map.put(persons[0],1);

        int max = persons[0];
        winners[0]=max;

        for(int i=1;i<persons.length;i++)
        {
            //updating in the map
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);


            if(map.get(persons[i])>=map.get(max))
            {
                max = persons[i];
            }

            winners[i]=max;

        }

        System.out.println("the hashmap is:");
        for(Map.Entry<Integer,Integer> obj : map.entrySet()){
            System.out.println("key is:"+obj.getKey());
            System.out.println("value is:"+obj.getValue());
        }
        return winners;

    }

    public int q(int t, int [] time, int [] winners  ) {
        int low = -1;
        int high =time.length;
        // binary search to find the lower bound like for time 12, 10 is the lower bound so we check the max votes at time 10.
        while(low+1<high)
        {
            int mid = low + (high - low)/2;
            //if(time[mid]== t)
            //return winners[mid];
            if(time[mid]<=t)
                low= mid;
            else
                high = mid;
        }

        return winners[low];
    }
}
