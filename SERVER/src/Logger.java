import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Logger {
	
	void syslog(String msg){
		
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Syslog.txt", true)));
            out.println(get_timestamp() + msg);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
	}
	
	void log(String msg, String filename){
		
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            out.println(get_timestamp() + msg);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
	}
	
	String get_timestamp(){
		String timestamp = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		timestamp += (dateFormat.format(cal.getTime()));
    	timestamp += ": ";
		return timestamp;
	}


}
