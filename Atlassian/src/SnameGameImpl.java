public class SnameGameImpl implements SnakeGameIntf{
    private Cell cell;
    int curr_row;
    int curr_col;
    public SnameGameImpl(Cell cell, int curr_row, int curr_col){
        this.cell = cell;

        this.curr_row = curr_row;
        this.curr_col = curr_col;
    }
    @Override
    public void moveSnake(Enum direction) {


        if(direction==Direction.UP){
            this.cell.getCellItem()[this.curr_row-1][this.curr_col] = 1;
            this.curr_row = this.curr_row-1;
        }else if(direction == Direction.DOWN){
            this.cell.getCellItem()[this.curr_row+1][this.curr_col] = 1;
            this.curr_row = this.curr_row+1;
        }else if(direction == Direction.LEFT){
            this.cell.getCellItem()[this.curr_row][this.curr_col-1] = 1;
            this.curr_col = this.curr_col-1;
        }else if(direction == Direction.RIGHT){
            this.cell.getCellItem()[this.curr_row][this.curr_col+1] = 1;
            this.curr_col = this.curr_col+1;
        }


    }

    @Override
    public boolean isGameOver() {
        if(this.cell.getCellItem()[curr_row][curr_col]==1){
            return true;
        }
        return false;
    }
}
