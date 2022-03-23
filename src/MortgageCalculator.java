import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class MortgageCalculator {

	public static void main(String[] args) {
		Methods account1=new Methods();
		account1.input();
		account1.calculateMonthlyPayment();
		account1.print();
		
		
		
		File file = new File("C:\\Users\\misko\\Desktop\\MortgageData.txt");
		PrintStream stream = null;
		try {
			stream = new PrintStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    System.out.println("Main information is written into "+file.getAbsolutePath());
	    System.setOut(stream);
	    System.out.println("Here is the information about your account");
	    System.out.println("_________________________________________________________________________________________");
		account1.print();
	}
	static{
		System.out.println("Welcome to mortgage calculator\n" +
				"Please enter only positive numbers and interest in percentage format");
	}
}


