package com.dell.lockerapp.outputScreen;

import java.util.Scanner;

import com.dell.lockerapp.implementation.Features;



public class OutputScreen {
	
	public static String username = "admin";
	public static String password = "demo@123";
	Scanner sc = new Scanner(System.in);

	public void mainScreen() {
		System.out.println("*********************************************************************************************");
		System.out.println();
		System.out.println("         *************         Welcome to Company Lockers Pvt. Ltd  *************");
		System.out.println("                  *************      (LockedMe.com)        *************");
		System.out.println("            *************      Developed by Prince Joy      *************");
		System.out.println();
		System.out.println("*********************************************************************************************");
	}

	public boolean loginScreen() {
		for (int i = 3; i > 0; i--) {
			System.out.println("Login Attempt(s) Remaining: "+i);
			System.out.print("Enter the Username: ");
			
			String uName = sc.nextLine();

			System.out.print("Enter the Password: ");
			String pwd = sc.nextLine();
			if (uName.equalsIgnoreCase(username) && pwd.equals(password)) {
				System.out.println("*********************************************************************************************");
				System.out.println("***********************       Logged in Successfully       **********************************");
				return true;
			} else {
				if (i==1) {
					System.out.println("No. of attempts failed. Please login after sometime.");
					break;
				}
				System.out.println("Incorrect credentials. Please try again");
			}
		}

		return false;
	}

	private void functionalityScreen() {

		System.out.println("*********************************************************************************************");
		Features func = new Features();
		func.getAllFiles();
		System.out.println("               Select from the below options to perform the action");
		System.out.println("                     (1) Add a file to the system");
		System.out.println("                     (2) Delete a file from the system");
		System.out.println("                     (3) Search a file from the system");
		System.out.println("                     (4) Logout from the application");
		System.out.println("*********************************************************************************************");


	}

	public void functionalityOptions() {
		functionalityScreen();
		Features func = new Features();
		System.out.print("Enter the option--> ");
		try {
			
			int input = sc.nextInt();
			switch (input) {
			case 1:
				func.addFile();
				break;
			case 2:
				func.deleteFileByName();
				break;
			case 3:
				func.getFileByName();
				break;
			case 4:
				func.quitApplication();
				break;
			default:
				System.out.println("Your Selection is Invalid! You need to Select 1 or 2 or 3 or 4 to Proceed Further.");
				functionalityOptions();
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}


}
}
