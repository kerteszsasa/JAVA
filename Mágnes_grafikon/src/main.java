import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class main {

    public static void main(String[] args) {
        System.out.println("Hello, World");
        
        
        
        
        final Serial serialport = new Serial();
        serialport.connect("Serialoptions.txt");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	
                List<Double> scores = new ArrayList<>();
                Random random = new Random();
                int maxDataPoints = 40;
                int maxScore = 10;
                for (int i = 0; i < maxDataPoints; i++) {
                    scores.add((double) random.nextDouble() * maxScore);
//                    scores.add((double) i);
                }
                GraphPanel mainPanel = new GraphPanel(scores);
                mainPanel.setPreferredSize(new Dimension(800, 600));
                JFrame frame = new JFrame("DrawGraph");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            	
                
                
    
            	
            	
                List<Double> data_values = new ArrayList<>();
             
                String buffer = "";
                
                while(true){


                    	
                    	
                		serialport.lock.lock();
                		
              
                		while(serialport.incoming_data_fifo.isEmpty() == false){
                			byte data = serialport.incoming_data_fifo.remove();
                			
                			buffer += (char)data;
                		}
                		
                		serialport.lock.unlock();
                		
                		
                		
                		
                		System.out.print(buffer);
                		
                		buffer	 =buffer.replace("INFO [ADC_sample](src/DoorSensor.cpp:dataReady:159) [X Y Z]  [", "");
                		buffer	 =buffer.replace("INFO [ADC_sample](src/DoorSensor.cpp:dataReady:152) [X Y Z]  [", "");
                		buffer	 =buffer.replace("INFO [ADC_sample](src/DoorSensor.cpp:dataReady:171) [X Y Z]  [", "");
                		
                		buffer	 =buffer.replace("]  [", " ");
                		buffer	 =buffer.replace("]", "");
                		
                		String[] parts = buffer.split(" ");

                		if(parts.length>12){
                			data_values.clear();
                		
                			
                			try{
                			data_values.add( (double) Integer.parseInt(parts[0]) );
                			data_values.add( (double) Integer.parseInt(parts[1]) );
                			data_values.add( (double) Integer.parseInt(parts[2]) );
                			data_values.add( (double) Integer.parseInt(parts[3]) );
                			data_values.add( (double) Integer.parseInt(parts[4]) );
                			data_values.add( (double) Integer.parseInt(parts[5]) );
                			data_values.add( (double) Integer.parseInt(parts[6]) );
                			data_values.add( (double) Integer.parseInt(parts[7]) );
                			data_values.add( (double) Integer.parseInt(parts[8]) );
                			data_values.add( (double) Integer.parseInt(parts[9]) );
                			data_values.add( (double) Integer.parseInt(parts[10]) );
                			data_values.add( (double) Integer.parseInt(parts[11]) );
                			
                			//System.out.println(data_values);
                			mainPanel.setScores(data_values);
                			
                			} catch (Exception e) {
                				System.out.print("Exception" + e);
                			}
         
                	//	System.out.print(buffer);
                		}
                		buffer = "";
                    	
                    	
                    	
                    	
                    }
                
            	
            	

    }

}