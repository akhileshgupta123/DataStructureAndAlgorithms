package SnakeGame1;

/*
*
* [ 1, 2, 3, 4, 5
* 4, 5, 6, 7, 8
* 7, 8 , 9 , 10, 11
* 1,1,1,1,1
* 2,3,4,5,6]
*
*
* */

/*
/*\



Problem Description:
Remember the old phone game of Snake? If not, let’s look at this first:
The snake can move up, down, left or right in a 2-dimensional board of arbitrary size.
Let’s try to implement the base logic of this game.
Rules:
- Every time moveSnake() is called, the snake moves up, down, left or right
- The snake’s initial size is 3 and grows by 1 every 5 steps
- The game ends when the snake hits itself

We can use the following as a starting point (pseudo-code):

Problem
interfaceSnakeGame{
 moveSnake(snakeDirection);
 isGameOver();
}

 */

public class SnakeGameClient {
    public static void main(String[] args){
        System.out.println("inside snake game client");

        int width = 3;
        int height = 3;
        int[][] food = new int[][]{{0,1},{1,0},{2,2}};

        SnakeGameClient obj = new SnakeGameClient();

        SnakeGame game = new SnakeGame(3,3,food);

        int result = game.move("D");


        System.out.println(result);
    }
}
