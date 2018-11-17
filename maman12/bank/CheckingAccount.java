package maman12.bank;

/**
 * Bank account with ability to write checks.
 * @param accountNumber
 * @param ownerName
 * @param ownerId
 * @param initialBalance
 */
public abstract class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountNumber, String ownerName, String ownerId, double initialBalance) {
		super(accountNumber, ownerName, ownerId, initialBalance);
	}
	
	/**
	 * Write a check - the balance will be reduced immediately.
	 * @param amount
	 * @throws IllegalBalanceException
	 */
	public void writeCheck(double amount) throws IllegalBalanceException {
		double remainingBalance = m_balance - amount;
		if (remainingBalance < 0) {
			throw new IllegalBalanceException(remainingBalance);
		}
		m_balance -= amount;
	}
}
