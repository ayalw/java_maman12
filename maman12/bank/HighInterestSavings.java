package maman12.bank;

/**
 * Bank account without ability to write checks, and with ability to gain interest.
 * The interest will be high but the account must retain a minimal balance.
 * @author ayalwarman
 *
 */
public class HighInterestSavings extends SavingsAccount {

	private double m_minimalBalance;
	
	protected final static double DEFAULT_MINIMAL_BALANCE = 5;
	
	public HighInterestSavings(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance) {
		this(accountNumber, ownerName, ownerId, initialBalance, DEFAULT_MINIMAL_BALANCE);
	}
	
	public HighInterestSavings(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance,
			double minimalBalance) {
		super(accountNumber, ownerName, ownerId, initialBalance);
		m_minimalBalance = minimalBalance;
	}
	
	public double getMinimalBalance() {
		return m_minimalBalance;
	}
	
	public void setMinimalBalance(double minimalBalance) {
		m_minimalBalance = minimalBalance;
	}
	
	@Override
	public void withdraw(double amount) throws IllegalBalanceException {
		double remainingBalance = m_balance - amount;
		if (remainingBalance < m_minimalBalance) {
			throw new IllegalBalanceException(remainingBalance);
		}
		super.withdraw(amount);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("[Minimal Balance: " + m_minimalBalance + "]");
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof HighInterestSavings)) {
			return false;
		}
		return super.equals(other)
				&& m_minimalBalance == ((HighInterestSavings)other).getMinimalBalance();
	}
}
