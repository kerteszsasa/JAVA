
import java.io.*;
import java.net.*;

public class UDPServer
{
	public static void main(String args[]) throws Exception
    {
		/* try{
		        DatagramSocket serverSocket = new DatagramSocket(9876);
		        byte[] receiveData = new byte[2048];
		        byte[] sendData = new byte[2048];

		        while(true)
		           {
		              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		              serverSocket.receive(receivePacket);
		              String sentence = new String( receivePacket.getData());
		              System.out.println("RECEIVED: " + sentence);
		              InetAddress IPAddress = receivePacket.getAddress();
		              String sendString = "123456789101112131415";
		              sendData = sendString.getBytes();
		              DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9875);
		              serverSocket.send(sendPacket);
		             // serverSocket.close();
		           }
		    }catch (Exception e){
		    	System.out.println("gáz van: " + e);
		    }*/
		
		
		
		
		 try{
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[2048];
    

        while(true)
           {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              
             if(  receivePacket.getLength() > 0 ){
              String sentence = new String( receivePacket.getData());
              System.out.println("RECEIVED: " + sentence);
              System.out.println("IP: " + receivePacket.getAddress());
              InetAddress IPAddress = receivePacket.getAddress();
              
             }else{
            	 //delay;
             }
              

             // serverSocket.close();
           }
    }catch (Exception e){
    	System.out.println("gáz van: " + e);
    }
		
		
		
    }
	
}
