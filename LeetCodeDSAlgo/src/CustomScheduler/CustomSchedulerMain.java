package CustomScheduler;
import java.util.concurrent.*;
import java.util.concurrent.ScheduledExecutorService.*;
public class CustomSchedulerMain {
    public static void main(String args[]){
        try{

            ScheduledExecutorService testService = Executors.newScheduledThreadPool(5);
            testService.scheduleAtFixedRate(new ScheduleTask(testService),60,60,TimeUnit.SECONDS);
        }catch(Exception ex){
            System.out.println("exception inside here:"+ex.getMessage());
            throw ex;
        }
    }
}
