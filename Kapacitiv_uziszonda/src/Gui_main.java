import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JSpinner;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;


public class Gui_main extends JFrame {

	 Logic logic = null;
	 
	 JPanel contentPane;
	 int[] capac_calib_min = new int[6];
	 int[] capac_calib_max = {1024,1024,1024,1024,1024,1024};//new int[6];

	 
	 
		
	String ss="";
	
	JTextArea textArea = new JTextArea();
	JTextArea textArea_runtime = new JTextArea();
	
	JSlider slider;
	JSlider slider_1;
	JSlider slider_2;
	JSlider slider_3;
	JSlider slider_4;
	JSlider slider_5;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	
	JPanel panel_fuel;
	private JPanel panel_tank;
	private JButton btnReset;



	 




	public Gui_main(final Logic logicparameter) {
		
		logic = logicparameter;

		setResizable(false);
		setTitle("Kapacitiv_uziszonda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSTOP = new JButton("STOP");
		btnSTOP.setBackground(Color.RED);
		btnSTOP.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSTOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Stopsignal();
			}
		});
		btnSTOP.setBounds(897, 413, 103, 159);
		contentPane.add(btnSTOP);
		
		JPanel panel_textfield = new JPanel();
		panel_textfield.setBounds(0, 405, 513, 167);
		contentPane.add(panel_textfield);
		panel_textfield.setLayout(null);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 510, 144);
		panel_textfield.add(scrollPane);
		
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);
		
		JButton btnTxtClear = new JButton("Clear");
		btnTxtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		btnTxtClear.setBounds(421, 144, 89, 23);
		panel_textfield.add(btnTxtClear);
		
		JPanel panel_Serial = new JPanel();
		panel_Serial.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Serial.setBounds(0, 0, 173, 69);
		contentPane.add(panel_Serial);
		panel_Serial.setLayout(null);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//logic.connect();
				System.out.println("Connect button pressed");
								
			}
		});
		btnConnect.setBounds(10, 11, 109, 23);
		panel_Serial.add(btnConnect);
		
		JRadioButton rdbtnAutoconnect = new JRadioButton("Autoconnect");
		rdbtnAutoconnect.setBounds(10, 41, 109, 23);
		panel_Serial.add(rdbtnAutoconnect);
		
		JPanel panel_Conn_status = new JPanel();
		panel_Conn_status.setBackground(logic.getconnectionsatatus());
		panel_Conn_status.setBounds(132, 11, 31, 32);
		panel_Serial.add(panel_Conn_status);
		
		JPanel panel_runtime = new JPanel();
		panel_runtime.setBounds(198, 11, 519, 69);
		contentPane.add(panel_runtime);
		panel_runtime.setLayout(null);
		
		JScrollPane scrollPane_runtime = new JScrollPane();
		scrollPane_runtime.setBounds(10, 21, 499, 30);
		panel_runtime.add(scrollPane_runtime);
		
		scrollPane_runtime.setViewportView(textArea_runtime);
		
		JPanel panel_capacitance = new JPanel();
		panel_capacitance.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_capacitance.setBounds(10, 97, 503, 276);
		contentPane.add(panel_capacitance);
		panel_capacitance.setLayout(null);
		
		slider = new JSlider();
		slider.setBounds(10, 11, 41, 216);
		panel_capacitance.add(slider);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setMaximum(1024);
		
		textField = new JTextField();
		textField.setBounds(10, 245, 41, 20);
		panel_capacitance.add(textField);
		textField.setColumns(10);
		
		slider_1 = new JSlider();
		slider_1.setOrientation(SwingConstants.VERTICAL);
		slider_1.setMaximum(1024);
		slider_1.setBounds(61, 11, 41, 216);
		panel_capacitance.add(slider_1);
		
		slider_2 = new JSlider();
		slider_2.setOrientation(SwingConstants.VERTICAL);
		slider_2.setMaximum(1024);
		slider_2.setBounds(112, 11, 41, 216);
		panel_capacitance.add(slider_2);
		
		slider_3 = new JSlider();
		slider_3.setOrientation(SwingConstants.VERTICAL);
		slider_3.setMaximum(1024);
		slider_3.setBounds(163, 11, 41, 216);
		panel_capacitance.add(slider_3);
		
		slider_4 = new JSlider();
		slider_4.setOrientation(SwingConstants.VERTICAL);
		slider_4.setMaximum(1024);
		slider_4.setBounds(214, 11, 41, 216);
		panel_capacitance.add(slider_4);
		
		slider_5 = new JSlider();
		slider_5.setOrientation(SwingConstants.VERTICAL);
		slider_5.setMaximum(1024);
		slider_5.setBounds(265, 11, 41, 216);
		panel_capacitance.add(slider_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 245, 41, 20);
		panel_capacitance.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 245, 41, 20);
		panel_capacitance.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 245, 41, 20);
		panel_capacitance.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(214, 245, 41, 20);
		panel_capacitance.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(265, 245, 41, 20);
		panel_capacitance.add(textField_5);
		
		JButton btn_Calib_max = new JButton("Calib MAX");
		btn_Calib_max.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				capac_calib_max[0]=logic.capacitance[0];
				capac_calib_max[1]=logic.capacitance[1];
				capac_calib_max[2]=logic.capacitance[2];
				capac_calib_max[3]=logic.capacitance[3];
				capac_calib_max[4]=logic.capacitance[4];
				capac_calib_max[5]=logic.capacitance[5];
			}
		});
		btn_Calib_max.setBounds(351, 49, 89, 23);
		panel_capacitance.add(btn_Calib_max);
		
		JButton btn_Calib_min = new JButton("Calib MIN");
		btn_Calib_min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				capac_calib_min[0]=logic.capacitance[0];
				capac_calib_min[1]=logic.capacitance[1];
				capac_calib_min[2]=logic.capacitance[2];
				capac_calib_min[3]=logic.capacitance[3];
				capac_calib_min[4]=logic.capacitance[4];
				capac_calib_min[5]=logic.capacitance[5];
			}
		});
		btn_Calib_min.setBounds(351, 204, 89, 23);
		panel_capacitance.add(btn_Calib_min);
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capac_calib_min[0]=0;
				capac_calib_min[1]=0;
				capac_calib_min[2]=0;
				capac_calib_min[3]=0;
				capac_calib_min[4]=0;
				capac_calib_min[5]=0;
				
				capac_calib_max[0]=1024;
				capac_calib_max[1]=1024;
				capac_calib_max[2]=1024;
				capac_calib_max[3]=1024;
				capac_calib_max[4]=1024;
				capac_calib_max[5]=1024;
			}
		});
		btnReset.setBounds(414, 253, 89, 23);
		panel_capacitance.add(btnReset);
		
		panel_tank = new JPanel();
		panel_tank.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_tank.setBounds(593, 120, 200, 400);
		contentPane.add(panel_tank);
		panel_tank.setLayout(null);
		
		panel_fuel = new JPanel();
		panel_fuel.setBounds(0, 0, 200, 400);
		panel_tank.add(panel_fuel);
		panel_fuel.setBackground(Color.ORANGE);
		panel_fuel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label = new JLabel("100%");
		label.setBounds(801, 120, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("0%");
		label_1.setBounds(801, 506, 46, 14);
		contentPane.add(label_1);

		
		
		Start_GUI_Thread();
				
	}


		
	
	
	public void Start_GUI_Thread() {
	    new Thread(new GUI_Thread()).start();
	}
	
	 private class GUI_Thread implements Runnable {
	    public void run() {
	        while(true) {
	            try {
	                Thread.sleep(500);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	           /// do things here
	          //  textField_diver_V.setText(Integer.toString(logic.drivervoltage / 1000) +"."+ Integer.toString(logic.drivervoltage % 1000) +" V");
	          //  textField_motor_V.setText(Integer.toString(logic.motorvoltage / 1000) +"."+ Integer.toString(logic.motorvoltage % 1000) +" V");
	            
	            //panel_sensor_1.setBackground(new Color( 3*logic.motorvoltage,3 *logic.motorvoltage,3*logic.motorvoltage));

	
	            
	            
	            
				// Text box
				if (logic.isnewtext) {
					logic.stringlock.lock();
					textArea.append(logic.textmsg);
					textArea.setCaretPosition(textArea.getDocument().getLength());
					logic.textmsg = "";
					logic.isnewtext = false;
					logic.stringlock.unlock();

				}

				// Task %
				textArea_runtime.setText("");
				textArea_runtime.append(logic.runtime);

				// INCREMENT
				/*txtIncrement.setText("");
				txtIncrement.setText(Integer.toString(logic.increment));*/

				// UH
			/*	textField_front.setText("");
				textField_left.setText("");
				textField_right.setText("");
				textField_rear.setText("");
				textField_front.setText(Integer.toString(logic.UHvalues[0]));
				textField_right.setText(Integer.toString(logic.UHvalues[1]));
				textField_rear.setText(Integer.toString(logic.UHvalues[2]));
				textField_left.setText(Integer.toString(logic.UHvalues[3]));*/
				
				// accelerometer
				//textaccx.setText("");
				//textaccy.setText("");
				//textaccz.setText("");
				/*textaccx.setText(Integer.toString(logic.accel[0]));
				textaccy.setText(Integer.toString(logic.accel[1]));
				textaccz.setText(Integer.toString(logic.accel[2]));*/
				
				// gyro szöge
				/*textangle.setText("");
				textangle.setText(Float.toString(logic.angle));*/
				
				//sebesség
			/*	textspeed.setText(Float.toString(logic.speed));*/
				
				// infra adatok
				/* textfrontlinepos.setText(Integer.toString(logic.lineposition[0]));
				 textrearlinepos.setText(Integer.toString(logic.lineposition[1]));
				 textirmax.setText("S: "+ Float.toString(logic.speederror));
				 textirmin.setText("todo");
				 textszaberr.setText(Float.toString(logic.szaberror));
				 textlinetipe.setText(logic.linetype_F_R);*/
				  
				 
				 
				//TODO
				slider.setValue(  ( logic.capacitance[0]-capac_calib_min[0])  * 1024 / (1024 - capac_calib_min[0])   );
				textField.setText(Integer.toString(          ( logic.capacitance[0]-capac_calib_min[0])  * 1024 / (1024 - capac_calib_min[0])        ));
				
				slider_1.setValue( ( logic.capacitance[1]-capac_calib_min[1])  * 1024 / (1024 - capac_calib_min[1]) );
				textField_1.setText(Integer.toString(( logic.capacitance[1]-capac_calib_min[1])  * 1024 / (1024 - capac_calib_min[1])));
				
				slider_2.setValue( ( logic.capacitance[2]-capac_calib_min[2])  * 1024 / (1024 - capac_calib_min[2]) );
				textField_2.setText(Integer.toString(( logic.capacitance[2]-capac_calib_min[2])  * 1024 / (1024 - capac_calib_min[2])));
				
				slider_3.setValue( ( logic.capacitance[3]-capac_calib_min[3])  * 1024 / (1024 - capac_calib_min[3]) );
				textField_3.setText(Integer.toString(( logic.capacitance[3]-capac_calib_min[3])  * 1024 / (1024 - capac_calib_min[3])));
				
				slider_4.setValue( ( logic.capacitance[4]-capac_calib_min[4])  * 1024 / (1024 - capac_calib_min[4]) );
				textField_4.setText(Integer.toString(( logic.capacitance[4]-capac_calib_min[4])  * 1024 / (1024 - capac_calib_min[4])));
				
				slider_5.setValue( ( logic.capacitance[5]-capac_calib_min[5])  * 1024 / (1024 - capac_calib_min[5]) );
				textField_5.setText(Integer.toString(( logic.capacitance[5]-capac_calib_min[5])  * 1024 / (1024 - capac_calib_min[5])));
				
				int measured_val=( logic.capacitance[0]-capac_calib_min[0])  * 1024 / (1024 - capac_calib_min[0]) + 
						( logic.capacitance[1]-capac_calib_min[1])  * 1024 / (1024 - capac_calib_min[1]) + 
						( logic.capacitance[2]-capac_calib_min[2])  * 1024 / (1024 - capac_calib_min[2]) + 
						( logic.capacitance[3]-capac_calib_min[3])  * 1024 / (1024 - capac_calib_min[3]) + 
						( logic.capacitance[4]-capac_calib_min[4])  * 1024 / (1024 - capac_calib_min[4]) + 
						( logic.capacitance[5]-capac_calib_min[5])  * 1024 / (1024 - capac_calib_min[5]);
				
				//measured_val/=6;
				measured_val*=10;
				int fuel =measured_val*100/1024;
				
				int measured_level=(logic.capacitance[0]-capac_calib_min[0])*100/(capac_calib_max[0]-capac_calib_min[0])+
									(logic.capacitance[1]-capac_calib_min[1])*100/(capac_calib_max[1]-capac_calib_min[1])+
									(logic.capacitance[2]-capac_calib_min[2])*100/(capac_calib_max[2]-capac_calib_min[2])+
									(logic.capacitance[3]-capac_calib_min[3])*100/(capac_calib_max[3]-capac_calib_min[3])+
									(logic.capacitance[4]-capac_calib_min[4])*100/(capac_calib_max[4]-capac_calib_min[4])+
									(logic.capacitance[5]-capac_calib_min[5])*100/(capac_calib_max[5]-capac_calib_min[5]);
				measured_level/=6;
				
				fuel=measured_level;
				//FUEL : 0 - 100
				fuel*=4;
				if(fuel>400) fuel=400;
				panel_fuel.setBounds(0, 400-fuel, 200, fuel); //max 400
				
				
	           
	          //till this line  
	        }
	    }
	}
}// end of gui
