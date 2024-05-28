import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<Integer> buffer;


    public Producer(BlockingQueue<Integer> q){
        this.buffer = q;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 20; i++) {
                Thread.sleep(1000);
                int item = i;
                buffer.put(item);
                System.out.println("Produced: " + item);
            }

        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
}
