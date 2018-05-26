package Collections.Stack;

public class MainStacker {

    public static void main(String[] args) {
        Stacker stack = new Stacker(15);

        for (int i=1; i < 15; i++){
            stack.push(i);
        }

        for (int i = 1; i < 5; i++){
            try {
                stack.pop();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(stack.peek());
    }
}
