package com.masai.utility;

import java.io.*;
import java.util.*;

import com.masai.entities.*;

public class FileExists {

	public static Map<Integer, Crime> crimeFile() {

		Map<Integer, Crime> pFile = null;

		File f = new File("Crime.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {

				pFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(pFile);
				return pFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				pFile = (Map<Integer, Crime>) ois.readObject();

				return pFile;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return pFile;
	}

	public static Map<Integer, Criminal> criminalFile() {

		Map<Integer, Criminal> cFile = null;

		File f = new File("Criminal.ser");
		boolean flag = false;
		try {
			if (!f.exists()) {
				f.createNewFile();
				flag = true;
			}

			if (flag) {

				cFile = new LinkedHashMap<>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(cFile);
				return cFile;

			} else {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				cFile = (Map<Integer, Criminal>) ois.readObject();

				return cFile;

			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return cFile;

	}

}
