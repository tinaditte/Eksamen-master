package Collections.Stack;

public class Stacker {

    private int stacksize;
    private int[] array;
    private int top;

    public Stacker(int size){
        this.stacksize = size;
        this.array = new int[stacksize];
        this.top = -1;
    }

    public boolean isStackEmpty(){
        if (top < 0){
            return true;
        }else
            return false;
    }

    public boolean isStackFull(){
        if (top == stacksize - 1){
            return true;
        }else
            return false;
    }

    public void push(int entry){
        if (this.isStackFull()){
            System.out.println("Stack is full. Increasing the capacity...");
            this.increaseStackCap();
        }
        System.out.println("Adding: " + entry);
        this.array[++top] = entry;
    }

    public int pop() {
        if (this.isStackEmpty()){
            System.out.println("Stack is empty.");
        }
        int entry = this.array[top--];
        System.out.println("Entry removed: " + entry);
        return entry;
    }

    public int peek(){
        return array[top];
    }

    private void increaseStackCap() {
        int[] newStack = new int[this.stacksize*2];

        for (int i = 0; i < stacksize; i++){
            newStack[i] = this.array[i];
        }

        this.array = newStack;
        this.stacksize = this.stacksize*2;
    }
}
