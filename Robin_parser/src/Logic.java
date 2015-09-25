import javax.swing.JDialog;

public class Logic {

	Serial serial = null;
	
	Logger logger= null;
	Filename dialog = null;
	
	static byte start_cmd[] = { (byte) 0xAA, (byte) 0xAA, (byte) 0xAA,
			(byte) 0x99, (byte) 0x3E, (byte) 0xFE, (byte) 0x04, (byte) 0x05,
			(byte) 0x03, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x01,
			(byte) 0x4A };

	int input;
	int[] magnet_values = new int[12];
	int[] magnet_max = new int[12];
	int[] magnet_min = new int[12];
	int[] magnet_base = new int[12];
	int[] magnet_match = new int[12];
	boolean valid_data = false;
	
	
	Serial serial2 = null;
	boolean isserial2= false;
	float temperature=0;
	

	public Logic(Serial s) {

		
		serial = s;
		serial.connect("Serialoptions.txt");
		System.out.println(serial.isconnected());
		serial.send_bytes(start_cmd, 14);
		serial.send_bytes(start_cmd, 14);
		serial.send_bytes(start_cmd, 14);
		serial.send_bytes(start_cmd, 14);
		serial.send_bytes(start_cmd, 14);
		startRunningThread();
		
		for(int i=0; i<12; i++){
			magnet_max[i]=0;
			magnet_min[i]=4096;	
		}
		
		logger= new Logger();
		//logger.log_timestamp("Program started" , "Vector.txt");
		
		//hack
		serial2 = new Serial();
		serial2.connect("Serialoptions2.txt");
		isserial2 = serial2.isconnected();

		
		// set saved filename
		try {
			dialog = new Filename();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	boolean Read_data() {
		serial.lock.lock();
		/*
		 * if (serialport.incoming_data_fifo.isEmpty()) {
		 * serialport.lock.unlock(); continue; }
		 */

		if (serial.incoming_data_fifo.size() < 38) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 170)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 170)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 170)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 153)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 55)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 62)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 0)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 29)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 3)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 0)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 0)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 25)) {
			serial.lock.unlock();
			return false;
		}
		input = (int) serial.incoming_data_fifo.remove() & 0xFF;
		if ((input != 5)) {
			//serial.lock.unlock();
			//return false;
		}
		for (int i = 0; i < 12; i++) {
			magnet_values[i] = (int) serial.incoming_data_fifo.remove() & 0xFF;
			magnet_values[i] *= 256;
			magnet_values[i] += (int) serial.incoming_data_fifo.remove() & 0xFF;
		}

		input = (int) serial.incoming_data_fifo.remove() & 0xFF; // get CRC
		/*
		 * for (int i = 0; i < 12; i++) { System.out.print(magnet_values[i] +
		 * " "); }
		 * 
		 * System.out.println("");
		 */
		serial.lock.unlock();
		
		
		//HACK
		int[] csere = new int[12];
		
		{
			csere[0] = magnet_values[1];
			csere[1] = magnet_values[2];
			csere[2] = magnet_values[0];
			csere[3] = magnet_values[5];
			csere[4] = magnet_values[4];
			csere[5] = magnet_values[3];
			csere[6] = magnet_values[11];
			csere[7] = magnet_values[9];
			csere[8] = magnet_values[10];
			csere[9] = magnet_values[8];
			csere[10] = magnet_values[7];
			csere[11] = magnet_values[6];
			
			magnet_values = csere;
 
		

		
		}
		
		
		
		for(int i=0; i<12; i++){
			if(magnet_max[i] < magnet_values[i]) magnet_max[i] = magnet_values[i];
			if(magnet_min[i] > magnet_values[i]) magnet_min[i] = magnet_values[i];
			
		}
		
		Save_vector();
		
		return true;
	}
	
	
	void Read_temp(){
		float data=0;
		int sign =0;
		float read_temp=0;
		
		serial2.lock.lock();
		if (serial2.incoming_data_fifo.size() < 10) {
			serial2.lock.unlock();
			return;
			
		}
		
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF;	// + OR -
		if( data !='+' && data !='-'){
			return;
		}
		if(data== '+'){
			sign =1;												// positive number
		}
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF -48;	
		read_temp+= 10* data;
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF -48;
		read_temp+=data;
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF;	// .
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF -48;	
		read_temp+= data/10;
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF -48;	
		read_temp+= data/100;
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF -48;	
		read_temp+= data/1000;
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF -48;	
		read_temp+= data/10000;
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF;	// \r
		data = (int) serial2.incoming_data_fifo.remove() & 0xFF;	// \n
		
		if(sign ==0){
			read_temp=-read_temp;
		}
		
		//System.out.println(read_temp);
		serial2.lock.unlock();
	
		temperature=read_temp;
		System.out.println(temperature);
	}
	
	void Set_base(){
		for(int i=0; i<12; i++){
			 magnet_base[i] = magnet_values[i];	
		}
	}
	
	void Set_match(){
		for(int i=0; i<12; i++){
			 magnet_match[i] = magnet_values[i];	
		}
	}
	
	void Save_vector(){
		String data="";
		for(int i=0; i<12; i++){
			 data += magnet_values[i];
			 data += " ";
		}
		data += (int)temperature;
		 logger.log_timestamp(data , "LOG\\" + dialog.Get_filename() + ".txt");
	}
	
	
	

	// futó szál
	public void startRunningThread() {
		new Thread(new RunningThread()).start();
	}

	private class RunningThread implements Runnable {
		public void run() {
			while (true) {
				// readSerial();
				try {
					Thread.sleep(1);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				if (Read_data() ) {
					valid_data = true;
				}
				
				
				if(isserial2){
					Read_temp();
				}

			}
		}
	}

}// end of logic 
