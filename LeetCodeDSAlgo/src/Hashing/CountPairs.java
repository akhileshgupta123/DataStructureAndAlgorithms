package Hashing;
import java.util.*;

//1711. Count Good Meals
//Time Complexity: O(22n) = O(n)
//        Space Complexity: O(n)
public class CountPairs {
    public static void main(String args[]){
        CountPairs obj = new CountPairs();
        //int deliciousness[] = new int[]{1,3,5,7,9};
        int deliciousness[] = new int[]{1,1,1,3,3,3,7};

        int result = obj.countPairs(deliciousness);

        System.out.println("results is :"+result);
    }

    public int countPairs(int deliciousness[]){
        Map<Integer, Integer> map = new HashMap<Integer,Integer>(); // key: num, val: ocurrence
        int length = deliciousness.length, answer = 0, MOD = 1000000007;

        for (int num : deliciousness) {

            int sum = 1;

            for (int i = 0; i <= 21; i++) {// 21 because 2^20 + 2^20 = 2^21, this is largest sum we can obtain in this problem.
                if (sum >= num && map.containsKey(sum - num)) {
                    System.out.println("the inner value is :"+map.get(sum - num));
                    answer += map.get(sum - num);
                    System.out.println("first :"+sum);
                    System.out.println("second :"+(sum-num));
                    //answer %= MOD;
                }
                sum *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        return (int)answer;
    }
}
