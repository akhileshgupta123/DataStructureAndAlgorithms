import java.io.*;

// Context

class Chain {
	
	// Maintain state of concrete subclass
    private State current; 

    public Chain()                  { current = new Off(); }

    public void setState( State s ) { current = s; }

    public void pull()              { current.pull( this ); }

}

 
// Interface State

abstract class State {

    public void pull( Chain wrapper ) {

        wrapper.setState( new Off() );

        System.out.println( "   turning off" );

}   }

//Concretestate subclass 

class Off extends State {

    public void pull( Chain wrapper ) {

        wrapper.setState( new Low() );

        System.out.println( "   low speed" );

}   }

 
//Concretestate subclass 

class Low extends State {

    public void pull( Chain wrapper ) {

        wrapper.setState( new Medium() );

        System.out.println( "   medium speed" );

}   }

//Concretestate subclass 

class Medium extends State {

    public void pull( Chain wrapper ) {

        wrapper.setState( new High() );

        System.out.println( "   high speed" );

}   }

 
//Concretestate subclass 

class High extends State { }

 
// Client

public class StateDemo {

    public static void main( String[] args ) throws IOException {

        InputStreamReader is = new InputStreamReader( System.in );

        int ch;

        Chain chain = new Chain();
	
		int count =0;

	   while (count<4) {

			count++;

            System.out.print( "Press 'Enter'" );

            ch = is.read();    ch = is.read();

            chain.pull();
		}
	}
}