// given a string find least distance between two given substrings within the string
public class DistanceBetweenString {
    public static void main(String args[]){
        String s = "geeks for geeks contribute practice";
        String w1 = "geeks";
        String w2 = "practice";

        DistanceBetweenString obj = new DistanceBetweenString();
        int result = obj.distance(s,w1,w2);
        System.out.println(result);
    }

    private int distance(String s, String w1, String w2){
        if (w1.equals(w2)) {
            return 0;
        }
        String[] words = s.split(" ");
        int n = words.length;
        int min_dist = n + 1;

        int prev = 0, i = 0;

        for (i = 0; i < n; i++) {
            if (words[i].equals(w1) || words[i].equals(w2)) {
                prev = i;
                break;
            }
        }

        while(i < n){
            if (words[i].equals(w1) || words[i].equals(w2)) {

                if(!words[prev].equals(words[i]) && (i-prev) < min_dist){
                    min_dist = i - prev - 1;
                    prev = i;
                }else{
                    prev = i;
                }

            }

            i = i+1;

        }

        return min_dist;
    }
}
