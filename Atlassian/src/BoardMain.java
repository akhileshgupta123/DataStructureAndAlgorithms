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


public class BoardMain {
    private int up = -1;
    private int down = +1;
    private int left = -1;
    private int right = +1;
    public static void main(String args[]){
        Cell cellObj = new Cell(8,8);

        //TBD
        cellObj.getCellItem()[0][0] = 1;
        cellObj.getCellItem()[1][0] = 1;
        cellObj.getCellItem()[2][0] = 1;
        int currrow = 0;
        int currcol = 0;
        SnakeGameIntf obj  = new SnameGameImpl(cellObj,currrow,currcol);

        if(obj.isGameOver()){
            obj.moveSnake(Direction.RIGHT);
        }


        obj.moveSnake(Direction.DOWN);

        obj.moveSnake(Direction.UP);


    }
}
