package Voting;

public class Votes {
    public String voter_name;
    public int voter_id;

    public Votes(int voter_id) {
        this.voter_id = voter_id;
    }
    public Votes(String voter_name){
        this.voter_name = voter_name;
    }

    public String getVoter_name() {
        return voter_name;
    }

    public void setVoter_name(String voter_name) {
        this.voter_name = voter_name;
    }

    public int getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(int voter_id) {
        this.voter_id = voter_id;
    }

    public void printdetails(){
        System.out.println("user has voted with voter id "+voter_id);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
