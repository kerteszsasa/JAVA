public class ESPMessage {
	String IP;
	byte[] BUFFER;

	public	ESPMessage(String ip, byte[] buffer) {
			IP = ip;
			BUFFER = buffer;
		}
	
	public	byte[] Getbytes() {
			return BUFFER;
		}
	
	public	String GetIP() {
			return IP;
		}

}
