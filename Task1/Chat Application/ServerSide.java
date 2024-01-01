// Level 3 - Task 1

// Chat Application Server side Code

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerSide {

    public static void main(String[] args) throws IOException{

        DatagramSocket ds = new DatagramSocket(2019);

        byte recivedata[] = new byte[1000];
        byte senddata[] = new byte[1000];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            DatagramPacket reciveDP = new DatagramPacket(recivedata, recivedata.length);

            ds.receive(reciveDP);

            String clientMsg = new String(reciveDP.getData(),0,reciveDP.getLength());
            System.out.println("Client Message - "+clientMsg);

            InetAddress ip = reciveDP.getAddress();

            System.out.println("\n Enter Server Message - ");
            String serverMsg = br.readLine();
            senddata = serverMsg.getBytes();

            DatagramPacket sendDp = new DatagramPacket(senddata,senddata.length,ip,reciveDP.getPort());

            ds.send(sendDp);

            recivedata = new byte[1000];
        } while (true);
        
    }
}