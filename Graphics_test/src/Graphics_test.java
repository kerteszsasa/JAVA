import java.awt.EventQueue;

import javax.swing.JDialog;


public class Graphics_test{
	public static void main(String args[]){
		
		System.out.println("Graphics_test software 1.0 \n");
		
		
		
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		

		
	}


	


}

