import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Terminal{

	public Terminal(){
		
		startTerminalThread();


/*

		  //  prompt the user to enter their name
	      System.out.print("Enter your name: ");

	      //  open up standard input
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      String userName = null;

	      //  read the username from the command-line; need to use try/catch with the
	      //  readLine() method
	      try {
	         userName = br.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error trying to read your name!");
	         System.exit(1);
	      }

	      System.out.println("Thanks for the name, " + userName);
*/
	}
	
	
	//futó szál
	public void startTerminalThread() {
	    new Thread(new TerminalThread()).start();
	}
	
	private class TerminalThread implements Runnable {
	    public void run() {
			while (true) {
				//TODO chech is this sleep nessecery?
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Terminal thread can not sleep");
					//e.printStackTrace();
				}

				String input = null;
				// open up standard input
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				// try/catch with the
				// readLine() method
				try {
					input = br.readLine();
				} catch (IOException ioe) {
					System.out.println("IO error trying to read from console");
					System.exit(1);
				}

				if (input.equals("exit")) {
					System.exit(1);
				}

			}
	    }
	}

   
}
