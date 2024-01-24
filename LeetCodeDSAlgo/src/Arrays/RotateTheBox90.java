package Arrays;
//1861. Rotating the Box
public class RotateTheBox90 {
    public static void main(String args[]){
        RotateTheBox90 obj = new RotateTheBox90();

        char box[][] = new char[][]{{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};

        char result[][] = obj.getRotateBox(box);

        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[0].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    private char[][] getRotateBox(char[][] box){
        int r = box.length, c = box[0].length;
        char[][] box2 = new char[c][r];


        for(int i = 0; i<r; ++i){
            int empty = c-1;
            for(int j = c-1; j>=0; --j){
                if(box[i][j] == '*'){
                    empty = j-1;
                }
                if(box[i][j] == '#'){
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    --empty;
                }
            }
        }
        for(int i = 0; i<r; ++i){
            for(int j = c-1; j>=0; --j)
                box2[j][r-i-1] = box[i][j];
        }
        return box2;
    }
}
