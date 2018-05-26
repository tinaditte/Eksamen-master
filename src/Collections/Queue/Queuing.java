package Collections.Queue;

import java.util.LinkedList;

public class Queuing{
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int end;
    private int totalItems;

    public Queuing(int size){
        this.maxSize = size;
        queueArray = new int[size];
    }

    public void insert(int i){
        end++;
        System.out.println("Inserted " + i);
        queueArray[end] = 1;
        totalItems++;
    }

    public int remove(){
        front++;
        totalItems--;
        System.out.println("Removed: " + queueArray[front]);
        return queueArray[front];
    }

    public boolean isFull(){
        System.out.println("Is the queue full?");
        return (totalItems == maxSize);
    }

    public boolean isEmpty(){
        System.out.println("Is the queue empty?");
        return (totalItems == 0);
    }

}
