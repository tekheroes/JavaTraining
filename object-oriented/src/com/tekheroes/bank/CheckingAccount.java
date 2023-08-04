package com.tekheroes.bank;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String holder) {
		super(holder, MIN_CHECKING_BALANCE);
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance - MIN_CHECKING_BALANCE))
			balance -= amount;
		else
			throw new BalanceException("Insufficient balance!");
	}
}
