package Arrays;
import java.util.*;
//2410. Maximum Matching of Players With Trainers
public class MatchPlayerTrainer {
    public static void main(String args[]){
        MatchPlayerTrainer obj = new MatchPlayerTrainer();
        int players[] = new int[]{4,7,9};
        int trainers[] = new int[]{8,2,5,8};
        int result = obj.getMatchCount(players,trainers);
        System.out.println(result);
    }

    public int getMatchCount(int[] player, int[] train){
        Arrays.sort(player);
        Arrays.sort(train);
        int i = 0, j = 0, res = 0;
        while(j<train.length && i<player.length) {
            if(player[i]>train[j]){
                while(j<train.length && train[j]<player[i]){
                    j++;
                }

            }else{
                res++; i++; j++;
            }
        }
        return res;
    }
}
