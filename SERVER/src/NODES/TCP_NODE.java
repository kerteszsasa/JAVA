package NODES;

import java.nio.ByteBuffer;

public class TCP_NODE {
	
	public void IN_buffer(ByteBuffer inbuf){
		System.out.println(inbuf.toString());
	}
	
	public ByteBuffer OUT_buffer(){
		return null;
	}

}
