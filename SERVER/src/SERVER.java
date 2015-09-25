import java.awt.event.KeyEvent;


public class SERVER {
    public static void main(String[] args) {
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
