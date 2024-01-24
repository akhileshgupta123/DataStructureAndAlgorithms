package Voting;

import java.util.HashMap;
import java.util.Scanner;

public class DigitalVoting {
    public static void main(String args[]){

        HashMap<Nominee,Nominee> NomineeDetails = new HashMap<Nominee, Nominee>();
        HashMap<Votes,Integer> VoterDetails = new HashMap<Votes, Integer>();
        HashMap<Votes,Votes> UserDetails = new HashMap<Votes,Votes>();
        NomineeDetails.put(new Nominee(1),new Nominee("TRS"));
        NomineeDetails.put(new Nominee(2),new Nominee("BJP"));
        NomineeDetails.put(new Nominee(3),new Nominee("CONGRESS"));
        NomineeDetails.put(new Nominee(4),new Nominee("CPI"));
        System.out.println("Welcome to virtual voting");
        System.out.println("Pls enter no of voters");

        Scanner sc = new Scanner(System.in);
        int voters = sc.nextInt();
        while(voters!=0){
            System.out.println("enter last 4 digits of your aadhar");
            int VoterId = sc.nextInt();
            System.out.println("Enter voter name");
            String VoterName = sc.next();

            System.out.println("Choose whom to vote");
            System.out.println("for TRS enter 1");
            System.out.println("for BJP enter 2");
            System.out.println("for CONGRESS enter 3");
            System.out.println("for CPI enter 4");
            int NomineeId = sc.nextInt();
            Votes v = new Votes(VoterId);
            if(VoterDetails.keySet().contains(v)) {
                System.out.println("You have already voted");
            }
            else{
                VoterDetails.put(new Votes(VoterId), NomineeId);
                UserDetails.put(new Votes(VoterId),new Votes(VoterName));
            }
            voters--;
        }

        int winners = 0;
        int TrsVotes,BjpVotes,CongressVotes,CpiVotes;
        TrsVotes=BjpVotes=CongressVotes=CpiVotes=0;
        System.out.println("Displaying TRS party voters: ");



        for (Votes key : VoterDetails.keySet()) {
            if (VoterDetails.get(key).equals(1)) {
                key.printdetails();
                TrsVotes++;
            }else if (VoterDetails.get(key).equals(2)) {
                key.printdetails();
                BjpVotes++;
            }else if (VoterDetails.get(key).equals(3)) {
                key.printdetails();
                CongressVotes++;
            }else if (VoterDetails.get(key).equals(4)) {
                key.printdetails();
                CpiVotes++;
            }
        }


        int max = (Math.max(TrsVotes,Math.max(BjpVotes,Math.max(CongressVotes,CpiVotes))));
        if(TrsVotes == max){
            System.out.println("TRS has max votes");
            winners++;
        }
        if(BjpVotes == max){
            System.out.println("BJP has max votes");
            winners++;
        }
        if(CongressVotes == max){
            System.out.println("Congress has max votes");
            winners++;
        }
        if(CpiVotes == max){
            System.out.println("Cpi has max votes");
            winners++;
        }
        if(winners>1){
            System.out.println("Hence it is draw");
        }
    }
}
