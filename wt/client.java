import java.net.*;
import java.io.*;
import java.util.*;


public class client
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;

    int gcd(int a, int h)
    {
      int temp;
          while (true)
          {
          temp = a%h;
          if (temp == 0)
            return h;
            a = h;
            h = temp;
          }
    }

    boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n%2 == 0 || n%3 == 0) return false;

        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
               return false;

        return true;
    }


    int nextPrime(int N)
  {

      // Base case
      if (N <= 1)
          return 2;

      int prime = N;
      boolean found = false;

      // Loop continuously until isPrime returns
      // true for a number greater than n
      while (!found) {
          prime++;

          if (isPrime(prime))
              found = true;
      }

      return prime;
  }

    // constructor to put ip address and port
    public client(String address, int port) throws Exception
    {
        // establish a connection

            socket = new Socket(address, port);
            //System.out.println("Connected");
            //System.out.println("hello0");
            out    = new DataOutputStream(socket.getOutputStream());


        //System.out.println("hello1");
        int p=3;
        System.out.println("p is "+p);
        int q=5;
        System.out.println("q is "+q);
        int pq=p*q;
        int e = 3;
        int phi = (p-1)*(q-1);
        //System.out.println("hello2");
        // while (e < phi)
        // {
        // // e must be co-prime to phi and
        // // smaller than phi.
        //   if ((int)gcd(e, phi)==1)
        //       break;
        //   else
        //       e++;
        // }
        int k = 2;  // A constant value
        int d =3;
        System.out.println("e value is "+e);
        System.out.println("d value is "+d);
        System.out.println("enter a letter to encrypt");
        Scanner s = new Scanner(System.in);
        //char inp = s.nextLine().charAt(0);
        int asc = s.nextInt();
        System.out.println("asc of inoput os "+asc);
        double enc = Math.pow(asc,e);
        System.out.println("after power with e " + enc);
        enc = enc%pq;
        System.out.println("encrypted msg is "+enc);
        out.writeUTF(pq+"");
        out.writeUTF(d+"");
        // string to read message from input


        out.writeUTF(enc+"");
        try
        {

            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[]) throws Exception
    {
        client client = new client("localhost", 5000);
    }
}
