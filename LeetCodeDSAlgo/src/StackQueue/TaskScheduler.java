package StackQueue;
import java.util.*;
//621. Task Scheduler
public class TaskScheduler {
    public static void main(String args[]){

        char tasks[] = new char[]{'A','A','A','B','B','B'};
        int n = 2;
        TaskScheduler obj = new TaskScheduler();
        int result = obj.leastInterval(tasks,n);

        System.out.println(result);

    }

    private int leastInterval(char tasks[], int n){
        HashMap<Character,Integer>hm = new HashMap<Character,Integer>();
        for(char ch:tasks)
            hm.put(ch,(hm.getOrDefault(ch,0)+1));


        Queue<Integer>pq=new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });






        pq.addAll(hm.values());
        int result=0;


        while(!pq.isEmpty()){
            int time=0;

            List<Integer>tmp=new ArrayList<Integer>();
            for(int i=0;i<n+1;i++)
            {
                if(!pq.isEmpty())
                {
                    tmp.add(pq.poll()-1);
                    time++;
                }
            }
            System.out.println(tmp);
            System.out.println(time);
            for(int l:tmp)
            {
                if(l>0)
                    pq.add(l);
            }
            result+=pq.isEmpty()?time:n+1;

            System.out.println("result:"+result);
        }

        return result;

    }
}
