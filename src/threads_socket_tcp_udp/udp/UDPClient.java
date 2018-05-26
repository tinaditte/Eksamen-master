package threads_socket_tcp_udp.udp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Created by tinab on 2/12/2018.
 */
public class UDPClient {
    private static final int NUMBER_OF_PACKETS = 10;
    private static final int DELAY = 1000;  // milliseconds
    private static final int WAIT_ACK = 1000;  // milliseconds

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Required arguments: server.IP-adr server.port#");  //evt. Client.port#
            return;
        }
        // Server IP and Port#.
        InetAddress serverHost = InetAddress.getByName(args[0]);
        int         serverPort = Integer.parseInt(args[1]);

        // Client IP and Port#.
        InetAddress clientHost = InetAddress.getLocalHost();
        // int         clientPort = 4712; //evt. = Integer.parseInt(args[2]);


        DatagramSocket socket = new DatagramSocket();// evt. = new DatagramSocket(clientPort); // System choose port#
        //clientPort = socket.getPort();

        // Create a datagram packet to hold outgoing UDP packet.
        DatagramPacket msgOut = new DatagramPacket(new byte[1024], 0);

        // Create a datagram packet to hold incoming UDP packet.
        DatagramPacket msgAck = new DatagramPacket(new byte[1024], 1024);

        // Processing loop.
        for (int i=1;i <= NUMBER_OF_PACKETS;i++) {
            // Send "i" msg-packets.
            String s = "MSG " + i + " from: " + clientHost + ", " + socket.getLocalSocketAddress(); //clientPort;
            byte[] buf = s.getBytes();     // raw data iso String

            Scanner userEntry = new Scanner(System.in);
            Integer int1;
            Integer int2;

            System.out.println("Enter first number");
            int1 = userEntry.nextInt();
            int2 = userEntry.nextInt();
            buf = ByteBuffer.allocate(8).putInt(int1).putInt(int2).array();

            msgOut = new DatagramPacket(new byte[8], 8, serverHost, serverPort);
            msgOut.setData(buf);
            socket.send(msgOut);
            System.out.println("         Message " + i + " sent.");

            // Block max WAIT_ACK millisec until the host receives a UDP packet.
            try {
                socket.setSoTimeout(WAIT_ACK);
                socket.receive(msgAck);
                // Print the recieved data.
                printData(msgAck);
            }
            catch (SocketTimeoutException e) {
                System.out.println("   Missing ACK from message# " + i + "!");//i=i-1;
                continue;
            }
            finally {
                // Delay between packets.
                Thread.sleep(DELAY);
            }
        }
    }
    /*
    * Print msg data to the standard output stream.
    */
    private static void printData(DatagramPacket request) throws Exception
    {
        // Obtain references to the packet's array of bytes.
        byte[] buf = request.getData();

        // Wrap the bytes in a byte array input stream,
        // so that you can read the data as a stream of bytes.
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);

        // Wrap the byte array output stream in an input stream reader,
        // so you can read the data as a stream of characters.
        InputStreamReader isr = new InputStreamReader(bais);

        // Wrap the input stream reader in a bufferred reader,
        // so you can read the character data a line at a time.
        // (A line is a sequence of chars terminated by any combination of \r and \n.)
        BufferedReader br = new BufferedReader(isr);

        // The message data is contained in a single line, so read this line.

        ByteBuffer byteBuffer = ByteBuffer.wrap(buf);
        int sum = byteBuffer.getInt();


        // Print host address and data received from it.
        System.out.println("Sum " /*+ request.getAddress().getHostAddress()*/ + ": " + sum );
    }

}