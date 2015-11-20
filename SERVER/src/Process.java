public class Process{

	public Process(){
		
		startProcessThread();
	}
	
	
	//futó szál
	public void startProcessThread() {
	    new Thread(new ProcessThread()).start();
	}
	
	private class ProcessThread implements Runnable {
	    public void run() {
			while (true) {
				//TODO chech is this sleep nessecery?
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Process thread can not sleep");
					//e.printStackTrace();
				}
				do_things();
			}
	    }
	}

	
	
   void do_things(){
	   System.out.println("process thread is running");
   }
   
   
}
