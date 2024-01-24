package Voting;

public class Nominee {
    public String nominee_name;
    public int nominee_id;


    public Nominee( int nominee_id) {
        this.nominee_id = nominee_id;
    }
    public Nominee(String nominee_name){

        this.nominee_name = nominee_name;
    }
    public String getNominee_name() {
        return nominee_name;
    }

    public void setNominee_name(String nominee_name) {
        this.nominee_name = nominee_name;
    }

    public int getNominee_id() {
        return nominee_id;
    }

    public void setNominee_id(int nominee_id) {
        this.nominee_id = nominee_id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
