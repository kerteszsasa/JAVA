import java.awt.Color;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.locks.ReentrantLock;


public class Logic {
	
	
	int[] capacitance = new int[6];
	
	
	//new stuff
	int[] stm8_inputdata = new int[40];
	int[] progress_min_calib = new int[40];
	int[] progress_max_calib = new int[40];
	int[] progressbar = new int[40];
	
	
	

	
	

	
	String runtime ="";
	String linetype_F_R= "";
	
	String textmsg="";
	final ReentrantLock stringlock = new ReentrantLock();
	boolean isnewtext =false;
	
	
	MISE_protocol misep=null;
	
	byte[] matlab_speed_parameters = new byte[28];
	
	int matlab_servo_parameters_iterator =0;
	int osszevart_data=5;
	byte[] matlab_servo_parameters = new byte[44*osszevart_data];
	
	
	public Logic(MISE_protocol m){
		misep = m;
		startRunningThread();
		//startMatlabThread();
	}
	void connect(){
		misep.connect();
	}

	Color getconnectionsatatus() {
		if (misep.getstatus())
			return Color.GREEN;
		else
			return Color.RED;
	}
	
	void Startsignal(){
		//TODO
		System.out.println("START button pressed");
	}
	
	void Stopsignal(){
		//send speed = 0
		byte[] data={(byte) 0};
		misep.send_msg( 22, data,  1);
	}
	
	void GyroNull(){
		byte[] data={(byte) 0};
		misep.send_msg( 13, data,  0);
	}
	void Setspeed(int speed){
		byte[] data={(byte) speed};
		misep.send_msg( 22, data,  1);
	}
	
	//speed : 90 üzenet 4 byte: speedp,  speedi,  speedd,  speeddelay
	void Send_PID_speed_values(int speedp, int speedi, int speedd, int speeddelay){
		byte[] data={(byte) speedp, (byte) speedi, (byte) speedd, (byte) speeddelay};
		misep.send_msg( 90, data,  4);
	}
	

	// servo: 91 üzenet 
	void Send_PID_servo_values(int line_P, int line_I, int line_D,  int line_ratio, int angle_P, int angle_I, int angle_D, int angle_ratio, int servo_delay, int selector){
		byte[] data={(byte) line_P, (byte) line_I, (byte) line_D,  (byte) line_ratio, (byte) angle_P, (byte) angle_I, (byte) angle_D, (byte) angle_ratio, (byte) servo_delay, (byte) selector};
		misep.send_msg( 91, data,  10);
	}
	
	//speedselector 92 üzenet
	void Send_speedselector_values(int lassu, int gyorsabb){
		byte[] data={(byte) lassu, (byte) gyorsabb};
		misep.send_msg( 92, data,  2);
	}
	
	//speedselector 93 üzenet
	void Send_cascade_multilier_values(int szorzo){
		byte[] data={(byte) szorzo};
		misep.send_msg( 92, data,  1);
	}
	
	//incoming message processing--------------------------------------------//
	//incoming message processing--------------------------------------------//
	//incoming message processing--------------------------------------------//
	
