//mediator

interface MedIntf
{
	 public void storeMessage( int num );
	  public int retrieveMessage() ;

}

//concrete mediator

class Mediator implements MedIntf {                        // 1. The "intermediary" 

   private boolean slotFull = false;    // 4. The Mediator arbitrates

   private int     number;

   public synchronized void storeMessage( int num ) {

      while (slotFull == true)          // no room for another message

         try { wait(); } catch (InterruptedException e ) { }

      slotFull = true;

      number = num;

      notifyAll();

   }

   public synchronized int retrieveMessage() {

      while (slotFull == false)         // no message to retrieve

         try { wait(); } catch (InterruptedException e ) { }

      slotFull = false;

      notifyAll();

      return number;

}  }


//concrete colleague

class Producer extends Thread {

   private Mediator med;                // 2. Producers are coupled only to

   private int      id;                 //    the Mediator

   private static int num = 1;

   public Producer( Mediator m ) { med = m;  id = num++; }

   public void run() {

      int num;

      while (true) {

         med.storeMessage( num = (int)(Math.random()*100) );

         System.out.print( "p" + id + "-" + num + "   " );

}  }  }

 
//concrete colleague

class Consumer extends Thread {

   private Mediator med;                // 3. Consumers are coupled only to

   private int      id;                 //    the Mediator

   private static int num = 1;

   public Consumer( Mediator m ) { med = m;  id = num++; }

   public void run() {

      while (true) {

         System.out.print( "c" + id + "-" + med.retrieveMessage() + "   " );

}  }  }

 

class MediatorDemo1 {

   public static void main( String[] args ) {

      Mediator mb = new Mediator();

      new Producer( mb ).start();

      new Producer( mb ).start();

      new Consumer( mb ).start();

      new Consumer( mb ).start();

      new Consumer( mb ).start();

      new Consumer( mb ).start();

}  }