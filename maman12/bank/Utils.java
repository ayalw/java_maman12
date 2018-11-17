package maman12.bank;

/**
 * Class for financial calculations
 * @author ayalwarman
 *
 */
public class Utils {

	/**
	 * Add percentage to amount
	 * @param amount 
	 * @param percentage must be between 0 to 100
	 * @return
	 */
	public static double addPercentage(double amount, double percentage) {
		return amount *= (1 + (percentage/100));
	}
}
