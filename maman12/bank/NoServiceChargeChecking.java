package maman12.bank;

public class NoServiceChargeChecking extends CheckingAccount {

	private double m_minimalBalance;
	
	protected final static double DEFAULT_MINIMAL_BALANCE = 5;
	
	public NoServiceChargeChecking(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance) {
		this(accountNumber, ownerName, ownerName, initialBalance, DEFAULT_MINIMAL_BALANCE);
	}
	
	public NoServiceChargeChecking(String accountNumber,
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
	public void manage() throws IllegalBalanceException {
		// Do Nothing		
	}
	
	@Override
	public void withdraw(double amount) throws IllegalBalanceException {
		if (m_balance - amount < m_minimalBalance) {
			throw new IllegalBalanceException();
		}
		super.withdraw(amount);
	}
	
	@Override
	public void writeCheck(double amount) throws IllegalBalanceException {
		if (m_balance - amount < m_minimalBalance) {
			throw new IllegalBalanceException();
		}
		super.writeCheck(amount);
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
		if (!(other instanceof NoServiceChargeChecking)) {
			return false;
		}
		return super.equals(other)
				&& m_minimalBalance == ((NoServiceChargeChecking)other).getMinimalBalance();
	}

}
