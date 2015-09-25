import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;





public class main {

	
    public static void main(String[] args) {
        System.out.println("Hello, gui test");
        
        
        //Config_reader c = new Config_reader();
        
       // Graph.createAndShowGui();
       
      //  Graph gr = new Graph("hello");

        List<Double> scores = new ArrayList<>();
        List<Double> scores2 = new ArrayList<>();
        List<Double> scores3 = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 1000;
        int maxScore = 10;
        for (int i = 0; i < maxDataPoints; i++) {
            scores.add((double) random.nextDouble() * maxScore);
            //scores2.add((double) random.nextDouble() * maxScore*2);
            scores2.add((double) i);
        }
        
        
   /*     int temp=0;
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i;
        }
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i*2;
        }
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i*3;
        }
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i+5;
        }        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i;
        }
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i*2;
        }
        temp=0;
        for (int i=0; i<107; i++){
        	scores3. add((double) temp);
        	temp=temp+i*3;
        }
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i+5;
        }       temp=0;
        for (int i=0; i<107; i++){
        	scores3. add((double) temp);
        	temp=temp+i*3;
        }
        for (int i=0; i<100; i++){
        	scores3. add((double) temp);
        	temp=temp+i+5;
        }
       
     */
     //   Graph gr = new Graph(scores, "hello");
        
      //  Graph grr = new Graph(scores2, "hello");
       
        
       
      //  gr.setScores(scores);
        
        
        Udp_node udp = null;

       // 	udp =new Udp_node( 1111);

    
        
        /*
        
        while(true){
        	System.out.println("gfgfg");
        }
        */
        
        /************************************************************/
        List<Double> hum = new ArrayList<>();
        List<Double> tem = new ArrayList<>();
        List<Double> lig = new ArrayList<>();
        List<Double> wat = new ArrayList<>();
        
    	String content = "";
    	String[] parts = null;
    	
    	    try {
    			content = readFile("noveny.txt", StandardCharsets.UTF_8);
    			parts = content.split("\\r?\\n");	//There's only really two newlines (UNIX and Windows) that you need to worry about.
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			//e.printStackTrace();
    			System.out.println("No noveny.txt file found!");
    		}
    	    
    	    
    	    
    	//    System.out.println(parts.length);
    	    
		for (int i = 0; i < parts.length; i++) {

			String[] parameters = parts[i].split("=");

			parameters[1] = parameters[1].replace("&temperature", "");
			parameters[2] = parameters[2].replace("&light", "");
			parameters[3] = parameters[3].replace("&water", "");

			/*
			 * System.out.println(parameters[1]);
			 * System.out.println(parameters[2]);
			 * System.out.println(parameters[3]);
			 * System.out.println(parameters[4]);
			 */

			hum.add((double) Integer.parseInt(parameters[1]));
			tem.add((double) Integer.parseInt(parameters[2]));
			lig.add((double) Integer.parseInt(parameters[3]));
			wat.add((double) Integer.parseInt(parameters[4]));
		}
		
		
		Graph gr1 = new Graph(hum, "hum");
		Graph gr2 = new Graph(tem, "tem");
		Graph gr3 = new Graph(lig, "lig");
		Graph gr4 = new Graph(wat, "wat");
    	    
    	    /******************************************************************/
        

    }
    
    
    static String readFile(String path, Charset encoding) 
    		  throws IOException 
    		{
    		  byte[] encoded = Files.readAllBytes(Paths.get(path));
    		  return new String(encoded, encoding);
    		}
      

  	
  	
  	
    

    
  

}
//TODO : GUI make thread safe