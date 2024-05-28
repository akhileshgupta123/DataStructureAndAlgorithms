public class Candidate {
    int candidate_id;
    int candidate_name;
    Party party;
    int score;


    Candidate(int candidate_id, Party party){
        this.candidate_id = candidate_id;
        this.party = party;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