	void data_process() {
		switch (misep.msg_TYPE) {
		/*case 0: {
			stringlock.lock();
			//textmsg+="INFO: " + misep.incoming_message + "\n\r";
			textmsg+="INFO: ";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				textmsg +=c;
			}
			
			textmsg+= "\n\r";
			isnewtext=true;
			stringlock.unlock();
			
			break;
		}*/
			case 0: {
				if(misep.szonda_msg_LENGTH>40)System.out.println("HO HÓ Max 40 bájtot tudok feldolgozni!!!");
				for(int i=0;i<misep.szonda_msg_LENGTH;i++){
					//
					int a=		(char) (misep.szonda_incoming_message_bytes.removeFirst() & 0xFF);
					stm8_inputdata[i]=a;
					
				}
				break;
			}
		case 2: {
			stringlock.lock();
			textmsg+="WARNING: ";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				textmsg +=c;
			}
			
			textmsg+= "\n\r";
			isnewtext=true;
			stringlock.unlock();
			
			break;
		}
		case 3: {
			stringlock.lock();
			textmsg+="ERROR: ";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				textmsg +=c;
			}
			
			textmsg+= "\n\r";
			isnewtext=true;
			stringlock.unlock();
			
			break;
		}
		/*case 10: {
			accel[0] = misep.incoming_message.removeFirst();
			accel[0] += 256 * (misep.incoming_message.removeFirst());
			accel[0] += 256 * 256 * (misep.incoming_message.removeFirst());
			accel[0] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());

			accel[1] = misep.incoming_message.removeFirst();
			accel[1] += 255 * (misep.incoming_message.removeFirst());
			accel[1] += 256 * 256 * (misep.incoming_message.removeFirst());
			accel[1] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());

			accel[2] = misep.incoming_message.removeFirst();
			accel[2] += 256 * (misep.incoming_message.removeFirst());
			accel[2] += 256 * 256 * (misep.incoming_message.removeFirst());
			accel[2] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			System.out.println("x:" + accel[0] + "  y:" + accel[1] + "  z:" + accel[2] );
			break;
		}
		case 11: {
			//ez a matlabnak megy!!!!
			gyro[0] = misep.incoming_message.removeFirst();
			gyro[0] += 256 * (misep.incoming_message.removeFirst());
			gyro[0] += 256 * 256 * (misep.incoming_message.removeFirst());
			gyro[0] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());

			gyro[1] = misep.incoming_message.removeFirst();
			gyro[1] += 255 * (misep.incoming_message.removeFirst());
			gyro[1] += 256 * 256 * (misep.incoming_message.removeFirst());
			gyro[1] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());

			gyro[2] = misep.incoming_message.removeFirst();
			gyro[2] += 256 * (misep.incoming_message.removeFirst());
			gyro[2] += 256 * 256 * (misep.incoming_message.removeFirst());
			gyro[2] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			break;
		}*/
		/*case 12: {
			
			//angle = misep.incoming_message.removeFirst();
			//angle += 256 * (misep.incoming_message.removeFirst());
			//angle += 256 * 256 * (misep.incoming_message.removeFirst());
			//angle += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			
			//bytes to float
			 byte[] bytes = {0,0,0,0};
			 int temp=0;
			 temp=misep.incoming_message.removeFirst();
			 bytes[0]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[1]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[2]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[3]=(byte)temp;
			 float f = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			 
			 angle = f;

			break;
		}
		case 20: {
			increment = misep.incoming_message.removeFirst();
			increment += 256 * (misep.incoming_message.removeFirst());
			increment += 256 * 256 * (misep.incoming_message.removeFirst());
			increment += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			increment-=2000000000;
			break;
		}*/
		/*case 21: {

			 byte[] bytes = {0,0,0,0};
			 int temp=0;
			 temp=misep.incoming_message.removeFirst();
			 bytes[0]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[1]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[2]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[3]=(byte)temp;
			 speed = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			 
			 //
			 //TODO
			 //hack
			 
			// byte[] bytes = {0,0,0,0};
			// int temp=0;
			 temp=misep.incoming_message.removeFirst();
			 bytes[0]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[1]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[2]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[3]=(byte)temp;
			 speederror = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			 
//				stringlock.lock();
//				textmsg+="Speederror: ";
//				
//
//					textmsg += (Float.toString(speederror));
//
//				
//				textmsg+= "\n\r";
//				isnewtext=true;
//				stringlock.unlock();
				
				//end of hack
			 
			 
			 
			 
			break;
		}*/
		case 22: {
			
			// TODO matlab send speed data
			
			for (int i = 0; i < 28; i++) {
				matlab_speed_parameters[i] = misep.incoming_message_bytes.removeFirst();
				
			}
			UDP_send(matlab_speed_parameters);

			break; 
		}
		case 23: {
			
			// TODO matlab send servo data
			
			
			for (int i = 0; i < 44; i++) {
				matlab_servo_parameters[i+matlab_servo_parameters_iterator*44] = misep.incoming_message_bytes.removeFirst();
				
			}
			matlab_servo_parameters_iterator++;
			
			if(matlab_servo_parameters_iterator == osszevart_data){
				UDP_send(matlab_servo_parameters);
				matlab_servo_parameters_iterator=0;
			}

			break; 
		}
		/*case 30: {
			for (int i = 0; i < 48; i++) {
				IRvalues[i] = misep.incoming_message.removeFirst();
				IRvalues[i] += 256 * (misep.incoming_message.removeFirst());
				IRvalues[i]=IRvalues[i]/4;
				if(IRvalues[i]>255)IRvalues[i]=255;
			}
			break;
		}*/
		/*case 33: {
				//
			lineposition[0] = misep.incoming_message.removeFirst();
			lineposition[1] = misep.incoming_message.removeFirst();
			
			
			//bytes to float
			 byte[] bytes = {0,0,0,0};
			 int temp=0;
			 temp=misep.incoming_message.removeFirst();
			 bytes[0]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[1]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[2]=(byte)temp;
			 temp=misep.incoming_message.removeFirst();
			 bytes[3]=(byte)temp;
			 float f = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();
			
			 szaberror=f;
			
			//szaberror = misep.incoming_message.removeFirst();
			//szaberror += 255 * (misep.incoming_message.removeFirst());
			//szaberror += 256 * 256 * (misep.incoming_message.removeFirst());
			//szaberror += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			break;
		}*/
		/*case 34: {
			
			linetype_F_R="";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				linetype_F_R +=c;
			}
			
			break;
		}
		case 41: {
			
			motorvoltage = misep.incoming_message.removeFirst();
			motorvoltage += 256 * (misep.incoming_message.removeFirst());
			drivervoltage = misep.incoming_message.removeFirst();
			drivervoltage += 256 * (misep.incoming_message.removeFirst());

			break;
		}*/
		case 42: {
			
			runtime="";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				runtime +=c;
			}
			
