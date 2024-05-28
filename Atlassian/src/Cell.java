public class Cell {
    private int row;
    private int col;
    private int[][] cellItem;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellItem = new int[row][col];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getCellItem() {
        return cellItem;
    }

    public void setCellItem(int[][] cellItem) {
        this.cellItem = cellItem;
    }
}
