package CustomScheduler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledExecutorService.*;

public class ScheduleTask implements Runnable{

    private ScheduledExecutorService testService;
    public ScheduleTask(ScheduledExecutorService test ){
        this.testService = test;
    }
    @Override
    public void run() {
        try{

            System.out.println("Inside run method");
        }catch(Exception ex){
            System.out.println("Exception inside run"+ex.getMessage());
        }
    }
}
