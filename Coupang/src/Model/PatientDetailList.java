package Model;
import java.util.*;
public class PatientDetailList {
    List<PatientRecord>  data = new ArrayList<PatientRecord>();

    public List<PatientRecord> getData() {
        return data;
    }

    public void setData(List<PatientRecord> data) {
        this.data = data;
    }
}
