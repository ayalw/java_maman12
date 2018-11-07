package maman12.bank;

public abstract class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountNumber, String ownerName, String ownerId, double initialBalance) {
		super(accountNumber, ownerName, ownerId, initialBalance);
	}
	
	public void writeCheck(double amount) throws IllegalBalanceException {
		if (amount > m_balance) {
			throw new IllegalBalanceException();
		}
		m_balance -= amount;
	}
}
