
public class Packet_serial {
	
	private
	byte MISE_STARTBYTE=(byte) 255;
	byte fraction;
	byte[] from_address = new byte[12];
	byte[] to_address = new byte[12];
	byte[] type = new byte[2];
	byte[] length = new byte[2];
	byte header_crc;
	byte[] data;
	byte data_crc;
	
}
