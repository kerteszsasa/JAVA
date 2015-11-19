import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDP_broadcaster {
	int port;
	String msg;
	int repeat_time_s;

	public UDP_broadcaster(int port, String msg, int repeat_time_s) {
		UDP_broadcasterThread();
		this.port = port;
		this.msg = msg;
		this.repeat_time_s = repeat_time_s;
	}

	// futó szál
	public void UDP_broadcasterThread() {
		new Thread(new UDP_broadcasterThread()).start();
	}

	private class UDP_broadcasterThread implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000*repeat_time_s);
				} catch (InterruptedException e) {
					System.out.println("Terminal thread can not sleep");
					// e.printStackTrace();
				}

				
				
				for (int i = 0; i < 256; i++) {

					String ip = "192.168." + i + ".255";
					// System.out.println(ip);

					byte[] sendData = new byte[1024];
					sendData = msg.getBytes();
					// System.out.println("UDP SEND to: " + port + " MSG: " + msg);
					UDP_send(sendData, ip , port);
				}
				System.out.println("UDP");

			}
		}
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

}
