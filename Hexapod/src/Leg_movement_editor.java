import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;




public class Leg_movement_editor {
	MISE_protocol misep=null;
	LinkedList list = new LinkedList();
	int actual_frame = 0;
	boolean legs_moving = false;
	boolean start_movement = false;
	
	
	public Leg_movement_editor(MISE_protocol m){

			misep = m;
			
			
			
			
			/////read file
			
			File txt_file = new File("C:\\SASA\\MOVEMENTS\\AAA.txt");
			
			String aaa=null;
			
			
			try {

				ArrayList<String> names = new ArrayList<String>();
				Scanner scanner = new Scanner(txt_file);
				while (scanner.hasNextLine()) {
					//names.add(scanner.nextLine());
					aaa+=(scanner.nextLine() + "\r");
				}
				scanner.close();
				//System.out.println(">>>" + names.get(0));

		

			} catch (IOException e) {
				System.out.print("Exception: File read error");
			}
			
			System.out.println(">>>" + aaa);
			
			//////write file
			
		    try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\SASA\\MOVEMENTS\\BBB.txt"));
		       // String someText = "aString\nthis is a\nttest";
		        String someText = ("ez itt comment");
		 
		       
		        out.write(someText);
		        out.newLine();
		        out.write(someText);
		        out.close();
		        }
		        catch (IOException e)
		        {
		        System.out.println("Exception ");
		        }
			
			
			
			
			//System.out.println(txt_file.);
	
			startServoDriveThread();


	}
	

	public String[] Get_txt_file_list(String working_dir) {
		// TODO new
		File dir = new File(working_dir);

		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		};

		String[] s = dir.list(filter);

		if (s == null) {
			System.out.println(dir + " is INCORRECT or does not exist!");
		} else {

			for (int i = 0; i < s.length; i++) {
				//System.out.println(s[i]);
			}
		}
		return s;

	}



	
	void Add(int A_leg, int A_pos, int A_speed, int B_leg, int B_pos, int B_speed, int C_leg, int C_pos, int C_speed){
		Leg_movement move = new Leg_movement( A_leg,  A_pos,  A_speed,  B_leg,  B_pos,  B_speed,  C_leg,  C_pos,  C_speed);
		
		list.add(actual_frame,move);
		actual_frame ++;
	}

	void Remove(){
		if(actual_frame == 0)
			return;
		if(list.size() >= actual_frame){
			list.remove(actual_frame -1);
			actual_frame --;
		}
	}
	
	void Save(){
		  try {  
			    FileOutputStream fos = new FileOutputStream ("keep.dat");  
			    ObjectOutputStream oos = new ObjectOutputStream(fos);  
			    oos.writeObject(list);  
			    fos.close();  
			  }   
			  catch (Exception e) {  
			    System.out.println(e);     
			  }  
			} 	
	
	
	void Load(){
		 
		  try {  
		    FileInputStream fis = new  FileInputStream("keep.dat");  
		    ObjectInputStream ois = new ObjectInputStream(fis);  
		    Object obj = ois.readObject();  
		    list = (LinkedList) obj;  
		  }   
		  catch (Exception e) {  
		    System.out.println(e);  
		  }   
		   
	}
	
	void Next(){
		if(list.size()>actual_frame)
			actual_frame ++;
		
	}
	
	void Prev(){
		if(actual_frame > 0)
			actual_frame --;
	}
	
	int Get_actual_frame(){
		
		return actual_frame;
	}
	
	int [] Get_actual_data(){
		int[] data = ( (Leg_movement) list.get(actual_frame -1) ).Get_data();
		return data;
	}
	
	void Finished_movement(){
		legs_moving = false;
		System.out.println("legs stopped");
	}

	/*void Send_movements(){
		legs_moving = true;
		//TODO
		int[] data = null;
		int list_iterator = 0;
		while(list.size() > list_iterator){
			Leg_movement move = (Leg_movement) list.get(list_iterator);
			data = move.Get_data();
			//for(int i=0; i<9; i++){
				//System.out.print(data[i] + " ");
			if(data[0] >0){
				byte[] servo_data={(byte) data[0], (byte) data[1], (byte) data[2]};
				misep.send_msg( 54, servo_data,  3);
			}
			if(data[3] >0){
				byte[] servo_data={(byte) data[3], (byte) data[4], (byte) data[5]};
				misep.send_msg( 54, servo_data,  3);
			}
			if(data[6] >0){
				byte[] servo_data={(byte) data[6], (byte) data[7], (byte) data[8]};
				misep.send_msg( 54, servo_data,  3);
			}
			//}
			//System.out.println(" ");
			list_iterator++;
			while(legs_moving);
		}
	}
	
	*/
	
	void Send_movements(){
		start_movement = true;
		
	}
	
	
	//futó szál
	public void startServoDriveThread() {
	    new Thread(new ServoDrive()).start();
	}

	private class ServoDrive implements Runnable {
	    public void run() {
	        while(true) {

				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
	            //process here
				if (start_movement == true) {
					start_movement = false;
					
					int[] data = null;
					int list_iterator = 0;
					while (list.size() > list_iterator) {
						legs_moving = true;
						Leg_movement move = (Leg_movement) list
								.get(list_iterator);
						data = move.Get_data();

						if (data[0] > 0) {
							byte[] servo_data = { (byte) data[0],
									(byte) data[1], (byte) data[2] };
							misep.send_msg(54, servo_data, 3);
						}
						if (data[3] > 0) {
							byte[] servo_data = { (byte) data[3],
									(byte) data[4], (byte) data[5] };
							misep.send_msg(54, servo_data, 3);
						}
						if (data[6] > 0) {
							byte[] servo_data = { (byte) data[6],
									(byte) data[7], (byte) data[8] };
							misep.send_msg(54, servo_data, 3);
						}

						list_iterator++;
						while (legs_moving) {
							try {
								Thread.sleep(10);
							} catch (InterruptedException ex) {
								Thread.currentThread().interrupt();
							}
						}
					}

				}

				
	            //till this line
	            }

	        }
	    }
	
	
	
}// end of class
