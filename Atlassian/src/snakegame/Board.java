package snakegame;

public class Board {
    final int ROW_COUNT,COL_COUNT;
    private Cell[][] cells;
    public Board(int rowCount, int columnCount){
        this.ROW_COUNT = rowCount;
        this.COL_COUNT = columnCount;
        cells = new Cell[this.ROW_COUNT][this.COL_COUNT];
        for(int row=0; row<ROW_COUNT; row++){
            for(int col=0; col< COL_COUNT; col++){
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
/*
    public void initializeSnakeSize(){
        int row = (int)(Math.random() * ROW_COUNT);
        int column = (int)(Math.random() * COL_COUNT);
        System.out.println("row num is:"+row);
        System.out.println("col num is:"+column);
        if(column+2<this.COL_COUNT){
            for(int i=column; i<column+2; i++){
                cells[row][i].setCellType(CellType.SNAKE_NODE);
            }
        }else if(column-2>0) {
            for (int i = column; i > column - 2; i--) {
                cells[row][i].setCellType(CellType.SNAKE_NODE);
            }
        }
    }*/
}
