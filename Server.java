// receives data and sends data 
import java.io.*; 
import java.net.*; 

class Server { 
    public static void main(String args[]) throws Exception { 
        // Create server Socket 
        ServerSocket server = new ServerSocket(6969); 

        // to read data from the keyboard 
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in)); 
        while (true) { 
            // connect it to client socket 
            Socket s = server.accept(); 
            System.out.println("Connection established"); 
            // to send data to the client 
            PrintStream ps = new PrintStream(s.getOutputStream()); 

            // to read data coming from the client 
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            String str, str1; 
            // repeat as long as the client 
            // does not send a null string 
            // read from client 

            str = br.readLine();
            while (str != null) { 
                System.out.println("Client: " + str); 
                str1 = kb.readLine(); 

                // send to client 
                ps.println("server: " + str1); 
                str = br.readLine();
            } 

            // close connection 
            ps.close(); 
            br.close(); 
            s.close(); 

        } // end of while 
    } 
}
