import java.util.ArrayList;

public class JSONFormatString {

    public static void main(String args[]){


        String test = "{A:'B',C:{D:'E',F:{G:'H',I:'J'}}}";

        JSONFormatString obj = new JSONFormatString();
        ArrayList<String> result = obj.prettyJSON(test);

        System.out.println("result is:"+result);
    }


    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> result = new ArrayList<>();
        if (A == null || A.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        int brackets = 0;
        char lastChar = '\0';
        // when next line:
        //  1. curr = ',' or bracket
        //  2. next char = bracket
        for (int i = 0; i < A.length(); i ++) {
            char c = A.charAt(i);
            if (c == ' ') continue;
            sb.append(c);
            if (c == ',' || c == '{' || c == '[' || c == '}' || c == ']') {
                if (c == '{' || c == '[') {
                    addTab(sb, brackets);
                    brackets ++;
                } else if (c == '}' || c == ']') {
                    brackets --;
                    addTab(sb, brackets);
                    if (i + 1 < A.length()) {
                        char n = A.charAt(i + 1);
                        if (n == ',') {
                            sb.append(n);
                            i ++;
                        }
                    }
                } else {
                    addTab(sb, brackets);
                }
                result.add(sb.toString());
                sb.setLength(0);
            } else if (i + 1 < A.length()) {
                char n = A.charAt(i + 1);
                if (n == '{' || n == '[' || n == '}' || n == ']') {
                    addTab(sb, brackets);
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            }
            lastChar = A.charAt(i);
        }
        return result;
    }

    private void addTab(StringBuilder sb, int j) {
        for (int i = 0; i < j; i ++) {
            sb.insert(0, '\t');
        }
    }
}
