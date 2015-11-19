import java.awt.event.KeyEvent;
import java.io.IOException;


public class SERVER {
    public static void main(String[] args) {
    	
    	
		System.out.println("Homeserver started \n");
		//Serial serialport = new Serial();
	//	MISE_protocol misep = new MISE_protocol(serialport);
	//	Logic logic = new Logic(misep);
		

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
		
		
		
		try {
		//	ModbusTCPslave modbus = new ModbusTCPslave(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("Main thread still running after start modbusTCP\n");
		

		try {
			Gui frame = new Gui(espinterface);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Main thread still running after start GUI \n");
		
       /* String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                "running the date service on port 9090:");*/
		
		//System.out.println(JOptionPane.showConfirmDialog(null, "fff"));
		

		
		UDP_broadcaster udp_broadcaster = new UDP_broadcaster(30303,"0xFF \n", 1);
		
		
		
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
    	
    	
    	
    	
        System.out.println("Server started");
        
        Logger log = new Logger();
        log.syslog("Server started");
        Terminal term = new Terminal();
        Config_reader config = new Config_reader();
        
        
        Udp_connection udp = null;
        if(config.Is_UDP_NODE()){
        	udp =new Udp_connection( config.UDP_NODE_IN_PORT);
        }
        
        
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
        
        
//       
//     
//       
//       byte[] sendData = new byte[1024];	      
//	      sendData ="hello".getBytes();
//
//			udp.UDP_send(sendData,"127.0.0.1",9876);
//
//
//        
////TODO: make thread!!!
//			/*
//        Webinterface web = new Webinterface();
//        web.start();
//        
//        
//        */
//			
//			
//			
//			/**TEST  ********************/
//        while(true){
//        	Packet b = udp.UDP_get();
//        	if(b != null){
//
//        		
//        		String str = new String(b.Get_data());
//
//				System.out.println("ARDUINO: " + str);
//				log.log("ARDUINO: " + str, "noveny.txt");
//        	}
//        }
//        
//        /**_______________________________*/
//          
//        



    }
    
    
    
    
}
