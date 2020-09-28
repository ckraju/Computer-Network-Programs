//TCPServer

import java.io.*;
import java.net.*;


class TCPServer
{
 public static void main(String args[])throws IOException
 {
  ServerSocket ss=new ServerSocket(2511); //Creating a TCP socket, with a call to socket(). Binding the socket to the listen port
  Socket soc=ss.accept();//Accepting incoming connections, via a call to accept(). 
   DataInputStream i=new DataInputStream(soc.getInputStream()); 
  DataOutputStream o=new DataOutputStream(soc.getOutputStream()); 
  
  String inp,conv;
  while(true)
  {
   inp=i.readUTF();
   conv=inp.toUpperCase(); 
   
   o.writeUTF(conv);
   }
 } 
}
