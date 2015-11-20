import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;



public class ESP_interface {
	private static int ESP_output_PORT = 30303;
	private static int ESP_input_PORT = 30304;
	
	public List<ESPMessage> INCOMING_MSG = new ArrayList<ESPMessage>();
	public List<ESPMessage> OUTGOING_MSG = new ArrayList<ESPMessage>();


    public ESP_interface() throws Exception {
        System.out.print("ESP interface started, listen on "+ESP_input_PORT+" TCP port.   ");
        System.out.println("ESP interface started, send to "+ESP_output_PORT+" TCP port.");
        ServerSocket listener = new ServerSocket(ESP_input_PORT);     
        new TCP_ListenerThread(listener, INCOMING_MSG).start();
        new TCP_SenderThread(OUTGOING_MSG).start();
    }
    
	private static class TCP_SenderThread extends Thread {
		List<ESPMessage> outgoing_list;

		public TCP_SenderThread(List<ESPMessage> outgoing_l) {
			outgoing_list = outgoing_l;
		}

		public void run() {
			while (true) {

				if (outgoing_list.isEmpty()) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				} else {
					// System.out.println("sending available data");
					ESPMessage msg = outgoing_list.remove(0);
					// System.out.println("FIXME");

					String serverAddress = msg.GetIP();
					try {
						Socket s = new Socket(serverAddress, ESP_output_PORT);
						OutputStream out = s.getOutputStream();
						DataOutputStream dos = new DataOutputStream(out);
						dos.write(msg.Getbytes(), 0, msg.Getbytes().length);
						s.close();

					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
    
    
    private static class TCP_ListenerThread extends Thread {

        private ServerSocket serv_sock;
        List<ESPMessage> incoming_list;
 
        public TCP_ListenerThread(ServerSocket serv_s, List<ESPMessage> incomong_l) {
        	serv_sock = serv_s;  
        	incoming_list = incomong_l;        
        }
     
		public void run() {
			try {
				while (true) {
					try {
						new ModbusSocketThread(serv_sock.accept(), incoming_list).start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} finally {
				try {
					serv_sock.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }
    



    private static class ModbusSocketThread extends Thread {
        private Socket socket;
        List<ESPMessage> in_list;
        
        public ModbusSocketThread(Socket socket, List<ESPMessage> in_l) {
            this.socket = socket;
            in_list = in_l;
            log("New connection with client# " + 33 + " at " + socket);
        }

        public void run() {
            try {
            //	socket.setSoTimeout(5000);
         
            	   InputStream in = socket.getInputStream();
            	  
            	   // DataInputStream dis = new DataInputStream(in);

				while (true) {

					byte[] tmp_inbuf = new byte[10000];
					System.out.println(in.available());
					
					
				/*	while(in.available()==0){
					System.out.println( out.checkError());
					}*/

					
					
			
					
					System.out.println(in.available());

					int msg_len = in.read(tmp_inbuf, 0, 10000);
					//int msg_len = readInputStreamWithTimeout(in, tmp_inbuf, 6000);
					System.out.println("msg len: "+msg_len);
					if (msg_len == -1)
						break;// client disconnected

					// just for save memory: not a good idea to save 10000 byte
					// messages
					byte[] inbuf = new byte[msg_len];
					for (int i = 0; i < msg_len; i++) {
						inbuf[i] = tmp_inbuf[i];
					}

					String incoming_IP = socket.getInetAddress().getHostAddress();

					/* for debug
					
					System.out.println("IP: " + incoming_IP);
					String decoded = new String(inbuf, "UTF-8");
					System.out.println("MESSAGE: " + decoded);*/

					ESPMessage ESPmsg = new ESPMessage(incoming_IP, inbuf);
					in_list.add(ESPmsg);

				}
            } catch (IOException e) {
                log("Error handling client# " + 33 + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Couldn't close a socket, what's going on?");
                }
                log("Connection with client# " + 33 + " closed");
            }
        }


        private void log(String message) {
            System.out.println(message);
        }
    }
    

} // end of ESP_interface class