import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server{
    public static void main(String[] args) throws SocketException, IOException {
        //here is created datagram socket and binds it with the available Port Number on the localhost machine.
        DatagramSocket serverSocket = new DatagramSocket(9876);
        boolean bye = false;
        while(true) //true
        {
            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer  = new byte[1024];
            DatagramPacket receivedPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            //client data will be received in receivedPacket
            serverSocket.receive(receivedPacket);
            //client address
            InetAddress IP = receivedPacket.getAddress();
            //client port
            int portNumber = receivedPacket.getPort();
            //convert client data into string format
            String clientData = new String(receivedPacket.getData());
            //here we output the client data
            System.out.println("\nClient : "+ clientData);
            System.out.print("\nServer : ");
            //here is input of server
            BufferedReader serverRead = new BufferedReader(new InputStreamReader (System.in) );
            String serverData = serverRead.readLine();
            //here we convert server input to byte format
            sendBuffer = serverData.getBytes();
            //here we create datagram packet which is used to send the server packet.
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, IP,portNumber);
            //send packet to the client
            serverSocket.send(sendPacket);
            //here the check condition for server data which must be bye
            if(serverData.equalsIgnoreCase("bye"))
            {
                System.out.println("connection ended by Server");
                break;
            }
        }
        serverSocket.close();
    }
}