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
