import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> buffer;


    public Consumer(BlockingQueue<Integer> q){
        this.buffer = q;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 20; i++) {
                Thread.sleep(1500);
                int item = buffer.take();
                System.out.println("Consumed: " + item);
            }

        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
}
