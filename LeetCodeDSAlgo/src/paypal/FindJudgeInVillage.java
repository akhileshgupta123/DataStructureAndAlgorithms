package paypal;
//https://leetcode.com/problems/find-the-town-judge/submissions/

/*

Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

sunder solution:
    - first first the node, which has n-1 trustee (right)
    - and just check, if that trustee is not in truster (left side)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//this one using map is O(n^2)

public class FindJudgeInVillage {

    public static void main(String args[]){
        FindJudgeInVillage obj = new FindJudgeInVillage();
        int n = 4;
        int trust[][] = new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}};

        int result = obj.findJudge(n,trust);

        System.out.println("result:"+result);

    }

    public int findJudge(int n, int[][] trust) {

        Map<Integer, List<Integer>> trustLinkMap = new HashMap<>();

        //for each node put an empty list

        for (int i = 1; i <= n; i++) {

            trustLinkMap.put(i, new ArrayList<>());
        }


        //fill a Map from 2d array
        for (int i = 0; i < trust.length; i++) {

            int truster = trust[i][0];
            int trustee = trust[i][1];

            trustLinkMap.get(truster).add(trustee);

        }


        //check which node has emptyList
        int possibleJudge = -1;
        for (Map.Entry<Integer, List<Integer>> entrySet : trustLinkMap.entrySet()) {

            int truster = entrySet.getKey();
            List<Integer> trusteeList = entrySet.getValue();
            if (trusteeList.isEmpty()) {

                //means 2 judges are there
                if (possibleJudge != -1) {

                    return -1;
                }

                possibleJudge = truster;
            }
        }

        System.out.println("possibleJudge:"+possibleJudge);
        //possible is present in all the list or not
        //check which node has emptyList
        for (Map.Entry<Integer, List<Integer>> entrySet : trustLinkMap.entrySet()) {

            int truster = entrySet.getKey();
            List<Integer> trusteeList = entrySet.getValue();
            if (truster != possibleJudge) {

                System.out.println("truster:"+truster);
                System.out.println("trusteeList:"+trusteeList);
                if (!trusteeList.contains(possibleJudge)) {

                    return -1;
                }
            }
        }

        return possibleJudge;
    }
}
