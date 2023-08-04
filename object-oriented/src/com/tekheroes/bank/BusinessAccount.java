package com.tekheroes.bank;

public class BusinessAccount extends BankAccount {
	private double overdraft;

	public BusinessAccount(String holder) {
		super(holder, OPENIN_BUSINESS_BALANCE);
		overdraft = OVERDRAFT_LIMIT;
	}

	@Override
	public void summary() {
		super.summary();
		System.out.println("Overdraft: " + overdraft);
	}

	@Override
	public void deposit(double amount) {
		overdraft += amount;
		if(overdraft > OVERDRAFT_LIMIT) {
			balance += (overdraft - OVERDRAFT_LIMIT);
			overdraft = OVERDRAFT_LIMIT;
		}
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance + overdraft)) {
			balance -= amount;
			if(balance < MIN_BUSINESS_BALANCE) {
				overdraft += balance;
				balance = MIN_BUSINESS_BALANCE;
			}
		} else
			throw new BalanceException("Insufficient balance!");
	}
}
