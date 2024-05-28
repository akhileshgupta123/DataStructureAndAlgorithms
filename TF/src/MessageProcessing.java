public class MessageProcessing implements Runnable{


    int start;
    int end;
    int success_count = 0;
    int failure_count = 0;
    public MessageProcessing(int start, int end){
        this.start = start;
        this.end = end;

    }

    public void run(){

        for(int i = start; i<end;i++){
            try {
                this.sendMessage(i);
                success_count++;
                //Thread.sleep(1000);
            }catch(Exception ex){

                failure_count++;
            }

        }



    }

    public void sendMessage(int id){
        System.out.println("Hello "+id);
    }
}
