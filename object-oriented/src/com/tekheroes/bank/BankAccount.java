package com.tekheroes.bank;

public abstract class BankAccount implements Account {
	private int acntNo;
	private String holder;
	protected double balance;
	
	private static int generator = INIT_ACCOUNT_NO;
	
	public BankAccount(String holder, double balance) {
		this.acntNo = generator ++;
		this.holder = holder;
		this.balance = balance;
	}
	
	public void summary() {
		System.out.println("A/C No: " + acntNo);
		System.out.println("Holder: " + holder);
		System.out.println("Balance: " + balance);
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public abstract void withdraw(double amount) throws BalanceException;

	public double getBalance() {
		return balance;
	}
}
