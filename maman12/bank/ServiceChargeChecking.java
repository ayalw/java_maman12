package maman12.bank;

/**
 * Checking account with monthly management fee.
 * Account holder is allowed to write checks as high as his balance is.
 * @author ayalwarman
 *
 */
public class ServiceChargeChecking extends CheckingAccount {

	/**
	 * How much money will be paid as monthly fee.
	 */
	private double m_serviceCharge;
	
	private final static double DEFAULT_SERVICE_CHARGE = 10;
	
	public ServiceChargeChecking(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance) {
		this(accountNumber, ownerName, ownerId, initialBalance, DEFAULT_SERVICE_CHARGE);
	}
	
	public ServiceChargeChecking(String accountNumber,
			String ownerName,
			String ownerId,
			double initialBalance,
			double serviceCharge) {
		super(accountNumber, ownerName, ownerId, initialBalance);
		m_serviceCharge = serviceCharge;
	}
	
	public void setServiceCharge(double serviceCharge) {
		m_serviceCharge = serviceCharge;
	}
	
	public double getServiceCharge() {
		return m_serviceCharge;
	}

	@Override
	public void manage() throws IllegalBalanceException {
		double remainingBalance = m_balance - m_serviceCharge;
		if (remainingBalance < 0) {
			throw new IllegalBalanceException(remainingBalance);
		}
		m_balance = remainingBalance;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("[Service Charge: " + m_serviceCharge + "]");
		sb.append(System.getProperty("line.separator"));
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ServiceChargeChecking)) {
			return false;
		}
		return super.equals(other)
				&& m_serviceCharge == ((ServiceChargeChecking)other).getServiceCharge();
	}

}
