


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
import java.util.Iterator;
import java.util.List;



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

public TCP_NIO_server() throws IOException {
    this(DEFAULT_PORT);
}

public TCP_NIO_server(int port) throws IOException {
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
    System.out.println(socketChannel.getRemoteAddress());
    if (numRead == -1) {
        System.out.println("Graceful shutdown");
        key.channel().close();
        key.cancel();

        return;
    }
System.out.println(socketChannel.getRemoteAddress());
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
    ByteBuffer dummyResponse = ByteBuffer.wrap("ok".getBytes("UTF-8"));

    socketChannel.write(dummyResponse);
    if (dummyResponse.remaining() > 0) {
        System.err.print("Filled UP");
    }

    key.interestOps(SelectionKey.OP_READ);
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


}