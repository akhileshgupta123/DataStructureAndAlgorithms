package Graph;
//2374. Node With Highest Edge Score
public class HighestEdgeScore {
    public static void main(String args[]){
        int edges[] = new int[]{1,0,0,0,0,7,7,5};
        HighestEdgeScore obj = new HighestEdgeScore();
        int result = obj.getEdgeScore(edges);
        System.out.println("result is:"+result);
    }

    private int getEdgeScore(int[] edges){
        int[] memo = new int[edges.length];
        int max = -1;
        int key = -1;

        for (int i = 0; i < edges.length; i++) {
            memo[edges[i]] += i;
            if(memo[edges[i]]>max || (memo[edges[i]]==max && edges[i]<key)){
                max = memo[edges[i]];
                key = edges[i];
            }
        }
        return key;
    }
}
