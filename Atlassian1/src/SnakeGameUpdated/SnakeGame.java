package SnakeGameUpdated;

public class SnakeGame {

    private Snake snake;
    private Board board;
    private static final int DIRECTION_NONE =0, DIRECTION_LEFT = -1, DIRECTION_RIGHT = 1,DIRECTION_UP = 2,DIRECTION_DOWN=-2;
    private int direction;
    private boolean gameOver;

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

        System.out.println("########the row and col");
        System.out.println(row);
        System.out.println(col);
        Cell nextCell = board.getCells()[row][col];
        return nextCell;
    }

    public void update(){
        System.out.println("Going to update the game");

        if(!this.isGameOver()){
            Cell cell = this.getNextCell(snake.getHead());
            if(snake.checkCrash(cell)){
                this.gameOver=true;
            }else{
                this.snake.move(cell);
            }

        }
    }

    public static void main(String[] args){

        Board board = new Board(10,10);
        Cell item1 = board.getCells()[0][0];
        Cell item2 = board.getCells()[0][1];
        Cell item3 = board.getCells()[0][2];

        Snake initSnake = new Snake(item3,item2,item1);

        SnakeGame newGame = new SnakeGame(initSnake, board);

        System.out.println("col:"+initSnake.getHead().getCol());

        System.out.println("row:"+initSnake.getHead().getRow());

        System.out.println("size:"+initSnake.getSnakePartList().size());

        newGame.gameOver = false;
        newGame.direction = DIRECTION_RIGHT;
        /*for (int i = 0; i < 7; i++) {
            newGame.update();
            if (newGame.gameOver == true){

                System.out.println("#####the game is over");
                break;
            }
        }*/

        while(!newGame.gameOver){

            Cell currcell = newGame.snake.getHead();
            if(currcell.getCol()== board.COL_COUNT-1){
                System.out.println("########inside here");
                if(currcell.getRow()!=board.ROW_COUNT-1){
                    newGame.direction = DIRECTION_DOWN;
                }else{
                    newGame.direction = DIRECTION_LEFT;
                }
            }else if(currcell.getRow()== board.ROW_COUNT-1){
                System.out.println("########inside else");
                if(currcell.getCol()!=board.COL_COUNT-1){
                    newGame.direction = DIRECTION_UP;
                }else{
                    newGame.direction = DIRECTION_DOWN;
                }
            }else if(currcell.getRow()==0 && currcell.getCol()!=0){
                newGame.direction = DIRECTION_RIGHT;
            }/*else if(currcell.getCol()==0 && currcell.getRow()!=){
                newGame.direction = DIRECTION_RIGHT;
            }*/

            System.out.println("The curr row is :"+currcell.getRow());
            System.out.println("The curr col is :"+currcell.getCol());

            System.out.println("The curr direction is :"+newGame.direction);
            newGame.update();

        }

        System.out.println("final snake size:"+initSnake.getSnakePartList().size());


        System.out.println("final snake size:"+initSnake.getSnakePartList().size());

        for(Cell obj :  newGame.snake.getSnakePartList()){
            System.out.println("The cell row is:"+obj.getRow());
            System.out.println("The cell row is:"+obj.getCol());
            System.out.println("==========================");
        }

    }
}
