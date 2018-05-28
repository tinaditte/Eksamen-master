package Collections.Stack;

import java.util.Stack;

public class PlateStacker {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("One Plate");
        stack.push("Two Plate");
        stack.push("Red Plate");
        stack.push("Blue Plate");

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
    }

}
