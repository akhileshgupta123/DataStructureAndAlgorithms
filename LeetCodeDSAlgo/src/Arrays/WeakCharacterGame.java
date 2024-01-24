package Arrays;
import java.util.*;
//1996. The Number of Weak Characters in the Game
public class WeakCharacterGame {
    public static void main(String args[]){
        WeakCharacterGame obj = new WeakCharacterGame();
        //int properties[][] = new int[][]{{5,5},{6,3},{3,6}};
        int properties[][] = new int[][]{{2,2},{3,3}};
        int result = obj.getWeakCharacter(properties);
        System.out.println("The result is :"+result);
    }
    private int getWeakCharacter(int[][] properties){
        Arrays.sort(properties, (a,b)-> (a[0]==b[0])?a[1]-b[1]:b[0]-a[0]);



        int max = 0;
        int count = 0;
        int len = properties.length;
        for(int i=0;i<len;i++){
            System.out.println(properties[i][0]);
            System.out.println(properties[i][1]);
            System.out.println(" ");

            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }
}
