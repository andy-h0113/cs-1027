
public class SavingsAccount extends BankAccount{
	
	private double interestRate;
	
	public SavingsAccount (double initialAmount, double rate) {
		super(initialAmount);
		interestRate = rate;		
	}
	
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void calculateInterest() {
		double interest = this.getBalance() * interestRate;
		this.deposit(interest);		
	}
	
	public String toString() {
		return "SavingsAccount: balance $" + this.getBalance() + ", interest rate " + this.interestRate;
	}

	public static void main(String[] args) {
	    SavingsAccount myAccount = new SavingsAccount(100.0,0.15);
	    myAccount.calculateInterest();
	    System.out.println(myAccount.toString());
	}
}