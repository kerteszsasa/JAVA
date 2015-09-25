
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;





public class Idata_parser {

	
    public static void main(String[] args) {
        System.out.println("Hello, gui test");
        
        

        //magnes_adat_kinyer();
        
      //  idobelyeg_feldolgozas();
    	    

		
		


        

    }// END OF MAIN
    
    
    static void idobelyeg_feldolgozas(){
    	String content_M = "";
    	String[] parts_M = null;
    	
    	String content_T = "";
    	String[] parts_T = null;
    	
    	    try {
    			content_M = readFile("C:/Users/kerteszs/Desktop/serial/mágnes feldolgozott adatok/magnet_values.txt", StandardCharsets.UTF_8);
    			parts_M = content_M.split("\\r?\\n");	//There's only really two newlines (UNIX and Windows) that you need to worry about.
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			System.out.println("No  file found!");
    		}
    	    
    	    try {
    			content_T = readFile("C:/Users/kerteszs/Desktop/serial/mágnes feldolgozott adatok/temperature.txt", StandardCharsets.UTF_8);
    			parts_T = content_T.split("\\r?\\n");	//There's only really two newlines (UNIX and Windows) that you need to worry about.
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			System.out.println("No  file found!");
    		}
    	    
    	    
		String output = "";

		for (int j = 0; j < parts_M.length; j++) {
			String magnet_time="";
			
			
			magnet_time += parts_M[j].substring(0, 5);
			

			for (int i = 0; i < parts_T.length; i++) {

				parts_T[i] = parts_T[i].replace("2014-09-11 ", "");
				String[] temps = parts_T[i].split("\t");

			/*	System.out.println(parts_T[i]);
				System.out.println(temps[0]);
				System.out.println(temps[1]);
				System.out.println(temps[2]);
				*/
				
				if(magnet_time.equals( temps[0] )){
					writeFile("C:/Users/kerteszs/Desktop/serial/mágnes feldolgozott adatok/output.txt",parts_M[j] +" " + temps[1] +" "+ temps[2]);
				}

			}
		}
    }
    
    
    
    
    
    
    
    //*******************************************************************************************************************/
    //*******************************************************************************************************************/
    
    
   static void magnes_adat_kinyer(){
    	String content = "";
    	String[] parts = null;
    	
    	    try {
    			content = readFile("C:/Users/kerteszs/Desktop/serial/mágnes feldolgozott adatok/magnes.txt", StandardCharsets.UTF_8);
    			parts = content.split("\\r?\\n");	//There's only really two newlines (UNIX and Windows) that you need to worry about.
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			System.out.println("No noveny.txt file found!");
    		}

    	    
    	    for (int i = 0; i < parts.length; i++) {
    	    	//System.out.println(parts[i].length());
    	    	//if(parts[i].length() ==273)
    	    		//writeFile(parts[i]);
    	    	
    	    	parts[i]=	 parts[i].replace("CEST 2014	62	55	true	0	ROBIN[to=37,from=3e,flags=0,ev=3,data=05", "");
    	    	parts[i]=	 parts[i].replace("Thu Sep 11 ", "");
    	    	parts[i]=	 parts[i].replace("]	25	ROBIN[to=37,from=3e,flags=0,ev=3,data=05", "");
    	    	
    	    	String data[] =null;
    	    	data = parts[i].split(" ");
    	    	String temp ="";
    	    	temp+=data[0];
    	    	temp+=" ";
    	    
    	    	
    	    	int a;
    	    	int b;
    	    	for(int n=0; n<24;n+=2){
    	    		a = (int) Long.parseLong(data[n+2], 16);
        	    	b = (int) Long.parseLong(data[n+3], 16);
        	    	int u =a*256 +b;
        	    	temp+= u;
        	    	temp+=" ";
    	    	}
    	    	
    	    	
    	    	//System.out.println(data[0]);
    	    	System.out.println(temp);
    	    	
    	    	 writeFile("C:/Users/kerteszs/Desktop/serial/mágnes feldolgozott adatok/magnet_values.txt",temp);
    	    }
    }
    
    
    
    
    
    
    
    
    
    
    //*******************************************************************************************************************/
    //*******************************************************************************************************************/
    //*******************************************************************************************************************/
    //*******************************************************************************************************************/
    static String readFile(String path, Charset encoding) 
    		  throws IOException 
    		{
    		  byte[] encoded = Files.readAllBytes(Paths.get(path));
    		  return new String(encoded, encoding);
    		}
      

  	
	static void writeFile(String path,String msg){
		
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            out.println(msg);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
	}
  	
    

    
  

}
//TODO : GUI make thread safe