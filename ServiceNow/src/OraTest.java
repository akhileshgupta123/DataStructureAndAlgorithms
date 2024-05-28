import java.util.*;
public class OraTest {
    public static void main(String args[]){
        String json = "{\n" +
                "            \"page\": 1,\n" +
                "                \"per_page\": 10,\n" +
                "                \"total\": 1000,\n" +
                "\n" +
                "                \"data\": [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                    \"name\": \"John Doe\",\n" +
                "                    \"email\": \"johndoe@example.com\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 2,\n" +
                "                    \"name\": \"Jane Smith\",\n" +
                "                    \"email\": \"janesmith@example.com\"\n" +
                "            }\n" +
                "    ]}";

    StringTokenizer token = new StringTokenizer(json,",");
    while(token.hasMoreElements()){
        String token1 = token.nextToken();
        if(token1.contains("total")){
            //System.out.println(token1.trim());
            //int item = Integer.parseInt(token1.trim().substring(8));
            String first = token1.trim().substring(8).trim();
            int item = Integer.parseInt(first);
            System.out.println(item);
        }

    }

    }
}

