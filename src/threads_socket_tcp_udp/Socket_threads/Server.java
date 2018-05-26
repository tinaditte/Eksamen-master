package threads_socket_tcp_udp.Socket_threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 6543;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        //Running til terminated
        while (true){
            Socket link = null;

            System.out.println("Waiting for client...");
            try {
                serverSocket = new ServerSocket(PORT);
            }catch (IOException ex){
            }

            try {
                link = serverSocket.accept();

                System.out.println("Client is connecting at: " + link);

                DataInputStream input = new DataInputStream(link.getInputStream());
                DataOutputStream output = new DataOutputStream(link.getOutputStream());

                System.out.println("Assigning thread for client");

                Thread thread = new ClientHandler(link, input, output);

                thread.start();

            }catch (IOException e){
                System.out.println("Connection error");
                e.printStackTrace();
            }
        }
    }
}
