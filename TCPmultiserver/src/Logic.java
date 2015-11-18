import java.util.concurrent.locks.ReentrantLock;


public class Logic {
	
	int[] Leg_currents = new int[6];
	int[] Leg_color = new int[6];
	int supply_servo_state = 0;
	int battery_voltage =0 ;
	int[] RC_controller = new int[4];
	
	
	String runtime ="";
	//String linetype_F_R= "";
	
	String textmsg="";
	final ReentrantLock stringlock = new ReentrantLock();
	boolean isnewtext =false;

	
	public Logic(int m){
	
		startRunningThread();
		
		
	}
	void connect(){
		
	}

	

	
	
	
	//incoming message processing--------------------------------------------//
	//incoming message processing--------------------------------------------//
	//incoming message processing--------------------------------------------//
	
	void data_process() {
		switch (5) {
			case 0: {
			// PRINT
			break;
			}
			default: {
			// TODO
			break;
			}
		}
	}
	


	
	//futó szál
	public void startRunningThread() {
	    new Thread(new RunningThread()).start();
	}
	
	private class RunningThread implements Runnable {
	    public void run() {
	        while(true) {
	            try {
	                Thread.sleep(1);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	            if( true ){
	            	data_process();
	            }

	        }
	    }
	}

}// end of logic


