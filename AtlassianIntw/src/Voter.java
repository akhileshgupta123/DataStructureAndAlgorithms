import java.util.*;
public class Voter {
    int voter_id;
    int voter_name;
    List<Candidate> list_candidate;
    Voter(int voter_id, List<Candidate> candidate_list){
        this.voter_id = voter_id;
        this.list_candidate = candidate_list;
    }


    public int getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(int voter_id) {
        this.voter_id = voter_id;
    }

    public int getVoter_name() {
        return voter_name;
    }

    public void setVoter_name(int voter_name) {
        this.voter_name = voter_name;
    }

    public List<Candidate> getList_candidate() {
        return list_candidate;
    }

    public void setList_candidate(List<Candidate> list_candidate) {
        this.list_candidate = list_candidate;
    }
}
