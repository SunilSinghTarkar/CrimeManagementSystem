package com.masai.utility;

public class IDGenerator {
	public static int generateId() {

		// random function generates value between 0.0000111 to 0.9999

		return (int) (Math.random() * 100000);
	}
}
