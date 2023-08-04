package com.tekheroes.bank;

public final class AccountFactory {
	
	private AccountFactory() {
	}

	public static Account openChecking(String holder) {
		return new CheckingAccount(holder);
	}
	
	public static Account openBusiness(String holder) {
		return new BusinessAccount(holder);
	}
}
