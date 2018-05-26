package threads_socket_tcp_udp.udp;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Random;

public class UDPserver {
    private static final double LOSS_RATE = 0.1;
    private static int AVERAGE_DELAY = 100; //mm sec.
    private static final int PORT = 3545;

    public static void main(String[] args) {
        //To simulate packets loss
        Random random = new Random();

        System.out.println("Setting up Datagram Socket port");
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("New Datagram Socket port failed");
        }

        while (true){
            DatagramPacket request = new DatagramPacket(new byte[1024], 1024);

            try {
                socket.receive(request);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Socket receive request failed");
            }

            try {
                printData(request);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to printData request");
            }

            //Checks if random number smaller than loss rate - if it is, simulates packet loss
            if(random.nextDouble() < LOSS_RATE){
                System.out.println("Reply not sent");
                continue;
            }

            //simulates delay
            try {
                Thread.sleep((int)(random.nextDouble() * 2 * AVERAGE_DELAY));
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread failed to calculate");
            }

            //Builds up reply packet and sends it
            InetAddress clientHost = request.getAddress();
            int clientPort = request.getPort();
            byte[] buf = request.getData();

            ByteBuffer buffer = ByteBuffer.wrap(buf);
            int int1 = buffer.getInt();
            int int2 = buffer.getInt();
            int sum = int1 + int2;
            buf = ByteBuffer.allocate(4).putInt(sum).array();

            DatagramPacket reply = new DatagramPacket(buf, buf.length, clientHost, clientPort);

            try {
                socket.send(reply);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to send reply");
            }

            System.out.println("Reply sent");
        }
    }
    //printData method that prints message data to the output stream

    private static void printData(DatagramPacket request) throws Exception{
        //reference to the packets array of bytes
        //then wrap the bytes in a byte buffer
        //then initiates two ints and reads the data into buffer
        byte[] buf = request.getData();
        ByteBuffer buffer = ByteBuffer.wrap(buf);
        int int1 = buffer.getInt();
        int int2 = buffer.getInt();

        //Wraps the bytes in array of input stream - reads data as a stream of bytes
        //
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);

        //Wrap the byte array output stream in an input stream reader
        InputStreamReader isr = new InputStreamReader(bais);

        //Wrap input stream in a buffer reader
        BufferedReader br = new BufferedReader(isr);

        //Data message is contained in a single line
        String line = br.readLine();

        //Calculates sum of the two ints
        //then build up message with a string + host address and the string line
        System.out.println(int1 + int2);
        System.out.println("Recieved from " + request.getAddress().getHostAddress() + ": " + new String(line));
    }
}