package maman12.bank;

public abstract class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountNumber, String ownerName, String ownerId, double initialBalance) {
		super(accountNumber, ownerName, ownerId, initialBalance);
	}
	
	public void writeCheck(double amount) throws IllegalBalanceException {
		double remainingBalance = m_balance - amount;
		if (remainingBalance < 0) {
			throw new IllegalBalanceException(remainingBalance);
		}
		m_balance -= amount;
	}
}
