package Collections.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class CattleQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Maren");
        queue.offer("Karen");
        queue.offer("Karsten");
        queue.offer("Larsen");

        System.out.println("Først kom: " + queue.poll() + " på græs");
        System.out.println("Så kom: " + queue.poll()+ " på græs");
        System.out.println("Dernæst: " + queue.poll()+ " på græs");
        System.out.println("Til sidst: " + queue.poll() + " på græs");
        System.out.println("Vi venter endnu på " + queue.peek() + " i kostalden.");
    }
}
