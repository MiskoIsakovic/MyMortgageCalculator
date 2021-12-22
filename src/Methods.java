import java.util.Scanner;

public class Methods {
	
	private double deposit;
	private double YearlyInterest;
	private double PMI;
	private double HOA;
	private double additionalPrincipal;
	final double VATAXRATE=0.01098;
	private double price;
	private double timeInYears;
	private double timeInMonths;
	private double balance;
	private double priceAfterDeposit;
	
	
	public void input() {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter the home price");
		int x1=1;
		do{try {this.price=input.nextDouble(); if (price<0) {throw new InvalidNumberException();}x1=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x1==1);
	    System.out.println("Enter the deposit amount");
	    int x2=1;
		do{try {this.deposit=input.nextDouble(); if (deposit<0) {throw new InvalidNumberException();}x2=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x2==1);
		System.out.println("Enter yearly interest rate");
		int x3=1;
		do{try {YearlyInterest=input.nextDouble()/100; if (YearlyInterest<0) {throw new InvalidNumberException();}x3=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x3==1);
		System.out.println("Enter the mortgage number of years");
		int x4=1;
		do{try {this.timeInYears=input.nextDouble(); if (timeInYears<0) {throw new InvalidNumberException();}x4=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x4==1);
	    System.out.println("Enter the PMI amount");
	    int x5=1;
		do{try {this.PMI=input.nextDouble(); if (PMI<0) {throw new InvalidNumberException();}x5=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x5==1);
		System.out.println("Enter the monthly HOA fees");
		int x6=1;
		do{try {this.HOA=input.nextDouble(); if (HOA<0) {throw new InvalidNumberException();}x6=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x6==1);
		System.out.println("Enter additional monthly principal (if not, just imput 0)");
		int x7=1;
		do{try {additionalPrincipal=input.nextDouble(); if (additionalPrincipal<0) {throw new InvalidNumberException();}x7=2;} 
		catch(InvalidNumberException e) {System.out.println(e.getMessage());}}while(x7==1);
		this.priceAfterDeposit=price-deposit;
	}
	public double calculateBalance() {
		return balance=price-deposit;
	}
	
	public double calculateMonthlyInterest() {
		double monthlyInterest=YearlyInterest/12;
		return monthlyInterest;
	}
	public double calculateTimeInMonths() {
		this.timeInMonths=timeInYears*12;
		return timeInMonths;
	}
	public double calculateTaxes() {
		double tax=(price*VATAXRATE)/12;
		return tax;
	}
	public double calculateMonthlyPayment() {
		double monthlyPayment=priceAfterDeposit*((calculateMonthlyInterest()*Math.pow(1+calculateMonthlyInterest(), calculateTimeInMonths()))/(Math.pow(1+calculateMonthlyInterest(), calculateTimeInMonths())-1))+additionalPrincipal;
		return monthlyPayment;
	}
	public double calculateTotalMonthlyPayment() {
		double totalMonthlyPayment;
		if (price-calculateBalance()<price*0.2) 
			totalMonthlyPayment=calculateMonthlyPayment()+HOA+calculateTaxes()+PMI;
		else
			totalMonthlyPayment=calculateMonthlyPayment()+HOA+calculateTaxes();
		return totalMonthlyPayment;
	}
	public void print() {
		System.out.println("Monthly only the basic payment is "+Math.floor(calculateMonthlyPayment())+" $");
		System.out.println("Total monthly payment is "+Math.floor(calculateTotalMonthlyPayment())+" $");
		System.out.println("Month no        Interest        Principal       Balance");
		System.out.println();
		double sum=0;
		for (int i = 1; i <= calculateTimeInMonths() && balance>=0; i++) {
			double interest = calculateMonthlyInterest() * balance;
			double principal = calculateMonthlyPayment() - interest;
			balance = balance - principal;
			
			System.out.println((int)i+"\t\t\t\t"+Math.floor(interest)+"\t\t\t"+Math.floor(principal)+"\t\t\t"+ Math.floor(balance));
			sum+=interest;
			}
		System.out.println("--------------------------------------------------------");
		System.out.println("Total interest paid will be "+Math.floor(sum));
	}
	
	
}
