package com.tekheroes.bank;

/**
 * The banking application super interface describing application constants and behaviour.
 * @author Zubair
 * @version 1.0
 */
public interface Account {
	// Application Constants
	int INIT_ACCOUNT_NO = 101;
	double MIN_CHECKING_BALANCE = 100;
	double OPENIN_BUSINESS_BALANCE = 1000;
	double OVERDRAFT_LIMIT = 10000;
	double MIN_BUSINESS_BALANCE = 0;

	// Application Behaviour
	void summary();

	double getBalance();

	void deposit(double amount);

	void withdraw(double amount) throws BalanceException;
}
