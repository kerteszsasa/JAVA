import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;


public class MISE_protocol {
	
	//Misep special chars
	
	byte MISE_STARTBYTE=(byte) 255;
	byte MISE_FROMBYTE=(byte) 11;
	byte MISE_TOBYTE=(byte) 12;
	byte MISE_TYPE1BYTE=(byte) 13;
	byte MISE_TYPE2BYTE=(byte) 14;
	
	byte MISE_ROBOTCAR=(byte) 14;
	byte MISE_PC=(byte) 14;
	byte MISE_HEXAPOD=(byte) 14;
	byte MISE_HOVERCRAFT=(byte) 14;
	
	byte msg_TYPE1;
	byte msg_TYPE2;
	byte msg_LENGTH1;
	byte msg_LENGTH2;
	byte msg_CRC;
	
	byte msg_FROM;
	byte msg_TO;
	int msg_TYPE;
	int msg_LENGTH;
	
	
	
	LinkedList<Integer> incoming_message = new LinkedList<Integer>();
	LinkedList<Byte> incoming_message_bytes = new LinkedList<Byte>();
	
	Serial serialport = null;



	public MISE_protocol(Serial s) {
		serialport = s;
	}

	void connect() {
		try {
			serialport.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!serialport.isconnected());
			
	}

	

	void send_msg(int type, byte buffer[], int length) {

		serialport.send_byte((byte) MISE_STARTBYTE);
		serialport.send_byte((byte) MISE_STARTBYTE);

		serialport.send_byte((byte) MISE_FROMBYTE);
		serialport.send_byte((byte) MISE_TOBYTE);
		serialport.send_byte((byte) type);
		serialport.send_byte((byte) (type >> 8));

		serialport.send_byte((byte) length);
		serialport.send_byte((byte) (length >> 8));

		serialport.send_byte((byte) (
				MISE_STARTBYTE +
				MISE_STARTBYTE +
				MISE_FROMBYTE +
				MISE_TOBYTE +
				((byte) type) +
				((byte) (type >> 8)) +
				(byte) (length) +
				(byte) (length << 8)
				));
		
		

		byte crc = 0;
		for (int i = 0; i < length; i++) {
			serialport.send_byte((byte) buffer[i]);
			crc += (byte) buffer[i];
		}
		serialport.send_byte(crc);

	}




	boolean getstatus() {
		return serialport.isconnected();
	}
	
	boolean process_message(){
		//System.out.println("feldolgoz");
		serialport.lock.lock();
		if(serialport.incoming_data_fifo.isEmpty()){
			serialport.lock.unlock();
			return false;
		}
		
		if(serialport.incoming_data_fifo.size() < 9){
			serialport.lock.unlock();
			return false;
		}
		
		int a=(int) serialport.incoming_data_fifo.remove() & 0xFF;
		if( (a !=255)  ){
			serialport.lock.unlock();
			return false;
		}
		a=(int) serialport.incoming_data_fifo.remove() & 0xFF;
		if( (a !=255)  ){
			serialport.lock.unlock();
			return false;
		}
		
		 msg_FROM = serialport.incoming_data_fifo.remove();
		 msg_TO = serialport.incoming_data_fifo.remove();
		 msg_TYPE1 = serialport.incoming_data_fifo.remove();
		 msg_TYPE2 = serialport.incoming_data_fifo.remove();
		 msg_LENGTH1 = serialport.incoming_data_fifo.remove();
		 msg_LENGTH2 = serialport.incoming_data_fifo.remove();
		 msg_CRC = serialport.incoming_data_fifo.remove();
		 
		 if( MISE_STARTBYTE + MISE_STARTBYTE+msg_FROM + msg_TO +	 msg_TYPE1 + msg_TYPE2+ msg_LENGTH1+	msg_LENGTH2 != msg_CRC){
			 serialport.lock.unlock();
			 return false;
		 }
		 
			 
		 int datasize = (int)msg_LENGTH1& 0xFF ;
		 datasize += 256*( (int)msg_LENGTH2& 0xFF );
		 datasize += 1;
		 
		 int available_data = serialport.incoming_data_fifo.size();
		 
		 serialport.lock.unlock();
		 while(available_data <  datasize ){
		
		     try {
	             Thread.sleep(1);
	         } catch(InterruptedException ex) {
	             Thread.currentThread().interrupt();
	         }
		     
		     serialport.lock.lock();
		     available_data = serialport.incoming_data_fifo.size();
		     serialport.lock.unlock();
			 //TODO ide kell egy timeout számláló, ami x idõ után visszatér hibával
		 }
		 serialport.lock.lock();
		 

		 incoming_message.clear();
		 incoming_message_bytes.clear();
		 byte data;
		 byte crc=0;
		 //TODO shiftelni !!!
		 for(int i=0;i< ( (int)msg_LENGTH1& 0xFF + (int)msg_LENGTH2& 0xFF) ;i++){
			 data = serialport.incoming_data_fifo.remove();
			 crc+=data;
			 incoming_message.add( (int)data& 0xFF );
			 incoming_message_bytes.add(data);
		 }
		 
		
		 msg_CRC = serialport.incoming_data_fifo.remove();
		 if(msg_CRC!=crc){
			 serialport.lock.unlock();
			 return false;
		 }
		 
		 //System.out.println(incoming_message);
		 msg_TYPE = (int)msg_TYPE1& 0xFF ;
		 msg_TYPE += 256*( (int)msg_TYPE2& 0xFF );
		 msg_LENGTH = datasize-1;
		 serialport.lock.unlock();
		 return true;
		 
		 
	}
	


}// end of MISE

