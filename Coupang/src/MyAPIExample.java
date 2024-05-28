import Model.PatientDetailList;
import Model.PatientRecord;
import Model.PatientVitals;

import java.util.*;
import java.net.*;

public class MyAPIExample {

    public static void main(String args[]){
        /*HttpURLConnection connection = new HttpURLConnection()

        URL url = new URLConnection("https://jsonmock.hackerrank.com/api/medical_records?page=1");
        url.get*/

        MyAPIExample obj = new MyAPIExample();



        PatientDetailList details = new PatientDetailList();
        List<PatientRecord>  data = new ArrayList<PatientRecord>();
        data.add(obj.createPatientData(2,2,"ABC","14-09-1989", 154,91));
        data.add(obj.createPatientData(2,2,"ABC","14-09-1989", 139,81));
        data.add(obj.createPatientData(3,3,"CDE","14-09-1994", 153,99));
        data.add(obj.createPatientData(4,4,"EFG","14-09-1987", 147,96));
        data.add(obj.createPatientData(5,5,"EFG","14-09-1989", 127,78));
        details.setData(data);
        List<PatientRecord> resuklt = obj.findRecord(details);
        System.out.println(resuklt.size());

    }

    private PatientRecord createPatientData(int id, int userId, String userName, String userDob, int bloodPressureDiastole, int bloodPressureSystole){
        PatientVitals patientVitals = new PatientVitals(bloodPressureDiastole, bloodPressureSystole);
        PatientRecord patientRecord = new PatientRecord(id,userId,userName,userDob,patientVitals);
        return patientRecord;
    }

    private List<PatientRecord> findRecord(PatientDetailList details){
        //Map<Integer, PatientRecord>  patientMap = new HashMap<Integer, PatientRecord>();

        List<PatientRecord> listPatientRecord = new ArrayList<PatientRecord>();
        for(PatientRecord patientRecord: details.getData()){
            String dob = patientRecord.getUserDob();
            int userId = patientRecord.getUserId();

            //if(!patientMap.containsKey(userId)){
                Date todayDate = new Date();

                String[] dobArray =  dob.split("-");
                int dobYear = Integer.parseInt(dobArray[2]);



                int age = todayDate.getYear() - dobYear;

                if(age>45 && patientRecord.getVitals()!=null){
                    int bloodPressureDifference = patientRecord.getVitals().getBloodPressureDiastole() - patientRecord.getVitals().getBloodPressureSystole();
                    if(bloodPressureDifference>=30){
                        listPatientRecord.add(patientRecord);
                        //patientMap.put(userId,patientRecord);
                    }
                }


            //}

        }

         /*for(Map.Entry<Integer, PatientRecord> item : patientMap.entrySet()){
             listPatientRecord.add(item.getValue());
         }*/


        return listPatientRecord;

    }
}
