import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;*/

//JsonParser parser = new JsonParser();
import java.io.StringReader;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
public class OraTest1 {
    public static void main(String[] args){
        OraTest1 obj = new OraTest1();
        String result = obj.fetchApiResponse();

        System.out.println(result);

        /*JsonReader reader = Json.createReader(new StringReader(jsonResponse));
        JsonObject jsonObject = reader.readObject();
        reader.close();*/

        //JsonElement jsonElement = JsonParser.parseString(jsonResponse);

        //ObjectMapper mapper = new ObjectMapper();

    }


    private String fetchApiResponse() {

        String result="";
        try{
            String apiUrl = "https://jsonmock.hackerrank.com/api/medical_records";

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Response from API:");
            System.out.println(response.toString());

            result = response.toString();
            connection.disconnect();

        }catch(Exception ex){

            System.err.println("Error: " + ex.getMessage());
        }

        return result;

    }
}
