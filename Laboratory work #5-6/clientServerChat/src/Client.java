import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
public class Client{
    public static void main(String[] args) throws SocketException, IOException {
        //input from user
        BufferedReader clientRead = new BufferedReader(new InputStreamReader(System.in));
        //ip address with which you want to communicate
        InetAddress IP = InetAddress.getByName("127.0.0.1");
        //datagram socket and binds it with the available Port Number on the localhost machine.
        DatagramSocket clientSocket = new DatagramSocket();
        while(true)    //true
        {
            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];
            System.out.print("\nClient: ");
            //read data from the client
            String clientData = clientRead.readLine();
            //convert client data in byte format
            sendBuffer = clientData.getBytes();
            //here we create datagram packet which is used to send the client packet.
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, IP, 9876);
            //send packet to the server
            clientSocket.send(sendPacket);
            //here the check condition for client data which must be bye
            if(clientData.equalsIgnoreCase("bye"))
            {
                System.out.println("Connection ended by Client");
                break;
            }
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            String serverData = new String(receivePacket.getData());
            System.out.print("\nServer: " + serverData);
        }
        clientSocket.close();
    }
}