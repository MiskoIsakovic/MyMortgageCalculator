import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class MortgageCalculator {

	public static void main(String[] args) {
		Methods account1=new Methods();
		account1.input();
		account1.calculateMonthlyPayment();
		account1.print();
		
		
		
		File file = new File("C:\\Users\\misko\\Desktop\\empty.txt");
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
	    System.out.println("Monthly only the basic payment is "+Math.floor(account1.calculateMonthlyPayment())+" $");
	    System.out.println("Total monthly payment is "+Math.floor(account1.calculateTotalMonthlyPayment())+" $");
		account1.print();
	}
}


