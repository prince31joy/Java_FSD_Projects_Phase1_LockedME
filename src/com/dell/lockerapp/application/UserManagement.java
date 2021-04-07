/**
 * 
 */
package com.dell.lockerapp.application;



import com.dell.lockerapp.outputScreen.OutputScreen;



/**
 * @author joyp1
 *
 */
public class UserManagement {

	public static void main(String[] args) {
		OutputScreen os = new OutputScreen();
		os.mainScreen();

		if (os.loginScreen()) {
			os.functionalityOptions();
		}

	}
}
