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


public class Gui_main extends JFrame {

	 Logic logic = null;
	 
	 JPanel contentPane;
	 JTextField txtIncrement;
	 JTextField textirmin;
	 JTextField textirmax;
	 JTextField textspeed;
	 JTextField textangle;
	 JTextField textaccx;
	 JTextField textaccy;
	 JTextField textaccz;

	 
	 
		
	String ss="";
	
	//varibles
	JPanel panel_sensor_1 = new JPanel();
	JPanel panel_sensor_2 = new JPanel();
	JPanel panel_sensor_3 = new JPanel();
	JPanel panel_sensor_4 = new JPanel();
	JPanel panel_sensor_5 = new JPanel();
	JPanel panel_sensor_6 = new JPanel();
	JPanel panel_sensor_7 = new JPanel();
	JPanel panel_sensor_8 = new JPanel();
	JPanel panel_sensor_9 = new JPanel();
	JPanel panel_sensor_10 = new JPanel();
	JPanel panel_sensor_11 = new JPanel();
	JPanel panel_sensor_12 = new JPanel();
	JPanel panel_sensor_13 = new JPanel();
	JPanel panel_sensor_14 = new JPanel();
	JPanel panel_sensor_15 = new JPanel();
	JPanel panel_sensor_16 = new JPanel();
	JPanel panel_sensor_17 = new JPanel();
	JPanel panel_sensor_18 = new JPanel();
	JPanel panel_sensor_19 = new JPanel();
	JPanel panel_sensor_20 = new JPanel();
	JPanel panel_sensor_21 = new JPanel();
	JPanel panel_sensor_22= new JPanel();
	JPanel panel_sensor_23= new JPanel();
	JPanel panel_sensor_24= new JPanel();
	JPanel panel_sensor_25= new JPanel();
	JPanel panel_sensor_26= new JPanel();
	JPanel panel_sensor_27= new JPanel();
	JPanel panel_sensor_28= new JPanel();
	JPanel panel_sensor_29= new JPanel();
	JPanel panel_sensor_30= new JPanel();
	JPanel panel_sensor_31= new JPanel();
	JPanel panel_sensor_32= new JPanel();
	JPanel panel_sensor_33= new JPanel();
	JPanel panel_sensor_34= new JPanel();
	JPanel panel_sensor_35= new JPanel();
	JPanel panel_sensor_36= new JPanel();
	JPanel panel_sensor_37= new JPanel();
	JPanel panel_sensor_38= new JPanel();
	JPanel panel_sensor_39= new JPanel();
	JPanel panel_sensor_40= new JPanel();
	JPanel panel_sensor_41= new JPanel();
	JPanel panel_sensor_42= new JPanel();
	JPanel panel_sensor_43= new JPanel();
	JPanel panel_sensor_44= new JPanel();
	JPanel panel_sensor_45= new JPanel();
	JPanel panel_sensor_46= new JPanel();
	JPanel panel_sensor_47= new JPanel();
	JPanel panel_sensor_48= new JPanel();
	
	JTextArea textArea = new JTextArea();
	JTextArea textArea_runtime = new JTextArea();
	
	
	 JTextField textField_front;
	 JTextField textField_left;
	 JTextField textField_right;
	 JTextField textField_rear;
	 
	 JSlider slider_speed;
	 JTextField textsetspeed;
	 JRadioButton rdbtnMotorsetspeed;
	 JTextField textField_diver_V;
	 JTextField textField_motor_V;
	 JPanel panel_PID_speed = new JPanel();
	 JLabel lblSpeedP = new JLabel("Speed P");
	 JLabel lblSpeedI = new JLabel("Speed I");
	 JLabel lblSpeedD = new JLabel("Speed D");
	 JLabel lblServo_line_P = new JLabel("Line P");
	 JLabel lblServo_line_I = new JLabel("Line I");
	 
	 JSlider sliderspeedp;
	 JSlider sliderspeedi;
	 JSlider sliderspeedd;
	 JSlider sliderservo_line_P;
	 JSlider sliderservo_line_I;
	 JTextField textspeedp;
	 JTextField textspeedi;
	 JTextField textspeedd;
	 JTextField textservo_line_P;
	 JTextField textservo_line_I;
	 
	 //TODO
	 JSlider sliderservo_line_D = new JSlider();
	 JSlider sliderservo_line_ratio = new JSlider();
	 JSlider slider_speeddelay = new JSlider();
	 JSlider slider_servodelay = new JSlider();
	 
	 
	 JTextField textservo_line_d = new JTextField();
	 JTextField text_line_ratio = new JTextField();
	 JTextField textspeeddelay = new JTextField();
	 JTextField textservodelay = new JTextField();
	 
	 
	 
	 JTextField textfrontlinepos = new JTextField();
	 JTextField textrearlinepos = new JTextField();
	 JTextField textszaberr = new JTextField();
	 JTextArea textlinetipe;
	 JPanel panel = new JPanel();
	 

	  JSlider sliderservo_angle_P;
	  JSlider sliderservo_angle_I;
	  JSlider sliderservo_angle_D;
	  JSlider sliderservo_angle_ratio;
	  JTextField textangle_P;
	  JTextField textangle_I;
	  JTextField textangle_D;
	  JTextField texangle_ratio;
	  
	  JTextField text_speedselector_lassu;
	  JTextField text_speedselector_gyorsabb;
	  JSlider slider_speedselector_lassu;
	  JSlider slider_speedselector_gyorsabb;
	  private final JTextField text_cascade_multiplier = new JTextField();
	  private final JLabel lblCascademult = new JLabel("Cascade_mult");
	  JPanel panel_speed_indicator = new JPanel();



	 




