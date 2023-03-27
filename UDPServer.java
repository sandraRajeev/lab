import java.io.*;
import java.net.*;
import java.lang.*;
class UDPServer
{
    public static void main(String a[])throws IOException {
        DatagramSocket socket = new DatagramSocket(6969);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte buffer[] = new byte[256];

        while(true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Msg Received: " + received);

            InetAddress address = packet.getAddress();
            int port = packet.getPort();

            System.out.println("Enter a line of text to send:");
            String message = br.readLine();
            byte[] bytes = message.getBytes();
            packet = new DatagramPacket(bytes, bytes.length, address, port);
            socket.send(packet);

            if(message.equals("exit"))
                break;
        }
    }
}