import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;


public class SERVER {
    public static void main(String[] args) {
    	
    	// create a synchronized map
    	Map<String, List<ByteBuffer> > RXmap = new HashMap<String, List<ByteBuffer>>();
    	Map<String, List<ByteBuffer> > TXmap = new HashMap<String, List<ByteBuffer>>();
        // create a synchronized map
        Map<String, List<ByteBuffer>> TcpRxTunnel = Collections.synchronizedMap(RXmap);
        Map<String, List<ByteBuffer>> TcpTxTunnel = Collections.synchronizedMap(TXmap);
        
        
        
        
        
        
        
        
        
         List<ByteBuffer> list = new ArrayList<ByteBuffer>();
         
         ByteBuffer dummyResponse;
		try {
			dummyResponse = ByteBuffer.wrap("ok".getBytes("UTF-8"));
			 list.add(dummyResponse);
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

        
       /* 
        TcpTxTunnel.put("a", "1");
        TcpTxTunnel.put("as", "12");
        TcpTxTunnel.put("asd", "123");
        TcpTxTunnel.put("asdf", "1234");
        TcpTxTunnel.put("a", "22222");
        
        TcpTxTunnel.get("as");
        TcpTxTunnel.remove("asd");

        
        RXmap.put("elso", )
        
        
        */
        
		 TcpTxTunnel.put("elso", list);
		 TcpTxTunnel.put("masodik", list);
		 TcpTxTunnel.put("harmadik", list);
		 
        
        System.out.println( TcpTxTunnel.keySet() );
        
        System.out.println(  TcpTxTunnel.get("defef") );
        
        
        
        
        
        
        
        
        
        
        
        
    	
		System.out.println("SERVER started \n");
		Logger logger = new Logger();
        logger.syslog("Server started");
        
        Config_reader config = new Config_reader();
        Terminal term = new Terminal();
        
        
        
     //  logger.log("ARDUINO: " + "mérési eredmények str", "meresi eredmenyek.txt");
        

		

			ESP_interface espinterface = null;
			try {
				espinterface = new ESP_interface();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		
		
			try {
				new TCP_NIO_server();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("TCP nio server started at 30303");
			
			
			
			try {
				//	ModbusTCPslave modbus = new ModbusTCPslave(1000);
					//System.out.println("Main thread still running after start modbusTCP\n");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		//	System.out.println("TODO: ide kell a process szál");
			Process process = new Process();
			
			
			/*	System.out.println("UDP broadcaster thread started");
			UDP_broadcaster udp_broadcaster = new UDP_broadcaster(30303,"0xFF \n", 10, "192.168.200.212");
			System.out.println("TODO: fix the gateway ip, for config reader");
			*/
		
		
		
			  Webinterface web = new Webinterface(8080);
		

		
		

		try {
			Gui frame = new Gui(espinterface);
			System.out.println("Main thread still running after start GUI \n");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
     /* FOR POPUP WINDOW
       String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                "running the date service on port 9090:");
		
		System.out.println(JOptionPane.showConfirmDialog(null, "fff"));*/
		


/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
    	

      /*  
        
        Udp_connection udp = null;
        if(config.Is_UDP_NODE()){
        	udp =new Udp_connection( config.UDP_NODE_IN_PORT);
        }
        
        */
      
      /*
        HTTP_connection http = new HTTP_connection(33589);
        //  http.HTTP_send("hello".getBytes(), "localhost", 23);
        //   http.HTTP_send("almaaaaa\r\n".getBytes(), "localhost", 23);
        while(true){
        	Packet b = http.HTTP_get();
        	if(b != null){

       		
        		String str = new String(b.Get_data());

				System.out.println( str);
			//log.log("ARDUINO: " + str, "noveny.txt");
        	}
        }
        
        */



    }
    
        
}
