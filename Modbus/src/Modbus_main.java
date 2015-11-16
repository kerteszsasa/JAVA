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


public class Modbus_main{
	public static void main(String args[]){
		
		System.out.println("Kapacitiv_uziszonda_v2 software 1.0 \n");
		//Serial serialport = new Serial();
	//	MISE_protocol misep = new MISE_protocol(serialport);
	//	Logic logic = new Logic(misep);
		try {
			ModbusTCPslave modbus = new ModbusTCPslave(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("Kapacitiv_uziszonda_v2 software 1.0 \n");
		

	}

}
