import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Filename extends JDialog {
	private JTextField textField;
	String filename = "DEFAULT";


	public Filename( ) {
		setBounds(100, 100, 157, 148);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Set log file name:");
		label.setBounds(10, 11, 129, 14);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(10, 37, 129, 20);
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JButton btnStart = new JButton("Change filename");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filename = textField.getText();
				if(filename.equals("")){
					filename = "Vector";
				}
			}
		});
		btnStart.setBounds(10, 81, 129, 23);
		getContentPane().add(btnStart);
		
		
		
		
	}
	
	String Get_filename(){
		return filename;
	}
}
