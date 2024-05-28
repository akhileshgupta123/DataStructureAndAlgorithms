import java.util.*;

/* For a list of votes, return an ordered set of candidates in descending order of their votes.
/*
List<String> findWinners(List<Votes> votes)

Example Votes:
Vote ={“Candidate A”,  “Candidate B”, “Candidate C”}

Candidate A: 3 points
Candidate B: 2 points
Candidate C: 1 point

Vote ={“Candidate B”,  “Candidate D”, “Candidate A”}
Candidate B: 3 points
Candidate D: 2 points
Candidate A: 1 point

output

candidate B : 5 point
candidate A  : 4 point
candidate D : 2 point
candidate C : 1 point

 */
public class ElectionVotingMain {

    public static void main(String args[]){
        ElectionVotingMain electionVotingObj = new ElectionVotingMain();
        List<Candidate> candidateList = new ArrayList<Candidate>();
        Map<Integer, Voter> voterMap = new HashMap<Integer,Voter>();
        candidateList.add(electionVotingObj.populateCandidateDetails(1,Party.BJP));
        candidateList.add(electionVotingObj.populateCandidateDetails(2,Party.CONGRESS));
        candidateList.add(electionVotingObj.populateCandidateDetails(3,Party.AAP));
        candidateList.add(electionVotingObj.populateCandidateDetails(4,Party.SP));





        int voter_count = 5;



       /* while(voter_count!=0){






            voterMap.put();
            voter_count--;
        }*/

        Voter v1 = electionVotingObj.populateVoterDetails(1111,voterMap);
        electionVotingObj.applyVotePreference(v1,candidateList.get(0));
        electionVotingObj.applyVotePreference(v1,candidateList.get(2));
        electionVotingObj.applyVotePreference(v1,candidateList.get(3));
        //[BJP, AAP,SP]
        Voter v2 = electionVotingObj.populateVoterDetails(2222,voterMap);
        electionVotingObj.applyVotePreference(v2,candidateList.get(1));
        electionVotingObj.applyVotePreference(v2,candidateList.get(2));
        electionVotingObj.applyVotePreference(v2,candidateList.get(3));
        //[Congress, AAP,SP]
        Voter v3 = electionVotingObj.populateVoterDetails(3333,voterMap);
        electionVotingObj.applyVotePreference(v3,candidateList.get(0));
        electionVotingObj.applyVotePreference(v3,candidateList.get(3));
        electionVotingObj.applyVotePreference(v3,candidateList.get(2));
        //[BJP, SP,AAP]
        Voter v4 = electionVotingObj.populateVoterDetails(4444,voterMap);
        electionVotingObj.applyVotePreference(v4,candidateList.get(1));
        electionVotingObj.applyVotePreference(v4,candidateList.get(3));
        electionVotingObj.applyVotePreference(v4,candidateList.get(2));
        //[Congress, SP,AAP]
        Voter v5 = electionVotingObj.populateVoterDetails(5555,voterMap);
        electionVotingObj.applyVotePreference(v5,candidateList.get(3));
        electionVotingObj.applyVotePreference(v5,candidateList.get(2));
        electionVotingObj.applyVotePreference(v5,candidateList.get(0));

        //[SP, AAP,BJP]


        Map<Candidate,Integer> resultMap =  electionVotingObj.calculateWinnerPoint(voterMap);

        PriorityQueue<Candidate> pq = new PriorityQueue<Candidate>(new Comparator<Candidate>(){
            public int compare(Candidate a,Candidate b ){
                return b.score-a.score;
            }
        });

        for(Map.Entry<Candidate,Integer> resultWinnerCandidate : resultMap.entrySet()){
            System.out.println("Candidate :"+ resultWinnerCandidate.getKey().candidate_id + " with score is :"+resultWinnerCandidate.getValue());
            resultWinnerCandidate.getKey().setScore(resultWinnerCandidate.getValue());
            pq.add(resultWinnerCandidate.getKey());
        }


        for(Candidate candidate : pq){
            System.out.println("Candidate :"+ candidate.candidate_id + " with score is :"+candidate.getScore());

        }





    }

    private Candidate populateCandidateDetails(int candidate_id, Party party){
        return new Candidate(candidate_id,party);
    }

    private Voter populateVoterDetails(int aadharid, Map<Integer, Voter> voterMap){
        Voter v = new Voter(aadharid,new ArrayList<>());
        voterMap.put(aadharid,v);
        return v;
    }

    private void applyVotePreference(Voter vote, Candidate candidate){
        vote.getList_candidate().add(candidate);
    }

    private Map<Candidate,Integer> calculateWinnerPoint(Map<Integer, Voter> voterMap ){


        Map<Candidate,Integer> candidateWinnerMap = new HashMap<Candidate,Integer>();


        for(Map.Entry<Integer,Voter> voterEntry : voterMap.entrySet()){

            int winner_point = 3;
            for(Candidate candidate: voterEntry.getValue().list_candidate){
                int current_existing_candidate_points = 0;
                if(candidateWinnerMap.containsKey(candidate)){
                    current_existing_candidate_points =  candidateWinnerMap.get(candidate);

                }/*else{

                }*/

                current_existing_candidate_points = current_existing_candidate_points + winner_point;
                candidateWinnerMap.put(candidate, current_existing_candidate_points);
                winner_point--;




            }



        }
        return candidateWinnerMap;
    }


}
