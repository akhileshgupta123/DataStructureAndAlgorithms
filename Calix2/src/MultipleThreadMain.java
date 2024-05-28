import java.util.concurrent.Callable;
import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.*;
import java.util.concurrent.Callable.*;
class WorkverThread extends Thread {

    private int thread_number;
    WorkverThread(int number){
        this.thread_number = number;
    }
    public void run(){
        try{
            System.out.println("inside thread:"+this.thread_number);
            Thread.sleep(2000);
        }catch(InterruptedException ex){

        }
    }

    public int getThread_number() {
        return thread_number;
    }

    public void setThread_number(int thread_number) {
        this.thread_number = thread_number;
    }
}
public class MultipleThreadMain {
    public static void main(String args[]) throws InterruptedException, ExecutionException{
        //First Implementations
/*
        WorkverThread t1 = new WorkverThread(1);
        t1.start();

        WorkverThread t2 = new WorkverThread(2);
        t2.start();

        WorkverThread t3 = new WorkverThread(3);
        t3.start();

        t3.join();
        System.out.println(t1.getThread_number());
        System.out.println(t2.getThread_number());
        System.out.println(t3.getThread_number());*/



        //Second Implementations





        //ExecutorService obj = new ScheduledThreadPoolExecutor(3);
        ExecutorService obj = Executors.newFixedThreadPool(5);


        ExecutorBackGround b1 = new ExecutorBackGround("Callable1");
        Future<String> result1 = obj.submit(b1);
        ExecutorBackGround b2 = new ExecutorBackGround("Callable2");
        Future<String> result2 = obj.submit(b2);
        ExecutorBackGround b3 = new ExecutorBackGround("Callable3");
        Future<String> result3 = obj.submit(b3);



            System.out.println("result from callable 1 : "+  result1.get());
            System.out.println("result from callable 2 : "+ result2.get());
            System.out.println("result from callable 3 : "+ result3.get());
            obj.shutdown();


    }
}


class ExecutorBackGround implements Callable{
    String callable_name;
    ExecutorBackGround(String name){
        this.callable_name = name;
    }

    public String call(){
        try{
            System.out.println("Inside callable function");
            Thread.sleep(2000);
        }catch(InterruptedException ex){

        }

        return this.callable_name;
    }

}
