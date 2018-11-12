package maman12.bank;

public class ServiceChargeChecking extends CheckingAccount {

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
		if (m_serviceCharge > m_balance) {
			throw new IllegalBalanceException();
		}
		m_balance -= m_serviceCharge;
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
