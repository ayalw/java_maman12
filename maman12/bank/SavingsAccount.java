package maman12.bank;

public class SavingsAccount extends BankAccount {

	private final static double DEFAULT_INTEREST = 0.02;
	
	private double m_interest;
	
	public SavingsAccount(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance,
			double interest) {
		super(accountNumber, ownerName, ownerId, initialBalance);
		m_interest = interest;
	}
	
	public SavingsAccount(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance) {
		this(accountNumber, ownerName, ownerId, initialBalance, DEFAULT_INTEREST);
	}
	
	public double getInterest() {
		return m_interest;
	}
	
	public void setInterest(double interest) {
		m_interest = interest;
	}
	
	@Override
	public void manage() throws IllegalBalanceException {
		m_balance *= (1 + m_interest);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("[Interest: " + m_interest + "]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof SavingsAccount)) {
			return false;
		}
		return super.equals(other)
				&& m_interest == ((SavingsAccount)other).getInterest();
	}

}
