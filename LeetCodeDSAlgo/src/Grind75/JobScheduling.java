package Grind75;
import java.util.*;

/*
* Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline.
* It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
* Maximize the total profit if only one job can be scheduled at a time.
* */
public class JobScheduling {

    public static void main(String args[]){
        List<Job> jobList = new ArrayList<Job>();
        jobList.add(new Job('a',2,100));
        jobList.add(new Job('b',1,19));
        jobList.add(new Job('c',2,27));
        jobList.add(new Job('d',1,25));
        jobList.add(new Job('e',3,15));

        JobScheduling obj = new JobScheduling();
        obj.printJobScheduling(jobList,3);
    }

    public void printJobScheduling(List<Job> jobList , int t){
        int n = jobList.size();

        ArrayList<Job> result = new ArrayList<>();


        PriorityQueue<Job> sourceHeap = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.deadline - o2.deadline;
            }
        });


        for(Job job: jobList){
            sourceHeap.add(job);
        }

        jobList  = new ArrayList<>();
        while(!sourceHeap.isEmpty()){
            jobList.add(sourceHeap.poll());
        }

        PriorityQueue<Job> maxHeap = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });

        for (int i = n - 1; i > -1; i--) {
            int slot_available;

            if (i == 0) {
                slot_available = jobList.get(i).deadline;
            }
            else {
                slot_available = jobList.get(i).deadline
                        - jobList.get(i - 1).deadline;
            }


            maxHeap.add(jobList.get(i));

            while (slot_available > 0
                    && maxHeap.size() > 0) {

                // get the job with max_profit
                Job job = maxHeap.remove();

                // reduce the slots
                slot_available--;

                // include the job in the result array
                result.add(job);
            }
        }




        for (Job job : result) {
            System.out.print(job.id + " ");
        }

        System.out.println();

    }
}
class Job{
    public char id;
    public int deadline, profit;
    public Job(char id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