			break;
		}
		/*case 60: {
			UHvalues[0] = misep.incoming_message.removeFirst();
			UHvalues[0] += 256 * (misep.incoming_message.removeFirst());
			UHvalues[0] += 256 * 256 * (misep.incoming_message.removeFirst());
			UHvalues[0] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());

			UHvalues[1] = misep.incoming_message.removeFirst();
			UHvalues[1] += 255 * (misep.incoming_message.removeFirst());
			UHvalues[1] += 256 * 256 * (misep.incoming_message.removeFirst());
			UHvalues[1] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());

			UHvalues[2] = misep.incoming_message.removeFirst();
			UHvalues[2] += 256 * (misep.incoming_message.removeFirst());
			UHvalues[2] += 256 * 256 * (misep.incoming_message.removeFirst());
			UHvalues[2] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			
			UHvalues[3] = misep.incoming_message.removeFirst();
			UHvalues[3] += 256 * (misep.incoming_message.removeFirst());
			UHvalues[3] += 256 * 256 * (misep.incoming_message.removeFirst());
			UHvalues[3] += 256 * 256 * 256 * (misep.incoming_message.removeFirst());
			break;
		}*/
		case 70: {
			stringlock.lock();
			textmsg+="STATE: ";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				textmsg +=c;
			}
			
			textmsg+= "\n\r";
			isnewtext=true;
			stringlock.unlock();
			
			break;
		}
		case 71: {
			stringlock.lock();
			textmsg+="                                   LINE: ";
			
			for (int i=0; i< misep.msg_LENGTH; i++){
				char c = (char) (misep.incoming_message_bytes.removeFirst() & 0xFF);
				textmsg +=c;
			}
			
			textmsg+= "\n\r";
			isnewtext=true;
			stringlock.unlock();
			
			break;
		}
		case 256: {
			//drivervoltage =(int) misep.incoming_message.removeFirst();
			//motorvoltage =(int) misep.incoming_message.removeFirst();
			//misep.incoming_message.removeFirst();
			//isnewtext=true;
			break;
		}
		
		case 567: {
			capacitance[0] = misep.incoming_message.removeFirst();
			capacitance[0] += 256 * (misep.incoming_message.removeFirst());
			
			capacitance[1] = misep.incoming_message.removeFirst();
			capacitance[1] += 256 * (misep.incoming_message.removeFirst());
			
			capacitance[2] = misep.incoming_message.removeFirst();
			capacitance[2] += 256 * (misep.incoming_message.removeFirst());
			
			capacitance[3] = misep.incoming_message.removeFirst();
			capacitance[3] += 256 * (misep.incoming_message.removeFirst());
			
			capacitance[4] = misep.incoming_message.removeFirst();
			capacitance[4] += 256 * (misep.incoming_message.removeFirst());
			
			capacitance[5] = misep.incoming_message.removeFirst();
			capacitance[5] += 256 * (misep.incoming_message.removeFirst());

			break;
		}
		default: {
			// TODO
			//System.out.println("TYPE" + misep.msg_TYPE);
			//System.out.println("LENGTH" + misep.msg_LENGTH);
			//System.out.println("MSG" + misep.incoming_message);
			

			
			
			
			//byte udp_msg[];
			/*
			String s = "";
			for (int i = 0; i < misep.msg_LENGTH; i++) {
				s += misep.incoming_message_bytes.get(i);
				s+=" ";
			}
			s+="\n\r";
			UDP_send(s.getBytes());
			*/
			break;
		}
		}
	}
	
	
	
void UDP_send(byte[] message){
		try {
			//String host = "255.255.255.255";
			String host = "152.66.168.228";
			int port = 12000;

			//byte[] message = "Java Source and Support".getBytes();
			

			// Get the internet address of the specified host
			InetAddress address = InetAddress.getByName(host);

			// Initialize a datagram packet with data and address
			DatagramPacket packet = new DatagramPacket(message, message.length,
					address, port);

			// Create a datagram socket, send the packet through it, close it.
			DatagramSocket dsocket = new DatagramSocket();
			dsocket.send(packet);
			dsocket.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}
	
	
	
//futó szál
public void startMatlabThread() {
    new Thread(new MatlabThread()).start();
}

private class MatlabThread implements Runnable {
    public void run() {
        while(true) {
            //readSerial();
            try {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            //process here
//            String str="";
//            str+=accel[0] + " " + accel[1] + " " +accel[2] + "\n";
//            UDP_send(str.getBytes());
			
				
				UDP_send(matlab_speed_parameters);
			
            
            }

        }
    }

	
	
	
	
	
	//futó szál
	public void startRunningThread() {
	    new Thread(new RunningThread()).start();
	}
	
	private class RunningThread implements Runnable {
	    public void run() {
	        while(true) {
	            //readSerial();
	            try {
	                Thread.sleep(1);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	            if( misep.process_szonda_message() ){
	            	data_process();
	            }

	        }
	    }
	}

}// end of logic


