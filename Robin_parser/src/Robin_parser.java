import javax.swing.JDialog;

public class Robin_parser {
	static byte start_cmd[] = { (byte) 0xAA, (byte) 0xAA, (byte) 0xAA,
			(byte) 0x99, (byte) 0x3E, (byte) 0xFE, (byte) 0x04, (byte) 0x05,
			(byte) 0x03, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x01,
			(byte) 0x4A };

	public static void main(String[] args) {
		System.out.println("Robin parser started");
		
		
		

		
		
		
		
		
		

		Serial serialport = new Serial();
		Logic logic = new Logic(serialport);
		Gui frame = new Gui(logic);
		frame.setVisible(true);

		


		/*
		 * Logger l= new Logger(); l.Syslog("dffdfdf");
		 * 
		 * 
		 * for(int i=0; i<2000;i++){ l.log("hghhgfhfg" + i, "aa.txt"); }
		 * System.out.println("Hello, World");
		 */

	}

}