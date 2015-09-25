//import gnu.io.*; // RXTX

import java.util.ArrayList;
// import javax.comm.*; // SUN
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TooManyListenersException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


public class Serial {

	String baudrates[] = { "9600", "19200", "56000", "115200" };
	String selectedport = null;
	String selectedbaud = null;
	InputStream in = null;
	OutputStream out = null;
	volatile boolean isconnected = false;
	Gui_serial_settings settings = null;
	LinkedList<Byte> incoming_data_fifo = new LinkedList<Byte>();
	
	 final ReentrantLock lock = new ReentrantLock();
	 
	 SerialPort serialPort = null;


	/*List getportlist() {
		CommPortIdentifier serialPortId;
		Enumeration enumComm;
		enumComm = CommPortIdentifier.getPortIdentifiers();
		List portnames = new ArrayList();

		while (enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				// System.out.println(serialPortId.getName());
				portnames.add(serialPortId.getName());
			}
		}
		return portnames;
	}*/

	void connect() {
		// Use GUI
		settings = new Gui_serial_settings(this);
		settings.setVisible(true);

	}
	
	void connect(String filename) {
		try {

			ArrayList<String> names = new ArrayList<String>();
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNextLine()) {
				names.add(scanner.nextLine());
			}
			scanner.close();

			System.out.println(names.get(1));
			selectedport = names.get(1);
			System.out.println(names.get(3));
			selectedbaud = names.get(3);

		} catch (IOException e) {
			System.out.print("Exception: File read error");
		}

		try {
			connect(selectedport, Integer.valueOf(selectedbaud));
		} catch (Exception e) {
			System.out.print("Exception: Error when opening a port");
		}

	}

	void connect(String portName, int baud) throws Exception {
		serialPort = new SerialPort(portName);
		try {
			serialPort.openPort();// Open serial port
			if (baud == 9600) {
				serialPort.setParams(SerialPort.BAUDRATE_9600,
						SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);// Set params. Also you
			}
			if (baud == 16200) {
				serialPort.setParams(SerialPort.BAUDRATE_19200,
						SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);// Set params. Also you
			}
			if (baud == 115200) {
				serialPort.setParams(SerialPort.BAUDRATE_115200,
						SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);// Set params. Also you
			}
			isconnected = true;
			// Start the receive method
			   int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;//Prepare mask
	            serialPort.setEventsMask(mask);//Set mask
	            serialPort.addEventListener(new SerialPortReader());//Add SerialPortEventListener
		} catch (SerialPortException ex) {
			isconnected = false;
			System.out.println(ex);
		}

	}


	boolean isconnected() {
		return isconnected;
	}
	
	void send_byte(byte b) {		
		try {
			//out.write(b);
			serialPort.writeByte(b);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void send_str(String s) {
		try {
			serialPort.writeBytes(s.getBytes());
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void send_bytes(byte buffer[], int length) {
		int i = 0;
		while (i < length) {
			try {
				serialPort.writeByte((byte) buffer[i]);
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
	

	
	//eventhandler
	
 class SerialPortReader implements SerialPortEventListener {

        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR()){//If data is available
            	byte [] buffer;
            
                    //ez kell
                	try {
            			int availableBytes = event.getEventValue();
            			lock.lock();
            			if (availableBytes > 0) {
            				// Read the serial port  				
            				buffer = serialPort.readBytes(availableBytes);
            				
            				for (int i=0; i<availableBytes;i++){
            					incoming_data_fifo.add(buffer[i]);
            				}
            				
            				availableBytes = event.getEventValue();
            			}
            			lock.unlock();

            		} catch (SerialPortException e) {
            		} finally {
            			
            		}
                
            }
            else if(event.isCTS()){//If CTS line has changed state
                if(event.getEventValue() == 1){//If line is ON
                    //System.out.println("CTS - ON");
                }
                else {
                   // System.out.println("CTS - OFF");
                }
            }
            else if(event.isDSR()){///If DSR line has changed state
                if(event.getEventValue() == 1){//If line is ON
                    //System.out.println("DSR - ON");
                }
                else {
                   // System.out.println("DSR - OFF");
                }
            }
        }
    }

	



}// end of serial class