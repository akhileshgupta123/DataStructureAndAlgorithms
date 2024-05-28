package Model;

public class PatientVitals {
    int bloodPressureDiastole;
    int bloodPressureSystole;

    public PatientVitals(int bloodPressureDiastole, int bloodPressureSystole){
        this.bloodPressureDiastole = bloodPressureDiastole;
        this.bloodPressureSystole = bloodPressureSystole;
    }

    public int getBloodPressureDiastole() {
        return bloodPressureDiastole;
    }

    public void setBloodPressureDiastole(int bloodPressureDiastole) {
        this.bloodPressureDiastole = bloodPressureDiastole;
    }

    public int getBloodPressureSystole() {
        return bloodPressureSystole;
    }

    public void setBloodPressureSystole(int bloodPressureSystole) {
        this.bloodPressureSystole = bloodPressureSystole;
    }
}
