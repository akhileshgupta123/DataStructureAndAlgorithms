package Hashing;
import java.util.*;
//2365. Task Scheduler II
public class TaskScheduler {
    public static void main(String args[]){
        TaskScheduler obj = new TaskScheduler();
        int tasks[] = new int[]{1,2,1,2,3,1};
        int space = 3;
        //int tasks[] = new int[]{1,2,1,2,1,2};
        //int space = 2;
        int result = obj.getTaskSchedulerII(tasks,space);
        System.out.println("result is :"+result);
    }

    private int getTaskSchedulerII(int[] tasks, int space){
        int currDay=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<tasks.length;i++) {
            int task=tasks[i];
            if(!map.containsKey(task)){
                //map.put(tasks[i],currDay);
            }else{
                int lastDay=map.get(task);
                int taskGap=currDay-lastDay;
                if(taskGap<=space){
                    currDay +=space-taskGap+1;
                }

            }
            map.put(tasks[i],currDay);
            ++currDay;
        }
        return currDay;
    }
}
