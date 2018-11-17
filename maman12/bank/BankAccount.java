package maman12.bank;

public abstract class BankAccount {
	
	/**
	 * Identifier for the account.
	 */
	private String m_accountNumber;
	
	/**
	 * Name of person owning this account.
	 */
	private String m_ownerName;
	
	/**
	 * ID of person owning this account.
	 */
	private String m_ownerId;
	
	/**
	 * Current amount of money in the account.
	 */
	protected double m_balance;
	
	/**
	 * Parameterized constructor
	 * @param accountNumber
	 * @param ownerName
	 * @param ownerId
	 * @param initialBalance
	 */
	public BankAccount(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance) {
		m_accountNumber = accountNumber;
		m_ownerName = ownerName;
		m_ownerId = ownerId;
		m_balance = initialBalance;
	}
	
	public String getAccountNumber() {
		return m_accountNumber;
	}
	
	public String getOwnerName() {
		return m_ownerName;
	}
	
	public void setOwnerName(String name) {
		m_ownerName = name;
	}
	
	public String getOwnerId() {
		return m_ownerId;
	}
	
	public double getBalance() {
		return m_balance;
	}
	
	/**
	 * Add money to the account.
	 * @param amount
	 */
	public void deposit(double amount) {
		m_balance += amount;
	}
	
	/**
	 * Withdraw money from the account.
	 * Amount must be less or equal to the balance.
	 * @param amount
	 * @throws IllegalBalanceException
	 */
	public void withdraw(double amount) throws IllegalBalanceException {
		double remainingBalance = m_balance - amount;
		if (remainingBalance < 0) {
			throw new IllegalBalanceException(remainingBalance);
		}
		m_balance = remainingBalance;
	}
	
	/**
	 * Performs periodic management, the management rules and fees depend of the type of account.
	 * @throws IllegalBalanceException
	 */
	public abstract void manage() throws IllegalBalanceException;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("line.separator"));
		sb.append("[Account Number: " + m_accountNumber + "]");
		sb.append(System.getProperty("line.separator"));
		sb.append("[Owner Name: " + m_ownerName + "]");
		sb.append(System.getProperty("line.separator"));
		sb.append("[Owner ID: " + m_ownerId + "]");
		sb.append(System.getProperty("line.separator"));
		sb.append("[Balance: " + m_balance + "]");
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof BankAccount)) {
			return false;
		}
		return m_accountNumber.equals(((BankAccount)other).getAccountNumber())
				&& m_ownerId.equals(((BankAccount)other).getOwnerId())
				&& m_ownerName.equals(((BankAccount)other).getOwnerName())
				&& m_balance == ((BankAccount)other).getBalance();
	}
}
