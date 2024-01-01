// Level 3 - Task 1

// Chat Application Client side Code

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientSide {

    public static void main(String[] args) throws IOException{

        DatagramSocket ds = new DatagramSocket();

        byte recivedata[] = new byte[1000];
        byte senddata[] = new byte[1000];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        InetAddress ip = InetAddress.getLocalHost();

        do {
            System.out.println("Enter Client Message - ");
            String clientMsg = br.readLine();
            senddata = clientMsg.getBytes();

            DatagramPacket sendDP = new DatagramPacket(senddata,senddata.length,ip,2019);

            ds.send(sendDP);

            DatagramPacket receiveDP = new DatagramPacket(recivedata,recivedata.length);

            ds.receive(receiveDP);

            String serverMsg = new String(receiveDP.getData(),0,receiveDP.getLength());

            System.out.println("\n Server Message - "+serverMsg);
        } while (true);
        
    }
}