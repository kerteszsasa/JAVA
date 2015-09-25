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
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;


public class Gui_main extends JFrame {

	 Logic logic = null;
	 
	 JPanel contentPane;
	 int[] capac_calib_min = new int[6];
	 int[] capac_calib_max = {1024,1024,1024,1024,1024,1024};//new int[6];

	 
	 
		
	String ss="";
	
	JTextArea textArea = new JTextArea();
	JTextArea textArea_runtime = new JTextArea();
	
	//servo
	JTextField textField_servonum;
	JTextField textField_servo_speed;
	JSlider slider_servovalue;
	
	//leg AD
	JTextField textField_leg_1;
	JTextField textField_leg_2;
	JTextField textField_leg_3;
	JTextField textField_leg_6;
	JTextField textField_leg_5;
	JTextField textField_leg_4;
	
	//supply
	JPanel panel_supply_servo_indicator;
	
	//battery
	JTextField textField_battery;
	
	//leg_move
	JTextField text_set_leg_a;
	JTextField text_set_leg_b;
	JTextField text_set_leg_c;
	JTextField text_set_pos_a;
	JTextField text_set_pos_b;
	JTextField text_set_pos_c;
	JTextField text_set_speed_a;
	JTextField text_set_speed_b;
	JTextField text_set_speed_c;
	JLabel lbl_frame_actual;
	



	 
	public Color Int_to_GreenYellowRed(int value) {
		// 0-33: green
		// 34-66: yellow
		// 67-100: red
		if(value>100)return (new Color(0,0,0));		// dummy input -> black color :)		
		if(value<50)return (new Color(155+value*2, 255, 0));//green
		if(value>50)return (new Color(255,  (255-((value-50)*3)),   0));//red
		return (new Color(255, 255, 0));//yellow
	}




