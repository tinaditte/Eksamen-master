package threads_socket_tcp_udp.thread.deadlock;

import java.util.Arrays;

public class Incrementer {
    public static void main(String[] args) throws InterruptedException {
            String[] names = { "Florence", "Karo", "Emma" };
            D.strings = new String[]{"Kaffekanden", "Koppen"};
            System.out.printf("%s\n%d der tørster, kun én kop og én kaffekande - SÆT IGANG!\n", Arrays.stream(names).reduce((a, b) -> a + ", " + b).orElse("Ingen-one"), names.length, D.strings.length);
            Thread[] threads = new Thread[names.length];
            for (int i = 0; i < names.length; ++i) {
                (threads[i] = new Thread(new D(i, names[i]))).start();
            }
            Thread.sleep(1500);
            if (Arrays.stream(threads).anyMatch(t -> t.isAlive())) {
                System.out.println("ÅH NEJ, Deadlock!");
            }
        }

        static class D implements Runnable {
            static String[] strings;
            int number;
            String name;

            D(int number, String name) {
                this.number = number;
                this.name = name;
            }

            @Override public void run() {
                String string = strings[number % strings.length];
                System.out.printf("%s går efter %s...\n", name, string);
                System.out.flush();
                try {
                    Thread.sleep(1000);
                } catch (Exception ignore) { }
                synchronized (strings[number % strings.length]) {
                    System.out.printf("[%s] fik %s!\n", name, string);
                    System.out.flush();
                    System.out.printf("[%s] går efter %s...\n", name, strings[(number + 1) % 2]);
                    System.out.flush();
                    synchronized (strings[(number + 1) % strings.length]) {
                        System.out.printf("[%s] fik %s!\n", name, strings[(number + 1) % 2]);
                        System.out.flush();
                    }
                    System.out.printf("[%s] er færdig med %s.\n", name, strings[(number + 1) % 2]);
                    System.out.flush();
                }
                System.out.printf("[%s] er færdig med '%s'.\n", name, string);
                System.out.flush();
                System.out.printf("[%s] OVERLEVEDE\n", name, string);
            }
        }

        static class T implements Runnable {
            String name;
            static int sum = 0;
            int count = 1000000;
            T(String name) { this.name = name; }

            @Override public void run() {
                while (count --> 0) {
                    synchronized (T.class) {
                        sum++;
                    }
                }
                System.out.printf("%s sum: %d\n", name, sum);
            }
        }
    }
