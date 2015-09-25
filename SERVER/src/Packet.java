public class Packet {

	// This is for store raw data
	private byte[] data;

	public Packet(byte[] d) {
		data = d;
	}

	byte[] Get_data() {
		return data;
	}

	int length() {
		return data.length;
	}

}
