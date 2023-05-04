package com.masaii;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.FileOutputStream;
import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.crimeException;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;

public class Main {

	// admin functionality
	private static void adminFunctionality(Scanner sc) throws InvalidDetailsException {
		// admin login

		adminLogin(sc);

		int choice = 0;
		try {
			do {
				System.out.println("Press 1 Add crime details");
				System.out.println("Press 2 Update crime details");
				System.out.println("Press 3 Add criminal details");
				System.out.println("Press 4 Update criminal details");
				System.out.println("Press 5 Assign criminals to crime");
				System.out.println("Press 6 Remove criminal from crime");
				System.out.println("Press 7 Delete crime using crime_id");
				System.out.println("Press 8 Delete criminal using criminal_id");
				System.out.println("Press 9 to log out");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddCrime(sc);
					System.out.println(added);
					break;
				case 2:

					adminUpdateCrime(sc);
					break;
				case 3:
					AddCriminal(sc);
					break;
				case 4:
					updateCriminal(sc);
					break;
				case 5:
					assignCriminalsToCrime(sc);
					break;
				case 6:
					removeCriminalsfromCrime(sc);
					break;
				case 7:
					deleteCrime(sc);
					break;
				case 8:
					deleteCriminal(sc);
					break;
				case 9:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void adminLogin(Scanner sc) throws InvalidDetailsException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}

	public static String adminAddCrime(Scanner sc) {

		String str = null;
		System.out.println("please enter the crime details");
		System.out.println("Select the crime type" + " 1--> Robbery , 2--> Theft , 3--> Homicide ");
		int type = sc.nextInt();
		String crimeType = "";
		if (type == 1)
			crimeType = "Robbery";
		else if (type == 2)
			crimeType = "Theft";
		else if (type == 3)
			crimeType = "Homicide";
		else
			throw new IllegalArgumentException("Invalid Selection");
		System.out.println("Enter the crime description ");
		String description = sc.nextLine();
		sc.next();
		System.out.println("Enter the poice station area");
		String area = sc.nextLine();
		sc.next();
		System.out.println("Enter a date (YYYY-MM-DD): ");
		sc.next();
		String date = sc.nextLine();
		System.out.println("Enter the Name of victim");
		sc.next();
		String name = sc.nextLine();

		return crimeType;

	}

	public static String adminUpdateCrime(Scanner sc) throws crimeException {
		String result = null;
		System.out.println("please enter the id of the crime which is to be updated");
		int id = sc.nextInt();
		System.out.println("Enter the updated details ");

		System.out.println("Select the crime type" + " 1--> Robbery , 2--> Theft , 3--> Homicide ");
		int type = sc.nextInt();
		String crimeType = "";
		if (type == 1)
			crimeType = "Robbery";
		else if (type == 2)
			crimeType = "Theft";
		else if (type == 3)
			crimeType = "Homicide";
		else
			throw new IllegalArgumentException("Invalid Selection");
		System.out.println("Enter the crime description ");
		String description = sc.nextLine();
		sc.next();
		System.out.println("Enter the poice station area");
		String area = sc.nextLine();
		sc.next();
		System.out.println("Enter a date (YYYY-MM-DD): ");
		sc.next();
		String date = sc.nextLine();
		System.out.println("Enter the Name of victim");
		sc.next();
		String name = sc.nextLine();

		return result;
	}

	public static String AddCriminal(Scanner sc) {

		String crimeType = null;
		System.out.println("please enter the criminal details");

		System.out.println("Enter the Name ");
		String name = sc.nextLine();
		sc.next();
		System.out.println("Enter the Date Of Birth (YYYY-MM-DD):");
		String dob = sc.nextLine();
		sc.next();
		System.out.println("Enter the Gender ");
		String gender = sc.nextLine();

		System.out.println("Enter a date (YYYY-MM-DD): ");
		sc.next();
		String date = sc.nextLine();
		System.out.println("Enter the Name of Identifying Mark");
		sc.next();
		String identifying_mark = sc.nextLine();
		System.out.println("Enter the First Arrest Date ");
		String first_arrest_date = sc.nextLine();

		return crimeType;

	}

	public static String updateCriminal(Scanner sc) {

		String crimeType = null;
		System.out.println("please enter the criminal details");

		System.out.println("Enter the Name ");
		String name = sc.nextLine();
		sc.next();
		System.out.println("Enter the Date Of Birth (YYYY-MM-DD):");
		String dob = sc.nextLine();
		sc.next();
		System.out.println("Enter the Gender ");
		String gender = sc.nextLine();

		System.out.println("Enter a date (YYYY-MM-DD): ");
		sc.next();
		String date = sc.nextLine();
		System.out.println("Enter the Name of Identifying Mark");
		sc.next();
		String identifying_mark = sc.nextLine();
		System.out.println("Enter the First Arrest Date ");
		String first_arrest_date = sc.nextLine();

		return crimeType;

	}

	public static void assignCriminalsToCrime(Scanner sc) {
		System.out.println("Enter criminal  id");
		String criminalId = sc.next();
		System.out.println("Enter crime id");
		String crimeId = sc.next();
	}

	public static void removeCriminalsfromCrime(Scanner sc) {
		System.out.println("Enter criminal  id");
		int criminalId = sc.nextInt();
		System.out.println("Enter crime id");
		int crimeId = sc.nextInt();
	}

	public static void deleteCrime(Scanner sc) {
		System.out.print("Enter crime id");
		int id = sc.nextInt();

	}

	public static void deleteCriminal(Scanner sc) {
		System.out.print("Enter criminal id");
		int id = sc.nextInt();
	}

	public static void main(String args[]) {
		Map<Integer, Crime> products = FileExists.crimeFile();
		Map<Integer, Criminal> customers = FileExists.criminalFile();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Crime Information  Management System");

		try {

			int preference = 0;
			do {
				System.out.println("Please enter your preference, " + " '1' --> Admin login , '2' --> View Crimes , "
						+ " '0' for exit");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					adminFunctionality(sc);
					break;
				case 2:

					break;

				case 0:
					System.out.println("successfully existed from the system");

					break;

				default:
					throw new IllegalArgumentException("Invalid Selection");
				}

			}

			while (preference != 0);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		} finally {
			// serialization (finally always executed)
			try {
				ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Crime.ser"));
//			poos.writeObject(products);
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Criminal.ser"));
//			coos.writeObject(customers);

				System.out.println("serialized..........");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
}
