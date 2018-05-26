package threads_socket_tcp_udp.thread;

public class Racing{

    public static void main(String[] args) {

        Racing aRace = new Racing();
    }

    public void laubching(String name){
        RaceCar rc = new RaceCar(name);
        Thread rcThread = new Thread(rc);
        rcThread.start();
    }

    public Racing(){
        laubching("Blue Car");
        laubching("Red Car");
        laubching("Green Car");
        laubching("Yellow Car");
        laubching("Pink Car");
        laubching("Purple Car");
        laubching("Orange Car");
        laubching("Violet Car");

        while (true){
            synchronized (RaceCar.class){
                if (RaceCar.place.size() == 8){
                    break;
                }
            }
        }
        System.out.println(RaceCar.place);
    }
}