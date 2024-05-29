package SnakeGame1;
import java.util.*;

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
    int[][] food;
    int foodIndex;
    int width;
    int height;
    int[] head;
    Deque<int[]> snake;
    Set<String> snakeParts;

    public SnakeGame(int width, int height, int[][] food){
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<int[]>();
        snakeParts = new HashSet<String>();
        head = new int[]{0,0};
        snake.offerFirst(head);
        snakeParts.add(Arrays.toString(head));
    }

    public int move(String direction){
        int[] newHead = this.head.clone();
        if(direction.equals("U"))
            newHead[0]--;
        else if(direction.equals("L"))
            newHead[1]--;
        else if(direction.equals("R"))
            newHead[1]++;
        else if(direction.equals("D"))
            newHead[0]++;

        String newHeadStr = Arrays.toString(newHead);
        int[] tail = snake.pollLast();
        snakeParts.remove(Arrays.toString(tail));

        if(newHead[0]<0 || newHead[0] == height ||
        newHead[1] <0 || newHead[1] == width || snakeParts.contains(newHeadStr)){
            return -1;
        }

        if(foodIndex < food.length &&
                food[foodIndex][0] == newHead[0] &&
                food[foodIndex][1] == newHead[1]){
            snake.offerFirst(newHead);
            snakeParts.add(newHeadStr);
            head = newHead;
            foodIndex++;
            snake.offerLast(tail);
            snakeParts.add(Arrays.toString(tail));
        }else{
            snake.offerFirst(newHead);
            snakeParts.add(newHeadStr);
            head = newHead;
        }

        return snake.size()-1;
    }
}
