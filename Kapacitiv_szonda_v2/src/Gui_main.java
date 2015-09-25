
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JSlider;


import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.SwingConstants;

import javax.swing.JProgressBar;


public class Gui_main extends JFrame {

	 Logic logic = null;
	 
	 JPanel contentPane;
	 int[] capac_calib_min = new int[6];
	 int[] capac_calib_max = {1024,1024,1024,1024,1024,1024};//new int[6];
	 
	 int test_bar=0;
	 int test_val=0;

	 
	 
		
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

	
	//progress bar panel
	JProgressBar progressBar_0;
	JProgressBar progressBar_1;
	JProgressBar progressBar_2;
	JProgressBar progressBar_8;
	JProgressBar progressBar_7;
	JProgressBar progressBar_6;
	JProgressBar progressBar_5;
	JProgressBar progressBar_4;
	JProgressBar progressBar_3;
	JProgressBar progressBar_9;
	JProgressBar progressBar_10;
	JProgressBar progressBar_11;
	JProgressBar progressBar_12;
	JProgressBar progressBar_13;
	JProgressBar progressBar_14;
	JProgressBar progressBar_15;
	JProgressBar progressBar_16;
	JProgressBar progressBar_17;
	JProgressBar progressBar_18;
	JProgressBar progressBar_19;
	JProgressBar progressBar_20;
	JProgressBar progressBar_21;
	JProgressBar progressBar_22;
	JProgressBar progressBar_23;
	JProgressBar progressBar_24;
	JProgressBar progressBar_25;
	JProgressBar progressBar_26;
	JProgressBar progressBar_27;
	JProgressBar progressBar_28;
	JProgressBar progressBar_29;
	JProgressBar progressBar_30;
	JProgressBar progressBar_31;
	JProgressBar progressBar_32;
	JProgressBar progressBar_33;
	JProgressBar progressBar_34;
	JProgressBar progressBar_35;
	JProgressBar progressBar_36;
	JProgressBar progressBar_37;
	JProgressBar progressBar_38;
	JProgressBar progressBar_39;
	
	JButton btnReset;
	JButton btnMagic;
	JRadioButton rdbtnNewRadioButton;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	
	
	JRadioButton rdbtnAuto;




	 




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
		
		JButton btnSTOP = new JButton("Measure");
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
		panel_runtime.setBounds(198, 11, 314, 69);
		contentPane.add(panel_runtime);
		panel_runtime.setLayout(null);
		
		JScrollPane scrollPane_runtime = new JScrollPane();
		scrollPane_runtime.setBounds(10, 21, 298, 30);
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
		btn_Calib_max.setBounds(305, 11, 89, 23);
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
		btn_Calib_min.setBounds(305, 197, 89, 23);
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
		
		panel_1 = new JPanel();
		panel_1.setBounds(316, 66, 143, 118);
		panel_capacitance.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kerteszs\\Desktop\\tmp\\1.png"));
		lblNewLabel_1.setBounds(49, 32, 45, 46);
		panel_1.add(lblNewLabel_1);
		
		panel_tank = new JPanel();
		panel_tank.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_tank.setBounds(754, 2, 200, 400);
		contentPane.add(panel_tank);
		panel_tank.setLayout(null);
		
