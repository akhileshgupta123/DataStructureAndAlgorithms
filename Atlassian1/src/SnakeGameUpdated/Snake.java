package SnakeGameUpdated;

import java.util.*;
public class Snake {

    private LinkedList<Cell> snakePartList = new LinkedList<Cell>();

    private Cell head;
    private int stepCount;


    public Snake(Cell initPos){
        this.head = initPos;
        this.snakePartList.add(this.head);
        this.head.setCellType(CellType.SNAKE_NODE);
        this.stepCount = 0;

    }

    public Snake(Cell first,Cell second,Cell third)
    {
        head = first;
        snakePartList.add(head);
        head.setCellType(CellType.SNAKE_NODE);

        snakePartList.add(second);
        second.setCellType(CellType.SNAKE_NODE);

        snakePartList.add(third);
        third.setCellType(CellType.SNAKE_NODE);
        this.stepCount = 0;
    }

    public LinkedList<Cell> getSnakePartList() {
        return snakePartList;
    }

    public void setSnakePartList(LinkedList<Cell> snakePartList) {
        this.snakePartList = snakePartList;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }


    public boolean checkCrash(Cell nextCell){
        System.out.println("Going to check for Crash");
        for(Cell cell: snakePartList){
            if(cell == nextCell)
                return true;

        }
        return false;

    }

    public void move(Cell nextCell){
        System.out.println("Snake is moving to "
                + nextCell.getRow() + " "
                + nextCell.getCol());
        stepCount++;

        if(stepCount%5==0){

            System.out.println("not delete node");
        }else{
            Cell tail = this.snakePartList.removeLast();
            tail.setCellType(CellType.EMPTY);
        }

        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartList.addFirst(head);

    }
}
