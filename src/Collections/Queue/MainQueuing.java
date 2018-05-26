package Collections.Queue;

public class MainQueuing {

    public static void main(String[] args) {
        Queuing que = new Queuing(12);
        for (int i = 1; i < 12; i++){
            que.insert(i);
        }

        System.out.println(que.isFull());

        for (int i = 1; i < 6; i++){
            try {
                que.remove();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(que.isEmpty());
    }
}
