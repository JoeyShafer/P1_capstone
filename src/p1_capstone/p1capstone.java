package p1_capstone;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class p1capstone {
	private static Scanner sc;
	private static Scanner scanner;
	private static ArrayList<String> array;
	
	// Main method
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		File file;
		try {
			
			file = getInput();
			array = parseFile(file); // read data & parse, store in array
			output();
			sc.close();
		} catch (Exception e) { // catch any errors here
			System.out.print("Oops! Something went wrong."); // error message
		}
	}
	
	// Read in file data
	public static File getInput()  {
		System.out.println("Please enter a file name to import your data from:"); // enter "src/test.csv"
		//sc.nextLine(); // call nextLine to consume that newline character so subsequent nextLine doesn't return nothing
		String fileName = sc.nextLine(); // store file name into fileName variable
		File file = new File(fileName); // create a new file object
		return file;
	}
	
	public static ArrayList<String> parseFile (File file) {
		try {
		Scanner scanner = new Scanner(file); // create scanner to read in data (separate from scanner to not interfere when closing scanner)
		ArrayList<String> array = new ArrayList<String>();
	
		while (scanner.hasNextLine()) { // while there is a line, continue reading in data
			String line = scanner.nextLine(); // grab the current line to store
			String[] splits = line.split(","); // String array to store parsed line where "," exists for Comma Separated Values (csv)
			
			for (int i = 0; i < splits.length; i++) {
				array.add(splits[i]);
			}
		}
		scanner.close();
		return array;
		}
		 catch (FileNotFoundException e) { // catch any errors here
				System.out.print("Oops! Something went wrong."); // error message
				return null;
			}
	}
	
	// Output array data
	public static void output() {
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
		}
	}

}
