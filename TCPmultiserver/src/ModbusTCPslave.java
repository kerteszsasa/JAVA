

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A server program which accepts requests from clients to
 * capitalize strings.  When clients connect, a new thread is
 * started to handle an interactive dialog in which the client
 * sends in a string and the server thread sends back the
 * capitalized version of the string.
 *
 * The program is runs in an infinite loop, so shutdown in platform
 * dependent.  If you ran it from a console window with the "java"
 * interpreter, Ctrl+C generally will shut it down.
 */
public class ModbusTCPslave {

    /**
     * Application method to run the server runs in an infinite loop
     * listening on port 9898.  When a connection is requested, it
     * spawns a new thread to do the servicing and immediately returns
     * to listening.  The server keeps a unique client number for each
     * client that connects just to show interesting logging
     * messages.  It is certainly not necessary to do this.
     */
	
	private static int[] registers = null;
	static boolean change = false;
	
    public ModbusTCPslave(int register_num) throws Exception {
        System.out.println("The capitalization server is running.");
        int clientNumber = 0;
        registers = new int[register_num];
        registers[0]=1;
        registers[1]=100;
        registers[3]=1;
        ServerSocket listener = new ServerSocket(502);
        
        new TCP_ListenerThread(listener).start();
       /* try {
            while (true) {
                new ModbusSocketThread(listener.accept(), clientNumber++).start();
            }
        } finally {
            listener.close();
        }*/
    }
    
    public int GetRegisterValue(int num){
    	return registers[num];
    }
    public void SetRegisterValue(int num, int value){
    	registers[num] = value;
    }
    public boolean IsRegisterChanged(){
    	boolean retval = change;
    	change = false;
    	return retval;
    }
    
    
    private static class TCP_ListenerThread extends Thread {

        private ServerSocket listen;
        private int clientNumber;
        
        public TCP_ListenerThread(ServerSocket lst) {
        	listen = lst;  
        }
     
		public void run() {
			try {
				while (true) {
					try {
						new ModbusSocketThread(listen.accept(), clientNumber++)
								.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} finally {
				try {
					listen.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }

    /**
     * A private thread to handle capitalization requests on a particular
     * socket.  The client terminates the dialogue by sending a single line
     * containing only a period.
     */
    private static class ModbusSocketThread extends Thread {
        private Socket socket;
        private int clientNumber;
        
        public ModbusSocketThread(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
            log("New connection with client# " + clientNumber + " at " + socket);
        }

        /**
         * Services this thread's client by first sending the
         * client a welcome message then repeatedly reading strings
         * and sending back the capitalized version of the string.
         */
        public void run() {
            try {

                // Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
            	
                BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));

               // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message to the client.
              //  out.println("Hello, you are client #" + clientNumber + ".");
             //   out.println("Enter a line with only a period to quit\n");

                // Get messages from the client, line by line; return them
                // capitalized
                while (true) {
                	  char[] inbuf = new char[200];
                	  char[] outbuf = new char[200];
                	  
                     int meg_len = in.read(inbuf, 0, 200);
                     if(meg_len == -1) break;// client disconnected
      
                     char trans_id_1		= inbuf[0];
                     char trans_id_2		= inbuf[1];
                     char prot_id_1			= inbuf[2];
                     char prot_id_2			= inbuf[3];
                     char len_1				= inbuf[4];
                     char len_2				= inbuf[5];
                     char unit_id			= inbuf[6];
                     
                     char function_code		= inbuf[7];
                     char reference_num_1	= inbuf[8];
                     char reference_num_2	= inbuf[9];
                     char word_count_1		= inbuf[10];
                     char word_count_2		= inbuf[11];
                
                     if(function_code == 3){
                    	// System.out.println("reg olvasás");             	                    	
                         outbuf[0] = trans_id_1;
                         outbuf[1] = trans_id_2;
                         outbuf[2] = prot_id_1;
                         outbuf[3] = prot_id_2;
                         outbuf[4] = 0;//len_1
                         outbuf[5] = 5;//len_2
                         outbuf[6] = unit_id;
                         
                         outbuf[7] = function_code;
                         outbuf[8] = 2;//byte_count;
                    	 int reference = reference_num_1*256 + reference_num_2;
                    	 int temp = registers[reference];
                		 outbuf[9] = (char) (temp/256);
                		 outbuf[10] = (char) (temp%256);

                    	 out.write(outbuf, 0, 11);
                         out.flush();
                     }
                     
                    if(function_code == 6){
                    	 //System.out.println("reg írás");
                    	 registers[ inbuf[8]*256+inbuf[9] ] = inbuf[10]*256+inbuf[11];
                    	 out.write(inbuf, 0, 12);
                         out.flush();
                         change = true;
                     }
                    
                /**    for(int i=0; i<10; i++){
                    	 System.out.print("REG"+i+":_"+registers[i]+"   ");
                     }
                     System.out.println();
                 **/

                }
            } catch (IOException e) {
                log("Error handling client# " + clientNumber + ": " + e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log("Couldn't close a socket, what's going on?");
                }
                log("Connection with client# " + clientNumber + " closed");
            }
        }

        /**
         * Logs a simple message.  In this case we just write the
         * message to the server applications standard output.
         */
        private void log(String message) {
            //System.out.println(message);
        }
    }
}