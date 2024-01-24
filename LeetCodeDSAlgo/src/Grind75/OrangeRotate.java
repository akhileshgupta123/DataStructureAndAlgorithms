package Grind75;
//994. Rotting Oranges
public class OrangeRotate {
    public static void main(String args[]){
        OrangeRotate obj = new OrangeRotate();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};

        int result = obj.orangesRotting(grid);

        System.out.println(result);


    }


    public int orangesRotting(int[][] grid){
        if(grid == null || grid.length == 0) return -1;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2)
                    rotAdjacent(grid, i, j, 2);
            }
        }

        int minutes = 2;

        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i<0 || i>= grid.length || j <0 || j>=grid[0].length || grid[i][j] == 0 || (1 < grid[i][j] && grid[i][j] < minutes)) {
            return;
        }else{

            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}
