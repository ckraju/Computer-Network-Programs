//TCPClient

import java.io.*;
import java.net.*;

class TCPClient
{
 public static void main(String args[])throws IOException
 {
  
  Socket s=new Socket(InetAddress.getByName("127.0.0.1"),2511);
  System.out.println("CLIENT AND SERVER CONNECTED!!!");
  
  DataInputStream i=new DataInputStream(s.getInputStream()); 
  DataOutputStream o=new DataOutputStream(s.getOutputStream()); 
  BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
  String inp;
  
  System.out.println("WRITE SOMETHING THAT CAN BE TO SEND TO SERVER AND PROCESS:::");
  String rec;
  while(true)
  {
   rec=k.readLine();
   o.writeUTF(rec);
   o.flush();
   inp=i.readUTF(); 
   System.out.println("The server sent "+inp);   
  }
 } 
}
