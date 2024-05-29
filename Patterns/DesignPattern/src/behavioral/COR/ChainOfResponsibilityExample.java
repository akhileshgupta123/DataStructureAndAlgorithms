import java.util.*;

//Handler

abstract class Logger 
{
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;
    protected int mask;
 
    // The next element in the chain of responsibility
    protected Logger next;
    public Logger setNext( Logger l)
    {
        next = l;
        return l;
    }
 
    public void message( String msg, int priority )
    {
		System.out.println("priority:"+priority);
		System.out.println("mask:"+mask);
		

        if ( priority <= mask ) 
        {
            writeMessage( msg );
            if ( next != null )
            {
				System.out.println("next:"+next.toString());
                next.message( msg, priority );
            }
        }
    }
 
    abstract protected void writeMessage( String msg );
 
}

//ConcreteHandler1
 
class StdoutLogger extends Logger 
{
 
    public StdoutLogger( int mask ) { this.mask = mask; }
 
    protected void writeMessage( String msg )
    {
        System.out.println( "Writing to stdout: " + msg );
    }
}
 

//ConcreteHandler2
 
class EmailLogger extends Logger 
{
 
    public EmailLogger( int mask ) { this.mask = mask; }
 
    protected void writeMessage( String msg )
    {
        System.out.println( "Sending via email: " + msg );
    }
}
 
//ConcreteHandler3

class StderrLogger extends Logger 
{
 
    public StderrLogger( int mask ) { this.mask = mask; }
 
    protected void writeMessage( String msg )
    {
        System.out.println( "Sending to stderr: " + msg );
    }
}
 
// Client

public class ChainOfResponsibilityExample
{
    public static void main( String[] args )
    {
		// Build the chain of responsibility
        Logger l,l1;
        l1 = l = new StdoutLogger( Logger.DEBUG ); // Logger.DEBUG = 7
        l1 = l1.setNext(new EmailLogger( Logger.NOTICE )); // Logger.NOTICE = 5
        l1 = l1.setNext(new StderrLogger( Logger.ERR ));  // Logger.ERR = 3
 
        // Handled by StdoutLogger
        l.message( "Entering function y.", Logger.DEBUG );
 
        // Handled by StdoutLogger and EmailLogger
        l.message( "Step1 completed.", Logger.NOTICE );
 
        // Handled by all three loggers
        l.message( "An error has occurred.", Logger.ERR );
    }
}

 

