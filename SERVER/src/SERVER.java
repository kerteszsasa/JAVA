import java.io.IOException;

import javax.swing.JOptionPane;


public class SERVER {
    public static void main(String[] args) {
    	
    	
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
