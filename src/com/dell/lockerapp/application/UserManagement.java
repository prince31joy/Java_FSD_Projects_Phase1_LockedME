/**
 * 
 */
package com.dell.lockerapp.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.dell.lockerapp.model.User;
import com.dell.lockerapp.model.UserCred;

/**
 * @author joyp1
 *
 */
public class UserManagement {

	// Input variables
	private static Scanner keyboard;
	private static Scanner input;
	private static Scanner lockerInput;

	// Output variables
	private static PrintWriter output;
	private static PrintWriter lockerOutput;

	// Model to store data
	private static User users;
	private static UserCred userCreds;

	public static void main(String[] args) {
		initApp();
		Dashbord();
		signInOptions();

	}
	
	public static void initApp() {

		File  Usersdb = new File("Users_DB.txt");
		File  UserAccountdb = new File("UserAccounts_DB.txt");
		
		try {
			//read data from Users file
			input = new Scanner(Usersdb);
			
			//red data from UserAccount file
			lockerInput = new Scanner(UserAccountdb);
			
			//read data from keyboard
			keyboard = new Scanner(System.in);
			
			//output 
			output = new PrintWriter( new FileWriter(Usersdb,true));
			lockerOutput = new PrintWriter( new FileWriter(UserAccountdb,true));
			
			users = new User();
			userCreds  = new UserCred();
			
			
		} catch (IOException e) {
			System.out.println("404 : File Not Found ");
		}
		
	}


	private static void Dashbord() {

		System.out.println("******************************************");
		System.out.println("*			                 *");
		System.out.println("*         Welcome To LockedMe.com        *");
		System.out.println("*      Your Customized Digital Locker    *");
		System.out.println("*					 *");
		System.out.println("******************************************");

	}

	private static void signInOptions() {

		System.out.println("1. Register User");
		System.out.println("2. Login ");
		int choice = keyboard.nextInt();
		switch (choice) {
		case 1:
			registerUser();
			break;
		case 2:
			loginUser();
			break;
		default:
			System.out.println("Please select 1 Or 2");
			break;
		}
		keyboard.close();
		input.close();

	}

	public static void lockerOptions(String inpUsername) {
		System.out.println("1. Fetch All Stored Account Credentials ");
		System.out.println("2. Add New Account Detials ");
		System.out.println("3. Delete All Stored Account Credentials ");
		int choice = keyboard.nextInt();
		switch (choice) {
		case 1:
			fetchCredentials(inpUsername);
			break;
		case 2:
			storeCredentials(inpUsername);
			break;
		case 3:
			removeCredentials(inpUsername);
			break;
		default:
			System.out.println("Please select 1 , 2 or 3");
			break;
		}
		lockerInput.close();
	}

	public static void registerUser() {
		System.out.println("******************************************");
		System.out.println("*			                 *");
		System.out.println("*            Register User	         *");
		System.out.println("*					 *");
		System.out.println("******************************************");

		System.out.println("Enter Username :");
		String username = keyboard.next();
		users.setUsername(username);

		System.out.println("Enter Password :");
		String password = keyboard.next();
		users.setPassword(password);

		output.println(users.getUsername());
		output.println(users.getPassword());

		System.out.println("User Registration Suscessful !");		
		output.close();
		loginUser();

	}

	public static void loginUser() {
		System.out.println("******************************************");
		System.out.println("*					 *");
		System.out.println("*        Welcome to Login Page	         *");
		System.out.println("*					 *");
		System.out.println("******************************************");
		System.out.println("Enter Username :");
		String inpUsername = keyboard.next();
		boolean found = false;
		while (input.hasNext() && !found) {
			if (input.next().equals(inpUsername)) {
				System.out.println("Enter Password :");
				String inpPassword = keyboard.next();
				if (input.next().equals(inpPassword)) {
					System.out.println("*****Login Successfull*****");
					found = true;
					lockerOptions(inpUsername);
					break;

				} else {
					System.out.println("Invalid Username/Password");
				}
			}
		}
		if (!found) {
			System.out.println("User Not Found : Login Failure : 404");
		}
	}

	// store credentials
	public static void storeCredentials(String loggedInUser) {
		System.out.println("*******************************************");
		System.out.println("*					                      *");
		System.out.println("*     Welcome to Digital Locker 	      *");
		System.out.println("*	  Store your Credentials here         *");
		System.out.println("*					                      *");
		System.out.println("*******************************************");

		userCreds.setLoggedInUser(loggedInUser);

		System.out.println("Enter Site Name :");
		String siteName = keyboard.next();
		userCreds.setSiteName(siteName);

		System.out.println("Enter Username :");
		String username = keyboard.next();
		userCreds.setUsername(username);

		System.out.println("Enter Password :");
		String password = keyboard.next();
		userCreds.setPassword(password);

		lockerOutput.println(userCreds.getLoggedInUser());
		lockerOutput.println(userCreds.getSiteName());
		lockerOutput.println(userCreds.getUsername());
		lockerOutput.println(userCreds.getPassword());

		System.out.println("YOUR CREDS ARE STORED AND SECURED!");
		lockerOutput.close();
	}

	// fetch credentials
	public static void fetchCredentials(String inpUsername) {
		System.out.println("*******************************************");
		System.out.println("*					  *");
		System.out.println("*        Welcome to Digital Locker 	  *");
		System.out.println("*        Your Account Details	          *");
		System.out.println("*					  *");
		System.out.println("*******************************************");
		System.out.println(inpUsername);

		while (lockerInput.hasNext()) {

			if (lockerInput.next().equals(inpUsername)) {

				System.out.println("Site Name: " + lockerInput.next());
				System.out.println("User Name: " + lockerInput.next());
				System.out.println("User Password: " + lockerInput.next());
			}

		}
	}

	// delete credentials for specific user
	public static void removeCredentials(String inpUsername) {

		System.out.println("*******************************************");
		System.out.println("*					                      *");
		System.out.println("*       Welcome to Digital Locker  	      *");
		System.out.println("*       Deleting Ur Account Delatis 	  *");
		System.out.println("*					                      *");
		System.out.println("*******************************************");
		System.out.println(inpUsername);

		while (lockerInput.hasNext()) {

			if (lockerInput.next().equals(inpUsername)) {

				System.out.println("Enter Site Name :");
				String siteName = "";
				userCreds.setSiteName(siteName);

				System.out.println("Enter Username :");
				String username = "";
				userCreds.setUsername(username);

				System.out.println("Enter Password :");
				String password = "";
				userCreds.setPassword(password);

				lockerOutput.println(userCreds.getSiteName());
				lockerOutput.println(userCreds.getUsername());
				lockerOutput.println(userCreds.getPassword());
			}
		}
		lockerOutput.close();
	}

}
