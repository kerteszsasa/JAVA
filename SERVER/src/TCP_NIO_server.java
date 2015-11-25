


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class TCP_NIO_server {

private static final int BUFFER_SIZE = 1024;
private final static int DEFAULT_PORT = 9090;

// The buffer into which we'll read data when it's available
private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);

private InetAddress hostAddress = null;

private int port;
private Selector selector;

private long loopTime;
private long numMessages = 0;

Map<String, List<ByteBuffer>> TcpRxTunnel ;
Map<String, List<ByteBuffer>> TcpTxTunnel ;


public TCP_NIO_server(int port, Map<String, List<ByteBuffer>> RX, Map<String, List<ByteBuffer>> TX) throws IOException {
	this.TcpRxTunnel = RX;
	this.TcpTxTunnel = TX;
	
    this.port = port;
    selector = initSelector();
    new TCP_Thread().start();
}



  class TCP_Thread extends Thread {

	public TCP_Thread() {	}

	public void run() {
		while (true) {

	        try{
	            selector.select();
	            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
	            while (selectedKeys.hasNext()) {
	                SelectionKey key = selectedKeys.next();
	                selectedKeys.remove();

	                if (!key.isValid()) {
	                    continue;
	                }

	                // Check what event is available and deal with it
	                if (key.isAcceptable()) {
	                    accept(key);
	                } else if (key.isReadable()) {
	                    read(key);
	                } else if (key.isWritable()) {
	                    write(key);
	                }
	                
	                
	        		try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
	    
		}
	}
}


private void accept(SelectionKey key) throws IOException {
    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

    SocketChannel socketChannel = serverSocketChannel.accept();
    socketChannel.configureBlocking(false);
    socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true);
    socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true);
    socketChannel.register(selector, SelectionKey.OP_READ);

    System.out.println("Client is connected");
}

private void read(SelectionKey key) throws IOException {
    SocketChannel socketChannel = (SocketChannel) key.channel();

    // Clear out our read buffer so it's ready for new data
    readBuffer.clear();


    // Attempt to read off the channel
    int numRead;
    try {
        numRead = socketChannel.read(readBuffer);
    } catch (IOException e) {
        key.cancel();
        socketChannel.close();

        System.out.println("Forceful shutdown");
        return;
    }

    if (numRead == -1) {
        System.out.println("Graceful shutdown");
        key.channel().close();
        key.cancel();

        return;
    }
//System.out.println("TEST: "+socketChannel.getRemoteAddress()+ "DATA: "+ readBuffer.toString());
    incomingdata(socketChannel.getRemoteAddress().toString(), readBuffer, TcpRxTunnel);


    socketChannel.register(selector, SelectionKey.OP_WRITE);

    numMessages++;
    if (numMessages%100000 == 0) {
        long elapsed = System.currentTimeMillis() - loopTime;
        loopTime = System.currentTimeMillis();
        System.out.println(elapsed);
    }
}

private void write(SelectionKey key) throws IOException {
    SocketChannel socketChannel = (SocketChannel) key.channel();



   // System.out.println("outsocketaddress:                             : "+socketChannel.getRemoteAddress());
    outgoingdata(socketChannel.getRemoteAddress().toString(), socketChannel, TcpTxTunnel);
    
    
    
    /*    ByteBuffer dummyResponse = ByteBuffer.wrap("ok".getBytes("UTF-8"));
    socketChannel.write(dummyResponse);
    if (dummyResponse.remaining() > 0) {
        System.err.print("Filled UP");
    }*/

    key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
}

private Selector initSelector() throws IOException {
    Selector socketSelector = SelectorProvider.provider().openSelector();

    ServerSocketChannel serverChannel = ServerSocketChannel.open();
    serverChannel.configureBlocking(false);

    InetSocketAddress isa = new InetSocketAddress(hostAddress, port);
    serverChannel.socket().bind(isa);
    serverChannel.register(socketSelector, SelectionKey.OP_ACCEPT);
    return socketSelector;
}


private void incomingdata(String ip_port, ByteBuffer incoming_data, Map<String, List<ByteBuffer>> incoming_tunnel){
	System.out.println("INCOMING DATA: "+ ip_port);
	
	   byte[] oldBytes = incoming_data.array();
	    byte[] copiedBytes = new byte[incoming_data.position()];
	    // (Object src, int srcPos, Object dest, int destPos, int length) 
	    System.arraycopy(oldBytes, 0, copiedBytes, 0, incoming_data.position());
	    ByteBuffer duplicate = ByteBuffer.wrap(copiedBytes);
	    
	   // System.out.println(duplicate);
	    
	    List<ByteBuffer> list = null;
	    
	    list = incoming_tunnel.get(ip_port);
	    if( list == null) list = new ArrayList<ByteBuffer>();
	    
	    list.add(duplicate);
	    incoming_tunnel.put(ip_port, list);
	    
	    System.out.println(incoming_tunnel.keySet());
	    
	    //TODO
	   // System.out.println("itt kell folytatni");
	 
}

private void outgoingdata(String ip_port, SocketChannel out_data_socket, Map<String, List<ByteBuffer>> outgoing_tunnel)  throws IOException{
	if(outgoing_tunnel.isEmpty()) return;
	
	List<ByteBuffer> list = null;
    list = outgoing_tunnel.get(ip_port);
    if( list == null) return;
    
    ByteBuffer data = null;
   data = list.remove(0);
   
   if (data == null){
	   outgoing_tunnel.remove(ip_port);
   }
   
   out_data_socket.write(data);
	
}

}