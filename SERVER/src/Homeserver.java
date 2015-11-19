import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.swing.JOptionPane;


public class Homeserver{
	public static void main(String args[]){
		
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
		
		
		

		

	}

}
