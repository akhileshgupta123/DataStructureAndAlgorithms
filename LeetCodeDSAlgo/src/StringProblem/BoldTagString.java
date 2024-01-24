package StringProblem;
//616. Add Bold Tag in String

//Time complexity : O(l*s*x)O(l∗s∗x). Three nested loops are there to fill boldbold array.
//        Space complexity : O(s)O(s). resres and boldbold size grows upto O(s)O(s).
public class BoldTagString {

    public static void main(String args[]){
        BoldTagString obj = new BoldTagString();
        /*String source = "abcxyz123";
        String dict[] = new String[]{"abc","123"};*/

        String source  = "aaabbcc";
        String dict[]  = new String[]{"aaa","aab","bc"};
        String result = obj.addBoldTag(source,dict);

        System.out.println(result);
    }

    private String addBoldTag(String s, String dict[]){

        if (s.length() == 0 || dict.length == 0)
        {
            return s;
        }

        StringBuilder res = new StringBuilder();
        boolean[] bold = new boolean[s.length()];

        /*
        for (String d: dict) {
            for (int i = 0; i <= s.length() - d.length(); i++) {
                if (s.substring(i, i + d.length()).equals(d)) {
                    for (int j = i; j < i + d.length(); j++)
                        bold[j] = true;
                }
            }

        }*/


        int end = 0;

        for(int i = 0; i < s.length(); i++)
        {
            for(String word : dict)
            {
                int wordLength = word.length();

                if(i + wordLength <= s.length() && s.substring(i, i + wordLength).equals(word))
                {
                    end = Math.max(end , i + wordLength);
                }
            }
            bold[i] = end > i;
        }


        for(boolean j : bold){
            System.out.println(j);
        }


        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                res.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            res.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return res.toString();
    }
}
