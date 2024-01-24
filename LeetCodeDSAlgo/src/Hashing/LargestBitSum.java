package Hashing;
//2275. Largest Combination With Bitwise AND Greater Than Zero
public class LargestBitSum {
    public static void main(String args[]){
        LargestBitSum obj = new LargestBitSum();
        int candidates[] = new int[]{16,17,71,62,12,24,14};
        int result = obj.largestCombination(candidates);
        System.out.println(result);
    }

    private int largestCombination(int[] candidates) {
        int[] ones = new int[24];
        for (int candidate : candidates){
            int index = 0;
            System.out.println("The current candidate is:"+candidate);
            while (candidate != 0){
                if((candidate & 1) == 1){
                    System.out.println("The if condition:"+candidate);
                    ones[index] += 1;
                }
                candidate = candidate >> 1;
                System.out.println("The inner candidate is:"+candidate);
                index++;
            }
        }
        int maxAns = 0;
        for (int i = 0; i < ones.length; i++) {
            System.out.println("i :"+i +"  value :"+ones[i]);
            maxAns = Math.max(maxAns, ones[i]);
        }
        return maxAns;
    }
}
