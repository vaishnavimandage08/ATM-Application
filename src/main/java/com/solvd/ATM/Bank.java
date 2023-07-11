package com.solvd.ATM;

import java.util.ArrayList;
import java.util.Random;

/* This class is for the Bank */

public class Bank {

	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;

	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>();
		this.accounts = new ArrayList<Account>();

	}

	public String getNewUserUUID() {

		String uuid;

		/* Create instance of Random class */

		Random rng = new Random();
		int len = 6;
		boolean nonUnique;

		/* Continue looping until we get a unique ID */
		do {
			// generate the number
			uuid = "";
			for (int c = 0; c < len; c++) {

				/*
				 * Passing arguments to the methods nextInt(10) for placing an upper bound on
				 * the range of the numbers to be generated
				 */
				uuid += ((Integer) rng.nextInt(10)).toString();
			}
			nonUnique = false;

			/* Check to make sure it's unique */
			
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
		} while (nonUnique);
		return uuid;

	}

	public String getNewAccountUUID() {

		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique;
		do {
			uuid = "";
			for (int c = 0; c < len; c++) {

				/*
				 * Passing arguments to the methods nextInt(10) for placing an upper bound on
				 * the range of the numbers to be generated
				 */

				uuid += ((Integer) rng.nextInt(10)).toString();
			}
			nonUnique = false;
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
		} while (nonUnique);
		return uuid;

	}

	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);

	}

	public User addUser(String firstName, String lastName, String pin) {
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		Account newAccount = new Account("Saving", newUser, this);
		newUser.addAccount(newAccount);
		this.addAccount(newAccount);
		return newUser;
	}

	public User userLogin(String userID, String pin)

	{
		for (User u : this.users) {
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin))

			{
				return u;
			}
		}
		return null;
	}

	public String getName() {
		return this.name;
	}
}
