package Model;

public class PatientRecord {
    int id;
    int userId;
    String userName;
    String userDob;
    PatientVitals vitals;

    public PatientRecord(int id, int userId, String userName, String userDob, PatientVitals vitals){
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userDob = userDob;
        this.vitals = vitals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public PatientVitals getVitals() {
        return vitals;
    }

    public void setVitals(PatientVitals vitals) {
        this.vitals = vitals;
    }
}
