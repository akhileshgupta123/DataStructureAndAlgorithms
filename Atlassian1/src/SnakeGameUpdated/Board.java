package SnakeGameUpdated;

public class Board {
    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;
    public Board(int row_count, int col_count){
        this.ROW_COUNT = row_count;
        this.COL_COUNT = col_count;
        cells = new Cell[this.ROW_COUNT][this.COL_COUNT];

        for(int row=0; row<this.ROW_COUNT; row++){
            for(int col=0; col<this.COL_COUNT; col++){
                cells[row][col] = new Cell(row,col);
            }
        }
    }

    public int getROW_COUNT() {
        return ROW_COUNT;
    }

    public int getCOL_COUNT() {
        return COL_COUNT;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
