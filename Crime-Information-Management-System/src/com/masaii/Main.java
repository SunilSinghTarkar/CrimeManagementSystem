package com.masaii;

import java.io.FileOutputStream;

import java.io.ObjectOutputStream;
import java.util.*;
import java.io.FileOutputStream;
import com.masai.entities.Crime;
import com.masai.entities.Criminal;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.crimeException;
import com.masai.exceptions.criminalException;
import com.masai.services.*;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;
import com.masai.utility.IDGenerator;

public class Main {

	// admin functionality
	private static void adminFunctionality(Scanner sc, Map<Integer, Crime> crime, Map<Integer, Criminal> criminal)
			throws InvalidDetailsException {
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
					adminAddCrime(sc, crime);
					System.out.println("Crime report added successfully");
					break;
				case 2:
					adminUpdateCrime(sc, crime);
					break;
				case 3:
					AddCriminal(sc, criminal);
					break;
				case 4:
					updateCriminal(sc, criminal);
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

	public static void adminAddCrime(Scanner sc, Map<Integer, Crime> crime) {

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
		sc.nextLine();

		System.out.println("Enter the crime description ");
		String description = sc.nextLine();

		System.out.println("Enter the poice station area");
		String area = sc.nextLine();

		System.out.println("Enter a date (YYYY-MM-DD): ");

		String date = sc.nextLine();
		System.out.println("Enter the Name of victim");
		String name = sc.nextLine();

		int ID = IDGenerator.generateId();

		Crime addCrime = new Crime(ID, crimeType, description, area, date, name);

		crime.put(ID, addCrime);

	}

	public static void adminUpdateCrime(Scanner sc, Map<Integer, Crime> crime) throws crimeException {
		String result = null;
		System.out.println("please enter the id of the crime which is to be updated");
		int ID = sc.nextInt();
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
		sc.nextLine();
		System.out.println("Enter the crime description ");
		String description = sc.nextLine();

		System.out.println("Enter the poice station area");
		String area = sc.nextLine();

		System.out.println("Enter a date (YYYY-MM-DD): ");
		String date = sc.nextLine();
		System.out.println("Enter the Name of victim");

		String name = sc.nextLine();

		Crime updateCrime = new Crime(ID, crimeType, description, area, date, name);

		CrimeServices crService = new CrimeServicesImpl();

		crService.updateCrime(updateCrime, crime);

	}

	public static void AddCriminal(Scanner sc, Map<Integer, Criminal> criminal) {

		System.out.println("Please enter the criminal details:");
		System.out.println("Enter the Name:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter the Date Of Birth (YYYY-MM-DD):");
		String dob = sc.next();

		System.out.println("Enter the Gender:");
		String gender = sc.next();

		System.out.println("Enter the Area of Crime:");
		sc.nextLine();
		String arrestedFromPsArea = sc.nextLine();

		System.out.println("Enter the Name of Identifying Mark:");
		String identifying_mark = sc.nextLine();

		System.out.println("Enter the First Arrest Date (YYYY-MM-DD):");
		String first_arrest_date = sc.next();

		int ID = IDGenerator.generateId();

		Criminal newCriminal = new Criminal(ID, name, dob, gender, identifying_mark, first_arrest_date,
				arrestedFromPsArea);

		criminal.put(ID, newCriminal);

		System.out.println("Criminal added successfully.");
	}

	public static void updateCriminal(Scanner sc, Map<Integer, Criminal> criminal) throws criminalException {

		System.out.println("Please enter the criminal details:");
		System.out.println("Enter the Criminal ID:");
		int ID = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Name:");
		String name = sc.nextLine();
//		sc.nextLine();
		System.out.println("Enter the Date Of Birth (YYYY-MM-DD):");
		String dob = sc.nextLine();

		System.out.println("Enter the Gender:");
		String gender = sc.nextLine();

		System.out.println("Enter the Area of  Crime :");
		String arrestedFromPsArea = sc.nextLine();

		System.out.println("Enter the Name of Identifying Mark:");
		String identifying_mark = sc.nextLine();

		System.out.println("Enter the First Arrest Date (YYYY-MM-DD):");
		String first_arrest_date = sc.nextLine();

		Criminal newCriminal = new Criminal(ID, name, dob, gender, identifying_mark, first_arrest_date,
				arrestedFromPsArea);

		CriminalServices crService = new CriminalServicesImpl();
		crService.updateCriminal(newCriminal, criminal);

		System.out.println("Criminal updated successfully.");

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
		Map<Integer, Crime> crime = FileExists.crimeFile();
		Map<Integer, Criminal> criminal = FileExists.criminalFile();
		System.out.println(crime);
		System.out.println(criminal);
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
					adminFunctionality(sc, crime, criminal);
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
				poos.writeObject(crime);
				poos.close();
				System.out.println(crime);
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Criminal.ser"));
				coos.writeObject(criminal);
				coos.close();
				System.out.println(criminal);
				System.out.println("serialized..........");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
