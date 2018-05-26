package threads_socket_tcp_udp.Socket_threads;

import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientHandler extends Thread {
    DateFormat getdate = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat gettime = new SimpleDateFormat("hh:mm");
    final DataInputStream input;
    final DataOutputStream output;
    final Socket link;

    public ClientHandler(Socket link, DataInputStream input, DataOutputStream output) {
        this.link = link;
        this.input = input;
        this.output = output;
    }

    public void run(){
        String receivedMessage;
        String returnMessage;

        while (true){
            try {
                output.writeUTF("You have following options: \n" +
                        "Type 'date' to get the Date of today.\n" +
                        "Type 'time' to get the time now\n" + "Type 'EXIT' to terminate the connection");

                receivedMessage = input.readUTF();

                if(receivedMessage.equals("EXIT")){
                    System.out.println("Client " + this.link + " exits");
                    System.out.println("Terminate connecting");
                    this.link.close();
                    System.out.println("Connection terminated");
                    break;
                }

                Date date = new Date();

                switch (receivedMessage){
                    case "date" : returnMessage = getdate.format(date);
                    output.writeUTF(returnMessage);
                    break;

                    case "time" : returnMessage = gettime.format(date);
                    output.writeUTF(returnMessage);
                    break;

                    default: output.writeUTF("Invalid input, try again.");
                    break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try {
            this.input.close();
            this.output.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
