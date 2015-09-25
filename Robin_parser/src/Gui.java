import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Gui extends JFrame {

	Logic logic = null;
	
	int tolerance =0;

	private JPanel contentPane;
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JPanel panel_0;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel label;
	private JLabel label_1;
	private JPanel panel_base;
	private JTextField textField;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JLabel lblTolerance;
	private JLabel lblBase;
	private JPanel panel_match;
	private JButton button;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JLabel lblMatch;
	private JPanel match_test;
	private JRadioButton rdbtnIgnore;
	private JTextField textField_temp;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Gui frame = new Gui();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public Gui(Logic l) {
		logic = l;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel magnets = new JPanel();
		magnets.setBorder(new LineBorder(new Color(0, 0, 0)));
		magnets.setBackground(Color.WHITE);
		magnets.setBounds(10, 11, 650, 340);
		contentPane.add(magnets);
		magnets.setLayout(null);
		
		panel_0 = new JPanel();
		panel_0.setBackground(Color.BLACK);
		panel_0.setBounds(60, 319, 5, 5);
		magnets.add(panel_0);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(110, 319, 5, 5);
		magnets.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(160, 319, 5, 5);
		magnets.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(210, 319, 5, 5);
		magnets.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(260, 319, 5, 5);
		magnets.add(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(310, 319, 5, 5);
		magnets.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(360, 319, 5, 5);
		magnets.add(panel_6);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(410, 319, 5, 5);
		magnets.add(panel_7);
		
		panel_8 = new JPanel();
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(460, 319, 5, 5);
		magnets.add(panel_8);
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(510, 319, 5, 5);
		magnets.add(panel_9);
		
		panel_10 = new JPanel();
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(560, 319, 5, 5);
		magnets.add(panel_10);
		
		panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(610, 319, 5, 5);
		magnets.add(panel_11);
		
		label = new JLabel("4000");
		label.setBounds(0, 0, 30, 14);
		magnets.add(label);
		
		label_1 = new JLabel("0");
		label_1.setBounds(0, 326, 17, 14);
		magnets.add(label_1);
		
	/*	JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.BLACK);
		progressBar.setValue(20);
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(88, 203, 146, 14);
		magnets.add(progressBar);*/

		JPanel actual_values = new JPanel();
		actual_values.setBorder(null);
		actual_values.setBounds(10, 362, 650, 84);
		contentPane.add(actual_values);
		actual_values.setLayout(null);

		textField_0 = new JTextField();
		textField_0.setBounds(60, 0, 40, 20);
		actual_values.add(textField_0);
		textField_0.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 0, 40, 20);
		actual_values.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 0, 40, 20);
		actual_values.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(210, 0, 40, 20);
		actual_values.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(260, 0, 40, 20);
		actual_values.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(310, 0, 40, 20);
		actual_values.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(360, 0, 40, 20);
		actual_values.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(410, 0, 40, 20);
		actual_values.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(460, 0, 40, 20);
		actual_values.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(510, 0, 40, 20);
		actual_values.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(560, 0, 40, 20);
		actual_values.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(610, 0, 40, 20);
		actual_values.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(60, 31, 40, 20);
		actual_values.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(110, 31, 40, 20);
		actual_values.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(160, 31, 40, 20);
		actual_values.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(210, 31, 40, 20);
		actual_values.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(260, 31, 40, 20);
		actual_values.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(310, 31, 40, 20);
		actual_values.add(textField_17);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(360, 31, 40, 20);
		actual_values.add(textField_18);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(410, 31, 40, 20);
		actual_values.add(textField_19);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(460, 31, 40, 20);
		actual_values.add(textField_20);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(510, 31, 40, 20);
		actual_values.add(textField_21);

		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(560, 31, 40, 20);
		actual_values.add(textField_22);

		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(610, 31, 40, 20);
		actual_values.add(textField_23);

		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(60, 62, 40, 20);
		actual_values.add(textField_24);

		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(110, 62, 40, 20);
		actual_values.add(textField_25);

		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(160, 62, 40, 20);
		actual_values.add(textField_26);

		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(210, 62, 40, 20);
		actual_values.add(textField_27);

		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(260, 62, 40, 20);
		actual_values.add(textField_28);

		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(310, 62, 40, 20);
		actual_values.add(textField_29);

		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(360, 62, 40, 20);
		actual_values.add(textField_30);

		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(410, 62, 40, 20);
		actual_values.add(textField_31);

		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(460, 62, 40, 20);
		actual_values.add(textField_32);

		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(510, 62, 40, 20);
		actual_values.add(textField_33);

		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(560, 62, 40, 20);
		actual_values.add(textField_34);

		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(610, 62, 40, 20);
		actual_values.add(textField_35);

		JLabel lbl_Actual = new JLabel("ACTUAL:");
		lbl_Actual.setBounds(0, 3, 56, 14);
		actual_values.add(lbl_Actual);

		JLabel lblMax = new JLabel("MAX:");
		lblMax.setBounds(0, 34, 56, 14);
		actual_values.add(lblMax);

		JLabel lblMin = new JLabel("MIN:");
		lblMin.setBounds(0, 65, 56, 14);
		actual_values.add(lblMin);
		
		panel_base = new JPanel();
		panel_base.setBounds(10, 457, 652, 54);
		contentPane.add(panel_base);
		panel_base.setLayout(null);
		
		JButton btnNewButton = new JButton("SET BASE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Set_base();
			}
		});
		btnNewButton.setBounds(262, 24, 190, 30);
		panel_base.add(btnNewButton);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBounds(62, 0, 40, 20);
		panel_base.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(112, 0, 40, 20);
		panel_base.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(162, 0, 40, 20);
		panel_base.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(212, 0, 40, 20);
		panel_base.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		textField_40.setBounds(262, 0, 40, 20);
		panel_base.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(312, 0, 40, 20);
		panel_base.add(textField_41);
		
		textField_42 = new JTextField();
		textField_42.setColumns(10);
		textField_42.setBounds(362, 0, 40, 20);
		panel_base.add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		textField_43.setBounds(412, 0, 40, 20);
		panel_base.add(textField_43);
		
		textField_44 = new JTextField();
		textField_44.setColumns(10);
		textField_44.setBounds(462, 0, 40, 20);
		panel_base.add(textField_44);
		
		textField_45 = new JTextField();
		textField_45.setColumns(10);
		textField_45.setBounds(512, 0, 40, 20);
		panel_base.add(textField_45);
		
		textField_46 = new JTextField();
		textField_46.setColumns(10);
		textField_46.setBounds(562, 0, 40, 20);
		panel_base.add(textField_46);
		
		textField_47 = new JTextField();
		textField_47.setColumns(10);
		textField_47.setBounds(612, 0, 40, 20);
		panel_base.add(textField_47);
		
		lblBase = new JLabel("BASE:");
		lblBase.setBounds(0, 3, 56, 14);
		panel_base.add(lblBase);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tolerance = Integer.parseInt(textField.getText());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					tolerance = 0;
					}
				textField.setText(Integer.toString(tolerance));
			}
		});
		textField.setText("0");
		textField.setBounds(84, 587, 80, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblTolerance = new JLabel("Tolerance:");
		lblTolerance.setBounds(10, 590, 70, 14);
		contentPane.add(lblTolerance);
		
		panel_match = new JPanel();
		panel_match.setLayout(null);
		panel_match.setBounds(10, 522, 652, 54);
		contentPane.add(panel_match);
		
		button = new JButton("SET MATCH");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.Set_match();
			}
		});
		button.setBounds(262, 24, 190, 30);
		panel_match.add(button);
		
		textField_48 = new JTextField();
		textField_48.setColumns(10);
		textField_48.setBounds(62, 0, 40, 20);
		panel_match.add(textField_48);
		
		textField_49 = new JTextField();
		textField_49.setColumns(10);
		textField_49.setBounds(112, 0, 40, 20);
		panel_match.add(textField_49);
		
		textField_50 = new JTextField();
		textField_50.setColumns(10);
		textField_50.setBounds(162, 0, 40, 20);
		panel_match.add(textField_50);
		
		textField_51 = new JTextField();
		textField_51.setColumns(10);
		textField_51.setBounds(212, 0, 40, 20);
		panel_match.add(textField_51);
		
		textField_52 = new JTextField();
		textField_52.setColumns(10);
		textField_52.setBounds(262, 0, 40, 20);
		panel_match.add(textField_52);
		
		textField_53 = new JTextField();
		textField_53.setColumns(10);
		textField_53.setBounds(312, 0, 40, 20);
		panel_match.add(textField_53);
		
		textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(362, 0, 40, 20);
		panel_match.add(textField_54);
		
		textField_55 = new JTextField();
		textField_55.setColumns(10);
		textField_55.setBounds(412, 0, 40, 20);
		panel_match.add(textField_55);
		
		textField_56 = new JTextField();
		textField_56.setColumns(10);
		textField_56.setBounds(462, 0, 40, 20);
		panel_match.add(textField_56);
		
		textField_57 = new JTextField();
		textField_57.setColumns(10);
		textField_57.setBounds(512, 0, 40, 20);
		panel_match.add(textField_57);
		
		textField_58 = new JTextField();
		textField_58.setColumns(10);
		textField_58.setBounds(562, 0, 40, 20);
		panel_match.add(textField_58);
		
		textField_59 = new JTextField();
		textField_59.setColumns(10);
		textField_59.setBounds(612, 0, 40, 20);
		panel_match.add(textField_59);
		
		lblMatch = new JLabel("MATCH:");
		lblMatch.setBounds(0, 3, 56, 14);
		panel_match.add(lblMatch);
		
		match_test = new JPanel();
		match_test.setBounds(503, 587, 129, 15);
		contentPane.add(match_test);
		
		rdbtnIgnore = new JRadioButton("Ignore 3 6 9 12");
		rdbtnIgnore.setBounds(374, 586, 109, 23);
		contentPane.add(rdbtnIgnore);
		
		textField_temp = new JTextField();
		textField_temp.setBounds(261, 590, 86, 20);
		contentPane.add(textField_temp);
		textField_temp.setColumns(10);

		Start_GUI_Thread();
	}// end of gui init
	
	
	
	
	boolean Matcher(int i){
		//********************************************* CHOOSE MATCHER ALG **************************************
		return MAtch_alg_1(i);
	}
	
	
	boolean MAtch_alg_1(int i){
		if(Math.abs(logic.magnet_values[i] - logic.magnet_match[i]) <= 10){
			return true;
		}
		
		if( 100* (Math.abs(logic.magnet_values[i] - logic.magnet_match[i]) + 0 ) / ( Math.abs(logic.magnet_match[i] - logic.magnet_base[i]) +1)  <= tolerance ){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	boolean MAtch_alg_2(int i){
		if(Math.abs(logic.magnet_values[i] - logic.magnet_match[i]) <= tolerance){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
	
	
	
	

	public void Start_GUI_Thread() {
		new Thread(new GUI_Thread()).start();
	}

	private class GUI_Thread implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
				// / do things here
				if (logic.valid_data) {

					textField_0.setText(Integer.toString(logic.magnet_values[0]));
					textField_1.setText(Integer.toString(logic.magnet_values[1]));
					textField_2.setText(Integer.toString(logic.magnet_values[2]));
					textField_3.setText(Integer.toString(logic.magnet_values[3]));
					textField_4.setText(Integer.toString(logic.magnet_values[4]));
					textField_5.setText(Integer.toString(logic.magnet_values[5]));
					textField_6.setText(Integer.toString(logic.magnet_values[6]));
					textField_7.setText(Integer.toString(logic.magnet_values[7]));
					textField_8.setText(Integer.toString(logic.magnet_values[8]));
					textField_9.setText(Integer.toString(logic.magnet_values[9]));
					textField_10.setText(Integer.toString(logic.magnet_values[10]));
					textField_11.setText(Integer.toString(logic.magnet_values[11]));
					
					textField_12.setText(Integer.toString(logic.magnet_max[0]));
					textField_13.setText(Integer.toString(logic.magnet_max[1]));
					textField_14.setText(Integer.toString(logic.magnet_max[2]));
					textField_15.setText(Integer.toString(logic.magnet_max[3]));
					textField_16.setText(Integer.toString(logic.magnet_max[4]));
					textField_17.setText(Integer.toString(logic.magnet_max[5]));
					textField_18.setText(Integer.toString(logic.magnet_max[6]));
					textField_19.setText(Integer.toString(logic.magnet_max[7]));
					textField_20.setText(Integer.toString(logic.magnet_max[8]));
					textField_21.setText(Integer.toString(logic.magnet_max[9]));
					textField_22.setText(Integer.toString(logic.magnet_max[10]));
					textField_23.setText(Integer.toString(logic.magnet_max[11]));
					
					textField_24.setText(Integer.toString(logic.magnet_min[0]));
					textField_25.setText(Integer.toString(logic.magnet_min[1]));
					textField_26.setText(Integer.toString(logic.magnet_min[2]));
					textField_27.setText(Integer.toString(logic.magnet_min[3]));
					textField_28.setText(Integer.toString(logic.magnet_min[4]));
					textField_29.setText(Integer.toString(logic.magnet_min[5]));
					textField_30.setText(Integer.toString(logic.magnet_min[6]));
					textField_31.setText(Integer.toString(logic.magnet_min[7]));
					textField_32.setText(Integer.toString(logic.magnet_min[8]));
					textField_33.setText(Integer.toString(logic.magnet_min[9]));
					textField_34.setText(Integer.toString(logic.magnet_min[10]));
					textField_35.setText(Integer.toString(logic.magnet_min[11]));
					
					textField_36.setText(Integer.toString(logic.magnet_base[0]));
					textField_37.setText(Integer.toString(logic.magnet_base[1]));
					textField_38.setText(Integer.toString(logic.magnet_base[2]));
					textField_39.setText(Integer.toString(logic.magnet_base[3]));
					textField_40.setText(Integer.toString(logic.magnet_base[4]));
					textField_41.setText(Integer.toString(logic.magnet_base[5]));
					textField_42.setText(Integer.toString(logic.magnet_base[6]));
					textField_43.setText(Integer.toString(logic.magnet_base[7]));
					textField_44.setText(Integer.toString(logic.magnet_base[8]));
					textField_45.setText(Integer.toString(logic.magnet_base[9]));
					textField_46.setText(Integer.toString(logic.magnet_base[10]));
					textField_47.setText(Integer.toString(logic.magnet_base[11]));
					
					textField_48.setText(Integer.toString(logic.magnet_match[0]));
					textField_49.setText(Integer.toString(logic.magnet_match[1]));
					textField_50.setText(Integer.toString(logic.magnet_match[2]));
					textField_51.setText(Integer.toString(logic.magnet_match[3]));
					textField_52.setText(Integer.toString(logic.magnet_match[4]));
					textField_53.setText(Integer.toString(logic.magnet_match[5]));
					textField_54.setText(Integer.toString(logic.magnet_match[6]));
					textField_55.setText(Integer.toString(logic.magnet_match[7]));
					textField_56.setText(Integer.toString(logic.magnet_match[8]));
					textField_57.setText(Integer.toString(logic.magnet_match[9]));
					textField_58.setText(Integer.toString(logic.magnet_match[10]));
					textField_59.setText(Integer.toString(logic.magnet_match[11]));
					
					/////
					textField_48.setBackground(Matcher(0)? Color.WHITE : Color.RED );
					textField_49.setBackground(Matcher(1)? Color.WHITE : Color.RED );
					textField_50.setBackground(Matcher(2)? Color.WHITE : Color.RED );
					textField_51.setBackground(Matcher(3)? Color.WHITE : Color.RED );
					textField_52.setBackground(Matcher(4)? Color.WHITE : Color.RED );
					textField_53.setBackground(Matcher(5)? Color.WHITE : Color.RED );
					textField_54.setBackground(Matcher(6)? Color.WHITE : Color.RED );
					textField_55.setBackground(Matcher(7)? Color.WHITE : Color.RED );
					textField_56.setBackground(Matcher(8)? Color.WHITE : Color.RED );
					textField_57.setBackground(Matcher(9)? Color.WHITE : Color.RED );
					textField_58.setBackground(Matcher(10)? Color.WHITE : Color.RED );
					textField_59.setBackground(Matcher(11)? Color.WHITE : Color.RED );
					

					if(rdbtnIgnore.isSelected() ){
						match_test.setBackground(( Matcher(0)&&Matcher(1)&&Matcher(0)&&Matcher(3)&&Matcher(4)&&Matcher(0)&&Matcher(6)&&Matcher(7)&&Matcher(0)&&Matcher(9)&&Matcher(10)&&Matcher(0))? Color.GREEN : Color.RED );
					}
					else{
					
						match_test.setBackground(( Matcher(0)&&Matcher(1)&&Matcher(2)&&Matcher(3)&&Matcher(4)&&Matcher(5)&&Matcher(6)&&Matcher(7)&&Matcher(8)&&Matcher(9)&&Matcher(10)&&Matcher(11))? Color.GREEN : Color.RED );
					}
					
					
					panel_0.setLocation(60, 335- logic.magnet_values[0]/12);
					panel_1.setLocation(110, 335- logic.magnet_values[1]/12);
					panel_2.setLocation(160, 335- logic.magnet_values[2]/12);
					panel_3.setLocation(210, 335- logic.magnet_values[3]/12);
					panel_4.setLocation(260, 335- logic.magnet_values[4]/12);
					panel_5.setLocation(310, 335- logic.magnet_values[5]/12);
					panel_6.setLocation(360, 335- logic.magnet_values[6]/12);
					panel_7.setLocation(410, 335- logic.magnet_values[7]/12);
					panel_8.setLocation(460, 335- logic.magnet_values[8]/12);
					panel_9.setLocation(510, 335- logic.magnet_values[9]/12);
					panel_10.setLocation(560, 335- logic.magnet_values[10]/12);
					panel_11.setLocation(610, 335- logic.magnet_values[11]/12);
					
					
					textField_temp.setText(Integer.toString((int)logic.temperature)   + "°C");

					logic.valid_data = false;
				}
				
			}// end of rhread WHILE
		}
	}
}// end off gui class
