import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;



public class Udp_node {
	
	int Listen_port;
	
	LinkedList<Packet> incoming_data_fifo = new LinkedList<Packet>();
	 final ReentrantLock lock = new ReentrantLock();
	
	
	public  Udp_node(int listen_port){
		Listen_port = listen_port;
		startUDP_Receiver_Thread();
	}
	
	

	public void UDP_send(byte[] sendData, String IP, int port) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName(IP);
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);
			clientSocket.send(sendPacket);
			clientSocket.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	Packet UDP_get() {
		lock.lock();
		if(incoming_data_fifo.isEmpty()){
			lock.unlock();
			return null;
		}
		else{
			Packet p = incoming_data_fifo.removeFirst() ;
			lock.unlock();
			return p;
		}
	}
	
	
	
	
	
	
	
	//futó szál
		public void startUDP_Receiver_Thread() {
		    new Thread(new UDP_Receiver_Thread()).start();
		}
		
		private class UDP_Receiver_Thread implements Runnable {
		    public void run() {
			while (true) {

				try {
					DatagramSocket serverSocket = new DatagramSocket(Listen_port);
					byte[] receiveData = new byte[2048];

					while (true) {
						DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
						serverSocket.receive(receivePacket);
						
						  byte[] data_temp = new byte[receivePacket.getLength()];						  
						  for(int i=0; i<receivePacket.getLength(); i++){
							  data_temp[i] = receiveData[i];
						  }
						  Packet data_p= new Packet( data_temp );
  
						  lock.lock();
						  incoming_data_fifo.add(data_p);
						  //TODO remove
						  System.out.println(data_temp);
						 
						  lock.unlock();
						
						
						
						/*
						String sentence = "";
						sentence = new String(receivePacket.getData());
						System.out.println("RECEIVED: " + sentence);
						// System.out.println("IP: "+
						// receivePacket.getAddress());
						InetAddress IPAddress = receivePacket.getAddress();
						receiveData = new byte[2048]; // to empty data buffer
						*/
					}
				} catch (Exception e) {
					System.out.println("Error: " + e);
				}

			}
		    }
		}
}
