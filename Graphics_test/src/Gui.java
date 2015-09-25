import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSlider;



public class Gui extends JFrame {
	

	

	private JPanel contentPane;
	
	
	
	Color Selected_color;
	private JPanel panel_RED;
	private JPanel panel_CYAN;
	private JPanel panel_MAGENTA;
	private JPanel panel_YELLOW;
	private JPanel panel_GREEN;
	private JPanel panel_BLUE;
	private JPanel panel_WHITE;
	private JPanel panel_BLACK;
	private JPanel panel_SELECTED;
	
	
	
	//**********************************************************
	JPanel PIXEL_PANEL;
	int pixel_panel_corner_x = 40;
	int pixel_panel_corner_y = 40;
	JPanel pixel;
	int pixel_size = 40;
	int pixel_x_num = 10;
	int pixel_y_num = 10;
	Color pixel_default_color = new Color(50, 50, 50);
	LinkedList<JPanel> pixel_list = new LinkedList<JPanel>();
	//**********************************************************
	
	
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
//COLOR PICKER		
//*********************************************************************************************************************************
		JPanel PAINT_PANEL = new JPanel();
		PAINT_PANEL.setBorder(new LineBorder(new Color(0, 0, 0)));
		PAINT_PANEL.setBounds(470, 127, 241, 197);
		contentPane.add(PAINT_PANEL);
		PAINT_PANEL.setLayout(null);
		
		panel_RED = new JPanel();
		panel_RED.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_RED.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_RED.setBackground(Color.RED);
		panel_RED.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_RED.setBounds(10, 11, 30, 30);
		PAINT_PANEL.add(panel_RED);
		
		panel_MAGENTA = new JPanel();
		panel_MAGENTA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_MAGENTA.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_MAGENTA.setBackground(Color.MAGENTA);
		panel_MAGENTA.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_MAGENTA.setBounds(10, 52, 30, 30);
		PAINT_PANEL.add(panel_MAGENTA);
		
		panel_YELLOW = new JPanel();
		panel_YELLOW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_YELLOW.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_YELLOW.setBackground(Color.YELLOW);
		panel_YELLOW.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_YELLOW.setBounds(50, 52, 30, 30);
		PAINT_PANEL.add(panel_YELLOW);
		
		panel_GREEN = new JPanel();
		panel_GREEN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_GREEN.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_GREEN.setBackground(Color.GREEN);
		panel_GREEN.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_GREEN.setBounds(50, 11, 30, 30);
		PAINT_PANEL.add(panel_GREEN);
		
		panel_BLUE = new JPanel();
		panel_BLUE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_BLUE.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_BLUE.setBackground(Color.BLUE);
		panel_BLUE.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_BLUE.setBounds(90, 11, 30, 30);
		PAINT_PANEL.add(panel_BLUE);
		
		panel_CYAN = new JPanel();
		panel_CYAN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_CYAN.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_CYAN.setBackground(Color.CYAN);
		panel_CYAN.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_CYAN.setBounds(90, 52, 30, 30);
		PAINT_PANEL.add(panel_CYAN);
		
		panel_WHITE = new JPanel();
		panel_WHITE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_WHITE.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_WHITE.setBackground(Color.WHITE);
		panel_WHITE.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_WHITE.setBounds(127, 11, 30, 30);
		PAINT_PANEL.add(panel_WHITE);
		
		panel_BLACK = new JPanel();
		panel_BLACK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Selected_color = panel_BLACK.getBackground();
				panel_SELECTED.setBackground(Selected_color);
			}
		});
		panel_BLACK.setBackground(Color.BLACK);
		panel_BLACK.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_BLACK.setBounds(127, 52, 30, 30);
		PAINT_PANEL.add(panel_BLACK);
		
		panel_SELECTED = new JPanel();
		panel_SELECTED.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_SELECTED.setBounds(170, 11, 55, 71);
		PAINT_PANEL.add(panel_SELECTED);
		
		JSlider slider_R = new JSlider();
		slider_R.setMaximum(255);
		slider_R.setBounds(10, 93, 215, 23);
		PAINT_PANEL.add(slider_R);
		
		JSlider slider_G = new JSlider();
		slider_G.setMaximum(255);
		slider_G.setBounds(10, 127, 215, 23);
		PAINT_PANEL.add(slider_G);
		
		JSlider slider_B = new JSlider();
		slider_B.setMaximum(255);
		slider_B.setBounds(10, 161, 215, 23);
		PAINT_PANEL.add(slider_B);
//*********************************************************************************************************************************		
		
		
		
//PIXEL TABLE		
//*********************************************************************************************************************************
		PIXEL_PANEL = new JPanel();
		PIXEL_PANEL.setBorder(new LineBorder(new Color(0, 0, 0)));
		//PIXEL_PANEL.setBounds(pixel_panel_corner_x, pixel_panel_corner_y, pixel_size * pixel_x_num, pixel_size * pixel_y_num); // ez OK
		PIXEL_PANEL.setBounds(pixel_panel_corner_x, pixel_panel_corner_y, pixel_size * pixel_x_num, pixel_size * pixel_y_num);
		PIXEL_PANEL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX()/pixel_size);
				System.out.println(e.getY()/pixel_size);
				
				pixel_list.get((e.getY()/pixel_size * pixel_x_num) +  e.getX()/pixel_size).setBackground( Selected_color );
				
				
				
				
			}
		});
		contentPane.add(PIXEL_PANEL);
		PIXEL_PANEL.setLayout(null);
		

		for(int iterator_y=0; iterator_y<pixel_y_num; iterator_y++){
			for(int iterator_x=0; iterator_x<pixel_x_num; iterator_x++){
				pixel = new JPanel();
				pixel.setBorder(new LineBorder(new Color(0, 0, 0)));
				pixel.setBounds(iterator_x*pixel_size, iterator_y*pixel_size, pixel_size, pixel_size);
				pixel_list.add(pixel);
			}
		}
		
		
		for (int i = 0; i < pixel_x_num * pixel_y_num; i++) {
			PIXEL_PANEL.add(pixel_list.get(i));
			pixel_list.get(i).setBackground(pixel_default_color);
		}
//*********************************************************************************************************************************

	
		
		
		
		
		
		
		
		
		
		//for test
		//pixel_list.get(25).setBackground(new Color(255, 0, 255));
		
		

		
		
		

	}
}
