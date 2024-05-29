package SnakeGameUpdated;

public class Cell {
    private final int row,col;
    CellType cellType;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellType = CellType.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
