import java.net.*;
import java.io.*;

public class server
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream inp       =  null;

    // constructor with port
    public server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            inp = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));


            String pqst = inp.readUTF();
            int pq = Integer.parseInt(pqst);
            System.out.println("pq is "+pq);
            String dstr = inp.readUTF();
            int d = Integer.parseInt(dstr);
            System.out.println("d is "+d);

            String input = inp.readUTF();
            System.out.println("input to server is "+input);
            double in = Double.parseDouble(input);
            System.out.println("aftyer parsing the input is  "+in);
            double dec = Math.pow(in,d);
            System.out.println("after powerin the value dec value is "+ dec);
            dec = dec%pq;
            System.out.println("des   "+dec);
            char res = (char)dec;
            System.out.println("the decrypted message is "+ res);




            System.out.println("Closing connection");

            // close connection
            socket.close();
            inp.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        server server = new server(5000);
    }
}