		panel_fuel = new JPanel();
		panel_fuel.setBounds(0, 0, 200, 400);
		panel_tank.add(panel_fuel);
		panel_fuel.setBackground(Color.ORANGE);
		panel_fuel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label = new JLabel("100%");
		label.setBounds(962, 2, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("0%");
		label_1.setBounds(962, 388, 46, 14);
		contentPane.add(label_1);
		
		JPanel panel_progress = new JPanel();
		panel_progress.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_progress.setBounds(537, 11, 212, 550);
		contentPane.add(panel_progress);
		panel_progress.setLayout(null);
		
		//progress bars
		progressBar_0 = new JProgressBar();
		progressBar_0.setBounds(10, 489, 146, 14);
		progressBar_0.setValue(0);
		panel_progress.add(progressBar_0);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setValue(0);
		progressBar_1.setBounds(10, 476, 146, 14);
		panel_progress.add(progressBar_1);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setValue(0);
		progressBar_2.setBounds(10, 465, 146, 14);
		panel_progress.add(progressBar_2);
		
		progressBar_3 = new JProgressBar();
		progressBar_3.setValue(0);
		progressBar_3.setBounds(10, 452, 146, 14);
		panel_progress.add(progressBar_3);
		
		progressBar_4 = new JProgressBar();
		progressBar_4.setValue(0);
		progressBar_4.setBounds(10, 440, 146, 14);
		panel_progress.add(progressBar_4);
		
		progressBar_5 = new JProgressBar();
		progressBar_5.setValue(0);
		progressBar_5.setBounds(10, 427, 146, 14);
		panel_progress.add(progressBar_5);
		
		progressBar_6 = new JProgressBar();
		progressBar_6.setValue(0);
		progressBar_6.setBounds(10, 416, 146, 14);
		panel_progress.add(progressBar_6);
		
		progressBar_7 = new JProgressBar();
		progressBar_7.setValue(0);
		progressBar_7.setBounds(10, 403, 146, 14);
		panel_progress.add(progressBar_7);
		
		progressBar_8 = new JProgressBar();
		progressBar_8.setValue(0);
		progressBar_8.setBounds(10, 391, 146, 14);
		panel_progress.add(progressBar_8);
		
		progressBar_9 = new JProgressBar();
		progressBar_9.setValue(0);
		progressBar_9.setBounds(10, 378, 146, 14);
		panel_progress.add(progressBar_9);
		
		progressBar_10 = new JProgressBar();
		progressBar_10.setValue(0);
		progressBar_10.setBounds(10, 367, 146, 14);
		panel_progress.add(progressBar_10);
		
		progressBar_11 = new JProgressBar();
		progressBar_11.setValue(0);
		progressBar_11.setBounds(10, 354, 146, 14);
		panel_progress.add(progressBar_11);
		
		progressBar_12 = new JProgressBar();
		progressBar_12.setValue(0);
		progressBar_12.setBounds(10, 342, 146, 14);
		panel_progress.add(progressBar_12);
		
		progressBar_13 = new JProgressBar();
		progressBar_13.setValue(0);
		progressBar_13.setBounds(10, 329, 146, 14);
		panel_progress.add(progressBar_13);
		
		progressBar_14 = new JProgressBar();
		progressBar_14.setValue(0);
		progressBar_14.setBounds(10, 318, 146, 14);
		panel_progress.add(progressBar_14);
		
		progressBar_15 = new JProgressBar();
		progressBar_15.setValue(0);
		progressBar_15.setBounds(10, 305, 146, 14);
		panel_progress.add(progressBar_15);
		
		progressBar_16 = new JProgressBar();
		progressBar_16.setValue(0);
		progressBar_16.setBounds(10, 293, 146, 14);
		panel_progress.add(progressBar_16);
		
		progressBar_17 = new JProgressBar();
		progressBar_17.setValue(0);
		progressBar_17.setBounds(10, 280, 146, 14);
		panel_progress.add(progressBar_17);
		
		progressBar_18 = new JProgressBar();
		progressBar_18.setValue(0);
		progressBar_18.setBounds(10, 269, 146, 14);
		panel_progress.add(progressBar_18);
		
		progressBar_19 = new JProgressBar();
		progressBar_19.setValue(0);
		progressBar_19.setBounds(10, 256, 146, 14);
		panel_progress.add(progressBar_19);
		
		progressBar_20 = new JProgressBar();
		progressBar_20.setValue(0);
		progressBar_20.setBounds(10, 244, 146, 14);
		panel_progress.add(progressBar_20);
		
		progressBar_21 = new JProgressBar();
		progressBar_21.setValue(0);
		progressBar_21.setBounds(10, 231, 146, 14);
		panel_progress.add(progressBar_21);
		
		progressBar_22 = new JProgressBar();
		progressBar_22.setValue(0);
		progressBar_22.setBounds(10, 220, 146, 14);
		panel_progress.add(progressBar_22);
		
		progressBar_23 = new JProgressBar();
		progressBar_23.setValue(0);
		progressBar_23.setBounds(10, 207, 146, 14);
		panel_progress.add(progressBar_23);
		
		progressBar_24 = new JProgressBar();
		progressBar_24.setValue(0);
		progressBar_24.setBounds(10, 195, 146, 14);
		panel_progress.add(progressBar_24);
		
		progressBar_25 = new JProgressBar();
		progressBar_25.setValue(0);
		progressBar_25.setBounds(10, 182, 146, 14);
		panel_progress.add(progressBar_25);
		
		progressBar_26 = new JProgressBar();
		progressBar_26.setValue(0);
		progressBar_26.setBounds(10, 171, 146, 14);
		panel_progress.add(progressBar_26);
		
		progressBar_27 = new JProgressBar();
		progressBar_27.setValue(0);
		progressBar_27.setBounds(10, 158, 146, 14);
		panel_progress.add(progressBar_27);
		
		progressBar_28 = new JProgressBar();
		progressBar_28.setValue(0);
		progressBar_28.setBounds(10, 146, 146, 14);
		panel_progress.add(progressBar_28);
		
		progressBar_29 = new JProgressBar();
		progressBar_29.setValue(0);
		progressBar_29.setBounds(10, 133, 146, 14);
		panel_progress.add(progressBar_29);
		
		progressBar_30 = new JProgressBar();
		progressBar_30.setValue(0);
		progressBar_30.setBounds(10, 122, 146, 14);
		panel_progress.add(progressBar_30);
		
		progressBar_31 = new JProgressBar();
		progressBar_31.setValue(0);
		progressBar_31.setBounds(10, 109, 146, 14);
		panel_progress.add(progressBar_31);
		
		progressBar_32 = new JProgressBar();
		progressBar_32.setValue(0);
		progressBar_32.setBounds(10, 97, 146, 14);
		panel_progress.add(progressBar_32);
		
		progressBar_33 = new JProgressBar();
		progressBar_33.setValue(0);
		progressBar_33.setBounds(10, 84, 146, 14);
		panel_progress.add(progressBar_33);
		
		progressBar_34 = new JProgressBar();
		progressBar_34.setValue(0);
		progressBar_34.setBounds(10, 73, 146, 14);
		panel_progress.add(progressBar_34);
		
		progressBar_35 = new JProgressBar();
		progressBar_35.setValue(0);
		progressBar_35.setBounds(10, 60, 146, 14);
		panel_progress.add(progressBar_35);
		
		progressBar_36 = new JProgressBar();
		progressBar_36.setValue(0);
		progressBar_36.setBounds(10, 48, 146, 14);
		panel_progress.add(progressBar_36);
		
		progressBar_37 = new JProgressBar();
		progressBar_37.setValue(0);
		progressBar_37.setBounds(10, 35, 146, 14);
		panel_progress.add(progressBar_37);
		
		progressBar_38 = new JProgressBar();
		progressBar_38.setValue(0);
		progressBar_38.setBounds(10, 24, 146, 14);
		panel_progress.add(progressBar_38);
		
		progressBar_39 = new JProgressBar();
		progressBar_39.setValue(0);
		progressBar_39.setBounds(10, 11, 146, 14);
		panel_progress.add(progressBar_39);
		
		JButton btn_progress_min = new JButton("---");
		btn_progress_min.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<40;i++)logic.progress_min_calib[i]=logic.stm8_inputdata[i];
			}
		});
		btn_progress_min.setBounds(159, 480, 48, 23);
		panel_progress.add(btn_progress_min);
		
		JButton btn_progress_reset = new JButton("Reset");
		btn_progress_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<40;i++)logic.progress_min_calib[i]=0;
				for(int i=0;i<40;i++)logic.progress_max_calib[i]=0;
			}
		});
		btn_progress_reset.setBounds(10, 514, 122, 23);
		panel_progress.add(btn_progress_reset);
		
		JButton btn_progress_max = new JButton("---");
		btn_progress_max.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<40;i++)logic.progress_max_calib[i]=logic.stm8_inputdata[i];
			}
		});
		btn_progress_max.setBounds(159, 11, 48, 23);
		panel_progress.add(btn_progress_max);
		
		btnMagic = new JButton("MAGIC");
		btnMagic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<40;i++){
					logic.progress_min_calib[i]=logic.stm8_inputdata[i];
					logic.progress_max_calib[i]=logic.progress_min_calib[i] +20;
				}
	
			}
		});
		btnMagic.setBounds(132, 514, 75, 23);
		panel_progress.add(btnMagic);
		
		rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(174, 342, 21, 23);
		panel_progress.add(rdbtnNewRadioButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(754, 441, 119, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnAuto = new JRadioButton("Auto");
		rdbtnAuto.setBounds(27, 43, 64, 23);
		panel.add(rdbtnAuto);


		
		
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
				/*
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
		*/
				
				/*//*************/
				
				//logic.Stopsignal();
				if( rdbtnAuto.isSelected())
				
				logic.misep.serialport.send_byte((byte) 0);
				
		/**//**********************************************************/
				if(logic.misep.newcapvalue == true){
					
					
					for (int i = 0; i < 40; i++) {
						if (logic.progress_max_calib[i] <= logic.progress_min_calib[i]) {
							logic.progress_max_calib[i] = 255;
							System.out.println("Nincs kalibrálva: " + i);
						}
					}
					
					for(int i=0;i<40;i++)logic.progressbar[i]=(logic.stm8_inputdata[i] - logic.progress_min_calib[i])*100 / (logic.progress_max_calib[i] - logic.progress_min_calib[i]);
					
					if(rdbtnNewRadioButton.isSelected())
						for(int i=0;i<40;i++)logic.progressbar[i]=logic.stm8_inputdata[i] ;
			
	
					progressBar_0.setValue( logic.progressbar[0] );
					progressBar_1.setValue( logic.progressbar[1] );
					progressBar_2.setValue( logic.progressbar[2] );
					progressBar_3.setValue( logic.progressbar[3] );
					progressBar_4.setValue( logic.progressbar[4] );
					progressBar_5.setValue( logic.progressbar[5] );
					progressBar_6.setValue( logic.progressbar[6] );
					progressBar_7.setValue( logic.progressbar[7] );
					progressBar_8.setValue( logic.progressbar[8] );
					progressBar_9.setValue( logic.progressbar[9] );
					progressBar_10.setValue( logic.progressbar[10] );
					progressBar_11.setValue( logic.progressbar[11] );
					progressBar_12.setValue( logic.progressbar[12] );
					progressBar_13.setValue( logic.progressbar[13] );
					progressBar_14.setValue( logic.progressbar[14] );
					progressBar_15.setValue( logic.progressbar[15] );
					progressBar_16.setValue( logic.progressbar[16] );
					progressBar_17.setValue( logic.progressbar[17] );
					progressBar_18.setValue( logic.progressbar[18] );
					progressBar_19.setValue( logic.progressbar[19] );
					progressBar_20.setValue( logic.progressbar[20] );
					progressBar_21.setValue( logic.progressbar[21] );
					progressBar_22.setValue( logic.progressbar[22] );
					progressBar_23.setValue( logic.progressbar[23] );
					progressBar_24.setValue( logic.progressbar[24] );
					progressBar_25.setValue( logic.progressbar[25] );
					progressBar_26.setValue( logic.progressbar[26] );
					progressBar_27.setValue( logic.progressbar[27] );
					progressBar_28.setValue( logic.progressbar[28] );
					progressBar_29.setValue( logic.progressbar[29] );
					progressBar_30.setValue( logic.progressbar[30] );
					progressBar_31.setValue( logic.progressbar[31] );
					progressBar_32.setValue( logic.progressbar[32] );
					progressBar_33.setValue( logic.progressbar[33] );
					progressBar_34.setValue( logic.progressbar[34] );
					progressBar_35.setValue( logic.progressbar[35] );
					progressBar_36.setValue( logic.progressbar[36] );
					progressBar_37.setValue( logic.progressbar[37] );
					progressBar_38.setValue( logic.progressbar[38] );
					progressBar_39.setValue( logic.progressbar[39] );
					
					//TEST
					if(logic.stm8_inputdata[0]<200)lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kerteszs\\Desktop\\tmp\\2.png"));
					else lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kerteszs\\Desktop\\tmp\\3.png"));
					
					
					for(int i=0;i<40;i++){
						System.out.print(logic.stm8_inputdata[i] + "   ");
						
					}
					System.out.println("");
					
					int fuel=0;
					
					fuel=0;for(int i=0;i<40;i++){
						if(logic.progressbar[i] >50)
							fuel++;
					}
					fuel= fuel*10/4;
					
					//FUEL : 0 - 100
					fuel*=4;
					if(fuel>400) fuel=400;
					panel_fuel.setBounds(0, 400-fuel, 200, fuel); //max 400
					logic.misep.newcapvalue = false;
				}
	           
	          //till this line  
	        }
	    }
	}
}// end of gui
