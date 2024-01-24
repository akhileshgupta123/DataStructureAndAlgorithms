package Hashing;
import java.util.*;

//1010. Pairs of Songs With Total Durations Divisible by 60
public class PairOfSong {
    public static void main(String args[]){
        PairOfSong obj = new PairOfSong();
        int time[] = new int[]{30,20,150,100,40};
        int result = obj.numberOfPairDivisible(time);
        System.out.println("The pair are :"+result);
    }

    private int numberOfPairDivisible(int time[]){
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<time.length;i++){
            int div=time[i]%60;
            System.out.println("dic:"+div);
            if(hm.containsKey(60-div)){
                count=count+hm.get(60-div);
            }

            if(div==0){
                hm.put(60,hm.getOrDefault(60,0)+1);
            }else{
                hm.put(div,hm.getOrDefault(div,0)+1);
            }
        }

        System.out.println(hm);
        return count;
    }
}
