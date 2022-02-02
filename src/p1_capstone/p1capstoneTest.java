package p1_capstone;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.*;
import org.junit.jupiter.api.Test;



class p1capstoneTest {
	// Strings for testCsv testing
    String correct = "src/english.csv"; // correct file
    String wrong = "src/english.txt"; // for testCsv()
    String correctWithNumbers = "src/englishWithNumbers.csv"; // for testCorrectChar()

	@Test 
	void testCsv() throws Exception  {
		File file = p1capstone.getInput();
		String filepath = file.getAbsolutePath();
		String fileExtension = filepath.substring(filepath.length()-4);
		assertEquals(fileExtension, ".csv");
	}
	
	@Test 
	void testCorrectChar() {
		//get file name 
		File file = p1capstone.getInput();
		//parse file
		ArrayList<String> array = new ArrayList<String>();
		array = p1capstone.parseFile(file);
		
		int i;
		String regex = "[0-9]+"; 	//regex for numbers
		Pattern p = Pattern.compile(regex);	//pattern for numbers
		Matcher m;						//matcher to check if numbers are in the string
		boolean noNum = true;			//if there are numbers in the string
		
		for (i = 0; i < array.size(); i++) {
			//check if string has number
			m = p.matcher(array.get(i));
			//if match fail the test
			if (m.matches()) {
				noNum = false;
				assertTrue(noNum);
			}
		}
		//if no match pass test
		if (noNum) {
			assertTrue(noNum);
		}
		
	}
	
	@Test
    public void throwsException() {
            File file = new File(correct);
            p1capstone.parseFile(file);

            ArrayList<String> array = new ArrayList<String>();
            array = p1capstone.parseFile(file);

            assertEquals(26, array.size());
    }

}
