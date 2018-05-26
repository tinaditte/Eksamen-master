package threads_socket_tcp_udp.thread;

import java.util.ArrayList;
import java.util.Random;

public class RaceCar implements Runnable {
    private String name = "";
    private int ditance = 0;
    private Random random = new Random();
    static ArrayList<RaceCar> place = new ArrayList<>();

    public RaceCar(String name){

        this.name = name;
    }

    @Override
    public void run() {

        while (ditance < 1000){
            ditance += 100;

            try {
                Thread.sleep(random.nextInt(500));
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }if (ditance == 1000){
            synchronized (RaceCar.class){
                System.out.print(this.name);
                place.add(this);
                System.out.println(" added to list");
            }
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
