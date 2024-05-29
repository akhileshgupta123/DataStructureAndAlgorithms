/**
* Iterator interface has method declarations for iterating through
* TV channels. All remote controls implement Iterator.
*/

// Iterator Interface
interface Iterator {
  	public Channel nextChannel(int currentChannel);
	public Channel prevChannel(int currentChannel);
}// End of interface


/**
* ChannelSurfer is a part of remote control which implements the Iterator
* interface. This class overrides the nextChannel and prevChannel methods.
*/


// Concrete Iterator

class ChannelSurfer implements Iterator {
  	/**
* nextChannel – method which takes the current channel number
* and returns the next channel.
*/
public Channel nextChannel (int currentChannel) {
  	  	Channel channel = new Channel(currentChannel+1);
		System.out.println("Next Channel no. "+(currentChannel+1)+" return");
return channel;
  	 } 	  	 
  	/**
* prevChannel – method which takes the current channel number
* and returns the previous channel.
*/
public Channel prevChannel (int currentChannel) {
  	  	  	Channel channel = new Channel(currentChannel-1);
			System.out.println("Previous Channel no. "+(currentChannel-1)+" return");
return channel;
  	} 	 
}// End of class


// Aggregate Interface
interface CreateIteratorIntf {
  	public Program getProgram(ChannelSurfer surfer);
}// End of interface


/**
* RemoteControl class is the actual remote control and it behaves and makes
* use of ChannelSurfer.
*/

// Concrete Aggregate

class RemoteControl implements CreateIteratorIntf{
  	private ChannelSurfer surfer;
	

public RemoteControl() {
  	  	surfer = new ChannelSurfer();		
  	 } 	 
  	/**
* getProgram returns the program for that channel.
*
*/
public Program getProgram(ChannelSurfer surfer) {
		
		System.out.println("return the program for selected channel.");
  	  	return new Program(surfer.nextChannel(5));
  	 } 	  	 
}// End of class

class Program
{
	Program(Channel channel)
	{
	}
}

class Channel 
{
	Channel(int channel_no)
	{
	}
}

public class IteratorExample
{
	public static void main(String args[])
	{
		RemoteControl obj = new RemoteControl();
		obj.getProgram(new ChannelSurfer());
	}
}