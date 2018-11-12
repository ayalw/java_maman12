package maman12.bank;

public class IllegalBalanceException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private double m_illegalBalance;
	
	public IllegalBalanceException(double illegalBalance) {
		m_illegalBalance = illegalBalance;
	}
	
	@Override
	public String getMessage() {
		return "Cannot complete transaction - balance of " + m_illegalBalance + " is illegal!";
	}
}
