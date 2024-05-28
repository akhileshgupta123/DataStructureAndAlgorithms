import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class OraTestRestApi {
    public static void main(String args[]) throws ParseException{

        int lowwerLimit = 120;
        int upperLimit = 160;
        OraTestRestApi obj = new OraTestRestApi();
        Set<Integer> uniqueMatchingPatient = new HashSet<Integer>();
        List<Integer> patientList = new ArrayList<Integer>();

        for(int i=1; i<=10; i++){
            String jsonResponse = obj.fetchApiResponse(i);

            /*String[] item = jsonResponse.split(",");
            for(String itemelement : item){
                if(itemelement.contains("bodyTemperature")){
                    //System.out.println(itemelement);
                    String[] inneritem  = itemelement.split(":");

                    //for(String finalElement : inneritem){
                        System.out.println(inneritem[1]);
                    //}

                }
            }*/
            JSONArray patientRecords = obj.generateJsonObject(jsonResponse);


            obj.processPatientRecord(patientList, patientRecords, lowwerLimit, upperLimit);



        }

        System.out.println(patientList);
        System.out.println(patientList.size());
        /*String result = obj.fetchApiResponse();

        System.out.println(result);

        //JsonElement jsonElement = JsonParser.parseString(result);

        //System.out.println("JSON Object:");
        //System.out.println(jsonElement);

        Gson gson = new Gson();

        PatientRecords patientRecords = gson.fromJson(result, PatientRecords.class);

        System.out.println(patientRecords.total);
        System.out.println(patientRecords.data[9].vitals.bloodPressureDiastole);*/
    }

    private void processPatientRecord(List<Integer> patientList, JSONArray patientsArray, int lowwerLimit,  int upperLimit){
        for(Object patient: patientsArray){
            JSONObject patientObject = (JSONObject) patient;
            if(this.isWithinRange(lowwerLimit, upperLimit,patientObject)){
                //Integer id = (Integer) patientObject.get("userId");
                patientList.add(1);
                //this.isWithinRange(lowwerLimit, upperLimit, patient);
            }
        }
    }

    private boolean isWithinRange(int lowwerLimit,  int upperLimit, JSONObject patientObject){
        boolean isRange = false;
        JSONObject vitalObject = (JSONObject)  patientObject.get("vitals");
       // System.out.println(vitalObject.toJSONString());
        Object pressureObject =  (Object)vitalObject.get("bloodPressureDiastole");
        System.out.println(pressureObject.toString());

        int num = Integer.parseInt(pressureObject.toString().trim());
System.out.println(num);

        if(num>=lowwerLimit && num<=upperLimit){
            isRange = true;
        }
        return isRange;
    }

    private JSONArray generateJsonObject(String jsonResponse) {
        JSONArray dataArray = null;
        try{
            JSONParser parser = new JSONParser();

            // Parse the JSON string to create a JSONObject
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            //Gson gson = new Gson();
            //PatientRecords patientRecords = gson.fromJson(jsonResponse, PatientRecords.class);

             dataArray = (JSONArray) jsonObject.get("data");

        }catch(Exception ex){

        }





        return dataArray;
    }


    private String fetchApiResponse(int pageNumber) {

        String result="";
        try{
            String apiUrl = "https://jsonmock.hackerrank.com/api/medical_records?page="+pageNumber;

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

            //System.out.println("Response from API:");
            //System.out.println(response.toString());

            result = response.toString();
            connection.disconnect();

        }catch(Exception ex){

            System.err.println("Error: " + ex.getMessage());
        }

        return result;

    }
}

class PatientRecords{
    int page;
    int per_page;
    int total;
    int total_pages;
    Patient data[];

}

class Patient{
    int id;
    int userId;
    String userName;
    Vital vitals;
}
class Vital{
    float bodyTemperature;
    int bloodPressureDiastole;
    int bloodPressureSystole;

}
