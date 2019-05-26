Laboratory work 5 / 6 
--
Task
--
Create a simple UDP/TCP chat.

TCP
--
The Transmission Control Protocol (TCP) is one of the main protocols of the Internet protocol suite. It originated in the initial network implementation in which it complemented the Internet Protocol (IP). Therefore, the entire suite is commonly referred to as TCP/IP. TCP provides reliable, ordered, and error-checked delivery of a stream of octets (bytes) between applications running on hosts communicating via an IP network. Major internet applications such as the World Wide Web, email, remote administration, and file transfer rely on TCP. Applications that do not require reliable data stream service may use the User Datagram Protocol (UDP), which provides a connectionless datagram service that emphasizes reduced latency over reliability.

Implementation:
```java
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
```
UDP
--

UDP is a communication protocol that transmits independent packets over the network with no guarantee of arrival and no guarantee of the order of delivery.

Most communication over the internet takes place over the Transmission Control Protocol (TCP), however, UDP has its place which we will be exploring in the next section.

UDP is quite different from the more common TCP. But before considering the surface level disadvantages of UDP, it’s important to understand that the lack of overhead can make it significantly faster than TCP.

Apart from speed, we also need to remember that some kinds of communication do not require the reliability of TCP but value low latency instead. The video is a good example of an application that might benefit from running over UDP instead of TCP.

Implementation:
```java
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
```
Java DatagramSocket and DatagramPacket
--
Java DatagramSocket and DatagramPacket classes are used for connection-less socket programming.

Java DatagramSocket class
--
Java DatagramSocket class represents a connection-less socket for sending and receiving datagram packets.
A datagram is basically an information but there is no guarantee of its content, arrival or arrival time.

Commonly used Constructors of DatagramSocket class
--
DatagramSocket() throws SocketEeption: it creates a datagram socket and binds it with the available Port Number on the localhost machine.

DatagramSocket(int port) throws SocketEeption: it creates a datagram socket and binds it with the given Port Number.

DatagramSocket(int port, InetAddress address) throws SocketEeption: it creates a datagram socket and binds it with the specified port number and host address.

Java DatagramPacket class
--
Java DatagramPacket is a message that can be sent or received. If you send multiple packet, it may arrive in any order. Additionally, packet delivery is not guaranteed.

Commonly used Constructors of DatagramPacket class
--
DatagramPacket(byte[] barr, int length): it creates a datagram packet. This constructor is used to receive the packets.
DatagramPacket(byte[] barr, int length, InetAddress address, int port): it creates a datagram packet. This constructor is used to send the packets.
