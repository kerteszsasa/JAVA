import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Gui_serial_settings extends JFrame {
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Gui_serial_settings(final Serial serial) {
		setTitle("Serial settings");
		setBounds(100, 100, 220, 232);
		getContentPane().setLayout(null);

		JLabel lblSelectCOM = new JLabel("Select port:");
		lblSelectCOM.setBounds(0, 0, 90, 16);
		getContentPane().add(lblSelectCOM);

	//	final JComboBox comboBox_SelectCOM = new JComboBox(serial.getportlist().toArray());
	//	comboBox_SelectCOM.setBounds(0, 26, 204, 25);
		/*comboBox_SelectCOM.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				System.out.println(comboBox_SelectCOM.getSelectedItem());
				serial.selectedport = comboBox_SelectCOM.getSelectedItem()
						.toString();
			}
		});*/
	//	getContentPane().add(comboBox_SelectCOM);

		final JComboBox comboBox_BAUD = new JComboBox(serial.baudrates);
		comboBox_BAUD.setBounds(0, 91, 204, 25);
		/*comboBox_BAUD.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				System.out.println(comboBox_BAUD.getSelectedItem());
				serial.selectedbaud = comboBox_BAUD.getSelectedItem()
						.toString();
			}
		});*/
		getContentPane().add(comboBox_BAUD);

		JLabel lbl_BAUD = new JLabel("Select baud:");
		lbl_BAUD.setBounds(0, 63, 90, 16);
		getContentPane().add(lbl_BAUD);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO
				try {
	//				serial.connect(comboBox_SelectCOM.getSelectedItem().toString(), Integer.valueOf(comboBox_BAUD.getSelectedItem().toString()));

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(serial.isconnected()){
					dispose();//close frame
				}
				
			}
		});
		btnConnect.setBounds(0, 128, 204, 50);
		getContentPane().add(btnConnect);

		textField = new JTextField();
		textField.setBounds(0, 179, 204, 16);
		getContentPane().add(textField);

	}
}
