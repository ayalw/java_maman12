package maman12.bank;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<BankAccount> accounts = createAccounts();
		for (BankAccount account : accounts) {
			testAccount(account);
		}	
	}
	
	private static ArrayList<BankAccount> createAccounts() {
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(new SavingsAccount("12345", "Ayal", "039907803", 200000));
		accounts.add(new SavingsAccount("33333", "Johnny", "333333333", 70000, 1.44));
		accounts.add(new ServiceChargeChecking("44444", "Miko", "444444444", 3800));
		accounts.add(new ServiceChargeChecking("55555", "Lizzy", "555555555", 40000, 20.4));
		accounts.add(new NoServiceChargeChecking("66666", "Gabriela", "666666666", 50000));
		accounts.add(new NoServiceChargeChecking("77777", "Adam", "777777777", 93800, 1500));
		accounts.add(new HighInterestSavings("88888", "Ozzy", "888888888", 400000));
		accounts.add(new HighInterestSavings("99999", "Jacky", "999999999", 30000, 2000));
		accounts.add(new InterestChecking("12121", "Ralph", "121121121", 555555));
		accounts.add(new InterestChecking("34343", "Daffi", "343343343", 0, 150));
		accounts.add(new InterestChecking("56565", "Jordi", "565565565", 6000, 900, 3.3));
		return accounts;
	}
	
	private static void testAccount(BankAccount account) {
		System.out.println("*** Testing Account ***");
		System.out.println("Type: " + account.getClass().getName());
		System.out.println("Details: " + account);
		testDeposit(account, 2000);
		testDeposit(account, 3000);
		testWithdraw(account, 500);
		testWithdraw(account, 40000);
	}
	
	private static void testDeposit(BankAccount account, double amount) {
		System.out.println("---Test Deposit--- Current balance: " + account.getBalance());
		System.out.println("Depositing amount of " + amount);
		account.deposit(amount);
		System.out.println("Balance is now " + account.getBalance());
	}
	
	private static void testWithdraw(BankAccount account, double amount) {
		System.out.println("---Test Withdraw--- Current balance: " + account.getBalance());
		System.out.println("Withdrawing amount of " + amount);
		try {
			account.withdraw(amount);
		} catch (IllegalBalanceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Balance is now " + account.getBalance());
	}

}