	public Gui_main(final Logic logicparameter) {
		text_cascade_multiplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(Integer.parseInt(text_cascade_multiplier.getText()));
				logic.Send_cascade_multilier_values(Integer.parseInt(text_cascade_multiplier.getText()));
				
			}
		});
		text_cascade_multiplier.setBounds(472, 366, 86, 20);
		text_cascade_multiplier.setColumns(10);
		textszaberr.setBounds(85, 111, 70, 20);
		textszaberr.setColumns(10);
		textrearlinepos.setBounds(85, 36, 70, 20);
		textrearlinepos.setColumns(10);
		textfrontlinepos.setBounds(85, 11, 70, 20);
		textfrontlinepos.setColumns(10);
		
		logic = logicparameter;

		setResizable(false);
		setTitle("Robonaut");
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
		
		final JRadioButton rdbtnInfo = new JRadioButton("INFO");
		rdbtnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(rdbtnInfo.isSelected());
				if(rdbtnInfo.isSelected()){
					ss+="INFO: "+ "msg" + "\n\r";
				}
				//TODo			
			}
		});
		rdbtnInfo.setBounds(0, 144, 56, 23);
		panel_textfield.add(rdbtnInfo);
		
		final JRadioButton rdbtnWarning = new JRadioButton("WARNING");
		rdbtnWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(rdbtnWarning.isSelected());
				if(rdbtnWarning.isSelected()){
					ss+="Warning: "+ "msg" + "\n\r";
				}
				//TODo			
			}
		});
		rdbtnWarning.setBounds(60, 144, 75, 23);
		panel_textfield.add(rdbtnWarning);
		
		final JRadioButton rdbtnError = new JRadioButton("ERROR");
		rdbtnError.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(rdbtnError.isSelected());
				if(rdbtnError.isSelected()){
					ss+="Error: "+ "msg" + "\n\r";
				}
				// TODo
			}
		});
		rdbtnError.setBounds(137, 144, 61, 23);
		panel_textfield.add(rdbtnError);
		
		JPanel panel_IR = new JPanel();
		panel_IR.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_IR.setBounds(176, 0, 535, 159);
		contentPane.add(panel_IR);
		panel_IR.setLayout(null);
		
		panel_sensor_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_1.setBackground(Color.WHITE);
		panel_sensor_1.setBounds(10, 11, 12, 12);
		panel_IR.add(panel_sensor_1);
		
		panel_sensor_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_2.setBackground(Color.WHITE);
		panel_sensor_2.setBounds(32, 11, 12, 12);
		panel_IR.add(panel_sensor_2);
		
		panel_sensor_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_3.setBackground(Color.WHITE);
		panel_sensor_3.setBounds(54, 11, 12, 12);
		panel_IR.add(panel_sensor_3);
		
		panel_sensor_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_4.setBackground(Color.WHITE);
		panel_sensor_4.setBounds(76, 11, 12, 12);
		panel_IR.add(panel_sensor_4);
		
		panel_sensor_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_5.setBackground(Color.WHITE);
		panel_sensor_5.setBounds(98, 11, 12, 12);
		panel_IR.add(panel_sensor_5);
		
		panel_sensor_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_6.setBackground(Color.WHITE);
		panel_sensor_6.setBounds(120, 11, 12, 12);
		panel_IR.add(panel_sensor_6);
		
		panel_sensor_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_7.setBackground(Color.WHITE);
		panel_sensor_7.setBounds(142, 11, 12, 12);
		panel_IR.add(panel_sensor_7);
		
		panel_sensor_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_8.setBackground(Color.WHITE);
		panel_sensor_8.setBounds(164, 11, 12, 12);
		panel_IR.add(panel_sensor_8);
		
		panel_sensor_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_9.setBackground(Color.WHITE);
		panel_sensor_9.setBounds(186, 11, 12, 12);
		panel_IR.add(panel_sensor_9);
		
		panel_sensor_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_10.setBackground(Color.WHITE);
		panel_sensor_10.setBounds(208, 11, 12, 12);
		panel_IR.add(panel_sensor_10);
		
		panel_sensor_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_11.setBackground(Color.WHITE);
		panel_sensor_11.setBounds(230, 11, 12, 12);
		panel_IR.add(panel_sensor_11);
		
		panel_sensor_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_12.setBackground(Color.WHITE);
		panel_sensor_12.setBounds(252, 11, 12, 12);
		panel_IR.add(panel_sensor_12);
		
		panel_sensor_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_13.setBackground(Color.WHITE);
		panel_sensor_13.setBounds(274, 11, 12, 12);
		panel_IR.add(panel_sensor_13);
		
		panel_sensor_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_14.setBackground(Color.WHITE);
		panel_sensor_14.setBounds(296, 11, 12, 12);
		panel_IR.add(panel_sensor_14);
		
		panel_sensor_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_15.setBackground(Color.WHITE);
		panel_sensor_15.setBounds(318, 11, 12, 12);
		panel_IR.add(panel_sensor_15);
		
		panel_sensor_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_16.setBackground(Color.WHITE);
		panel_sensor_16.setBounds(340, 11, 12, 12);
		panel_IR.add(panel_sensor_16);
	
		panel_sensor_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_17.setBackground(Color.WHITE);
		panel_sensor_17.setBounds(362, 11, 12, 12);
		panel_IR.add(panel_sensor_17);
		
		panel_sensor_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_18.setBackground(Color.WHITE);
		panel_sensor_18.setBounds(384, 11, 12, 12);
		panel_IR.add(panel_sensor_18);
		
		panel_sensor_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_19.setBackground(Color.WHITE);
		panel_sensor_19.setBounds(406, 11, 12, 12);
		panel_IR.add(panel_sensor_19);
		
		panel_sensor_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_20.setBackground(Color.WHITE);
		panel_sensor_20.setBounds(428, 11, 12, 12);
		panel_IR.add(panel_sensor_20);
		
		panel_sensor_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_21.setBackground(Color.WHITE);
		panel_sensor_21.setBounds(450, 11, 12, 12);
		panel_IR.add(panel_sensor_21);
		
		panel_sensor_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_22.setBackground(Color.WHITE);
		panel_sensor_22.setBounds(472, 11, 12, 12);
		panel_IR.add(panel_sensor_22);
		
		panel_sensor_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_23.setBackground(Color.WHITE);
		panel_sensor_23.setBounds(494, 11, 12, 12);
		panel_IR.add(panel_sensor_23);
		
		panel_sensor_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_24.setBackground(Color.WHITE);
		panel_sensor_24.setBounds(516, 11, 12, 12);
		panel_IR.add(panel_sensor_24);
		
		panel_sensor_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_25.setBackground(Color.WHITE);
		panel_sensor_25.setBounds(10, 136, 12, 12);
		panel_IR.add(panel_sensor_25);
		
		panel_sensor_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_26.setBackground(Color.WHITE);
		panel_sensor_26.setBounds(32, 136, 12, 12);
		panel_IR.add(panel_sensor_26);
		
		panel_sensor_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_27.setBackground(Color.WHITE);
		panel_sensor_27.setBounds(54, 136, 12, 12);
		panel_IR.add(panel_sensor_27);
		
		panel_sensor_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_28.setBackground(Color.WHITE);
		panel_sensor_28.setBounds(76, 136, 12, 12);
		panel_IR.add(panel_sensor_28);
		
		panel_sensor_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_29.setBackground(Color.WHITE);
		panel_sensor_29.setBounds(98, 136, 12, 12);
		panel_IR.add(panel_sensor_29);
		
		panel_sensor_30.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_30.setBackground(Color.WHITE);
		panel_sensor_30.setBounds(120, 136, 12, 12);
		panel_IR.add(panel_sensor_30);
		
		panel_sensor_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_31.setBackground(Color.WHITE);
		panel_sensor_31.setBounds(142, 136, 12, 12);
		panel_IR.add(panel_sensor_31);
		
		panel_sensor_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_32.setBackground(Color.WHITE);
		panel_sensor_32.setBounds(164, 136, 12, 12);
		panel_IR.add(panel_sensor_32);
		
		panel_sensor_33.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_33.setBackground(Color.WHITE);
		panel_sensor_33.setBounds(186, 136, 12, 12);
		panel_IR.add(panel_sensor_33);
		
		panel_sensor_34.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_34.setBackground(Color.WHITE);
		panel_sensor_34.setBounds(208, 136, 12, 12);
		panel_IR.add(panel_sensor_34);
		
		panel_sensor_35.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_35.setBackground(Color.WHITE);
		panel_sensor_35.setBounds(230, 136, 12, 12);
		panel_IR.add(panel_sensor_35);
		
		panel_sensor_36.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_36.setBackground(Color.WHITE);
		panel_sensor_36.setBounds(252, 136, 12, 12);
		panel_IR.add(panel_sensor_36);
		
		panel_sensor_37.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_37.setBackground(Color.WHITE);
		panel_sensor_37.setBounds(274, 136, 12, 12);
		panel_IR.add(panel_sensor_37);
		
		panel_sensor_38.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_38.setBackground(Color.WHITE);
		panel_sensor_38.setBounds(296, 136, 12, 12);
		panel_IR.add(panel_sensor_38);
		
		panel_sensor_39.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_39.setBackground(Color.WHITE);
		panel_sensor_39.setBounds(318, 136, 12, 12);
		panel_IR.add(panel_sensor_39);
		
		panel_sensor_40.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_40.setBackground(Color.WHITE);
		panel_sensor_40.setBounds(340, 136, 12, 12);
		panel_IR.add(panel_sensor_40);
		
		panel_sensor_41.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_41.setBackground(Color.WHITE);
		panel_sensor_41.setBounds(362, 136, 12, 12);
		panel_IR.add(panel_sensor_41);
		
		panel_sensor_42.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_42.setBackground(Color.WHITE);
		panel_sensor_42.setBounds(384, 136, 12, 12);
		panel_IR.add(panel_sensor_42);
		
		panel_sensor_43.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_43.setBackground(Color.WHITE);
		panel_sensor_43.setBounds(406, 136, 12, 12);
		panel_IR.add(panel_sensor_43);
		
		panel_sensor_44.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_44.setBackground(Color.WHITE);
		panel_sensor_44.setBounds(428, 136, 12, 12);
		panel_IR.add(panel_sensor_44);
		
		panel_sensor_45.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_45.setBackground(Color.WHITE);
		panel_sensor_45.setBounds(450, 136, 12, 12);
		panel_IR.add(panel_sensor_45);
		
		panel_sensor_46.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_46.setBackground(Color.WHITE);
		panel_sensor_46.setBounds(472, 136, 12, 12);
		panel_IR.add(panel_sensor_46);
		
		panel_sensor_47.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_47.setBackground(Color.WHITE);
		panel_sensor_47.setBounds(494, 136, 12, 12);
		panel_IR.add(panel_sensor_47);
		
		panel_sensor_48.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_sensor_48.setBackground(Color.WHITE);
		panel_sensor_48.setBounds(516, 136, 12, 12);
		panel_IR.add(panel_sensor_48);
		
		JPanel panel_runtime = new JPanel();
		panel_runtime.setBounds(10, 11, 519, 144);
		panel_IR.add(panel_runtime);
		panel_runtime.setLayout(null);
		
		JScrollPane scrollPane_runtime = new JScrollPane();
		scrollPane_runtime.setBounds(10, 21, 499, 100);
		panel_runtime.add(scrollPane_runtime);
		
		scrollPane_runtime.setViewportView(textArea_runtime);
		
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
		
		JPanel panel_measured = new JPanel();
		panel_measured.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_measured.setBounds(880, 0, 138, 218);
		contentPane.add(panel_measured);
		panel_measured.setLayout(null);
		
		txtIncrement = new JTextField();
		txtIncrement.setBounds(45, 11, 86, 20);
		panel_measured.add(txtIncrement);
		txtIncrement.setColumns(10);
		
		textspeed = new JTextField();
		textspeed.setColumns(10);
		textspeed.setBounds(45, 39, 86, 20);
		panel_measured.add(textspeed);
		
		JLabel lblIncrement = new JLabel("Increm");
		lblIncrement.setBounds(10, 14, 65, 14);
		panel_measured.add(lblIncrement);
		
		JLabel lblspeed = new JLabel("Speed");
		lblspeed.setBounds(10, 42, 65, 14);
		panel_measured.add(lblspeed);
		
		JLabel lblangle = new JLabel("Angle");
		lblangle.setBounds(10, 164, 65, 14);
		panel_measured.add(lblangle);
		
		textangle = new JTextField();
		textangle.setColumns(10);
		textangle.setBounds(45, 164, 86, 20);
		panel_measured.add(textangle);
		
		JButton btnGyroNull = new JButton("Gyro null");
		btnGyroNull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.GyroNull();
			}
		});
		btnGyroNull.setBounds(10, 189, 89, 23);
		panel_measured.add(btnGyroNull);
		
		textaccx = new JTextField();
		textaccx.setBounds(45, 71, 86, 20);
		panel_measured.add(textaccx);
		textaccx.setColumns(10);
		
		textaccy = new JTextField();
		textaccy.setBounds(45, 102, 86, 20);
		panel_measured.add(textaccy);
		textaccy.setColumns(10);
		
		textaccz = new JTextField();
		textaccz.setBounds(45, 133, 86, 20);
		panel_measured.add(textaccz);
		textaccz.setColumns(10);
		
		JLabel lblAccX = new JLabel("Acc X");
		lblAccX.setBounds(10, 74, 46, 14);
		panel_measured.add(lblAccX);
		
		JLabel lblAccY = new JLabel("Acc y");
		lblAccY.setBounds(10, 105, 46, 14);
		panel_measured.add(lblAccY);
		
		JLabel lblAccZ = new JLabel("Acc z");
		lblAccZ.setBounds(10, 136, 46, 14);
		panel_measured.add(lblAccZ);
		
		JPanel panel_batt_voltage = new JPanel();
		panel_batt_voltage.setBounds(0, 67, 173, 69);
		contentPane.add(panel_batt_voltage);
		panel_batt_voltage.setLayout(null);
		
		textField_diver_V = new JTextField();
		textField_diver_V.setBounds(77, 11, 86, 20);
		textField_diver_V.setColumns(10);
		panel_batt_voltage.add(textField_diver_V);
		
		textField_motor_V = new JTextField();
		textField_motor_V.setColumns(10);
		textField_motor_V.setBounds(77, 38, 86, 20);
		panel_batt_voltage.add(textField_motor_V);
		
		JLabel lbl_driverbatt = new JLabel("Driver V");
		lbl_driverbatt.setBounds(10, 14, 46, 14);
		panel_batt_voltage.add(lbl_driverbatt);
		
		JLabel lbl_motorbatt = new JLabel("Motor V");
		lbl_motorbatt.setBounds(10, 41, 46, 14);
		panel_batt_voltage.add(lbl_motorbatt);
		
		JPanel panel_control = new JPanel();
		panel_control.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_control.setBounds(523, 414, 364, 158);
		contentPane.add(panel_control);
		panel_control.setLayout(null);
		
		rdbtnMotorsetspeed = new JRadioButton("MOT maual");
		rdbtnMotorsetspeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textsetspeed.setText("Autocontrol");
				if(rdbtnMotorsetspeed.isSelected()){
					textsetspeed.setText("0");
					slider_speed.setValue(0);
					logic.Setspeed(0);
				}
				if(!rdbtnMotorsetspeed.isSelected()){
					textsetspeed.setText("Autocontrol");
					slider_speed.setValue(0);
					logic.Setspeed(255);
				}
			}
		});
		rdbtnMotorsetspeed.setBounds(6, 7, 103, 23);
		panel_control.add(rdbtnMotorsetspeed);
		
		final JRadioButton rdbtnRevEnable = new JRadioButton("Rev Enable");
		rdbtnRevEnable.setBounds(111, 7, 103, 23);
		panel_control.add(rdbtnRevEnable);
		
		JButton btnSTART = new JButton("START");
		btnSTART.setBounds(8, 37, 159, 41);
		btnSTART.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Startsignal();
				//TODO
				logic.Setspeed(slider_speed.getValue());
			}
		});
		panel_control.add(btnSTART);
		
		slider_speed = new JSlider();
		slider_speed.setMaximum(100);
		slider_speed.setMinimum(-100);
		slider_speed.setValue(0);
		slider_speed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnMotorsetspeed.isSelected()) {
					int speed = slider_speed.getValue();
					textsetspeed.setText(Integer.toString(speed * 10));
					
					// csak elore
					if (!rdbtnRevEnable.isSelected()) {
						if (speed < 0 )
							speed = 0;
						textsetspeed.setText(Integer.toString(speed * 10));
						logic.Setspeed(speed);
					}
					
					speed = slider_speed.getValue();
					// mehet hatra is
					if (rdbtnRevEnable.isSelected()) {
						textsetspeed.setText(Integer.toString(speed * 10));
						if (speed < 0 )
							speed = 100-speed;
						
						logic.Setspeed(speed);
					}

				}
			}
		});
		slider_speed.setBounds(6, 89, 348, 23);
		panel_control.add(slider_speed);
		
		textsetspeed = new JTextField();
		textsetspeed.setBounds(6, 120, 66, 20);
		panel_control.add(textsetspeed);
		textsetspeed.setText("Autocontrol");
		textsetspeed.setColumns(10);
		
		JPanel panel_UH = new JPanel();
		panel_UH.setBounds(886, 229, 132, 61);
		contentPane.add(panel_UH);
		panel_UH.setLayout(null);
		
		textField_front = new JTextField();
		textField_front.setBounds(44, 0, 44, 20);
		panel_UH.add(textField_front);
		textField_front.setColumns(10);
		
		textField_left = new JTextField();
		textField_left.setBounds(0, 21, 44, 20);
		panel_UH.add(textField_left);
		textField_left.setColumns(10);
		
		textField_right = new JTextField();
		textField_right.setBounds(87, 21, 44, 20);
		panel_UH.add(textField_right);
		textField_right.setColumns(10);
		
		textField_rear = new JTextField();
		textField_rear.setBounds(44, 40, 44, 20);
		panel_UH.add(textField_rear);
		textField_rear.setColumns(10);
		
		JLabel lblUH = new JLabel("UH");
		lblUH.setBounds(55, 24, 33, 14);
		panel_UH.add(lblUH);
		panel_PID_speed.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_PID_speed.setBounds(585, 301, 433, 111);
		
		contentPane.add(panel_PID_speed);
		panel_PID_speed.setLayout(null);
		lblSpeedP.setBounds(10, 11, 64, 14);
		
		panel_PID_speed.add(lblSpeedP);
		lblSpeedI.setBounds(10, 36, 64, 14);
		
		panel_PID_speed.add(lblSpeedI);
		lblSpeedD.setBounds(10, 61, 64, 14);
		
		panel_PID_speed.add(lblSpeedD);
		
		sliderspeedp = new JSlider();
		sliderspeedp.setValue(20);
		sliderspeedp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				textspeedp.setText(Integer.toString(sliderspeedp.getValue()));
				logic.Send_PID_speed_values(sliderspeedp.getValue(), sliderspeedi.getValue(), sliderspeedd.getValue(),  slider_speeddelay.getValue());
				}
		});
		sliderspeedp.setBounds(96, 2, 223, 23);
		panel_PID_speed.add(sliderspeedp);
		
		sliderspeedi = new JSlider();
		sliderspeedi.setValue(35);
		sliderspeedi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textspeedi.setText(Integer.toString(sliderspeedi.getValue()));
				logic.Send_PID_speed_values(sliderspeedp.getValue(), sliderspeedi.getValue(), sliderspeedd.getValue(),  slider_speeddelay.getValue());
			}
		});
		sliderspeedi.setBounds(96, 27, 223, 23);
		panel_PID_speed.add(sliderspeedi);
		
		sliderspeedd = new JSlider();
		sliderspeedd.setValue(0);
		sliderspeedd.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textspeedd.setText(Integer.toString(sliderspeedd.getValue()));
				logic.Send_PID_speed_values(sliderspeedp.getValue(), sliderspeedi.getValue(), sliderspeedd.getValue(),  slider_speeddelay.getValue());
			}
		});
		sliderspeedd.setBounds(96, 52, 223, 23);
		panel_PID_speed.add(sliderspeedd);
		
		textspeedp = new JTextField();
		textspeedp.setBounds(329, 5, 86, 20);
		panel_PID_speed.add(textspeedp);
		textspeedp.setColumns(10);
		
		textspeedi = new JTextField();
		textspeedi.setBounds(329, 30, 86, 20);
		panel_PID_speed.add(textspeedi);
		textspeedi.setColumns(10);
		
		textspeedd = new JTextField();
		textspeedd.setBounds(329, 55, 86, 20);
		panel_PID_speed.add(textspeedd);
		textspeedd.setColumns(10);
		
		JLabel lblSpeedDelay = new JLabel("Speed delay");
		lblSpeedDelay.setBounds(10, 86, 64, 14);
		panel_PID_speed.add(lblSpeedDelay);
		slider_speeddelay.setBounds(96, 86, 223, 23);
		panel_PID_speed.add(slider_speeddelay);
		slider_speeddelay.setValue(100);
		textspeeddelay.setBounds(329, 86, 86, 20);
		panel_PID_speed.add(textspeeddelay);
		textspeeddelay.setColumns(10);
		slider_speeddelay.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textspeeddelay.setText(Integer.toString(slider_speeddelay.getValue()));
				logic.Send_PID_speed_values(sliderspeedp.getValue(), sliderspeedi.getValue(), sliderspeedd.getValue(),  slider_speeddelay.getValue());
			}
		});
		
		JPanel panel_infraadatok = new JPanel();
		panel_infraadatok.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_infraadatok.setBounds(713, 0, 159, 186);
		contentPane.add(panel_infraadatok);
		panel_infraadatok.setLayout(null);
		
		JLabel lblElsVonalHelye = new JLabel("Front line pos:");
		lblElsVonalHelye.setBounds(10, 11, 84, 14);
		panel_infraadatok.add(lblElsVonalHelye);
		
		JLabel lblMasodikVonalHelye = new JLabel("Rear linepos:");
		lblMasodikVonalHelye.setBounds(10, 36, 84, 14);
		panel_infraadatok.add(lblMasodikVonalHelye);
		
		JLabel lblirmax = new JLabel("IR MAX:");
		lblirmax.setBounds(10, 61, 65, 14);
		panel_infraadatok.add(lblirmax);
		
		textirmax = new JTextField();
		textirmax.setBounds(85, 61, 70, 20);
		panel_infraadatok.add(textirmax);
		textirmax.setColumns(10);
		
		textirmin = new JTextField();
		textirmin.setBounds(85, 86, 70, 20);
		panel_infraadatok.add(textirmin);
		textirmin.setColumns(10);
		
		
		JLabel lblirmin = new JLabel("IR MIN:");
		lblirmin.setBounds(10, 86, 46, 14);
		panel_infraadatok.add(lblirmin);
		
		panel_infraadatok.add(textfrontlinepos);
		
		panel_infraadatok.add(textrearlinepos);
		
		JLabel lblError = new JLabel("SzabError:");
		
		lblError.setBounds(10, 111, 65, 14);
		panel_infraadatok.add(lblError);
		
		JLabel lblvonaltipus = new JLabel("Vonaltipus:");
		lblvonaltipus.setBounds(10, 136, 65, 14);		
		panel_infraadatok.add(lblvonaltipus);
		
		panel_infraadatok.add(textszaberr);
		
		textlinetipe = new JTextArea();
		textlinetipe.setBounds(85, 139, 70, 40);
		panel_infraadatok.add(textlinetipe);
		
		JPanel panel_PID_servo = new JPanel();
		panel_PID_servo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_PID_servo.setBounds(0, 180, 581, 175);
		contentPane.add(panel_PID_servo);
		panel_PID_servo.setLayout(null);
		lblServo_line_P.setBounds(10, 11, 37, 14);
		panel_PID_servo.add(lblServo_line_P);
		
		sliderservo_line_P = new JSlider();
		sliderservo_line_P.setBounds(57, 11, 172, 23);
		panel_PID_servo.add(sliderservo_line_P);
		sliderservo_line_P.setValue(3);
		lblServo_line_I.setBounds(10, 36, 64, 14);
		panel_PID_servo.add(lblServo_line_I);
		
		JLabel lblServoDelay = new JLabel("Servo delay");
		lblServoDelay.setBounds(165, 120, 64, 14);
		panel_PID_servo.add(lblServoDelay);
		
		JLabel lblservo_line_D = new JLabel("Line D");
		lblservo_line_D.setBounds(10, 61, 64, 14);
		panel_PID_servo.add(lblservo_line_D);
		
		JLabel lblservo_line_ratio = new JLabel("Line ratio");
		lblservo_line_ratio.setBounds(10, 86, 64, 14);
		panel_PID_servo.add(lblservo_line_ratio);
		
		sliderservo_line_I = new JSlider();
		sliderservo_line_I.setBounds(57, 36, 172, 23);
		panel_PID_servo.add(sliderservo_line_I);
		sliderservo_line_I.setValue(10);
		sliderservo_line_D.setBounds(57, 61, 172, 23);
		panel_PID_servo.add(sliderservo_line_D);
		sliderservo_line_D.setValue(22);
		sliderservo_line_ratio.setBounds(57, 86, 172, 23);
		panel_PID_servo.add(sliderservo_line_ratio);
		sliderservo_line_ratio.setValue(83);
		slider_servodelay.setBounds(239, 111, 172, 23);
		panel_PID_servo.add(slider_servodelay);
		slider_servodelay.setValue(20);
		
		textservo_line_P = new JTextField();
		textservo_line_P.setBounds(239, 8, 32, 20);
		panel_PID_servo.add(textservo_line_P);
		textservo_line_P.setColumns(10);
		
		textservo_line_I = new JTextField();
		textservo_line_I.setBounds(239, 33, 32, 20);
		panel_PID_servo.add(textservo_line_I);
		textservo_line_I.setColumns(10);
		textservo_line_d.setBounds(239, 58, 32, 20);
		panel_PID_servo.add(textservo_line_d);
		textservo_line_d.setColumns(10);
		text_line_ratio.setBounds(239, 83, 32, 20);
		panel_PID_servo.add(text_line_ratio);
		text_line_ratio.setColumns(10);
		textservodelay.setBounds(425, 108, 32, 20);
		panel_PID_servo.add(textservodelay);
		textservodelay.setColumns(10);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(281, 11, 3, 91);
		
		panel_PID_servo.add(panel);
		
		JLabel lblNewLabel = new JLabel("Angle P");
		lblNewLabel.setBounds(290, 11, 46, 14);
		panel_PID_servo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Angle I");
		lblNewLabel_1.setBounds(290, 36, 46, 14);
		panel_PID_servo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Angle D");
		lblNewLabel_2.setBounds(290, 61, 46, 14);
		panel_PID_servo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Angle ratio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setBounds(290, 86, 46, 14);
		panel_PID_servo.add(lblNewLabel_3);
		
		textangle_P = new JTextField();
		textangle_P.setBounds(539, 11, 32, 20);
		panel_PID_servo.add(textangle_P);
		textangle_P.setColumns(10);
		
		textangle_I = new JTextField();
		textangle_I.setBounds(539, 36, 32, 20);
		panel_PID_servo.add(textangle_I);
		textangle_I.setColumns(10);
		
		textangle_D = new JTextField();
		textangle_D.setBounds(539, 61, 32, 20);
		panel_PID_servo.add(textangle_D);
		textangle_D.setColumns(10);
		
		texangle_ratio = new JTextField();
		texangle_ratio.setBounds(539, 86, 32, 20);
		panel_PID_servo.add(texangle_ratio);
		texangle_ratio.setColumns(10);
		
		sliderservo_angle_P = new JSlider();
		sliderservo_angle_P.setValue(15);
		sliderservo_angle_P.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textangle_P.setText(Integer.toString(sliderservo_angle_P.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_angle_P.setBounds(329, 2, 200, 23);
		panel_PID_servo.add(sliderservo_angle_P);
		
		sliderservo_angle_I = new JSlider();
		sliderservo_angle_I.setValue(0);
		sliderservo_angle_I.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textangle_I.setText(Integer.toString(sliderservo_angle_I.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_angle_I.setBounds(329, 27, 200, 23);
		panel_PID_servo.add(sliderservo_angle_I);
		
		sliderservo_angle_D = new JSlider();
		sliderservo_angle_D.setValue(0);
		sliderservo_angle_D.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textangle_D.setText(Integer.toString(sliderservo_angle_D.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_angle_D.setBounds(329, 52, 200, 23);
		panel_PID_servo.add(sliderservo_angle_D);
		
		sliderservo_angle_ratio = new JSlider();
		sliderservo_angle_ratio.setValue(50);
		sliderservo_angle_ratio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				texangle_ratio.setText(Integer.toString(sliderservo_angle_ratio.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_angle_ratio.setBounds(329, 77, 200, 23);
		panel_PID_servo.add(sliderservo_angle_ratio);
		
		JButton btn_servoparam_speed_1 = new JButton("lassu");
		btn_servoparam_speed_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("lassu");
				
				panel_speed_indicator.setBackground(new Color( 0,255,0));
				 
								
				 //adatmentés
				logic.servo_speed_params[0 + logic.servo_speed_param_selector*9] = sliderservo_line_P.getValue();
				logic.servo_speed_params[1 + logic.servo_speed_param_selector*9] = sliderservo_line_I.getValue();
				logic.servo_speed_params[2 + logic.servo_speed_param_selector*9] = sliderservo_line_D.getValue();
				logic.servo_speed_params[3 + logic.servo_speed_param_selector*9] = sliderservo_line_ratio.getValue();
				logic.servo_speed_params[4 + logic.servo_speed_param_selector*9] = sliderservo_angle_P.getValue();
				logic.servo_speed_params[5 + logic.servo_speed_param_selector*9] = sliderservo_angle_I.getValue();
				logic.servo_speed_params[6 + logic.servo_speed_param_selector*9] = sliderservo_angle_D.getValue();
				logic.servo_speed_params[7 + logic.servo_speed_param_selector*9] = sliderservo_angle_ratio.getValue();
				logic.servo_speed_params[8 + logic.servo_speed_param_selector*9] = slider_servodelay.getValue();
				
				logic.servo_speed_param_selector = 0;
				//visszatöltés
				sliderservo_line_P.setValue( logic.servo_speed_params[0 + logic.servo_speed_param_selector*9] );
				sliderservo_line_I.setValue( logic.servo_speed_params[1 + logic.servo_speed_param_selector*9] );
				sliderservo_line_D.setValue( logic.servo_speed_params[2 + logic.servo_speed_param_selector*9] );
				sliderservo_line_ratio.setValue( logic.servo_speed_params[3 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_P.setValue( logic.servo_speed_params[4 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_I.setValue( logic.servo_speed_params[5 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_D.setValue( logic.servo_speed_params[6 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_ratio.setValue( logic.servo_speed_params[7 + logic.servo_speed_param_selector*9] );
				slider_servodelay.setValue( logic.servo_speed_params[8 + logic.servo_speed_param_selector*9] );
				
				
				
			}
		});
		btn_servoparam_speed_1.setBounds(10, 141, 89, 23);
		panel_PID_servo.add(btn_servoparam_speed_1);
		
		JButton btn_servoparam_speed_2 = new JButton("gyorsabb");
		btn_servoparam_speed_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("gyorsabb");
				
				panel_speed_indicator.setBackground(new Color( 255,0,0));
				 //adatmentés
				logic.servo_speed_params[0 + logic.servo_speed_param_selector*9] = sliderservo_line_P.getValue();
				logic.servo_speed_params[1 + logic.servo_speed_param_selector*9] = sliderservo_line_I.getValue();
				logic.servo_speed_params[2 + logic.servo_speed_param_selector*9] = sliderservo_line_D.getValue();
				logic.servo_speed_params[3 + logic.servo_speed_param_selector*9] = sliderservo_line_ratio.getValue();
				logic.servo_speed_params[4 + logic.servo_speed_param_selector*9] = sliderservo_angle_P.getValue();
				logic.servo_speed_params[5 + logic.servo_speed_param_selector*9] = sliderservo_angle_I.getValue();
				logic.servo_speed_params[6 + logic.servo_speed_param_selector*9] = sliderservo_angle_D.getValue();
				logic.servo_speed_params[7 + logic.servo_speed_param_selector*9] = sliderservo_angle_ratio.getValue();
				logic.servo_speed_params[8 + logic.servo_speed_param_selector*9] = slider_servodelay.getValue();
				
				logic.servo_speed_param_selector = 1;
				//visszatöltés
				sliderservo_line_P.setValue( logic.servo_speed_params[0 + logic.servo_speed_param_selector*9] );
				sliderservo_line_I.setValue( logic.servo_speed_params[1 + logic.servo_speed_param_selector*9] );
				sliderservo_line_D.setValue( logic.servo_speed_params[2 + logic.servo_speed_param_selector*9] );
				sliderservo_line_ratio.setValue( logic.servo_speed_params[3 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_P.setValue( logic.servo_speed_params[4 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_I.setValue( logic.servo_speed_params[5 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_D.setValue( logic.servo_speed_params[6 + logic.servo_speed_param_selector*9] );
				sliderservo_angle_ratio.setValue( logic.servo_speed_params[7 + logic.servo_speed_param_selector*9] );
				slider_servodelay.setValue( logic.servo_speed_params[8 + logic.servo_speed_param_selector*9] );
			}
		});
		btn_servoparam_speed_2.setBounds(125, 141, 89, 23);
		panel_PID_servo.add(btn_servoparam_speed_2);
		
		JPanel panel_speedselector = new JPanel();
		panel_speedselector.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_speedselector.setBounds(591, 188, 274, 102);
		contentPane.add(panel_speedselector);
		panel_speedselector.setLayout(null);
		
		JLabel lbl_speedselector_lassu = new JLabel("lassu");
		lbl_speedselector_lassu.setBounds(10, 11, 68, 14);
		panel_speedselector.add(lbl_speedselector_lassu);
		
		JLabel lbl_speedselector_gyorsabb = new JLabel("gyorsabb");
		lbl_speedselector_gyorsabb.setBounds(10, 57, 68, 14);
		panel_speedselector.add(lbl_speedselector_gyorsabb);
		
		text_speedselector_lassu = new JTextField();
		text_speedselector_lassu.setBounds(178, 8, 86, 20);
		panel_speedselector.add(text_speedselector_lassu);
		text_speedselector_lassu.setColumns(10);
		
		text_speedselector_gyorsabb = new JTextField();
		text_speedselector_gyorsabb.setBounds(178, 54, 86, 20);
		panel_speedselector.add(text_speedselector_gyorsabb);
		text_speedselector_gyorsabb.setColumns(10);
		
		slider_speedselector_lassu = new JSlider();
		slider_speedselector_lassu.setValue(0);
		slider_speedselector_lassu.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				text_speedselector_lassu.setText(Integer.toString(slider_speedselector_lassu.getValue()));
				logic.Send_speedselector_values(slider_speedselector_lassu.getValue() , slider_speedselector_gyorsabb.getValue());
				//TODO efdefer
			}
		});
		slider_speedselector_lassu.setBounds(20, 31, 244, 23);
		panel_speedselector.add(slider_speedselector_lassu);
		
		slider_speedselector_gyorsabb = new JSlider();
		slider_speedselector_gyorsabb.setValue(0);
		slider_speedselector_gyorsabb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				text_speedselector_gyorsabb.setText(Integer.toString(slider_speedselector_gyorsabb.getValue()));
				logic.Send_speedselector_values(slider_speedselector_lassu.getValue() , slider_speedselector_gyorsabb.getValue());
			}
		});
		slider_speedselector_gyorsabb.setBounds(20, 76, 244, 23);
		panel_speedselector.add(slider_speedselector_gyorsabb);
		
		contentPane.add(text_cascade_multiplier);
		lblCascademult.setBounds(346, 366, 96, 14);
		
		contentPane.add(lblCascademult);
		
		
		slider_servodelay.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textservodelay.setText(Integer.toString(slider_servodelay.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_line_ratio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				text_line_ratio.setText(Integer.toString(sliderservo_line_ratio.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_line_D.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textservo_line_d.setText(Integer.toString(sliderservo_line_D.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
				
			}
		});
		sliderservo_line_I.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textservo_line_I.setText(Integer.toString(sliderservo_line_I.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});
		sliderservo_line_P.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textservo_line_P.setText(Integer.toString(sliderservo_line_P.getValue()));
				logic.Send_PID_servo_values( sliderservo_line_P.getValue(), sliderservo_line_I.getValue(), sliderservo_line_D.getValue(), sliderservo_line_ratio.getValue(), sliderservo_angle_P.getValue(), sliderservo_angle_I.getValue(), sliderservo_angle_D.getValue(), sliderservo_angle_ratio.getValue(), slider_servodelay.getValue(), logic.servo_speed_param_selector);
			}
		});

		
		
		Start_GUI_Thread();
		//user code

		//TODO
		//kezdõértékek beállítása
		
		sliderservo_line_P.setValue( logic.servo_speed_params[0 ] );
		sliderservo_line_I.setValue( logic.servo_speed_params[1 ] );
		sliderservo_line_D.setValue( logic.servo_speed_params[2 ] );
		sliderservo_line_ratio.setValue( logic.servo_speed_params[3 ] );
		sliderservo_angle_P.setValue( logic.servo_speed_params[4 ] );
		sliderservo_angle_I.setValue( logic.servo_speed_params[5 ] );
		sliderservo_angle_D.setValue( logic.servo_speed_params[6 ] );
		sliderservo_angle_ratio.setValue( logic.servo_speed_params[7] );
		slider_servodelay.setValue( logic.servo_speed_params[8] );
		panel_speed_indicator.setBounds(264, 141, 37, 23);
		
		panel_PID_servo.add(panel_speed_indicator);
		
		slider_speedselector_lassu.setValue(logic.servo_speed_param_slow);
		slider_speedselector_gyorsabb.setValue(logic.servo_speed_param_faster);
				
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
	            textField_diver_V.setText(Integer.toString(logic.drivervoltage / 1000) +"."+ Integer.toString(logic.drivervoltage % 1000) +" V");
	            textField_motor_V.setText(Integer.toString(logic.motorvoltage / 1000) +"."+ Integer.toString(logic.motorvoltage % 1000) +" V");
	            
	            //panel_sensor_1.setBackground(new Color( 3*logic.motorvoltage,3 *logic.motorvoltage,3*logic.motorvoltage));
	            panel_sensor_1.setBackground(new Color( logic.IRvalues[0],logic.IRvalues[0],logic.IRvalues[0]));
	            panel_sensor_2.setBackground(new Color( logic.IRvalues[1],logic.IRvalues[1],logic.IRvalues[1]));
	            panel_sensor_3.setBackground(new Color( logic.IRvalues[2],logic.IRvalues[2],logic.IRvalues[2]));
	            panel_sensor_4.setBackground(new Color( logic.IRvalues[3],logic.IRvalues[3],logic.IRvalues[3]));
	            panel_sensor_5.setBackground(new Color( logic.IRvalues[4],logic.IRvalues[4],logic.IRvalues[4]));
	            panel_sensor_6.setBackground(new Color( logic.IRvalues[5],logic.IRvalues[5],logic.IRvalues[5]));
	            panel_sensor_7.setBackground(new Color( logic.IRvalues[6],logic.IRvalues[6],logic.IRvalues[6]));
	            panel_sensor_8.setBackground(new Color( logic.IRvalues[7],logic.IRvalues[7],logic.IRvalues[7]));
	            panel_sensor_9.setBackground(new Color( logic.IRvalues[8],logic.IRvalues[8],logic.IRvalues[8]));
	            panel_sensor_10.setBackground(new Color( logic.IRvalues[9],logic.IRvalues[9],logic.IRvalues[9]));
	            panel_sensor_11.setBackground(new Color( logic.IRvalues[10],logic.IRvalues[10],logic.IRvalues[10]));
	            panel_sensor_12.setBackground(new Color( logic.IRvalues[11],logic.IRvalues[11],logic.IRvalues[11]));
	            panel_sensor_13.setBackground(new Color( logic.IRvalues[12],logic.IRvalues[12],logic.IRvalues[12]));
	            panel_sensor_14.setBackground(new Color( logic.IRvalues[13],logic.IRvalues[13],logic.IRvalues[13]));
	            panel_sensor_15.setBackground(new Color( logic.IRvalues[14],logic.IRvalues[14],logic.IRvalues[14]));
	            panel_sensor_16.setBackground(new Color( logic.IRvalues[15],logic.IRvalues[15],logic.IRvalues[15]));
	            panel_sensor_17.setBackground(new Color( logic.IRvalues[16],logic.IRvalues[16],logic.IRvalues[16]));
	            panel_sensor_18.setBackground(new Color( logic.IRvalues[17],logic.IRvalues[17],logic.IRvalues[17]));
	            panel_sensor_19.setBackground(new Color( logic.IRvalues[18],logic.IRvalues[18],logic.IRvalues[18]));
	            panel_sensor_20.setBackground(new Color( logic.IRvalues[19],logic.IRvalues[19],logic.IRvalues[19]));
	            panel_sensor_21.setBackground(new Color( logic.IRvalues[20],logic.IRvalues[20],logic.IRvalues[20]));
	            panel_sensor_22.setBackground(new Color( logic.IRvalues[21],logic.IRvalues[21],logic.IRvalues[21]));
	            panel_sensor_23.setBackground(new Color( logic.IRvalues[22],logic.IRvalues[22],logic.IRvalues[22]));
	            panel_sensor_24.setBackground(new Color( logic.IRvalues[23],logic.IRvalues[23],logic.IRvalues[23]));
	            panel_sensor_25.setBackground(new Color( logic.IRvalues[24],logic.IRvalues[24],logic.IRvalues[24]));
	            panel_sensor_26.setBackground(new Color( logic.IRvalues[25],logic.IRvalues[25],logic.IRvalues[25]));
	            panel_sensor_27.setBackground(new Color( logic.IRvalues[26],logic.IRvalues[26],logic.IRvalues[26]));
	            panel_sensor_28.setBackground(new Color( logic.IRvalues[27],logic.IRvalues[27],logic.IRvalues[27]));
	            panel_sensor_29.setBackground(new Color( logic.IRvalues[28],logic.IRvalues[28],logic.IRvalues[28]));
	            panel_sensor_30.setBackground(new Color( logic.IRvalues[29],logic.IRvalues[29],logic.IRvalues[29]));
	            panel_sensor_31.setBackground(new Color( logic.IRvalues[30],logic.IRvalues[30],logic.IRvalues[30]));
	            panel_sensor_32.setBackground(new Color( logic.IRvalues[31],logic.IRvalues[31],logic.IRvalues[31]));
	            panel_sensor_33.setBackground(new Color( logic.IRvalues[32],logic.IRvalues[32],logic.IRvalues[32]));
	            panel_sensor_34.setBackground(new Color( logic.IRvalues[33],logic.IRvalues[33],logic.IRvalues[33]));
	            panel_sensor_35.setBackground(new Color( logic.IRvalues[34],logic.IRvalues[34],logic.IRvalues[34]));
	            panel_sensor_36.setBackground(new Color( logic.IRvalues[35],logic.IRvalues[35],logic.IRvalues[35]));
	            panel_sensor_37.setBackground(new Color( logic.IRvalues[36],logic.IRvalues[36],logic.IRvalues[36]));
	            panel_sensor_38.setBackground(new Color( logic.IRvalues[37],logic.IRvalues[37],logic.IRvalues[37]));
	            panel_sensor_39.setBackground(new Color( logic.IRvalues[38],logic.IRvalues[38],logic.IRvalues[38]));
	            panel_sensor_40.setBackground(new Color( logic.IRvalues[39],logic.IRvalues[39],logic.IRvalues[39]));
	            panel_sensor_41.setBackground(new Color( logic.IRvalues[40],logic.IRvalues[40],logic.IRvalues[40]));
	            panel_sensor_42.setBackground(new Color( logic.IRvalues[41],logic.IRvalues[41],logic.IRvalues[41]));
	            panel_sensor_43.setBackground(new Color( logic.IRvalues[42],logic.IRvalues[42],logic.IRvalues[42]));
	            panel_sensor_44.setBackground(new Color( logic.IRvalues[43],logic.IRvalues[43],logic.IRvalues[43]));
	            panel_sensor_45.setBackground(new Color( logic.IRvalues[44],logic.IRvalues[44],logic.IRvalues[44]));
	            panel_sensor_46.setBackground(new Color( logic.IRvalues[45],logic.IRvalues[45],logic.IRvalues[45]));
	            panel_sensor_47.setBackground(new Color( logic.IRvalues[46],logic.IRvalues[46],logic.IRvalues[46]));
	            panel_sensor_48.setBackground(new Color( logic.IRvalues[47],logic.IRvalues[47],logic.IRvalues[47]));
	
	            
	            
	            
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
				txtIncrement.setText("");
				txtIncrement.setText(Integer.toString(logic.increment));

				// UH
				textField_front.setText("");
				textField_left.setText("");
				textField_right.setText("");
				textField_rear.setText("");
				textField_front.setText(Integer.toString(logic.UHvalues[0]));
				textField_right.setText(Integer.toString(logic.UHvalues[1]));
				textField_rear.setText(Integer.toString(logic.UHvalues[2]));
				textField_left.setText(Integer.toString(logic.UHvalues[3]));
				
				// accelerometer
				//textaccx.setText("");
				//textaccy.setText("");
				//textaccz.setText("");
				textaccx.setText(Integer.toString(logic.accel[0]));
				textaccy.setText(Integer.toString(logic.accel[1]));
				textaccz.setText(Integer.toString(logic.accel[2]));
				
				// gyro szöge
				textangle.setText("");
				textangle.setText(Float.toString(logic.angle));
				
				//sebesség
				textspeed.setText(Float.toString(logic.speed));
				
				// infra adatok
				 textfrontlinepos.setText(Integer.toString(logic.lineposition[0]));
				 textrearlinepos.setText(Integer.toString(logic.lineposition[1]));
				 textirmax.setText("S: "+ Float.toString(logic.speederror));
				 textirmin.setText("todo");
				 textszaberr.setText(Float.toString(logic.szaberror));
				 textlinetipe.setText(logic.linetype_F_R);
				  
				 
				 
	
				
				
	           
	          //till this line  
	        }
	    }
	}
}// end of gui
