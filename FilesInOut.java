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
		String inputFile = "";
		String outputFile = "";
		String flag = "";
		boolean uppercase = false;

		// if 2 arguments are given in the terminal
		if (args.length == 2) {
			inputFile = args[0];
			outputFile = args[1];
		}
		// if 3 arguments are given in the terminal
		if (args.length == 3) {
			flag = args[0];
			if (flag.equals("-u")) {
				uppercase = true;
			}
			inputFile = args[1];
			outputFile = args[2];
		}
		// if none arguments given in the terminal then run form the console
		// ask user for input and output files
		else {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Please enter input file : ");
			String inputFilePath = sc.nextLine();
			File file = new File(inputFilePath);

            // as long as the given file doesnt exist and is not a file but a directory 
			while (!file.exists() || file.isDirectory()) {
			    System.out.println("Invalid input file! Please enter a valid file: ");
			    inputFilePath = sc.nextLine();
			    file = new File(inputFilePath);
			}
			inputFile = file.getName();

			System.out.print("Please enter output file: ");
			String outputFilePath = sc.nextLine();
			file = new File(outputFilePath);

			// as long as the file entered is a directory rather than a file
			while (file.isDirectory()) {
			    System.out.println("Invalid output file! Please enter a valid file: ");
			    outputFilePath = sc.nextLine();
			    file = new File(outputFilePath);
			}
			outputFile = file.getName();
			sc.close();
		}

		Scanner scan = new Scanner(new File(inputFile));           // to read the input file
		PrintWriter write = new PrintWriter(new File(outputFile)); // to write the changes to the output file

		// as long as there is a line in the file keep reading 
		while (scan.hasNextLine()) {
			String line = scan.nextLine();      // take one single line
			String[] tokens = line.split(" ");  // split into separate words based on whitespace

			String name = "";
		    String date = "";


		    for (String token : tokens) {
		        try {
		        	// if the token contains number then parse to integer
		            Integer.parseInt(token);
		            date = token.substring(0, 2) + "/" + token.substring(2, 4) + "/" + token.substring(4);
		            
		            // if not that means string value so handle the exception
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

		    // format each line with the name aligning towards left width 20, then follow with a tab and then date 
		    String formatted = String.format("%-20s\t%s", name, date);
		    write.println(formatted);
		}
		scan.close();
		write.close();
		System.out.println("File succesfully read and formatted.");
		
	}

} // FilesInOut
