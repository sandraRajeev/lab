import java.net.*;
import java.io.*;
public class SimpleClient
{
public static void main(String args[])throws IOException
{
Socket s=new Socket("localhost",1254);
InputStream sln = s.getInputStream();
DataInputStream dis= new DataInputStream(sln);
String st=new String(dis.readUTF());
System.out.println(st);
dis.close();
sln.close();
s.close();
}
}
