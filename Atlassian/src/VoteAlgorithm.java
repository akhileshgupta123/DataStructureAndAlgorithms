import java.util.*;
/*Vote algorightm - Given votes of candidates sort them by most votes received
First vote have highest weight and subsequent votes have weight-1 then previous vote*/
public class VoteAlgorithm {
    public static void main(String args[]){
        VoteAlgorithm obj = new VoteAlgorithm();
        List<List<String>> ballout = obj.calculateFinalListData();

        List<String> result = obj.calculateVotes(ballout);
        System.out.println(result);
    }

    private List<List<String>> calculateFinalListData(){
        List<List<String>> ballout = new ArrayList<List<String>>();
        ballout.add(generateBalloutList("A","B","C"));
        ballout.add(generateBalloutList("A","C","D"));
        ballout.add(generateBalloutList("D","A","C"));
        return ballout;
    }


    private List<String> generateBalloutList(String candidate1, String candidate2, String candidate3){
        List<String> item = new ArrayList<String>();
        item.add(candidate1);
        item.add(candidate2);
        item.add(candidate3);
        return item;
    }

    public List<String> calculateVotes(List<List<String>> ballouts){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (List<String> ballot : ballouts) {
            for (int i = 0; i < ballot.size(); i++) {
                String candidate = ballot.get(i);
                if(map.containsKey(candidate)){
                    int keyval = map.get(candidate);
                    map.put(candidate,keyval+ (ballot.size() - i));
                }else{
                    map.put(candidate,0+ (ballot.size() - i));
                }

            }
        }


        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> item1, Map.Entry<String,Integer> item2){
                return item2.getValue()-item1.getValue();
            }
        });
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            pq.add(entry);
        }

        List<String> finalResult = new ArrayList<String>();
        for(Map.Entry<String,Integer> entry : pq){
            finalResult.add(entry.getKey());
            System.out.println("Candidate :"+ entry.getKey() + " with score is :"+entry.getValue());
        }
        return finalResult;
    }
}
