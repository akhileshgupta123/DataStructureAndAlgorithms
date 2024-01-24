package StackQueue;
import java.util.*;
//1834. Single-Threaded CPU
public class SingleThreadCPU {
    public static void main(String args[]){
        SingleThreadCPU obj = new SingleThreadCPU();
        int tasks[][]=new int[][] {{1,2},{2,4},{3,2},{4,1}};
        //int tasks[][]=new int[][] {{7,10},{7,12},{7,5},{7,4},{7,2}};

        int result[] = obj.getOrder(tasks);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    private int[] getOrder(int[][] tasks){
        int n = tasks.length;
        int[] ans = new int[n];
        PriorityQueue<ThreadTask> taskQueue = new PriorityQueue<ThreadTask>(new Comparator<ThreadTask>(){
            public int compare(ThreadTask a, ThreadTask b){

                return a.enqueueTime-b.enqueueTime;
            }
        });

        PriorityQueue<ThreadTask> availableQueue = new PriorityQueue<ThreadTask>(new Comparator<ThreadTask>(){
            public int compare(ThreadTask a, ThreadTask b){
                if(a.processingTime==b.processingTime){
                    return a.index-b.index;
                }else{
                    return a.processingTime-b.processingTime;
                }
            }
        });








        for(int i=0;i<tasks.length;i++) {
            ThreadTask temp = new ThreadTask(i, tasks[i][0], tasks[i][1]);
            taskQueue.offer(temp);
            //availableQueue.offer(temp);
        }

        int index=0;
        int currentTime = taskQueue.peek().enqueueTime;
        //System.out.println(availableQueue.peek().enqueueTime);

        while(!taskQueue.isEmpty() || !availableQueue.isEmpty()) {


            while(!taskQueue.isEmpty() && taskQueue.peek().enqueueTime <= currentTime) {
                System.out.println("here when add in available queue"+taskQueue.peek().index);
                availableQueue.offer(taskQueue.poll());

            }

            if(!availableQueue.isEmpty()) {
                System.out.println("when fetch from available queue"+availableQueue.peek().index);
                currentTime = currentTime + availableQueue.peek().processingTime;
                ans[index++] = availableQueue.poll().index;
            } else currentTime = taskQueue.peek().enqueueTime;
        }

        return ans;
    }
}

class ThreadTask {
    int index,enqueueTime,processingTime;
    public ThreadTask(int index, int enqueueTime, int processingTime) {
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }
}
