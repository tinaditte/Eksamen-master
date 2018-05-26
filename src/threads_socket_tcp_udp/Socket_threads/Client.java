package threads_socket_tcp_udp.Socket_threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static InetAddress host;
    private static final int PORT = 6543;

    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        }catch (java.net.UnknownHostException uhe){
            System.out.println("Unable to locate host");
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer(){
        Socket link = null;

        try {
            System.out.println("Requesting connection...");
            link = new Socket(host, PORT);
        } catch (IOException e) {
            System.out.println("Connection request failed, unable to connect");
            e.printStackTrace();
        }

        try{
            Scanner scanner = new Scanner(System.in);
            DataInputStream input = new DataInputStream(link.getInputStream());
            DataOutputStream output = new DataOutputStream(link.getOutputStream());

            while (true){
                System.out.println(input.readUTF());
                String sendMessage = scanner.nextLine();
                output.writeUTF(sendMessage);

                if (sendMessage.equals("EXIT")){
                    System.out.println("Closing the connection for: " + link);
                    link.close();
                    System.out.println("The connection has been terminated");
                    break;
                }

                String receiveMessage = input.readUTF();
                System.out.println(receiveMessage);
            }

            scanner.close();
            input.close();
            output.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
