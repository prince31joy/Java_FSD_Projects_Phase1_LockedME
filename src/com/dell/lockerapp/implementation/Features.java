package com.dell.lockerapp.implementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.dell.lockerapp.outputScreen.OutputScreen;


public class Features {
	
	// Do you wish to perform another operation?
		Scanner sc = new Scanner(System.in);
		public static String folderPath = Features.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("bin")[0]+"data/";
		OutputScreen os = new OutputScreen();
		public void addFile() {
			System.out.print("Enter the file name to add: ");
			String value = sc.next();
			File file = new File(folderPath + value);
			try {
				if (file.createNewFile()) {
					System.out.println(value+" is added successfully!");
					// Write Content
					FileWriter writer = new FileWriter(file);
					writer.write("Test Data to file " + value);
					writer.close();
				} else {
					System.out.println("File Already Exists!");
				}
			} catch (IOException e) {
				System.out.println("File Creation Failed !");
			}
			os.functionalityOptions();
		}


		public void getAllFiles() {

			System.out.println("*********************************************************************************************");

			File directoryPath = new File(folderPath);
			String contents[] = directoryPath.list();
			if (contents.length>0) {
				System.out.println("           **********   Below are the available files in the directory.  *************");
				for (int i = 0; i < contents.length; i++) {
					System.out.println((i+1)+". "+contents[i]);
				}
			} else {
				System.out.println("         No files available in directory.         ");
			}

			System.out.println("*********************************************************************************************");

		}

		public void getFileByName() {
			try {
				System.out.print("Enter the file name to Search: ");
				String value = sc.next();
				File directoryPath = new File(folderPath+ value);
//				String contents[] = directoryPath.list();
				
				if (directoryPath.exists()) {
					System.out.println(value + " is Available!");
				} else {
					System.out.println(value + " is not Available!");
				}
			} catch (Exception e) {
				System.out.println("Error in File Handling");
			}
			os.functionalityOptions();
		}

		public void deleteFileByName() {
			System.out.print("Enter the file name to Delete: ");
			String value = sc.next();
			try {
				File directoryPath = new File(folderPath+ value);
				if (directoryPath.exists()) {
					directoryPath.delete();
					System.out.println(value + " is Deleted!");
				} else {
					System.out.println("File Not Found!");
				}

			} catch (Exception e) {
				System.out.println("File Not Found!");
			}
			os.functionalityOptions();
		}


		public void quitApplication() {
			System.out.println("************            Thanks for using the application.    ********************************");
			System.out.println("************                   Have a nice day.              ********************************");

		}


}
