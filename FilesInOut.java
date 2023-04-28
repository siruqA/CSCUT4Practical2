import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

	public static void main(String[] args) throws FileNotFoundException {
		String inputFile = " ";
		String outputFile = " ";
		String flag = " ";
		boolean uppercase = false;

		if (args.length == 2) {
			inputFile = args[0];
			outputFile = args[1];
		}
		if (args.length == 3) {
			uppercase = true;
			flag = args[0];
			inputFile = args[1];
			outputFile = args[2];
		}

		Scanner scan = new Scanner(new File(inputFile));
		PrintWriter write = new PrintWriter(new File(outputFile));

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");

			String name = "";
		    String date = "";


		    for (String token : tokens) {
		        try {
		            Integer.parseInt(token);
		            date = token.substring(0, 2) + "/" + token.substring(2, 4) + "/" + token.substring(4);
		            
		        } catch (NumberFormatException e) {
		        	String formatName = "";
		        	
		        	if (token.length() == 1) {
		            formatName = token.substring(0, 1).toUpperCase() + ".";
		        	}
		        	else {
		    			if (uppercase) {
		    				formatName = token.toUpperCase();
		    			} else {
		    				formatName = token.toLowerCase().substring(0, 1).toUpperCase()
		    						+ token.substring(1).toLowerCase();
		    			}
		    		}
		            name += formatName + " ";
		        }
		    }

		    String formatted = String.format("%-20s\t%s", name, date);
		    write.println(formatted);
		}
		scan.close();
		write.close();
		System.out.println("File succesfully read and formatted.");
		
	}

} // FilesInOut
