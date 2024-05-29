import java.util.*;
import java.io.*;

// Subject

class Subject {                                     // 1. The "independent" abs

   private Observer[] observers = new Observer[9];  // 3. Coupled to base class

   private int        totalObs  = 0;

   private int        state;

   public void attach( Observer o ) { observers[totalObs++] = o; } // 3. Coupled

   public int  getState()           { return state; }

   public void setState( int in ) {

      state = in;

      notifyObservers(); }

   private void notifyObservers() {

      for (int i=0; i < totalObs; i++)

         observers[i].update();         // 3. Coupled to base class

}  }                                    // 5. Broadcast events to observers

 
// Observer

abstract class Observer {               // 2. Root of the "dependent" hierarchy

   protected Subject subj;

   public abstract void update(); }

 
 // Concrete Observer

class HexObserver extends Observer {    // 2. Concrete class of the "dependent" 

   public HexObserver( Subject s ) {    //    hierarchy

      subj = s;  subj.attach( this ); } // 4. Observers register themselves

   public void update() {

      System.out.print( "  " + Integer.toHexString( subj.getState() ) );

}  }                                    // 6. Observers "pull" information 

 

// Concrete Observer

class OctObserver extends Observer {

   public OctObserver( Subject s ) {

      subj = s;  subj.attach( this ); } // 4. Observers register themselves

   public void update() {

      System.out.print( "  " + Integer.toOctalString( subj.getState() ) );

}  }                                    // 6. Observers "pull" information 

 
 // Concrete Observer

class BinObserver extends Observer {

   public BinObserver( Subject s ) {

      subj = s;  subj.attach( this ); } // 4. Observers register themselves

   public void update() {

      System.out.print( "  " + Integer.toBinaryString( subj.getState() ) );

}  }                                    // 6. Observers "pull" information 

 

// Client

public class ObserverDemo1 {

   public static void main( String[] args ) {

      Subject sub = new Subject();

      // 7. Client configures the number and type of Observers

      new HexObserver( sub );  new OctObserver( sub );  new BinObserver( sub );

      //while (true) {

         System.out.print( "\nEnter a number: 10" );

         //sub.setState( Reader.anInt() );

		 sub.setState( 10 );

//} 
}  }

 