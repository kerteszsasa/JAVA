

public class main {

	
    public static void main(String[] args) {
        System.out.println("Hello, World");
        
        
        
        Logger l= new Logger();
        l.Syslog("dffdfdf");
        
        
        for(int i=0; i<2000;i++){
        	l.log("hghhgfhfg" + i, "aa.txt");
        }
        System.out.println("Hello, World");
        


    }

}