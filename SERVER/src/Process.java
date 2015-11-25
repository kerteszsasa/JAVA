import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.sql.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import NODES.TCP_NODE;

public class Process{
	Map<String, List<ByteBuffer>> RX = null;
	Map<String, List<ByteBuffer>> TX = null;
	Map<String, TCP_NODE> NodeMAP = null;
	
	Map<String, String> temp_IP_to_MAC = new HashMap<String, String>();								
	Map<String, String> temp_conn_request_nodes = new HashMap<String, String>();		// ipport -> buffermessage(connectioninfo)						// node MAC  --->  CONN REQUEST NODE LIST

	public Process(Map<String, List<ByteBuffer>> RX, Map<String, List<ByteBuffer>> TX, Map<String, TCP_NODE> NodeMAP){
		this.RX = RX;
		this.TX = TX;
		this.NodeMAP = NodeMAP;
		
		startProcessThread();
	}
	
	
	//futó szál
	public void startProcessThread() {
	    new Thread(new ProcessThread()).start();
	}
	
	private class ProcessThread implements Runnable {
	    public void run() {
			while (true) {
				//TODO chech is this sleep nessecery?
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Process thread can not sleep");
					//e.printStackTrace();
				}
				do_things();
				//handle_TCP();
			}
	    }
	}

	
	
   void do_things(){
	   System.out.println("");
	   System.out.print("###PROCESS: ");

	  
	  Iterator it = RX.entrySet().iterator();
	    while (it.hasNext()) {
	        //This will be your very first element
	    
	        Map.Entry pairs = (Map.Entry)it.next(); 
	     //   System.out.println(pairs.getKey() + " = " + pairs.getValue());

	        
	
	        String macID = temp_IP_to_MAC.get(pairs.getKey());
	        	        
	        if(macID == null){
	        	System.out.println("nem volt a listában");

	            List tcp_msg_list = RX.get(pairs.getKey());
	        	Iterator<ByteBuffer> i = tcp_msg_list.iterator();
	        	while (i.hasNext()) {
	        	   ByteBuffer bb = i.next();
	        	  //  NodeMAP.get(macID).IN_buffer(bb);
	        	   
	        	  String v="";
	        	   
				try {
					
					v = new String(bb.array(), "ASCII");
					  System.out.println(v);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	   
				if( v.startsWith("DISCONNECT") ){
					// TODO remove ip from ip_to_mac map
					// TODO implement disconnect sending in TCP nio class!!!!
				}
				if(v.startsWith("CONNECT")){
	        		   System.out.println("valaki csatlakozni próbál");
	        		   
	        		   
	        		   //ADMIN GUI?
	        		   if(v.startsWith("CONNECT ADMIN")){
	        			   temp_IP_to_MAC.put(pairs.getKey().toString(), "ADMIN");
	        			   NodeMAP.put("ADMIN", new TCP_NODE()); 
	        		   }
	        		   
	        		   // fel van már véve a node a csatlakozottak közé?
	        		   	// if v.mac == nodelist . egyik mac, akkoor temp_ip_mac.put(ip, mac)
	        		   
	        		   // teljesen új nose?
	        		// if v.mac == nodelist . egyik mac sem, akkor berakjuk ide:
	        		   temp_conn_request_nodes.put(pairs.getKey().toString(), v);
	        	   }
	        	  
	        	    i.remove();
	        	}
	      
	        	
	        }
	        
	        
	        if(macID != null){
	        	System.out.println("benne volt a listában, elküldöm az üzenetet a node-nak");
	        	
	        	List<ByteBuffer> tcp_msg_list = RX.get(pairs.getKey());
	        	Iterator<ByteBuffer> i = tcp_msg_list.iterator();
	        	while (i.hasNext()) {
	        	   ByteBuffer bb = i.next();
	        	  //  NodeMAP.get(macID).IN_buffer(bb);
	        	   
	        	   
	        	  
				try {
					 String v;
					 v = new String(bb.array(), "ASCII");
					  System.out.println(v);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	  
	        	   
	        	    i.remove();
	        	}
	        	
	        }
	        
	        RX.remove(pairs.getKey()); 
	
	    }
	  
	  

   }
   
   void handle_TCP(){
	   System.out.println("");
	   System.out.print("###PROCESS: ");

	  
	  Iterator it = RX.entrySet().iterator();
	    while (it.hasNext()) {
	        //This will be your very first element
	    
	        Map.Entry pairs = (Map.Entry)it.next(); 
	     //   System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        
	      
	        
	        
	        String macID = temp_IP_to_MAC.get(pairs.getKey());
	        
	        
	        if(macID == null){
	        	System.out.println("nem volt a listában");

	            List tcp_msg_list = RX.get(pairs.getKey());
	        	Iterator<ByteBuffer> i = tcp_msg_list.iterator();
	        	while (i.hasNext()) {
	        	   ByteBuffer bb = i.next();
	        	  //  NodeMAP.get(macID).IN_buffer(bb);
	        	   
	        	   
	        	   String v;
				try {
					v = new String(bb.array(), "ASCII");
					  System.out.println(v);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	   
	        	  
	        	    i.remove();
	        	}
	      
	        	
	        }
	        
	        
	        if(macID != null){
	        	System.out.println("benne volt a listában, elküldöm az üzenetet a node-nak");
	        	
	        	List tcp_msg_list = RX.get(pairs.getKey());
	        	Iterator<ByteBuffer> i = tcp_msg_list.iterator();
	        	while (i.hasNext()) {
	        	   ByteBuffer bb = i.next();
	        	  //  NodeMAP.get(macID).IN_buffer(bb);
	        	   
	        	   
	        	   String v;
				try {
					v = new String(bb.array(), "ASCII");
					  System.out.println(v);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	   
	        	   
	        	   
	        	   
	        	 
	        	   
	        	    i.remove();
	        	}
	        	
	        	
	        	
	        	
	        }
	        
	        RX.remove(pairs.getKey()); 
	
	    }
	  
	  

   }
   
}
