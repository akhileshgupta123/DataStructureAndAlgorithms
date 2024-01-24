package Arrays;

public class MinimumWindow {
    public static void main(String args[]){
        String s = "ADOBECODEBANC";
        String t = "ABC";

        //String s = "aa";
        //String t = "aa";
        MinimumWindow obj = new MinimumWindow();
        String result = obj.min_window(s.toCharArray(), t.toCharArray());
        System.out.println(result);
    }

    private String min_window(char s[], char t[]){
        int m[] = new int[256];
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        for (int i = 0; i < t.length; i++) {

            if (m[t[i]] == 0)
                count++;

            m[t[i]]++;
        }

        System.out.println("count"+count);

        int i = 0;
        int j = 0;

        while (j < s.length){
            m[s[j]]--;
            if (m[s[j]] == 0)
                count--;

            if (count == 0){
                while (count == 0){
                    if (ans > j - i + 1){
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }

                    m[s[i]]++;
                    if (m[s[i]] > 0) {
                        System.out.println("element found:"+s[i]);
                        count++;
                    }
                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE)
            return String.valueOf(s).substring(start, ans+start);
        else
            return "-1";
    }
}
