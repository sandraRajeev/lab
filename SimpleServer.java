import java.net.*;
import java.io.*;
public class SimpleServer
{
public static void main(String args[]) throws IOException
{
ServerSocket ss=new ServerSocket(1254);
Socket s=ss.accept();
OutputStream sout=s.getOutputStream();
DataOutputStream dos=new DataOutputStream(sout);
dos.writeUTF("Hi there");
dos.close();
sout.close();
s.close();
}
}
