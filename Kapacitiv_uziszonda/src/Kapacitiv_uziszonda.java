import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;


public class Kapacitiv_uziszonda{
	public static void main(String args[]){
		
		System.out.println("Kapacitiv_uziszonda software 1.0 \n");
		Serial serialport = new Serial();
		MISE_protocol misep = new MISE_protocol(serialport);
		Logic logic = new Logic(misep);
		

		
		
/*
		try {
			serialport.connect("COM14", 115200);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		*/
		
		serialport.connect("Serialoptions.txt");
		
		
		
		
		
	//	serialport.send_str("hello");
	//	misep.send_msg(23, "TESTMSG".getBytes(), "TESTMSG".length());
		
			
		
		
		//logic.connect();
//		while(!serialport.isconnected());
			//misep.serial_send_str("HELLO bmfdkgkfgkgtkht");
		
		
		Gui_main frame = new Gui_main(logic);
		frame.setVisible(true);
			
		 
		
		

	

	//while(true){
//		System.out.println(misep.serial_get_msg());
	//}
	
/*		
		 while(!serialport.isconnected());
		 OutputStream out = null;
		 out = serialport.get_OutputStream();
		// out.
		try {
			out.write('H');

			out.write('e');
			out.write('l');
			out.write('l');
			out.write('o');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/		
		/*
		InputStream in = null;
		in = serialport.get_InputStream();
		byte[] b = null;
		
		while (true) {

			try {
				System.out.println(serialport.in.read());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		 */
		
	//	while(true)frame.repaint();

	}


	


}

/*	
System.out.println("Hexapod driver software 1.0 \n");

Serial serialport=new Serial();
	
//serialport.connect();		



//serialport.getportlist();



/*

List portlist = serialport.getportlist();
System.out.println(portlist.size());			
while(! portlist.isEmpty()){
	System.out.println(portlist.get(0));
	portlist.remove(0);
}

*//*
System.out.println( serialport.getportlist().toString() );*/

/*
 try
    {
	 serialport.connect("COM3", 9600);
	 
    }
    catch ( Exception e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

*/

 
 
// String s="Hello world";
 

 /*
 PrintStream out = null;
 try {
     out = new PrintStream(new FileOutputStream("Serialoptions.txt"));
     out.println("PORT:");
     out.println("COM1");
     out.println("BAUD:");
     out.println("9600");
 }catch(IOException e){
      System.out.print("Exception");
   }
 
 
 */
 
 /*
 try {
 
 ArrayList<String> names = new ArrayList<String>();
 Scanner scanner = new Scanner(new File("Serialoptions.txt"));
 while(scanner.hasNextLine()) {
     names.add(scanner.nextLine());
 }
 scanner.close();
// String[] namesArr = (String[]) names.toArray();
 
 
 
 System.out.println( names.get(1));
 System.out.println( names.get(3));
 
 }catch(IOException e){
      System.out.print("Exception");
   }
 
 */
/*serialport.connect("Serialoptions.txt");



}*/