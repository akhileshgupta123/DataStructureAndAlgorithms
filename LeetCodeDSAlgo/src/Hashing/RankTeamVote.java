package Hashing;
import java.util.*;
//1366. Rank Teams by Votes
public class RankTeamVote {
    public static void main(String args[]){
        RankTeamVote obj = new RankTeamVote();
        String votes[] = new String[]{"ABC","ACB","ABC","ACB","ACB"};
        String result = obj.rankTeam(votes);

        System.out.println("result"+result);
    }

    private String rankTeam(String votes[]){
        Map<Character, int[]> map = new HashMap<Character,int[]>();
        int l = votes[0].length();
        for(String vote : votes){
            for(int i = 0; i < l; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[l]);
                map.get(c)[i]++;
            }
        }
        /*System.out.println(map);
        for(int item:map.get('C')){
            System.out.println(item);
        }*/
        List<Character> list = new ArrayList<Character>();

        for(Map.Entry<Character,int[]> item:map.entrySet()){
            list.add(item.getKey());
        }

        Collections.sort(list, new Comparator<Character>(){
            public int compare(Character a, Character b){
                int Aarr[] = map.get(a);
                int Barr[] = map.get(b);
                for(int i=0; i<l; i++){
                    if(Aarr[i] != Barr[i]){
                        return Barr[i] - Aarr[i];
                    }
                }
                return (int)(a-b);
            }
        });
/*
        Collections.sort(list, (a,b) -> {
            for(int i = 0; i < l; i++){
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });*/
/*
        Arrays.sort(times,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (a[0] - b[0]);
            }
        });*/




        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
        //return null;
    }
}
