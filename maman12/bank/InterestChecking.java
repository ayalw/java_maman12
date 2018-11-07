package maman12.bank;

public class InterestChecking extends NoServiceChargeChecking {

	private final static double DEFAULT_INTEREST = 0.02;
	
	private double m_interest;
	
	public InterestChecking(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance,
			double minimalBalance,
			double interest) {
		super(accountNumber, ownerName, ownerId, initialBalance, minimalBalance);
		m_interest = interest;
	}
	
	public InterestChecking(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance) {
		this(accountNumber, ownerName, ownerId, initialBalance, DEFAULT_MINIMAL_BALANCE, DEFAULT_INTEREST);
	}
	
	public InterestChecking(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance,
			double minimalBalance) {
		this(accountNumber, ownerName, ownerId, initialBalance, minimalBalance, DEFAULT_INTEREST);
		
	}
	
	public double getInterest() {
		return m_interest;
	}
	
	public void setInterest(double interest) {
		m_interest = interest;
	}
	
	@Override
	public void manage() throws IllegalBalanceException {
		super.manage();
		m_balance *= (1 + m_interest);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("[Interest: " + m_interest + "]");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof InterestChecking)) {
			return false;
		}
		return super.equals(other)
				&& m_interest == ((InterestChecking)other).getInterest();
	}

}
