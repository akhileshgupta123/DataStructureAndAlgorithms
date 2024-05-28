package snakegame;
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

public class SnakeGame {

    private Snake snake;
    private Board board;

    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;

    //public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1,
      //      DIRECTION_LEFT = -1, DIRECTION_UP = -1, DIRECTION_DOWN = 1;
    private int direction;

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    private boolean gameOver;
    public SnakeGame(Snake snake, Board board)
    {
        this.snake = snake;
        this.board = board;
    }

    private Cell getNextCell(Cell currentPosition){
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();
        if(direction == DIRECTION_RIGHT){
            col++;
        }else if(direction == DIRECTION_LEFT){
            col--;
        }else if(direction == DIRECTION_UP){
            row--;
        }else if(direction == DIRECTION_DOWN){
            row++;
        }

        Cell nextCell = board.getCells()[row][col];
        return nextCell;
    }

    public void update(){
        System.out.println("Going to update the game");
        if(!this.isGameOver()){
            Cell nextCell = getNextCell(snake.getHead());
            if(snake.checkCrash(nextCell)){
                this.gameOver = true;
            }else{
                snake.move(nextCell);
            }
        }
    }
    public static void main(String args[]){
        Board board = new Board(10, 10);
        Cell item1 = board.getCells()[0][0];
        Cell item2 = board.getCells()[0][1];
        Cell item3 = board.getCells()[0][2];
        /*Cell initPos = new Cell(0, 0);
        Cell initPos1 = new Cell(0, 1);
        Cell initPos2 = new Cell(0, 2);*/
        Snake initSnake = new Snake(item3,item2,item1);
        SnakeGame newGame = new SnakeGame(initSnake, board);

        System.out.println("col:"+initSnake.getHead().getCol());

        System.out.println("row:"+initSnake.getHead().getRow());

        System.out.println("size:"+initSnake.getSnakePartList().size());

        newGame.gameOver = false;
        newGame.direction = DIRECTION_RIGHT;


        for (int i = 0; i < 7; i++) {
            newGame.update();
            if (newGame.gameOver == true){

                System.out.println("#####the game is over");
                break;
            }

        }


        System.out.println("final snake size:"+initSnake.getSnakePartList().size());

        for(Cell obj :  newGame.snake.getSnakePartList()){
            System.out.println("The cell row is:"+obj.getRow());
            System.out.println("The cell row is:"+obj.getCol());
            System.out.println("==========================");
        }




    }
}