	public Gui_main(final Logic logicparameter) {
		
		logic = logicparameter;

		setResizable(false);
		setTitle("HEXAPOD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSTOP = new JButton("STOP");
		btnSTOP.setBounds(897, 413, 103, 159);
		btnSTOP.setBackground(Color.RED);
		btnSTOP.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSTOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Send_Stop();
			}
		});
		contentPane.setLayout(null);
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
		panel_Serial.setBounds(0, 0, 173, 69);
		panel_Serial.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_Serial);
		panel_Serial.setLayout(null);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//logic.connect();
				//logic.misep.serialport.connect("Serialoptions.txt");
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
		
		JPanel panel_servotest = new JPanel();
		panel_servotest.setBounds(517, 425, 370, 114);
		panel_servotest.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_servotest);
		panel_servotest.setLayout(null);
		
		textField_servonum = new JTextField();
		textField_servonum.setText("0");
		textField_servonum.setBounds(10, 48, 86, 20);
		panel_servotest.add(textField_servonum);
		textField_servonum.setColumns(10);
		
		JLabel lblServoNumber = new JLabel("Servo number [ 1 - 18 ]");
		lblServoNumber.setBounds(10, 11, 129, 14);
		panel_servotest.add(lblServoNumber);
		
		JLabel lblSpeedDelayBetween = new JLabel("Speed: delay between steeps");
		lblSpeedDelayBetween.setBounds(169, 11, 191, 14);
		panel_servotest.add(lblSpeedDelayBetween);
		
		textField_servo_speed = new JTextField();
		textField_servo_speed.setText("100");
		textField_servo_speed.setBounds(169, 48, 86, 20);
		panel_servotest.add(textField_servo_speed);
		textField_servo_speed.setColumns(10);
		
		slider_servovalue = new JSlider();
		slider_servovalue.setMinimum(0);
		slider_servovalue.setMaximum(200);
		slider_servovalue.setValue(100);
		slider_servovalue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				logic.Send_servo_position(Integer.parseInt(textField_servonum.getText()), slider_servovalue.getValue() ,  Integer.parseInt(textField_servo_speed.getText()) );
				
				//System.out.println( Integer.parseInt(textField_servonum.getText()));
				//System.out.println( slider_servovalue.getValue() );
				//System.out.println( Integer.parseInt(textField_servo_speed.getText()));
				
			}
		});
		slider_servovalue.setBounds(20, 79, 340, 23);
		panel_servotest.add(slider_servovalue);
		
		JPanel panel_leg_AD = new JPanel();
		panel_leg_AD.setBounds(736, 25, 272, 167);
		panel_leg_AD.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_leg_AD);
		panel_leg_AD.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(99, 11, 79, 145);
		panel_leg_AD.add(panel);
		
		textField_leg_1 = new JTextField();
		textField_leg_1.setBackground(Color.GREEN);
		textField_leg_1.setBounds(178, 11, 86, 20);
		panel_leg_AD.add(textField_leg_1);
		textField_leg_1.setColumns(10);
		
		textField_leg_2 = new JTextField();
		textField_leg_2.setBackground(Color.GREEN);
		textField_leg_2.setColumns(10);
		textField_leg_2.setBounds(178, 72, 86, 20);
		panel_leg_AD.add(textField_leg_2);
		
		textField_leg_3 = new JTextField();
		textField_leg_3.setBackground(Color.GREEN);
		textField_leg_3.setColumns(10);
		textField_leg_3.setBounds(178, 136, 86, 20);
		panel_leg_AD.add(textField_leg_3);
		
		textField_leg_6 = new JTextField();
		textField_leg_6.setBackground(Color.GREEN);
		textField_leg_6.setColumns(10);
		textField_leg_6.setBounds(10, 11, 86, 20);
		panel_leg_AD.add(textField_leg_6);
		
		textField_leg_5 = new JTextField();
		textField_leg_5.setBackground(Color.GREEN);
		textField_leg_5.setColumns(10);
		textField_leg_5.setBounds(10, 72, 86, 20);
		panel_leg_AD.add(textField_leg_5);
		
		textField_leg_4 = new JTextField();
		textField_leg_4.setBackground(Color.GREEN);
		textField_leg_4.setColumns(10);
		textField_leg_4.setBounds(10, 136, 86, 20);
		panel_leg_AD.add(textField_leg_4);
		
		JPanel panel_supply_servo = new JPanel();
		panel_supply_servo.setBounds(889, 203, 111, 101);
		panel_supply_servo.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_supply_servo);
		panel_supply_servo.setLayout(null);
		
		panel_supply_servo_indicator = new JPanel();
		panel_supply_servo_indicator.setBackground(Color.RED);
		panel_supply_servo_indicator.setBounds(10, 11, 89, 30);
		panel_supply_servo.add(panel_supply_servo_indicator);
		
		JButton btn_supply_ON = new JButton("ON");
		btn_supply_ON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Send_supply_ONOFF(1);
			}
		});
		btn_supply_ON.setBounds(10, 52, 89, 23);
		panel_supply_servo.add(btn_supply_ON);
		
		JButton btn_supply_OFF = new JButton("OFF");
		btn_supply_OFF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.Send_supply_ONOFF(0);
			}
		});
		btn_supply_OFF.setBounds(10, 76, 89, 23);
		panel_supply_servo.add(btn_supply_OFF);
		
		JPanel panel_leg_move = new JPanel();
		panel_leg_move.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_leg_move.setBounds(28, 110, 513, 256);
		contentPane.add(panel_leg_move);
		panel_leg_move.setLayout(null);
		
		JLabel lbl_select_leg = new JLabel("LEG");
		lbl_select_leg.setBounds(10, 11, 46, 14);
		panel_leg_move.add(lbl_select_leg);
		
		JLabel lbl_select_pos = new JLabel("POS");
		lbl_select_pos.setBounds(73, 11, 46, 14);
		panel_leg_move.add(lbl_select_pos);
		
		JLabel lbl_select_speed = new JLabel("SPEED");
		lbl_select_speed.setBounds(129, 11, 46, 14);
		panel_leg_move.add(lbl_select_speed);
		
		text_set_leg_a = new JTextField();
		text_set_leg_a.setText("0");
		text_set_leg_a.setBounds(10, 51, 40, 20);
		panel_leg_move.add(text_set_leg_a);
		text_set_leg_a.setColumns(10);
		
		text_set_leg_b = new JTextField();
		text_set_leg_b.setText("0");
		text_set_leg_b.setBounds(10, 82, 40, 20);
		panel_leg_move.add(text_set_leg_b);
		text_set_leg_b.setColumns(10);
		
		text_set_leg_c = new JTextField();
		text_set_leg_c.setText("0");
		text_set_leg_c.setBounds(10, 113, 40, 20);
		panel_leg_move.add(text_set_leg_c);
		text_set_leg_c.setColumns(10);
		
		text_set_pos_a = new JTextField();
		text_set_pos_a.setText("100");
		text_set_pos_a.setColumns(10);
		text_set_pos_a.setBounds(73, 51, 40, 20);
		panel_leg_move.add(text_set_pos_a);
		
		text_set_pos_b = new JTextField();
		text_set_pos_b.setText("100");
		text_set_pos_b.setColumns(10);
		text_set_pos_b.setBounds(73, 82, 40, 20);
		panel_leg_move.add(text_set_pos_b);
		
		text_set_pos_c = new JTextField();
		text_set_pos_c.setText("100");
		text_set_pos_c.setColumns(10);
		text_set_pos_c.setBounds(73, 113, 40, 20);
		panel_leg_move.add(text_set_pos_c);
		
		text_set_speed_a = new JTextField();
		text_set_speed_a.setText("100");
		text_set_speed_a.setColumns(10);
		text_set_speed_a.setBounds(134, 51, 40, 20);
		panel_leg_move.add(text_set_speed_a);
		
		text_set_speed_b = new JTextField();
		text_set_speed_b.setText("100");
		text_set_speed_b.setColumns(10);
		text_set_speed_b.setBounds(134, 82, 40, 20);
		panel_leg_move.add(text_set_speed_b);
		
		text_set_speed_c = new JTextField();
		text_set_speed_c.setText("100");
		text_set_speed_c.setColumns(10);
		text_set_speed_c.setBounds(134, 113, 40, 20);
		panel_leg_move.add(text_set_speed_c);
		
		JButton btn_PREV = new JButton("<<");
		btn_PREV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.move_editor.Prev();
				lbl_frame_actual.setText( Integer.toString( logic.move_editor.Get_actual_frame() ) );
				
				if (logic.move_editor.Get_actual_frame() > 0) {
					text_set_leg_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[0]));
					text_set_pos_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[1]));
					text_set_speed_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[2]));
					text_set_leg_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[3]));
					text_set_pos_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[4]));
					text_set_speed_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[5]));
					text_set_leg_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[6]));
					text_set_pos_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[7]));
					text_set_speed_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[8]));
				}
				
			}
		});
		btn_PREV.setBounds(10, 154, 50, 23);
		panel_leg_move.add(btn_PREV);
		
		JButton btn_NEXT = new JButton(">>");
		btn_NEXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.move_editor.Next();
				lbl_frame_actual.setText( Integer.toString( logic.move_editor.Get_actual_frame() ) );
				
				if (logic.move_editor.Get_actual_frame() > 0) {
					text_set_leg_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[0]));
					text_set_pos_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[1]));
					text_set_speed_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[2]));
					text_set_leg_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[3]));
					text_set_pos_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[4]));
					text_set_speed_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[5]));
					text_set_leg_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[6]));
					text_set_pos_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[7]));
					text_set_speed_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[8]));
				}
			}
		});
		btn_NEXT.setBounds(125, 154, 50, 23);
		panel_leg_move.add(btn_NEXT);
		
		JButton btn_ADD = new JButton("ADD");
		btn_ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//logic.move_editor.Add(1,110,100, 2,99,100, 3,100,100);
				logic.move_editor.Add(Integer.parseInt(text_set_leg_a.getText()),Integer.parseInt(text_set_pos_a.getText()),Integer.parseInt(text_set_speed_a.getText()),Integer.parseInt(text_set_leg_b.getText()),Integer.parseInt(text_set_pos_b.getText()),Integer.parseInt(text_set_speed_b.getText()),Integer.parseInt(text_set_leg_c.getText()),Integer.parseInt(text_set_pos_c.getText()),Integer.parseInt(text_set_speed_c.getText()));
				
				lbl_frame_actual.setText( Integer.toString( logic.move_editor.Get_actual_frame() ) );
			}
		});
		btn_ADD.setBounds(205, 29, 89, 23);
		panel_leg_move.add(btn_ADD);
		
		JButton btn_REMOVE = new JButton("REMOVE");
		btn_REMOVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.move_editor.Remove();
				lbl_frame_actual.setText( Integer.toString( logic.move_editor.Get_actual_frame() ) );
				
				if (logic.move_editor.Get_actual_frame() > 0) {
					text_set_leg_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[0]));
					text_set_pos_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[1]));
					text_set_speed_a.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[2]));
					text_set_leg_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[3]));
					text_set_pos_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[4]));
					text_set_speed_b.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[5]));
					text_set_leg_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[6]));
					text_set_pos_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[7]));
					text_set_speed_c.setText(Integer.toString(logic.move_editor
							.Get_actual_data()[8]));
				}
			}
		});
		btn_REMOVE.setBounds(205, 81, 89, 23);
		panel_leg_move.add(btn_REMOVE);
		
		JPanel panel_frame_actual = new JPanel();
		panel_frame_actual.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_frame_actual.setBounds(73, 144, 40, 40);
		panel_leg_move.add(panel_frame_actual);
		panel_frame_actual.setLayout(null);
		
		lbl_frame_actual = new JLabel("0");
		lbl_frame_actual.setBounds(0, 0, 40, 40);
		panel_frame_actual.add(lbl_frame_actual);
		lbl_frame_actual.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btn_LOAD = new JButton("LOAD");
		btn_LOAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.move_editor.Load();
			}
		});
		btn_LOAD.setBounds(30, 222, 89, 23);
		panel_leg_move.add(btn_LOAD);
		
		JButton btn_SAVE = new JButton("SAVE");
		btn_SAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.move_editor.Save();
			}
		});
		btn_SAVE.setBounds(164, 222, 89, 23);
		panel_leg_move.add(btn_SAVE);
		
		JButton btn_move = new JButton("MOVE");
		btn_move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.move_editor.Send_movements();
			}
		});
		btn_move.setBackground(Color.GREEN);
		btn_move.setBounds(215, 154, 89, 42);
		panel_leg_move.add(btn_move);
		
		JComboBox comboBox_filelist = new JComboBox();
		String[] filelist = logic.move_editor.Get_txt_file_list("C:\\SASA\\MOVEMENTS");
		if(filelist != null){
			 for (int i=0; i<filelist.length; i++)
			 {
				 String filename = filelist[i];
				 comboBox_filelist.addItem(filename);
			 }
		}
		comboBox_filelist.setBounds(317, 82, 171, 20);
		panel_leg_move.add(comboBox_filelist);
		
		JPanel panel_battery = new JPanel();
		panel_battery.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_battery.setBounds(736, 203, 117, 62);
		contentPane.add(panel_battery);
		panel_battery.setLayout(null);
		
		textField_battery = new JTextField();
		textField_battery.setBounds(10, 29, 86, 20);
		panel_battery.add(textField_battery);
		textField_battery.setColumns(10);
		
		JLabel lbl_battery = new JLabel("Battery voltage");
		lbl_battery.setBounds(10, 11, 86, 14);
		panel_battery.add(lbl_battery);

		
		
		Start_GUI_Thread();
				
	}


		
	
	
	public void Start_GUI_Thread() {
	    new Thread(new GUI_Thread()).start();
	}
	
	 private class GUI_Thread implements Runnable {
	    public void run() {
	        while(true) {
	            try {
	                Thread.sleep(20);
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
				
				
				
				//LEG CURRENT
				
				//logic.Leg_currents[0]=slider_servovalue.getValue();
				
				
				textField_leg_1.setText(Integer.toString(logic.Leg_currents[0]) + "mA");
				textField_leg_1.setBackground(Int_to_GreenYellowRed( logic.Leg_color[0] ));
				
				textField_leg_2.setText(Integer.toString(logic.Leg_currents[1]) + "mA");
				textField_leg_2.setBackground(Int_to_GreenYellowRed( logic.Leg_color[1] ));
				
				textField_leg_3.setText(Integer.toString(logic.Leg_currents[2]) + "mA");
				textField_leg_3.setBackground(Int_to_GreenYellowRed( logic.Leg_color[2] ));
				
				textField_leg_4.setText(Integer.toString(logic.Leg_currents[3]) + "mA");
				textField_leg_4.setBackground(Int_to_GreenYellowRed( logic.Leg_color[3] ));
				
				textField_leg_5.setText(Integer.toString(logic.Leg_currents[4]) + "mA");
				textField_leg_5.setBackground(Int_to_GreenYellowRed( logic.Leg_color[4] ));
				
				textField_leg_6.setText(Integer.toString(logic.Leg_currents[5]) + "mA");
				textField_leg_6.setBackground(Int_to_GreenYellowRed( logic.Leg_color[5] ));
				
				//supply
				if(logic.supply_servo_state==1)
				panel_supply_servo_indicator.setBackground(Color.GREEN);
				else
					panel_supply_servo_indicator.setBackground(Color.RED);
				
				//batt voltage
				textField_battery.setText(Integer.toString(logic.battery_voltage / 100) + "." + Integer.toString(logic.battery_voltage % 100) + "V");
				
				
		
				
				
	           
	          //till this line  
	        }
	    }
	}
}// end of gui
