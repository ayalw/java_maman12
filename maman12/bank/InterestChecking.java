package maman12.bank;

/**
 * Checking account with monthly interest gain.
 * @author ayalwarman
 *
 */
public class InterestChecking extends NoServiceChargeChecking {

	private final static double DEFAULT_INTEREST = 2;
	
	/**
	 * Interest value is in percentage.
	 */
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
	/**
	 * Interest calculation: balance increases every month by percentage expressed in interest.
	 */
	public void manage() throws IllegalBalanceException {
		super.manage();
		m_balance = Utils.addPercentage(m_balance, m_interest);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("[Interest: " + m_interest + "]");
		sb.append(System.getProperty("line.separator"));
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
