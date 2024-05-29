/**
  * An abstract class that is common to several games in
  * which players play against the others, but only one is
  * playing at a given time.
  */

  //abstract class
 
 abstract class Game {
 
     private int playersCount;
 
     abstract void initializeGame();
 
     abstract void makePlay(int player);
 
     abstract boolean endOfGame();
 
     abstract void printWinner();
 
     /* A template method : */
     final void playOneGame(int playersCount) {
         this.playersCount = playersCount;
         initializeGame();
         int j = 0;
         while (!endOfGame()){
             makePlay(j);
             j = (j + 1) % playersCount;
         }
         printWinner();
     }
 }
 
//Now we can extend this class in order to implement actual games:

//Concrete class
 
 class Monopoly extends Game {
 
     /* Implementation of necessary concrete methods */
 
     void initializeGame() {
         // ...
		 System.out.println("Monopoly game initialized.");
     }
 
     void makePlay(int player) {
         // ...
		 System.out.println("Monopoly game Played by Player :"+player);
     }
 
     boolean endOfGame() {
         // ...
		  System.out.println("Monopoly game is over.");
		 return true;
     }
 
     void printWinner() {
         // ...
		  System.out.println("Winner.");
     }
 
     /* Specific declarations for the Monopoly game. */
 
     // ...
 
 }
 
 // Concrete class

 class Chess extends Game {
 
       /* Implementation of necessary concrete methods */
 
     void initializeGame() {
         // ...
		 System.out.println("Monopoly game initialized.");
     }
 
     void makePlay(int player) {
         // ...
		 System.out.println("Monopoly game Played by Player :"+player);
     }
 
     boolean endOfGame() {
         // ...
		  System.out.println("Monopoly game is over.");
		 return true;
     }
 
     void printWinner() {
         // ...
		  System.out.println("Winner.");
     }
 
     /* Specific declarations for the chess game. */
 
     // ...
 
 }

//Client

class TemplateMethodDemo
{
	public static void main(String args[])
	{
		Chess obj = new Chess();
		obj.playOneGame(1);

	}
}