import java.util.*;
public class TestExample {

    public static void main(String args[]) {

        String source = "abda";
        String target = "acca";

        TestExample obj = new TestExample();
        boolean result = obj.isMatch(source,target);

        System.out.println("result:"+result);

    }


    public boolean isMatch(String src, String target) {
        boolean match = true;

        if(src.length()!=target.length()){
            return false;
        }

        Map<Character, List<Integer>> mapRepo = new HashMap<>();
        char[] sourceArray = src.toCharArray();
        for (int i = 0; i < sourceArray.length; i++) {
            if (mapRepo.containsKey(sourceArray[i])) {
                List<Integer> itemIndex = mapRepo.get(sourceArray[i]);
                itemIndex.add(i);
            } else {
                List<Integer> itemIndex = new ArrayList<Integer>();
                itemIndex.add(i);
                mapRepo.put(sourceArray[i], itemIndex);
            }
        }


        char[] targetArray = target.toCharArray();
        Set<Character> duplicateTarget = new HashSet<Character>();
        for (Map.Entry<Character, List<Integer>> entrySet : mapRepo.entrySet()) {
            List<Integer> indexList = entrySet.getValue();


            if (indexList.size() == 1) {
                int index = indexList.get(0);
                Character ch = targetArray[index];
                if (duplicateTarget.contains(ch)) {
                    return false;
                }
                duplicateTarget.add(ch);
            } else {
//0,2
                Character ch = targetArray[indexList.get(0)];
                if (duplicateTarget.contains(ch)) {
                    return false;
                }


                duplicateTarget.add(ch);

                for (int itemIndex : indexList) {
                    if (ch != targetArray[itemIndex]) {
                        return false;
                    }
                }
            }
        }
        return match;
    }
}
