
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class FormatNames {
    public static void main(String[] args) {
        
        String inputFile = args[0];
        String outputFile = args[1];
        
        try { 
        	
        	FileReader fr = new FileReader(inputFile);
        	FileWriter fw = new FileWriter(outputFile);
        	BufferedReader br = new BufferedReader(fr); 
				
				
        		StringBuffer sb = new StringBuffer();
				String singleline = br.readLine();
				
				while (singleline   != null) {
				    String[] subline = singleline.split(" ");
				    
				    for (int i = 0; i < subline.length; i++) {
				        String name = subline[i];
				        
				        if (args.length == 3 && args[2].equals("-u")) {
				            name = name.toUpperCase();
				        } 
				        sb.append(name);
				        sb.append(" ");
				        
				    }
				    fw.write(sb.toString());
				    fw.write("\n");
				}
			
        } catch (IOException e) {
            System.out.println("Error!! unable to process the  file: " + e.getMessage());

        }
    }
}
