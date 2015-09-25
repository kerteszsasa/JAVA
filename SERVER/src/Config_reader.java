import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Config_reader {
	
	String configfile ="Config.cfg";
	
	//*****************************************************************************************************************************
	String content = "";
	String[] parts = null;
			
	String USERNAME = "";
	String PASSWORD = "";
	//
	boolean SERIAL = false;
	String SERIALPORT = "";
	int SERIALBAUD = 0;
	//
	boolean WEBINTERFACE = false;
	int WEBINTERFACE_PORT = 0;
	//
	boolean UDP_NODE = false;
	int UDP_NODE_IN_PORT = 0;
	int UDP_NODE_OUT_PORT = 0;

	//*****************************************************************************************************************************
	
	
	
	
	
	public  Config_reader(){
	    try {
			content = readFile(configfile, StandardCharsets.UTF_8);
			parts = content.split("\\r?\\n");	//There's only really two newlines (UNIX and Windows) that you need to worry about.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No Config.cfg file found!");
		}
	    
//GET PARAMETERS FROM CONFIG
	    USERNAME = Configparser("USERNAME");
	    PASSWORD = Configparser("PASSWORD");
	   if( Configparser("SERIAL").equals("ENABLE") ){
		   SERIAL = true;
		   SERIALPORT = Configparser("SERIALPORT");
		   SERIALBAUD = Integer.parseInt( Configparser("SERIALBAUD") );
	   }
	   if( Configparser("WEBINTERFACE").equals("ENABLE") ){
		   WEBINTERFACE = true;
	   }
	   if( Configparser("UDP_NODE").equals("ENABLE") ){
		   UDP_NODE = true;
		   UDP_NODE_IN_PORT = Integer.parseInt( Configparser("UDP_NODE_IN_PORT") );
		   UDP_NODE_OUT_PORT = Integer.parseInt( Configparser("UDP_NODE_OUT_PORT") );
	   }

	}
	
	/*void Syslog(String msg){
		
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
	
*/
    
	static String readFile(String path, Charset encoding) 
  		  throws IOException 
  		{
  		  byte[] encoded = Files.readAllBytes(Paths.get(path));
  		  return new String(encoded, encoding);
  		}
    

	String Configparser(String parameter) {
		String value = "";
		String[] temp = null;
		for (int i = 0; i < parts.length; i++) {
			temp = parts[i].split(" ");
			if (temp[0].equals(parameter)){
				if(temp.length > 1){
					value = temp[1];	
				}
			}
		}
		return value;
	}
	
	
	
	
	
	//*****************************************************************************************************************************
	//GET methods
	
	String Get_USERNAME(){return USERNAME;}
	String Get_PASSWORD(){return PASSWORD;}
	
	boolean Is_SERIAL(){return SERIAL;}
	String Get_SERIALPORT(){return SERIALPORT;}
	int Get_SERIALBAUD(){return SERIALBAUD;}
	
	boolean Is_WEBINTERFACE(){return WEBINTERFACE;}
	int Get_WEBINTERFACE_PORT(){return WEBINTERFACE_PORT;}
	
	boolean Is_UDP_NODE(){return UDP_NODE;}
	int Get_UDP_NODE_IN_PORT(){return UDP_NODE_IN_PORT;}
	int Get_UDP_NODE_OUT_PORT(){return UDP_NODE_OUT_PORT;}


}
