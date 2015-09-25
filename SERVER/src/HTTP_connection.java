





import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;



public class HTTP_connection {
	
	int Listen_port;
	
	
	
	/**/ //For send
    Socket sendpSocket = null;  
    DataOutputStream sendpSocket_os = null;
    DataInputStream sendpSocket_is = null;
    
    
    
	
	LinkedList<Packet> incoming_data_fifo = new LinkedList<Packet>();
	 final ReentrantLock lock = new ReentrantLock();
	
	
	public  HTTP_connection(int listen_port){
		Listen_port = listen_port;
		System.out.println("HTTP server started, listen at: " + listen_port);
		System.out.println("ez nem hhtp socketet nyit, hanem UDP!!!!!!");
		startHTTP_Receiver_Thread();
	}
	
	

//	public void HTTP_send(byte[] sendData, String IP, int port) {
//		try {
//			DatagramSocket clientSocket = new DatagramSocket();
//			InetAddress IPAddress = InetAddress.getByName(IP);
//			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);
//			clientSocket.send(sendPacket);
//			clientSocket.close();
//			
//		} catch (SocketException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void HTTP_send(byte[] sendData, String IP, int port) {
        try {
        	//InetAddress IPAddress = InetAddress.getByName(IP);
        	sendpSocket = new Socket(IP, port);
        	sendpSocket_os = new DataOutputStream(sendpSocket.getOutputStream());
        	sendpSocket_is = new DataInputStream(sendpSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + IP);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + IP);
        }


		if (sendpSocket != null && sendpSocket_os != null && sendpSocket_is != null) {
			try {
				
				sendpSocket_os.write(sendData, 0, sendData.length);
	
				
				// clean up:// close the output stream // close the input stream				// // close the socket
				sendpSocket_os.close();
				sendpSocket_is.close();
				sendpSocket.close();
			} catch (UnknownHostException e) {
				System.err.println("Trying to connect to unknown host: " + e);
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}

	}
	
	
	
	
	
	Packet HTTP_get() {
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
		public void startHTTP_Receiver_Thread() {
		    new Thread(new HTTP_Receiver_Thread()).start();
		}
		
	private class HTTP_Receiver_Thread implements Runnable {
		public void run() {
			while (true) {

				try {
					ServerSocket serverSocket = new ServerSocket(Listen_port);
					Socket sock = null;
					DataInputStream is;
					PrintStream os;

					while (true) {

						sock = serverSocket.accept();
						is = new DataInputStream(sock.getInputStream());
						os = new PrintStream(sock.getOutputStream());

						while (!sock.isClosed()) {
							
							//TODO implement timeout: azért hell, mert befagy a szál, ha a kliens csatlakozik, nem küld adatot, és zárja a kapcsolatot, vagy akkor is ha nem küld adatot, és nem is zárja

							int length = is.available();
							if (length > 0) {
								byte[] data_temp = new byte[length];
								for (int i = 0; i < length; i++) {
									data_temp[i] = is.readByte();
								}
								Packet data_p = new Packet(data_temp);
								lock.lock();
								incoming_data_fifo.add(data_p);
								lock.unlock();

								if (!sock.isClosed()) {
									sock.close();
								}

							}
						}
					}

				} catch (Exception e) {
					System.out.println("Error: " + e);
				}

			}
		}
	}
}
