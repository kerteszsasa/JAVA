import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui extends JFrame {

	private JPanel contentPane;
	
	ESP_interface espinterface;
	JTextArea textArea;
	JSlider red;
	JSlider green;
	JSlider blue;
	private JScrollPane scrollPane_1;

	/**
	 * Create the frame.
	 */
	public Gui(ESP_interface esp) {
		setTitle("RGB lamp");
		espinterface=esp;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		red = new JSlider();
		red.setValue(0);
		red.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				byte[] msg = new byte[5];
				msg[0] = (byte) 49;
				msg[1] = (byte) 51;
				msg[2] = (byte) red.getValue();
				msg[3] = (byte) green.getValue();
				msg[4] = (byte) blue.getValue();
				ESPMessage aa= new ESPMessage("192.168.1.119", msg);
				//ESPMessage aa= new ESPMessage("127.0.0.1", msg);
				espinterface.OUTGOING_MSG.add(aa);
			}
		});
		red.setMaximum(255);
		red.setBounds(20, 11, 200, 23);
		contentPane.add(red);
		
		green = new JSlider();
		green.setValue(0);
		green.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				byte[] msg = new byte[5];
				msg[0] = (byte) 49;
				msg[1] = (byte) 51;
				msg[2] = (byte) red.getValue();
				msg[3] = (byte) green.getValue();
				msg[4] = (byte) blue.getValue();
				ESPMessage aa= new ESPMessage("192.168.1.119", msg);
				//ESPMessage aa= new ESPMessage("127.0.0.1", msg);
				espinterface.OUTGOING_MSG.add(aa);
			}
		});
		green.setMaximum(255);
		green.setBounds(20, 51, 200, 23);
		contentPane.add(green);
		
		blue = new JSlider();
		blue.setValue(0);
		blue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				byte[] msg = new byte[5];
				msg[0] = (byte) 49;
				msg[1] = (byte) 51;
				msg[2] = (byte) red.getValue();
				msg[3] = (byte) green.getValue();
				msg[4] = (byte) blue.getValue();
				ESPMessage aa= new ESPMessage("192.168.1.119", msg);
				//ESPMessage aa= new ESPMessage("127.0.0.1", msg);
				espinterface.OUTGOING_MSG.add(aa);
			}
		});
		blue.setMaximum(255);
		blue.setBounds(20, 96, 200, 23);
		contentPane.add(blue);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//System.out.println("hello");
				//System.out.println(red.getValue() +"  "+ green.getValue() +"  "+ blue.getValue());
				byte[] msg = new byte[5];
				msg[0] = (byte) 49;
				msg[1] = (byte) 51;
				msg[2] = (byte) red.getValue();
				msg[3] = (byte) green.getValue();
				msg[4] = (byte) blue.getValue();
				ESPMessage aa= new ESPMessage("192.168.1.119", msg);
				//ESPMessage aa= new ESPMessage("127.0.0.1", msg);
				espinterface.OUTGOING_MSG.add(aa);
				
			}
		});
		btnSend.setBounds(281, 51, 89, 23);
		contentPane.add(btnSend);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 147, 358, 78);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(226, 11, 23, 23);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(226, 51, 23, 23);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(226, 96, 23, 23);
		contentPane.add(panel_2);
		Start_GUI_Thread();
	}
	
	
	
	
	
	
	
	public void Start_GUI_Thread() {
	    new Thread(new GUI_Thread()).start();
	}
	
	 private class GUI_Thread implements Runnable {
	    public void run() {
	        while(true) {
	            try {
	                Thread.sleep(200);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	           /** do things here*/
	            
	           // textPane.setText( "message size: "+ espinterface.INCOMING_MSG.size() ); 
	            
	            
				if (espinterface.INCOMING_MSG.size() > 0) {
					ESPMessage msg = espinterface.INCOMING_MSG.remove(0);

					String incoming_IP = msg.GetIP();
					byte[] inbuf = msg.Getbytes();
					/**/// for debug
					/**/
					/**/System.out.println("IP: " + incoming_IP);
					/**/String decoded = null;
					try {
						decoded = new String(inbuf, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/**/System.out.println("MESSAGE: " + decoded);

					textArea.append("IP: " + incoming_IP + "      "
							+ "MESSAGE: " + decoded+"\n");
				}
	            
	            
			
	            
	           
	          /**till this line */  
	        }
	    }
	}
}// end of gui


